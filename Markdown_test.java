package markdown;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.*;

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
	public void testMain(String[] args) throws IOException {
		MDParser.test_array = args;
		MDParser.main(null);

	}


}
