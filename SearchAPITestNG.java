
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchAPITestNG {
	SearchAPI sAPI = new SearchAPI();
	
	// We can write many unit test cases around search parameters 
	// in this case 4p3 valid search operations we can perform.
	
	@Test
	@Parameters("term")
    public void parameterTest1(String test) {
      //System.out.println("Parameterized value is : " + test);
      assertEquals("Madhavi", test);
    }
	
	@Test
	@Parameters("media")
    public void parameterTest2(String test) {
      //System.out.println("Parameterized value is : " + test);
      assertEquals("Software", test);
    }
	
	@Test
	@Parameters("limit")
    public void parameterTest3(String test) {
      //System.out.println("Parameterized value is : " + test);
      assertEquals("25", test);
    }
	
	@Test
	@Parameters("country")
    public void parameterTest4(String test) {
      //System.out.println("Parameterized value is : " + test);
      assertEquals("US", test);
    }
	
	@Test
	@Parameters({"country", "limit", "media", "term"})
    public void parameterTest5(String p1, String p2, String p3, String p4) {
      System.out.println("Parameterized value is : " + p1);
	  String str = "https://itunes.apple.com/search?" + "term=" + p4 + "&media=" + p3
	  	  + "&limit=" + p2 + "&country=" + p1;
	  System.out.println("String = " + str);
      assertEquals("Some search output", sAPI.searchString(p1));
    }
}
