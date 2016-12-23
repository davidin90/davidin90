package markdown;

public class Token implements MDElement{
   public String strings=new String();

      Token(){
         
      }
      Token(String s){
            strings=s;

      }

   public void accept(MDElementVisitor v){
      v.visitToken(this);
   }
   public String getstring(){
      return strings;
   }
   
}