

import java.io.*;

public class MDParser{
	public String htmlname = new String();
	MDParser(File mdfile, String h) throws IOException{
		String[] mdstring=new String[100];
		int k=0;
		File_reader fileread = new File_reader(mdfile);
		mdstring=fileread.getString();
		k=fileread.getLine();
		Node node=new Node(mdstring, k, h);
		k=0;
		mdstring=new String[100];
	}

}
