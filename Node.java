package markdown;

import java.io.IOException;
import java.util.*;

public class Node implements MDElement{

	private static ArrayList<MDElement[]> parselist = null;
	private static ArrayList<Node> nodelist = null;
	private static ArrayList<Token> tokenlist = null;
	private static String[] stringlist = null;
	private static String nodestring = null;
	private static String tokenstring = null;
	private static MDElement[] elementlist = null;
	public static String string = new String();
	public static Plain visitor= new Plain();
	public static int pre=0;

	public String strings;
	public static Node N;

	Node(){
	}
	Node(String[] s, int b, String htmlname) throws IOException{
		node.clear();
		char[] arr;
		int h=0;
		for(int j = 0; j<b; j++){
			arr = s[j].toCharArray();
			//Backslash
			//Block 0
			int i=0;
			System.out.println(j);	
			if(i<arr.length && (arr[i]==' ' || arr[i]=='\t')){
				while(i<arr.length){
					if(arr[i]==' '){
						if(i==3){
							pre=0;
							break;
						}
						i++;
					}
					else if(arr[0]=='\t'){
						pre=0;
					}
					else{
						break;
					}
				}
				if(pre==0){
					for(int a=i+1; a<arr.length; a++){
						string += arr[a];
					}
					
					Token token = new Token(string);
					
					string="<pre><code>"+string+"</pre></code>";
					
					Block block = new Block(string);
					node.add(block);
					string="";
				}
				i=0;
			}
			//Header 1
			else if(i<arr.length && arr[i]=='#'){
				for(i =0; i<arr.length; i++){
				      if(arr[i] != '#' ){
				      string += arr[i];
				      }
				}
				
				h = 0;
				while(arr.length>0 && arr[h]=='#'){
					h++;
				}
				Token token = new Token(string);
				if(h==1){
			        string = "<H1>"+ string + "</H1>";
		            Header header=new Header(string);
		            node.add(header);
	
				}
				if(h==2){
			        string = "<H2>"+ string + "</H2>";
		            Header header=new Header(string);
		            node.add(header);
	
				}
				if(h==3){
			        string = "<H3>"+ string + "</H3>";
		            Header header=new Header(string);
		            node.add(header);
	
				}
				if(h==4){
			        string = "<H4>"+ string + "</H4>";
		            Header header=new Header(string);
		            node.add(header);
	
				}
				if(h==5){
			        string = "<H5>"+ string + "</H5>";
		            Header header=new Header(string);
		            node.add(header);
	
				}
				if(h==6){
			        string = "<H6>"+ string + "</H6>";
		            Header header=new Header(string);
		            node.add(header);
	
				}
				if(pre==7){
					i=0;				
					while(arr[i]=='='){
						if(i==(arr.length-1)){
							
					        string = "<H1>"+ s[j-1] + "</H1>";
				            Header header=new Header(string);
				            node.add(header);
						}
						i++;
					}
				}
				pre=1;
				i=0;
				string="";
			}
			
			//Horizontal rule 3
			//Item list 4
			//Line Break 5
			//Quoted block 6
			//Text 7
			else{
				Node node = new Node(s, j, htmlname);
				Token token= new Token(string);
				
				pre=7;
			}
			
			
			string="";
		}
		for(int a=0; a<node.size(); a++){
			(node.get(a)).accept(visitor);
		}
		visitor.makehtml(htmlname);
		System.out.println(string);
	}

	public void accept(MDElementVisitor v) throws IOException{
		v.visitNode(this);
	}

}
