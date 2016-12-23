package markdown;

import java.io.IOException;
import java.util.ArrayList;

public interface MDElement{
	

	public ArrayList<MDElement> temp=new ArrayList<MDElement>();
	//public static final String strings=new String();
	public void accept(MDElementVisitor v) throws IOException;
	public String getstring();
	
	//public void setstring(String s);
}
