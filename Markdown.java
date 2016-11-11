

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
         // user로 부터 정보를 입력 받는다.

         if(command.equalsIgnoreCase("help")){
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Please enter in a specific order.");
            System.out.println("Ex) Convert a.md a.html plain.");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("If you enter 'quit', you can exit the program.");
            System.out.println("If you enter 'ls', you can check your list of current md & html files");
            System.out.println("---------------------------------------------------------------------");
         }
         // user가 help를 입력했을 때 위의 내용을 print한다.(단, 대소문자는 무시)

         else if(command.equalsIgnoreCase("quit")){
            System.out.println("Exit the program.");
            //delay.
            break;
         }
         // user가 quit을 입력했을 때 위의 내용을 print하고 프로그램을 종료 시킨다. (단, 대소문자는 무시)

         else if(command.equalsIgnoreCase("ls")){
            ls();
         }
         // user가 ls을 입력했을 때 위의 함수를 시행한다. (단, 대소문자는 무시)
         // 아직, 구상단계에 있어서 직접 코드를 짜지는 않았다.

         else{
            array=command.split(" ");
            // user에게 입력 받은 input을 분할한다.

            if(array.length==4){
               convert(); // user가 'convert'라는 단어를 제대로 입력했는지 알아보는 함수
               md(); // user가 존재하는 .md 파일을 입력했는지 알아보는 함수
               html(); //user가 입력한 .html 파일을 입력했는지 알아보는 함수
               htmlStyle(); // user가 어떤 style을 선택했는지 고르는 함수
               if(next==true){
            	   makehtml();  //html 파일을 만드는 함수
               }
            }
            // user에게 입력 받은 input은 4개가 필요하기 때문에 4개 일 경우만 실행한다.
            else{
               System.out.println("You should enter 4 words.\nIf you don't know how to enter, enter 'help'.");
            }
            // user에게 입력 받은 input이 4개가 아닐 경우, 에러 메세지를 출력한다.
         }
        }
   }

   public static void ls(){

   } // 현재의 .md, .html 파일을 보여주는 함수
     // 아직 구상단계에 있어서, 코드를 직접 짜지는 않았다.

   public static void convert(){
      if(array[0].equalsIgnoreCase("convert")){
    	  next=true;
      }
      // user가 'convert'를 제대로 입력 했으면 에러메세지를 출력하지 않는다.
      else{
    	  next=false;
         System.out.println("Try to enter 'convert' again.");
      }
      // user가 'convert'를 제대로 입력하지 못했으면 에러메세지를 출력한다.
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
