package markdown;

import java.io.*;

public class File_reader {

	private static File mdfile;
	static int cnt=0;
	public static String[] mdstring=new String[100];
	File_reader(File file){
		mdfile=file;
		fileread();
	}

	private static void fileread(){
		String line;
		BufferedReader read = null;
		try{
			int i=0;
			read = new BufferedReader(new FileReader(mdfile));

			while(((line=read.readLine()))!=null){
				System.out.println(line);
				mdstring[i++]=line;

			}
			cnt=i;
			read.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String[] getString(){
		return mdstring;
	}
	public int getLine(){
		return cnt;
	}
}
