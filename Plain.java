import org.w3c.tidy.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



public class Plain implements MDElementVisitor{
	private ArrayList<Node> node = new ArrayList<Node>();
	private String s;
	public Plain(){
	}

	public void visitDocument(Document document) {
		// TODO Auto-generated method stub

	}
	public void visitNode(Node n){
		node.add(n);

	}
	public void visitToken(Token token){

	}
	public void makehtml(String string) throws IOException{

		try{


			File html0=new File(string);
			 if(html0.isFile()){
	             System.out.println("That file has already existed.");
	         }
			 else{
				    s="<!Doctype html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n"+"<html>\n"+"<head>\n"+"<title></title>\n"
				   +"</head>\n"+"<body>\n";
		            for(int i=0; i<node.size(); i++){
		            	s = s+(node.get(i)).strings+"\n";
		            	System.out.println((node.get(i)).strings);
		            }
		            s= s+"</body>\n"+"</html>\n";
	                if(isValid(s)){
	                	FileWriter html=new FileWriter(string);
	                	html.write(s);

			            html.close();
			            System.out.println("Html file is created.");
			            node.clear();

	                }
	                else
	                	System.out.println("Wrong syntax");



			 }
		}

		catch(IOException e){
			e.getMessage();
		}

	}

	public void visitNode(ArrayList<Node> node) {
		// TODO Auto-generated method stub

	}
	private boolean isValid(String htmlData){
			   Tidy tidy = new Tidy();
			   InputStream stream = new ByteArrayInputStream(htmlData.getBytes());
			   tidy.parse(stream, System.out);
			   return (tidy.getParseErrors() == 0);
	}

}
