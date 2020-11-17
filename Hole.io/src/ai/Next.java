package ai;
import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import it.unical.mat.embasp.languages.asp.SymbolicConstant;

@Id("next")
public class Next {
	
	 @Param(0)
	 private SymbolicConstant action;
	 
	 public Next() {}
	public Next(SymbolicConstant action) {super(); this.action = action;}

	public SymbolicConstant getAction() {return action;}
	public void setAction(SymbolicConstant action) {this.action = action;}

	@Override
	public String toString() {
		return "Next [action=" + action + "]";
	}
}