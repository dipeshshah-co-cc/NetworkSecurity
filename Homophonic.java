import java.util.Scanner;
import java.util.regex.Pattern;

//Author: Dipesh Shah.
public class Homophonic {
	static String abc="abcdefghijklmnopqrstuvwxyz ";
	static String [] parts = abc.toString().split("(?<=\\G...)");
	static StringBuffer sb;
	static int i,j,k,l, total;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
		System.out.println("~~~~~ Welcome to Homophonic Cipher ~~~~~\n");
			System.out.println("Enter the Plain text: ");
			decrypt(encrypt(sc.next()));
	}

	private static void decrypt(String encrypt) {
		total = (int)Math.pow(3,encrypt.length());
		sb=new StringBuffer("");
		System.out.println((int)Math.pow(3,encrypt.length()));
		for (i = 0; i < encrypt.length(); i++)
			for(j=0;j<total;j++){
				for(k=0;k<3;k++)
				{	
					sb.append(parts[Integer.parseInt(""+encrypt.charAt(i))].charAt(k));
					System.out.println("s:"+parts[Integer.parseInt(""+encrypt.charAt(i))].charAt(k));
					//parts[Integer.parseInt(""+encrypt.charAt(i))];
					//System.out.println(parts[j-1]);
				}
				System.out.println();
			}
	}

	private static String encrypt(String next) {
		sb = new StringBuffer("");
		for (i = 0; i < next.length(); i++) {
			j=abc.indexOf(next.charAt(i)+"");
			j/=3;
			sb.append(""+(j+1));
		}
		System.out.println("Encrypted string:\n"+sb.toString());
		return sb.toString();
	}
}
/*
 *			System.out.println((i+1) + " :: "+parts[i]);
			for (int j = 0; j < parts.length; j++) {
				if(parts[j].contains(next.charAt(i)+"")){
					sb.append(""+(j+1)); break;
					}
			}
			
abc def ghi jkl mno pqr stu vwx yz 
1	2	3	4	5	6	7	8	9

		for (i = 0; i < encrypt.length(); i++)
			for (j = 0; j < parts.length; j++)
				for (k = 0; k < parts.length; k++)
					for (l = 0; l < parts[0].length(); l++) {
						System.out.print(parts[encrypt.charAt(l)]);
					}


 * */