package markdown;
import org.w3c.tidy.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



public class Fancy implements MDElementVisitor{
   private int a=0;

   private String s;
   public static Plain visitor= new Plain();
   public static int pre=0;
   public String strings;
   public static Node N;
   public static Token token;
   public static int list=0;
   public static int d=0;
   
   public Fancy(){
   }

   public void visitDocument(Document document) throws IOException {
	   int i=0;
	   int j=0;
	   
	   int k=document.li;
	   	   
	  /* for(i=0; i<k; i++){ 
			
			
			Node parsernode=new Node(document.documentlist.get(d)[i]);
			
			
			parsernode.accept(new Plain());
			
			System.out.println("string:   "+parsernode.strings);
			
			if(parsernode.iter==j){
				continue;
			}
			document.node2.add(parsernode);
			
			if(document.node2.size()>2){
				System.out.println("string  :  "+document.node2.get(document.node2.size()-3).getstring());
			}
			
			parsernode.string="";
			j=parsernode.iter;
		}
	   	

		//parsernode.elementlist.clear();
		*/
		k = 0;
	      try{


	          File html0=new File(document.hn);
	          
	           if(html0.isFile()){
	                 System.out.println("That file has already existed.");
	                 document.resultlist.clear();
	             }
	           else{
	        	   s="<!Doctype html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n"+"<html>\n"+"<head>\n"+"<style>\n"+
	        		 
	        		          "body {background-color: beige;}\n"+
	        		          
	        		                      "</style>\n"
	        		               +"</head>\n"+"<body>\n";
	                 
	                   for(i=0; i<document.resultlist.size(); i++){
	                	   for(j=0; j<document.resultlist.get(i).size(); j++){
	                		   s=s+document.resultlist.get(i).get(j);

	                	   }
	                      //s = s+(document.node2.get(i)).getstring()+"\n";
	                   }
	                   s= s+"</body>\n"+"</html>\n";
	                    if(isValid(s)){
	                      FileWriter html=new FileWriter(document.hn);
	                      html.write(s);
	                      html.close();
	                      System.out.println("Html file is created.");
	                      document.resultlist.clear();

	                    }
	           }
	       }

	       catch(IOException e){
	          e.getMessage();
	       }
	      d++;
			document.resultlist.clear();

   }
   public void visitNode(Node n){
	   
	   char[] arr;
	      int h=0;
	      int j=0;
	         arr = n.strings.toCharArray();       
	         
	         int i=0;
	            
	         //Item list 4
	            
	            if(list >= 1 || (2 <arr.length && (arr[i]=='*' || arr[i]=='+' || arr[i]=='-') && arr[i+1] ==' ')){
	           
	                      if(arr.length>i+1 && arr[i+1]==' '){
	                                 pre = 4;
	                           }
	                           
	                        if(pre == 4 && list == 0){              //list가 처음 시작하는 경우
	                           //System.out.println("시작");
	                           for(int a=i+2; a<arr.length; a++){
	                                 n.string += arr[a];
	                           }
	                           Token token = new Token(n.string);
	                           token.accept(this);
	                           n.string=token.getstring();
	                           n.string="<ul><li>" + n.string;
	                           
	                           //System.out.println(n.string);
	                                                  
	                           Item_List item_list = new Item_List(n.string);
	                           elementlist.add(item_list);
	                           n.iter++;
	                           list = 1;
	                        //n.string="";
	                        }else if(arr.length == 0){     //list 안에서 엔터가 들어온 경우
	                            if(list==2){ 
	                           n.string="</li></ul></ul>";
	                           list--;
	                            }
	                            else if(list==1){
	                               n.string="</li></ul>";
	                            }
	                             Item_List item_list = new Item_List(n.string);
	                             elementlist.add(item_list);
	                             n.iter++;
	                             list--;
	                            
	                         
	                      }else if(((arr[i]=='*' || arr[i]=='+' || arr[i]=='-') && arr[i+1] ==' ') && list ==1) {//list의 위에 list가 있었는 경우
	                                 for(int a=i+2; a<arr.length; a++){
	                                       n.string += arr[a];
	                                 }
	                                 Token token = new Token(n.string);
	                                 token.accept(this);
	  	                           n.string=token.getstring();
	                                 n.string="</li><li>" + n.string;                       
	                                 Item_List item_list = new Item_List(n.string);
	                                 elementlist.add(item_list);
	                                 n.iter++;
	                     }else if(list == 1 && ((arr.length > 5 && n.strings.substring(0,4).equals("    ")) 
	                                                        || (arr.length>3 && arr[0] == '\t'))){//list 안의 list
	                         
	                             if(n.strings.substring(0,4).equals("    ")){
	                                
	                                  if((arr[4] == '*' || arr[4] == '+' || arr[4] == '-') && arr[5] == ' '){
	                                     for(int a=6; a<arr.length; a++){
	                                            n.string += arr[a];
	                                      }
	                                      Token token = new Token(n.string);
	                                      token.accept(this);
	       	                           n.string=token.getstring();
	                                      n.string="<ul><li>" + n.string;                                                       
	                                      Item_List item_list = new Item_List(n.string);
	                                      elementlist.add(item_list);
	                                      n.iter++;
	                                      list = 2;
	                                  }
	                               }else{
	                                   if((arr[1] == '*' || arr[1] == '+' || arr[1] == '-') && arr[2] == ' '){
	                                        for(int a=2; a<arr.length; a++){
	                                               n.string += arr[a];
	                                         }
	                                         Token token = new Token(n.string);
	                                         token.accept(this);
	          	                           n.string=token.getstring();
	                                         n.string="<ul><li>" + n.string;                                                       
	                                         Item_List item_list = new Item_List(n.string);
	                                         elementlist.add(item_list);
	                                         list = 2;
	                                         n.iter++;
	                                     }
	                                }
	                        }else if(list==2 && arr.length>2 && (arr[0]=='*' || arr[0]=='+' || arr[0]=='-') && arr[1] ==' '){
	                               //list 2 이후  list 1
	                               for(int a=2; a<arr.length; a++){
	                                    n.string += arr[a];
	                              }
	                              Token token = new Token(n.string);
	                              token.accept(this);
		                           n.string=token.getstring();
	                              n.string="</li></ul><li>" + n.string;                                                       
	                              Item_List item_list = new Item_List(n.string);
	                              elementlist.add(item_list);
	                              list = 1;
	                              n.iter++;
	                        }else if(list == 2 && ((arr.length > 5 &&n.strings.substring(0,4).equals("    ")) 
	                                || (arr.length>3 && arr[0] == '\t'))){
	                               //list 2 이후  list 2
	                               if(arr.length>5 && n.strings.substring(0,4).equals("    ")){
	                                    if(arr[4] == '*' || arr[4] == '+' || arr[4] == '-'){
	                                       for(int a=5; a<arr.length; a++){
	                                              n.string += arr[a];
	                                        }
	                                        Token token = new Token(n.string);
	                                        token.accept(this);
	         	                           n.string=token.getstring();
	                                        n.string="</li><li>" + n.string;                                                       
	                                        Item_List item_list = new Item_List(n.string);
	                                        elementlist.add(item_list);
	                                        n.iter++;
	                                        list = 2;
	                                    }
	                                 }
	                               else{
	                                  if((arr[1] == '*' || arr[1] == '+' || arr[1] == '-') && arr[2] == ' '){
	                                       for(int a=2; a<arr.length; a++){
	                                              n.string += arr[a];
	                                        }
	                                        Token token = new Token(n.string);
	                                        token.accept(this);
	         	                           n.string=token.getstring();
	                                        
	                                        n.string="</li><li>" + n.string;                                                       
	                                        Item_List item_list = new Item_List(n.string);
	                                        elementlist.add(item_list);
	                                        n.iter++;
	                                        list = 2;
	                                    }
	                               }
	                               
	                        }else if(arr[i] != '\n' && (list == 1) || (list ==2)){                //list 안에서 그냥 문장이 온 경우
	                                 for(i=0; i <arr.length; i++){
	                                       n.string += arr[i];
	                                 }
	                                 Token token = new Token(n.string);   
	                                 token.accept(this);
	  	                           n.string=token.getstring();
	                                 Item_List item_list = new Item_List(n.string);
	                                 elementlist.add(item_list);
	                                 n.iter++;
	                          }
	                  i=0;
	                  }
	         //Horizontal rule 3
	         
	            else if((i<arr.length) && ((arr[i] == '-') || (arr[i] == '*'))){
	              int h_n = 0;
	               int a_n = 0;
	               int hr=0;
	             
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
	      	            token= new Token(n.strings);
	    	            token.accept(this);
	    	            n.string=token.getstring();
	    	            hr=1;
	                     break;
	                  }
	               }
	              if(hr==0&&(h_n>=3 || a_n>=3)){
	              
	                n.string= "<hr style=\"height:5px; background:purple\">";
	                n.iter++;
	               Horizontal_rule h_rule = new Horizontal_rule(n.string);
	               elementlist.add(h_rule);
	            } 
	               i = 0;
	              
	         }      
	         
	         
	         
	         //Header 1
	            
	            else if(i<arr.length && arr[i]=='#' ){
	            	
	                for(i =0; i<arr.length; i++){
	                      if(arr[i] != '#' ){
	                    	 
	                      n.string += arr[i];
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
	                      n.string +=arr[j];
	                   }
	                
	            h = 0;
	            while(arr.length>0 && arr[h]=='#'){
	               h++;
	            }
	            Token token = new Token(n.string);
	            token.accept(this);
	            n.string = token.getstring();
	            if(h==1){
	               /*Emn.string="";
	               for(i=0; i<d.length()-3; i++){
	                  c+=arr[i+2];
	                  Emn.string+=arr[i+2];
	               }
	               System.out.println(c);
	                 n.string = "<H1>"+ (new Node(c, 1, htmlname)).Emn.string + "</H1>";
	                  Header header=new Header(n.string);
	                  node.add(header);*/
	               n.string = "<center><H1>"+ n.string + "</H1></center>";
	                  Header header=new Header(n.string);
	                  elementlist.add(header);
	            }
	            if(h==2){
	                 n.string = "<H2 style=\"color:red\">"+ n.string + "</H2>";
	                  Header header=new Header(n.string);
	                  elementlist.add(header);
	   
	            }
	            if(h==3){
	                 n.string = "<H3 style=\"color:blue; font-family:serif\">"+ n.string + "</H3>";
	                  Header header=new Header(n.string);
	                  elementlist.add(header);
	   
	            }
	            if(h==4){
	                 n.string = "<H4>"+ n.string + "</H4>";
	                  Header header=new Header(n.string);
	                  elementlist.add(header);
	   
	            }
	            if(h==5){
	                 n.string = "<H5>"+ n.string + "</H5>";
	                  Header header=new Header(n.string);
	                  elementlist.add(header);
	   
	            }
	            if(h==6){
	               
	                 n.string = "<H6>"+ n.string + "</H6>";
	                  Header header=new Header(n.string);
	                  elementlist.add(header);
	   
	            }
	            pre=1;
	            i=0;
	            n.iter++;
	         }
	         else if(i<arr.length && arr[i]=='='&&pre==7){
	               i=0;            
	               while(i<arr.length && arr[i]=='='){
	                  if(i==(arr.length-1)){
	                       n.string = "<H1>"+ (elementlist.get(elementlist.size()-1)).getstring() + "</H1>";
	                        Header header=new Header(n.string);
	                     
	                        elementlist.remove(elementlist.size()-1);
	                        elementlist.add(header);
	                        
	                  }
	                  i++;
	               }

	               pre=1;
	               i=0;
	            }
	         
	   
	            //n.string="";
	         
	            
	         
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
	                     n.string += arr[a];
	                  }
	                  
	                  n.string="<pre><code>"+n.string+"</code></pre>";
	                  n.iter++;
	                  Block block = new Block(n.string);
	                  elementlist.add(block);
	                  //n.string="";
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
	                           n.string += arr[a];
	                     }
	                     Token token = new Token(n.string);
	                     token.accept(this);
	                     n.string = token.getstring();
	                     for(int a=0; a<q_n; a++){
	                           n.string="<blockquote style=\"font-style:italic\">"+n.string+"</blockquote>";
	                     }
	                     n.iter++;
	                  Quoted_block q_block = new Quoted_block(n.string);
	                  elementlist.add(q_block);
	                  //n.string="";
	               }   
	         i=0;
	         }
	         //Text 7
	         else{
	            token= new Token(n.strings);
	            token.accept(this);
	            n.string=token.getstring();
	            elementlist.add(token);
	            pre=7;
	            i=0;
	            n.iter++;
	         }
	  n.strings=n.string;
	  n.string="";
   }
   public void visitToken(Token token){
	   char[] arr;
       strings="";
     //Image
       if(token.strings.indexOf("!")!=-1 && token.strings.indexOf("!")+1==token.strings.indexOf("[") && token.strings.indexOf("[")<token.strings.indexOf("]")){
           if(token.strings.indexOf("(")==(token.strings.indexOf("]")+1) && token.strings.indexOf(")")!=-1){
              if(token.strings.indexOf("(")<token.strings.indexOf("\"") && token.strings.indexOf(")")>token.strings.indexOf("\"", token.strings.indexOf("\"")+1) &&
                    token.strings.indexOf("\"")!=-1 && token.strings.indexOf("\"", token.strings.indexOf("\"")+1)!=-1){
                 strings=token.strings.substring(0, token.strings.indexOf("!"))+"<img src=\""+ 
                       token.strings.substring(token.strings.indexOf("(")+1, token.strings.indexOf("\"")-1)+"\" alt=\""+
                       token.strings.substring(token.strings.indexOf("[")+1, token.strings.indexOf("]"))+"\" title="+
                       token.strings.substring(token.strings.indexOf("\""), token.strings.indexOf(")"))+" />";
              }
              else{
                 strings=token.strings.substring(0, token.strings.indexOf("!"))+"<img src=\""+ 
                       token.strings.substring(token.strings.indexOf("(")+1, token.strings.indexOf(")"))+"\" alt=\""+
                       token.strings.substring(token.strings.indexOf("[")+1, token.strings.indexOf("]"))+"\" title=\"\" />";
              }
              if(token.strings.length()>(token.strings.indexOf(")")+1)){
                 strings+=token.strings.substring(token.strings.indexOf(")")+1);
              }
           }
           token.strings=strings;
           
        }
       
       if(token.strings.indexOf("[")!=-1 && token.strings.indexOf("[")<token.strings.indexOf("]")){
           if(token.strings.indexOf("(")==(token.strings.indexOf("]")+1) && token.strings.indexOf(")")!=-1){
              if(token.strings.indexOf("(")<token.strings.indexOf("\"") && token.strings.indexOf(")")>token.strings.indexOf("\"", token.strings.indexOf("\"")+1) &&
                    token.strings.indexOf("\"")!=-1 && token.strings.indexOf("\"", token.strings.indexOf("\"")+1)!=-1){
                 
                 strings=token.strings.substring(0, token.strings.indexOf("["))+"<a href=\""+ 
                       token.strings.substring(token.strings.indexOf("(")+1, token.strings.indexOf("\"")-1)+"\" title="+
                       token.strings.substring(token.strings.indexOf("\""), token.strings.indexOf(")"))+">"+
                       token.strings.substring(token.strings.indexOf("[")+1, token.strings.indexOf("]"))+"</a>";
              }
              else{
                 strings=token.strings.substring(0, token.strings.indexOf("["))+"<a href=\""+ 
                       token.strings.substring(token.strings.indexOf("(")+1, token.strings.indexOf(")"))+"\">"+
                       token.strings.substring(token.strings.indexOf("[")+1, token.strings.indexOf("]"))+"</a>";
              }
              if(token.strings.length()>(token.strings.indexOf(")")+1)){
                 strings+=token.strings.substring(token.strings.indexOf(")")+1);
              }
              token.strings=strings;
           }
           
        }
    if(token.strings.indexOf("``")==-1&& token.strings.indexOf("`")!=-1){         
        strings=token.strings.replace("\\\\`", "hongsin");
        strings=strings.replaceFirst("`", "<code>");
        strings=strings.replaceFirst("`", "</code>");
        strings=strings.replace("hongsin", "`");
        token.strings=strings;
     }
    else if(token.strings.indexOf("`")!=-1){
        strings=token.strings.replaceFirst("``", "<code>");
        strings=strings.replaceFirst("``", "</code>");
        token.strings=strings;
     }
    
     
  //backslash
    int i=0;
    int index = 0;
    int pre = 0;  
    arr = token.strings.toCharArray();
    for(i=0;i<arr.length;i++){
      if(arr[i] == '\\'){
       if(arr.length>i+1){
    	   if( (arr[i+1] == '\\' || arr[i+1] == '`' || arr[i+1] == '*'
    	     || arr[i+1] == '_'||arr[i+1] == '{' || arr[i+1] == '}'
             || arr[i+1] == '[' || arr[i+1] == ']' ||arr[i+1] == '('
             || arr[i+1] == ')' || arr[i+1] == '#' ||arr[i+1] == '.'
             || arr[i+1] == '!')){
          pre = 10;
          index = i;
    	   }
      }
      }
     }
     
     if(pre == 10){
          strings="";
        for(int a=0; a<arr.length; a++){
           if(a == index){
              arr[a] = ' ';
           }
           strings += arr[a];
        }
       Backslash backslash = new Backslash(strings);
       token.strings=strings;
     }
     //strong
    strings="";
    arr = token.strings.toCharArray();
    i = 0;         
     for(i =0; i<arr.length-2;i++){
        for(int j = (i+2); j<arr.length-1;j++){
           if(((arr[i] == '*' && arr[i+1] == '*') &&(arr[j] == '*' && arr[j+1] == '*'))
                 || ((arr[i] == '_' && arr[i+1] == '_') &&(arr[j] == '_' && arr[j+1] == '_'))){
         	  
              for(int a=0; a<arr.length; a++){
                       if(a == i){
                          arr[a] = ' ';
                          arr[a+1] = ' ';
                          strings += "<strong style=\"font-size:30\">";
                       }
                       else if(a == j){
                          arr[a] = ' ';
                          arr[a+1] = ' ';
                          strings += "</strong>";
                       }
                       else{
                          strings += arr[a];   
                          }
                       
              }
              Token tokens = new Token(strings);
              tokens.accept(this);
              strings="";
              token.strings=tokens.getstring();
              arr = token.strings.toCharArray();
              strings=token.getstring();
           }
        }
     }
     for(i =0; i<arr.length-1;i++){
         for(int j = (i+1); j<arr.length;j++){
           if((arr[i] == '*' && arr[j] == '*') || (arr[i] == '_' && arr[j] == '_')){
                 strings="";
                    for(int a=0; a<arr.length; a++){
                       if(a == i){
                          arr[a] = ' ';
                          strings += "<em style=\"text-decoration:underline\">";
                       }
                       else if(a == j){
                          arr[a] = ' ';
                          strings += "</em>";
                       }
                       else{
                          strings += arr[a];   
                       }
                    }

                 Token tokens = new Token(strings);
                 tokens.accept(this);
                 strings="";
                 token.strings=tokens.getstring();
                 arr = token.strings.toCharArray();
                 strings=token.getstring();
                 }
     }
     }
        strings=token.strings;    
   }

   private boolean isValid(String htmlData){
            Tidy tidy = new Tidy();
            InputStream stream = new ByteArrayInputStream(htmlData.getBytes());
            tidy.parse(stream, System.out);
            return (tidy.getParseErrors() == 0);
   }

}