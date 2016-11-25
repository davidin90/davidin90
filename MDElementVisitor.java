package markdown;

import java.io.IOException;
import java.util.ArrayList;

public interface MDElementVisitor {
	
	public void visitDocument(Document document);
	public void visitNode(Node node) throws IOException;
	public void visitToken(Token token);
	
}
