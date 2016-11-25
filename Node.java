
import java.io.IOException;
import java.util.*;

public class Node implements MDElement{

   /*private static ArrayList<MDElement[]> parselist = null;
   private static ArrayList<Node> nodelist = null;
   private static ArrayList<Token> tokenlist = null;
   private static String[] stringlist = null;
   private static String nodestring = null;
   private static String tokenstring = null;
   private static MDElement[] elementlist = null;*/
   public static String string = new String();
   public static Plain visitor= new Plain();

   public String strings;
   public static Node N;

   Node(){
   }
   Node(String[] s, int b, String htmlname) throws IOException{
      node.clear();
      char[] arr;
      int h=0;
      for(int j = 0; j<b; j++){
         //Backslash
         //Block
         //Character
         //Header
         arr = s[j].toCharArray();
         for(int i =0; i<arr.length; i++){
               if(arr[i] != '#'){
               string += arr[i];
               }
         }
         h=0;
         for(int i=0; i<arr.length; i++){

            if(arr[i]=='#'){
               h=h+1;
            }
         }

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
         string="";
      }
         //Horizontal rule
         //Href
         //Image
         //Item list
         //Line Break
         //Quoted block
         //Text
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