package markdown;
import org.w3c.tidy.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



public class Fancy implements MDElementVisitor{
   ArrayList<MDElement> node = new ArrayList<MDElement>();
   private String s;
   private int a=0;
   public Fancy(){
   }

   public void visitDocument(Document document) {
      // TODO Auto-generated method stub

   }
   public void visitNode(Node n){
      node.add(n);
   }
   public void visitToken(Token token){
	node.add(token);

   }
   public void makehtml(String string) throws IOException{

      try{


         File html0=new File(string);
          if(html0.isFile()){
                System.out.println("That file has already existed.");
                node.clear();
            }
          else{
                s="<!Doctype html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n"+"<html>\n"+"<head>\n"+"<style>\n"+
          "p {font-family: serif; color:white;}\n"+
          "h1 {border-bottom: 1px solid gray; color:white;}\n"+
          "body {background-color: beige;}\n"+
          "h2 {color:green}\n"+
          "h3 {color:blue}\n"+
          "hr {height: 10px; background: purple}\n" +
          "blockquote {font-style : italic}\n"+
          "ul li {text-align :  center ; text-decoration: underline}\n"+
          "ul li li {text-align :  right}\n" +
                		"</style>\n"
               +"</head>\n"+"<body>\n";
                  for(int i=0; i<node.size(); i++){
                     s = s+(node.get(i)).getstring()+"\n";
                  }
                  s= s+"</body>\n"+"</html>\n";
                   if(isValid(s)){
                     FileWriter html=new FileWriter(string);
                     html.write(s);
                     html.close();
                     System.out.println("Html file is created.");
                     node.clear();

                   }
          }
      }

      catch(IOException e){
         e.getMessage();
      }

   }

   private boolean isValid(String htmlData){
            Tidy tidy = new Tidy();
            //InputStream stream = new ByteArrayInputStream(htmlData.getBytes());
           // tidy.parse(stream, System.out);
            return (tidy.getParseErrors() == 0);
   }

}