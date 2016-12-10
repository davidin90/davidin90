package markdown;

import java.io.IOException;
import java.util.*;

public class Node implements MDElement{

   static ArrayList<Node> nodelist = new ArrayList<Node>();

   public static int iter=1;
   public static String string = new String();
   public static Plain visitor= new Plain();
   public static int pre=0;
   public String strings;
   public static Node N;
   public static Token token;
   public static int list=0;
   Node(){
   }
   Node(String s, String htmlname) throws IOException{
      //node.clear();
      char[] arr;
      int h=0;
      int j=0;
         arr = s.toCharArray();
         int i=0;

         //Item list 4

            if(list >= 1 || (2 <arr.length && (arr[i]=='*' || arr[i]=='+' || arr[i]=='-') && arr[i+1] ==' ')){

                      if(arr.length>i+1 && arr[i+1]==' '){
                                 pre = 4;
                           }

                        if(pre == 4 && list == 0){              //list가 처음 시작하는 경우
                           //System.out.println("시작");
                           for(int a=i+2; a<arr.length; a++){
                                 string += arr[a];
                           }
                           Token token = new Token(string);
                           string="<ul><li>" + string;

                           //System.out.println(string);

                           Item_List item_list = new Item_List(string);
                           elementlist.add(item_list);
                           iter++;
                           list = 1;
                        //string="";
                        }else if(arr.length == 0){     //list 안에서 엔터가 들어온 경우
                            if(list==2){
                           string="</li></ul></ul>";
                           list--;
                            }
                            else{
                               string="</li></ul>";
                            }
                             Item_List item_list = new Item_List(string);
                             elementlist.add(item_list);
                             iter++;
                             list--;


                      }else if(((arr[i]=='*' || arr[i]=='+' || arr[i]=='-') && arr[i+1] ==' ') && list ==1) {//list의 위에 list가 있었는 경우
                                 for(int a=i+2; a<arr.length; a++){
                                       string += arr[a];
                                 }
                                 Token token = new Token(string);
                                 string="</li><li>" + string;
                                 Item_List item_list = new Item_List(string);
                                 elementlist.add(item_list);
                                 iter++;
                     }else if(list == 1 && ((arr.length > 5 && s.substring(0,4).equals("    "))
                                                        || (arr.length>3 && arr[0] == '\t'))){//list 안의 list

                             if(s.substring(0,4).equals("    ")){

                                  if((arr[4] == '*' || arr[4] == '+' || arr[4] == '-') && arr[5] == ' '){
                                     for(int a=6; a<arr.length; a++){
                                            string += arr[a];
                                      }
                                      Token token = new Token(string);
                                      string="<ul><li>" + string;
                                      Item_List item_list = new Item_List(string);
                                      elementlist.add(item_list);
                                      iter++;
                                      list = 2;
                                  }
                               }else{
                                   if((arr[1] == '*' || arr[1] == '+' || arr[1] == '-') && arr[2] == ' '){
                                        for(int a=2; a<arr.length; a++){
                                               string += arr[a];
                                         }
                                         Token token = new Token(string);
                                         string="<ul><li>" + string;
                                         Item_List item_list = new Item_List(string);
                                         elementlist.add(item_list);
                                         list = 2;
                                         iter++;
                                     }
                                }
                        }else if(list==2 && arr.length>2 && (arr[0]=='*' || arr[0]=='+' || arr[0]=='-') && arr[1] ==' '){
                               //list 2 이후  list 1
                               for(int a=2; a<arr.length; a++){
                                    string += arr[a];
                              }
                              Token token = new Token(string);
                              string="</li></ul><li>" + string;
                              Item_List item_list = new Item_List(string);
                              elementlist.add(item_list);
                              list = 1;
                              iter++;
                        }else if(list == 2 && ((arr.length > 5 &&s.substring(0,4).equals("    "))
                                || (arr.length>3 && arr[0] == '\t'))){
                               //list 2 이후  list 2
                               if(arr.length>5 && s.substring(0,4).equals("    ")){
                                    if(arr[4] == '*' || arr[4] == '+' || arr[4] == '-'){
                                       for(int a=5; a<arr.length; a++){
                                              string += arr[a];
                                        }
                                        Token token = new Token(string);
                                        string="</li><li>" + string;
                                        Item_List item_list = new Item_List(string);
                                        elementlist.add(item_list);
                                        iter++;
                                        list = 2;
                                    }
                                 }
                               else{
                                  if((arr[1] == '*' || arr[1] == '+' || arr[1] == '-') && arr[2] == ' '){
                                       for(int a=2; a<arr.length; a++){
                                              string += arr[a];
                                        }
                                        Token token = new Token(string);
                                        string="</li><li>" + string;
                                        Item_List item_list = new Item_List(string);
                                        elementlist.add(item_list);
                                        iter++;
                                        list = 2;
                                    }
                               }

                        }else if(arr[i] != '\n' && (list == 1) || (list ==2)){                //list 안에서 그냥 문장이 온 경우
                                 for(i=0; i <arr.length; i++){
                                       string += arr[i];
                                 }
                                 Token token = new Token(string);
                                 Item_List item_list = new Item_List(string);
                                 elementlist.add(item_list);
                                 iter++;
                          }
                  i=0;
                  }
         //Horizontal rule 3

            else if((i<arr.length) && ((arr[i] == '-') || (arr[i] == '*'))){
              int h_n = 0;
               int a_n = 0;


              while(i<arr.length){
                  if(arr[i] == '-'){
                     h_n++;
                     i++;
                  }
                  else if(arr[i] == '*'){
                     a_n++;
                     i++;
                  }
                  else{
                     break;
                  }
               }
              if(h_n>=3 || a_n>=3){
              pre = 3;

               }
               if(pre == 3){
                string= "<hr>";
                iter++;
               Horizontal_rule h_rule = new Horizontal_rule(string);
               elementlist.add(h_rule);
            }
               i = 0;

         }



         //Header 1
            else if(i<arr.length && arr[i]=='#' ){
                for(i =0; i<arr.length; i++){
                      if(arr[i] != '#' ){
                      string += arr[i];
                      break;
                      }
                }
               if(arr[arr.length-1]=='#')
                  for(h=arr.length-1; h>=0; h--){
                     if(arr[h]=='#'){
                        arr[h]=' ';
                     }
                     else
                        break;

                  }
               for(j=i+1; j<arr.length;j++){

                      //if(j==arr.length-i)
                       //  if(arr[j]=='#'){
                       //     i--;
                       //     continue;
                       //  }
                      string +=arr[j];
                   }

            h = 0;
            while(arr.length>0 && arr[h]=='#'){
               h++;
            }
            Token token = new Token(string);
            string = token.getstring();
            if(h==1){
               /*EmString="";
               for(i=0; i<d.length()-3; i++){
                  c+=arr[i+2];
                  EmString+=arr[i+2];
               }
               System.out.println(c);
                 string = "<H1>"+ (new Node(c, 1, htmlname)).EmString + "</H1>";
                  Header header=new Header(string);
                  node.add(header);*/
               string = "<H1>"+ string + "</H1>";
                  Header header=new Header(string);
                  elementlist.add(header);
            }
            if(h==2){
                 string = "<H2>"+ string + "</H2>";
                  Header header=new Header(string);
                  elementlist.add(header);

            }
            if(h==3){
                 string = "<H3>"+ string + "</H3>";
                  Header header=new Header(string);
                  elementlist.add(header);

            }
            if(h==4){
                 string = "<H4>"+ string + "</H4>";
                  Header header=new Header(string);
                  elementlist.add(header);

            }
            if(h==5){
                 string = "<H5>"+ string + "</H5>";
                  Header header=new Header(string);
                  elementlist.add(header);

            }
            if(h==6){

                 string = "<H6>"+ string + "</H6>";
                  Header header=new Header(string);
                  elementlist.add(header);

            }
            pre=1;
            i=0;
            iter++;
         }
         else if(i<arr.length && arr[i]=='='&&pre==7){
               i=0;
               while(i<arr.length && arr[i]=='='){
                  if(i==(arr.length-1)){
                       string = "<H1>"+ (elementlist.get(elementlist.size()-1)).getstring() + "</H1>";
                        Header header=new Header(string);

                        elementlist.remove(elementlist.size()-1);
                        elementlist.add(header);

                  }
                  i++;
               }

               pre=1;
               i=0;
            }


            //string="";



               //Line Break 5

          //Block 0
         else if(list == 0 && i<arr.length && (arr[i]==' ' || arr[i]=='\t')){
               while(i<arr.length){
                  if(arr[i]==' '){
                     if(i==3){
                        pre=0;
                        break;
                     }
                     i++;
                  }
                  else if(arr[i]=='\t'){
                     pre=0;
                     break;
                  }
                  else{
                     break;
                  }
               }
               if(pre==0){
                  for(int a=i+1; a<arr.length; a++){
                     string += arr[a];
                  }

                  string="<pre><code>"+string+"</code></pre>";
                  iter++;
                  Block block = new Block(string);
                  elementlist.add(block);
                  //string="";
               }
               i=0;
            }


               //Quoted block 6

         else if(i<arr.length && (arr[i]=='>')){
                int q_n = 0;
                while(i<arr.length){
                     if(arr[i]=='>'){
                       q_n++;
                        i++;
                        pre = 4;
                     }
                     else{
                        break;
                     }
                  }


                  if(pre == 4){
                     for(int a=q_n; a<arr.length; a++){
                           string += arr[a];
                     }
                     Token token = new Token(string);
                     string = token.getstring();
                     for(int a=0; a<q_n; a++){
                           string="<blockquote>"+string+"</blockquote>";
                     }
                     iter++;
                  Quoted_block q_block = new Quoted_block(string);
                  elementlist.add(q_block);
                  //string="";
               }
         i=0;
         }
         //Text 7
         else{
            token= new Token(s);
            string=token.getstring();
            elementlist.add(token);
            pre=7;
            i=0;
            iter++;
         }
      string="";
   }

   public void accept(MDElementVisitor v) throws IOException{
      v.visitNode(this);
   }
   public String getstring(){
      return strings;
   }


}
