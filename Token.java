package markdown;

public class Token implements MDElement{
   public String strings;
      String a;
      String b;
      String c;
      Token(){
         
      }
      Token(String s){
         strings="";
         System.out.println("Token: "+s);
         char[] arr;
         
         arr = s.toCharArray();
         
         //backslash

         if(s.indexOf("[")!=-1 && s.indexOf("[")<s.indexOf("]")){
                if(s.indexOf("(")==(s.indexOf("]")+1) && s.indexOf(")")!=-1){
                   if(s.indexOf("(")<s.indexOf("\"") && s.indexOf(")")>s.indexOf("\"", s.indexOf("\"")+1) &&
                         s.indexOf("\"")!=-1 && s.indexOf("\"", s.indexOf("\"")+1)!=-1){
                      System.out.println("ok");
                      strings=s.substring(0, s.indexOf("["))+"<a href=\""+ 
                            s.substring(s.indexOf("(")+1, s.indexOf("\"")-1)+"\" title="+
                            s.substring(s.indexOf("\""), s.indexOf(")"))+">"+
                            s.substring(s.indexOf("[")+1, s.indexOf("]"))+"</a>";
                   }
                   else{
                      strings=s.substring(0, s.indexOf("["))+"<a href=\""+ 
                            s.substring(s.indexOf("(")+1, s.indexOf(")"))+"\">"+
                            s.substring(s.indexOf("[")+1, s.indexOf("]"))+"</a>";
                   }
                   if(s.length()>(s.indexOf(")")+1)){
                      strings+=s.substring(s.indexOf(")")+1);
                   }
                   s=strings;
                }
                
             }
         if(s.indexOf("``")==-1&& s.indexOf("`")!=-1){         
             s=s.replace("\\\\`", "hongsin");
             s=s.replaceFirst("`", "<code>");
             s=s.replaceFirst("`", "</code>");
             s=s.replace("hongsin", "`");
             strings=s;
          }
         else if(s.indexOf("`")!=-1){
             s=s.replaceFirst("``", "<code>");
             s=s.replaceFirst("``", "</code>");
             strings=s;
          }
         
         
         
         int i = 0;
         int index = 0;
         int pre = 0;
          
         
         for(i=0;i<arr.length;i++){
           if(arr[i] == '\\'){
            if(arr.length>(i) && (arr[i+1] == '\\' || arr[i+1] == '`' || arr[i+1] == '*'
                  || arr[i+1] == '_'||arr[i+1] == '{' || arr[i+1] == '}'
                  || arr[i+1] == '[' || arr[i+1] == ']' ||arr[i+1] == '('
                  || arr[i+1] == ')' || arr[i+1] == '#' ||arr[i+1] == '.'
                  || arr[i+1] == '!')){
               pre = 10;
               index = i;
           }
           }
          }
          
          if(pre == 10){
             for(int a=0; a<arr.length; a++){
                if(a == index){
                   arr[a] = ' ';
                }
                strings += arr[a];
          }
            Backslash backslash = new Backslash(strings);
          }
          
          //strong
         
       
          for(i =0; i<arr.length-2;i++){
             for(int j = (i+2); j<arr.length-2;j++){
                if((arr[i] == '*' && arr[i+1] == '*') &&(arr[j] == '*' && arr[j+1] == '*')
                      || (arr[i] == '_' && arr[i+1] == '_') &&(arr[j] == '_' && arr[j+1] == '_')){
                   for(int a=0; a<arr.length; a++){
                            if(a == i){
                               arr[a] = ' ';
                               arr[a+1] = ' ';
                               strings += "<strong>";
                            }
                            else if(a == j){
                               arr[a] = ' ';
                               arr[a+1] = ' ';
                               strings += "</strong>";
                            }
                            else{
                               //System.out.println("else : "+strings);
                               strings += arr[a];   
                               }
                            
                }
                   Token token = new Token(strings);
                   strings="";
                   s=token.getstring();
                   arr = s.toCharArray();
                   strings=token.getstring();
             }
               if((arr[i] == '*' && arr[j] == '*') || (arr[i] == '_' && arr[j] == '_')){
                         for(int a=0; a<arr.length; a++){
                            if(a == i){
                               arr[a] = ' ';
                               strings += "<em>";
                            }
                            else if(a == j){
                               arr[a] = ' ';
                               strings += "</em>";
                            }
                            else{
                               strings += arr[a];   
                            }
                         }

                      Token token = new Token(strings);
                      strings="";
                      s=token.getstring();
                      arr = s.toCharArray();
                      strings=token.getstring();
                
                      }
               
          }
          } //Image
             if(s.indexOf("!")!=-1 && s.indexOf("!")+1==s.indexOf("[") && s.indexOf("[")<s.indexOf("]")){
                 if(s.indexOf("(")==(s.indexOf("]")+1) && s.indexOf(")")!=-1){
                    if(s.indexOf("(")<s.indexOf("\"") && s.indexOf(")")>s.indexOf("\"", s.indexOf("\"")+1) &&
                          s.indexOf("\"")!=-1 && s.indexOf("\"", s.indexOf("\"")+1)!=-1){
                       strings=s.substring(0, s.indexOf("!"))+"<img src=\""+ 
                             s.substring(s.indexOf("(")+1, s.indexOf("\"")-1)+"\" alt=\""+
                             s.substring(s.indexOf("[")+1, s.indexOf("]"))+"\" title="+
                             s.substring(s.indexOf("\""), s.indexOf(")"))+" />";
                    }
                    else{
                       strings=s.substring(0, s.indexOf("!"))+"<img src=\""+ 
                             s.substring(s.indexOf("(")+1, s.indexOf(")"))+"\" alt=\""+
                             s.substring(s.indexOf("[")+1, s.indexOf("]"))+"\" title=\"\" />";
                    }
                    if(s.length()>(s.indexOf(")")+1)){
                       strings+=s.substring(s.indexOf(")")+1);
                    }
                 }
              }
             
             
             
             else{
                strings=s;
                
             }
      }

   public void accept(MDElementVisitor v){
      v.visitToken(this);
   }
   public String getstring(){
      return strings;
   }
   public void setstring(String s) {
      strings=s;
   }
}