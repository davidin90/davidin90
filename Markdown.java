

import java.util.*;
import java.io.*;

public class Markdown{
    public static String command;
    public static String[] array;
    public static File md;
    public static File html0;
    public static FileWriter html;
    public static boolean next;
   public static void main(String[] args) throws IOException{

     while(true){

        System.out.print(new File(".").getCanonicalPath()+">");
         Scanner scanner=new Scanner(System.in);
         command=scanner.nextLine();
         // user�� ���� ������ �Է� �޴´�.

         if(command.equalsIgnoreCase("help")){
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Please enter in a specific order.");
            System.out.println("Ex) Convert a.md a.html plain.");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("If you enter 'quit', you can exit the program.");
            System.out.println("If you enter 'ls', you can check your list of current md & html files");
            System.out.println("---------------------------------------------------------------------");
         }
         // user�� help�� �Է����� �� ���� ������ print�Ѵ�.(��, ��ҹ��ڴ� ����)

         else if(command.equalsIgnoreCase("quit")){
            System.out.println("Exit the program.");
            //delay.
            break;
         }
         // user�� quit�� �Է����� �� ���� ������ print�ϰ� ���α׷��� ���� ��Ų��. (��, ��ҹ��ڴ� ����)

         else if(command.equalsIgnoreCase("ls")){
            ls();
         }
         // user�� ls�� �Է����� �� ���� �Լ��� �����Ѵ�. (��, ��ҹ��ڴ� ����)
         // ����, ����ܰ迡 �־ ���� �ڵ带 ¥���� �ʾҴ�.

         else{
            array=command.split(" ");
            // user���� �Է� ���� input�� �����Ѵ�.

            if(array.length==4){
               convert(); // user�� 'convert'��� �ܾ ����� �Է��ߴ��� �˾ƺ��� �Լ�
               md(); // user�� �����ϴ� .md ������ �Է��ߴ��� �˾ƺ��� �Լ�
               html(); //user�� �Է��� .html ������ �Է��ߴ��� �˾ƺ��� �Լ�
               htmlStyle(); // user�� � style�� �����ߴ��� ���� �Լ�
               if(next==true){
            	   makehtml();  //html ������ ����� �Լ�
               }
            }
            // user���� �Է� ���� input�� 4���� �ʿ��ϱ� ������ 4�� �� ��츸 �����Ѵ�.
            else{
               System.out.println("You should enter 4 words.\nIf you don't know how to enter, enter 'help'.");
            }
            // user���� �Է� ���� input�� 4���� �ƴ� ���, ���� �޼����� ����Ѵ�.
         }
        }
   }

   public static void ls(){

   } // ������ .md, .html ������ �����ִ� �Լ�
     // ���� ����ܰ迡 �־, �ڵ带 ���� ¥���� �ʾҴ�.

   public static void convert(){
      if(array[0].equalsIgnoreCase("convert")){
    	  next=true;
      }
      // user�� 'convert'�� ����� �Է� ������ �����޼����� ������� �ʴ´�.
      else{
    	  next=false;
         System.out.println("Try to enter 'convert' again.");
      }
      // user�� 'convert'�� ����� �Է����� �������� �����޼����� ����Ѵ�.
   }

   public static void md() throws IOException{
      if(array[1].endsWith(".md")){
        md = new File(array[1]);
        if(md.isFile()){
        }
        else{
            System.out.println("There is no md File");
            next=false;
        }
              }
     else{
         System.out.println("It is not md file.");
         next=false;
      }
    }
   public static void html() throws IOException {
	   if(array[2].endsWith(".html")){
           html0=new File(array[2]);
              if(html0.isFile()){
                  System.out.println("That file has already existed.");
                  next=false;
              }

         }
         else{
                 System.out.println("It is not html file");
                 next=false;
         }
   }

   public static void htmlStyle() throws IOException{

           if(array[3].equalsIgnoreCase("plain")){

           }
           else if(array[3].equalsIgnoreCase("fancy")){

           }
           else if(array[3].equalsIgnoreCase("slide")){

           }
           else{
        	   next=false;
              System.out.println("Try to choose style again");
           }
   }
   public static void makehtml() throws IOException{
	   if(next==true){
           html=new FileWriter(array[2]);
           System.out.println("Html file is created.");
     	 }
   }

}
