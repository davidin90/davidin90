package markdown;

import java.io.IOException;
import java.util.ArrayList;

public interface MDElement{
	public ArrayList<Node> node=new ArrayList<Node>();
	public void accept(MDElementVisitor v) throws IOException;
}
