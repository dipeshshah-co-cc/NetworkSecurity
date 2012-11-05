//Author: Dipesh Shah
import java.util.Scanner;
import java.util.regex.Pattern;

public class CeaserCipher {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
		System.out.println("~~~~~ Welcome to Ceaser Cipher ~~~~~\n");
		System.out.println("Option 1 :: Encrypt Plain Text.");
		System.out.println("Option 2 :: Decrypt Cipher Text.");
		System.out.println("Your Choice ?");
		switch(sc.nextInt()) {
		case 1: 
			System.out.println("Enter the Plain text: "); String msg=sc.next();
			System.out.println("Enter the key: ");int k=sc.nextInt();
			encrypt(msg,k); break;
		case 2: System.out.println("Enter the Cipher text"); decrypt(sc.next()); break;
		default: System.out.println("Wrong input please try again"); break;
		}		
	}

	private static void decrypt(String ct) {
		for(int key=0; key<26;key++)	{
			StringBuffer sb = new StringBuffer("");
			for(int i=0; i<ct.length();i++)	{
				if((int)(ct.charAt(i)) == 32)
					sb.append((char)((int)(ct.charAt(i))));
				
				else if((int)(ct.charAt(i))<=90 && (int)(ct.charAt(i)) >= 65)	{
					if((int)(ct.charAt(i))-key>=65)
						sb.append((char)((int)(ct.charAt(i))-key));
					else					
						sb.append((char)((int)(ct.charAt(i))-key+26));
				}
	
				else if((int)(ct.charAt(i))<=122 && (int)(ct.charAt(i)) >= 97)	{
					if((int)(ct.charAt(i))-key>=97)
						sb.append((char)((int)(ct.charAt(i))-key));
					else					
						sb.append((char)((int)(ct.charAt(i))-key+26));
				}
			}
			System.out.println("Key "+key+" :"+sb.toString());
		}
	}	
		
	private static void encrypt(String pt, int key) {
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<pt.length();i++)	{
			if((int)(pt.charAt(i)) == 32)
				sb.append((char)((int)(pt.charAt(i))));
			
			else if((int)(pt.charAt(i))<=90 && (int)(pt.charAt(i)) >= 65)	{
				if((int)(pt.charAt(i))+key<=90)
					sb.append((char)((int)(pt.charAt(i))+key));
				else					
					sb.append((char)((int)(pt.charAt(i))+key-26));
			}

			else if((int)(pt.charAt(i))<=122 && (int)(pt.charAt(i)) >= 97)	{
				if((int)(pt.charAt(i))+key<=122)
					sb.append((char)((int)(pt.charAt(i))+key));
				else					
					sb.append((char)((int)(pt.charAt(i))+key-26));
			}
		}
		System.out.println(sb.toString());
	}	
}