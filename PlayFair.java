//Author: Dipesh Shah
import java.util.Scanner;
import java.util.regex.Pattern;

public class PlayFair {
	static String abc="abcdefghiklmnopqrstuvwxyz", parts[];    //25
	static StringBuffer ptnosp, ct = new StringBuffer(""), pfmat = new StringBuffer("");
	static Scanner sc = new Scanner(System.in);
	static int pos1, pos2;
	static char x, y;

	public static void main(String args[])
	{
		sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
		System.out.println("~~~~~ Welcome to PlayFair Cipher ~~~~~\n");
		System.out.println("Enter the keyword:");
		String key = sc.next();		
		if(!checkkey(key))
		{
			System.out.println("Invalid Key Please try again\n");
			main(null);
			System.exit(0);
		}
		System.out.println("Enter the plain text:");
		String pt = sc.next();

		for (int i = 0; i < 25; i++) {
			if(i<key.length())
			{
				pfmat.append(key.charAt(i));
				abc = abc.substring(0,abc.indexOf(key.charAt(i)))+abc.substring(abc.indexOf(key.charAt(i))+1,abc.length());
			}
			else
			{
				pfmat.append(abc);
				break;
			}
		}
		System.out.println("\nPlayFair Matrix\n");
//printing
		for (int i = 0; i < 25; i++) {
			System.out.print(pfmat.charAt(i)+" ");
			if((i+1) % 5 == 0)
				System.out.println();
		}
		ptnosp = new StringBuffer(pt.replaceAll("\\s+",""));
		System.out.println("Original String w/o space: "+ptnosp.toString());
		parts = ptnosp.toString().split("(?<=\\G..)");
		checkparts();
//main Logic
		for (int i = 0; i < parts.length; i++) {
			System.out.print(parts[i]+" ");
			
			pos1 = pfmat.indexOf(parts[i].charAt(0)+"");
			pos2 = pfmat.indexOf(parts[i].charAt(1)+"");
			System.out.println(pos1 + " " +pos2);
			if(pos1%5 == pos2%5){
				x = pfmat.charAt((pos1+5)%25);
				y = pfmat.charAt((pos2+5)%25);
			}
			else if(!checkrow(pos1,pos2))
			{
				x = pfmat.charAt(((pos1+1)%5)+((pos1/10)*10));
				y = pfmat.charAt(((pos2+1)%5)+((pos2/10)*10));				
			}
			else{
				x = pfmat.charAt(pos1-((pos1%5)-(pos2%5)));
				y = pfmat.charAt(pos2+((pos1%5)-(pos2%5)));				
			}
			
			//System.out.println("x: "+x+" y: "+y);
			ct.append(x);
			ct.append(y);
		}
		System.out.println("\nCipher Text: "+ct.toString());
	
	}

	private static boolean checkrow(int pos12, int pos22) {
		if(pos12/5 == pos22/5)
			return false;
		return true;
	}

	private static void checkparts(){
		for (int i= 0; i < parts.length; i++) {
			if(parts[i].charAt(0)==parts[i].charAt(1)){
				ptnosp.insert(((2*i)+1), 'q');
				parts = ptnosp.toString().split("(?<=\\G..)");
				checkparts();
			}
			else if(parts[i].length()==1)
			{
				ptnosp.append('q');
				parts = ptnosp.toString().split("(?<=\\G..)");
				checkparts();
			}
		}
	}

	private static boolean checkkey(String key) {
		if(key.length()<6 || key.contains("i") || key.contains("j"))
			return false;
		else if(key.length()>5)
		{
			if(!keyrepete(key))
				return false;
		}
		return true;
	}

	private static boolean keyrepete(String key) {
		for (int i = 0; i < key.length(); i++) {
			for (int j = i+1; j < key.length(); j++) {
				if(key.charAt(i) == key.charAt(j)){
				System.out.println(key.charAt(i)+" : "+ i +" :: "+key.charAt(j)+": "+j);
					return false;
				}
			}
		}
		return true;
	}
}