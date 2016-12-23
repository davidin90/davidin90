package markdown;

import java.io.IOException;
import java.util.ArrayList;

public interface MDElementVisitor {
	//public static String tokenstring = new String();
	public ArrayList<MDElement> elementlist=new ArrayList<MDElement>();
	public void visitDocument(Document document) throws IOException;
	public void visitNode(Node node) throws IOException;
	public void visitToken(Token token);


}
