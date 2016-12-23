package markdown;

import java.io.IOException;
import java.util.ArrayList;

public class Document implements MDElement{
	public ArrayList<String[]> documentlist = new ArrayList<String[]>();
	public ArrayList<ArrayList<String>> resultlist = new ArrayList<ArrayList<String>>();
	public static ArrayList<Node> node2=new ArrayList<Node>();
	public static String hn=new String();
	public static int li=0;
	
	Document(){
		
	}
/*	Document(String[] s) throws IOException{
	//	new Node(s, 1, );
		documentlist.add(s);
	}*/

	public ArrayList<String[]> getDocument(){
		return documentlist;
	}
	public void accept(MDElementVisitor v) throws IOException{
		v.visitDocument(this);
	}

	public String getstring() {
		// TODO Auto-generated method stub
		return null;
	}
}
