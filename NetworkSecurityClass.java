import java.util.Scanner;
import java.util.regex.Pattern;

public class NetworkSecurityClass {
	Scanner sc;
	
	public NetworkSecurityClass() {
		sc = new Scanner(System.in);
		sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
	}

}
