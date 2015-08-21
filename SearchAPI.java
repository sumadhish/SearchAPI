
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SearchAPI
{
	public static void main(String[] args) {
		
		SearchAPI sAPI = new SearchAPI();
		
		// Here you can construct 4p3 times of the URI with different keys combinations
		
		String multipleKeys =  "https://itunes.apple.com/search?" 
			 + "term=Madhavi&limit=25&media=Software&Country=US";
		
			//	"grep ERROR /Users/madhavi/Downloads/test.txt";
		
		sAPI.searchString(multipleKeys);
	}
	
	protected String searchString(String str){
		String s = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			// It basically executes the command in a shell
			Process p = Runtime.getRuntime().exec("curl -v " + str);
			
			BufferedReader stdInput = new BufferedReader(new
			       InputStreamReader(p.getInputStream()));
			
			BufferedReader stdError = new BufferedReader(new
			       InputStreamReader(p.getErrorStream()));
	
			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			    //System.out.println(s);
			}
			
			//System.out.println("Output = " + sb.toString());
	       
			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
			   System.out.println(s);
			} //
	       
			//return sb.toString();
		}
		catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
		
		return sb.toString();
	}
}