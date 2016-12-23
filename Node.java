package markdown;

import java.io.IOException;
import java.util.*;

public class Node implements MDElement{

   protected static String strings=new String();
   static ArrayList<Node> nodelist = new ArrayList<Node>();
   public static String string=new String();
   public static String[] st;
   public static String[] next=new String[1000];
   public static Node n=new Node();
   
   public static int iter=1;
   
   Node(){
   }
   Node(String[] s) throws IOException{
	   st=s;
	   accept(new Plain());
	   
   }
   Node(String s){
      strings=s;
   }

   public void accept(MDElementVisitor v) throws IOException{
	  /*int i=0;
	  while(st[i]!=null){
		   Node n = new Node(st[i]);
		   v.visitNode(n);
		   next[i]=n.strings;
		   i++;
	  }*/
	   v.visitNode(this);
   }
   public String getstring(){
	  return strings;
   }
}
