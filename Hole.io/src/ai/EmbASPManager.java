package ai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv.desktop.DLVDesktopService;

public class EmbASPManager {
	
	private static EmbASPManager singleton_instance;
	
	private static String encodingResource="encodings/hole";
	
	private static Handler handler;
	
	private static EmbASPManager instance() {
        if (singleton_instance == null)
        	singleton_instance = new EmbASPManager();
        return singleton_instance;
	}
	
	private static String getEncodings(String ecodingFile) {
		BufferedReader reader;
		StringBuilder builder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(encodingResource));
			String line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	private void GenerateFacts() {
		handler = new DesktopHandler(new DLVDesktopService("lib/dlv.mingw.exe"));
		
		InputProgram facts = new ASPInputProgram();
		facts.addFilesPath(encodingResource);
		
		handler.addProgram(facts);
		
		Output o = handler.startSync();
		
		AnswerSets answers = (AnswerSets) o;
		for(AnswerSet a : answers.getAnswersets())
		{
			try {
				for(Object obj : a.getAtoms())
				{
					System.out.println("Alessia lascia le cose a metà");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e.getMessage());
			}
		}
	}

}
