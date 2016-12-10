package markdown.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import markdown.MDParser;

import org.junit.Test;

import static org.junit.Assert.*;

public class MDParserTest{

   @Test
   public void testmain() throws IOException {

      String[] Test_string = {"help", "conver", "Convert ajkl", "Convert a.md ", "Convert a.md fad ", "Convert a.md fisdf.dfhdi",
    		  "Convert a.md hflsa.html sddjfa", "Convert a.md b fancy", "Convert a.md b.html slide",
    		  "Convert b.md fjsadf", "Convert a.md ?.html plain", "Convert a.md a.html plain" , "Convert a.md a.html plain",
    		  "quit"};

      MDParser mdparser=new MDParser();
      mdparser.test_array = Test_string;
      mdparser.main(Test_string);

      String line;
      BufferedReader read = null;
      BufferedReader test = null;
      String[] htmlstring=new String[1000];
      String[] teststring=new String[1000];
      try{
         int i=0;

         read = new BufferedReader(new FileReader("a.html"));
         test=new BufferedReader(new FileReader("h.html"));

         while(((line=read.readLine()))!=null){
            htmlstring[i++]=line;

         }
         i=0;
         while((line=test.readLine())!=null){
            teststring[i++]=line;
         }
         read.close();
         test.close();
      }catch(Exception e){
         e.printStackTrace();
      }
      assertArrayEquals(htmlstring, teststring);
   }

}