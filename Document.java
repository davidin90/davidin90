package markdown;

import java.io.IOException;
import java.util.ArrayList;

public class Document implements MDElement{
	public ArrayList<String[]> documentlist = new ArrayList<String[]>();
	
	Document(){
		
	}
/*	Document(String[] s) throws IOException{
	//	new Node(s, 1, );
		documentlist.add(s);
	}*/

	public ArrayList<String[]> getDocument(){
		return documentlist;
	}
	public void accept(MDElementVisitor v){
		v.visitDocument(this);
	}

	@Override
	public String getstring() {
		// TODO Auto-generated method stub
		return null;
	}
}
