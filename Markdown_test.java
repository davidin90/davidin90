package markdown;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Markdown_test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParser() throws IOException {
//		MDParser MDParser = new MDParser();
//		md = new File("a.md");
//		MDParser.parser(md, ".md");

	}

	@Test
	public void testMain() throws IOException {
		String[] Test_string = {"Help" , "Con", "convert", "Convert ajkl", "Convert a.md", "Convert a.md fad", 
				"Convert a.md fisdf.dfhdi", "Convert a.md hflsa.html sddjfa", "Convert a.md hflsa.html fancy", 
				"Convert a.md hflsadd.html slide", "Convert b.md fjsadf", "Convert a.md a.html plain", "Convert a.md a.html plain",
				"Convert a.md ?.html plain", "quit"};
		MDParser.test_array = Test_string;
		MDParser.main(null);

	}


}
