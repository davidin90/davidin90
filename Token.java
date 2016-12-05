package markdown;

public class Token implements MDElement{
	Token(String s){
		
	}
	public void accept(MDElementVisitor v){
		v.visitToken(this);
	}
}
