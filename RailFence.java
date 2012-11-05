/** @author deep		ip:4 helloworld */
public class RailFence {
	public static void main(String[] args) throws NumberFormatException, Exception {			
			decrypt(Integer.parseInt(args[0]),encrypt(Integer.parseInt(args[0]),args[1].toString()));
	}
	
	public static String encrypt(int lvl,String string) throws Exception
	{
		System.out.println("Plaint Text: "+string);
		StringBuffer str = new StringBuffer(string);
		StringBuffer sb1, sb2;
		while(lvl>0)
		{
			sb1 = new StringBuffer();	sb2 = new StringBuffer();
		
			for (int i = 0; i < str.length(); i=i+2) {
				sb1.append(str.charAt(i)+"");	if(i<str.length()-1)	sb2.append(str.charAt(i+1)+"");
			}
			str = new StringBuffer(sb1.toString()+sb2.toString());
			lvl--;
		}
		System.out.println("Cipher Text: "+str.toString());
		return str.toString();
	}

	public static void decrypt(int lvl, String string) {
		StringBuffer str = new StringBuffer(string);
		StringBuffer sb1, sb2;
		while(lvl>0)
		{
			if((str.length() & 1) == 1){
			sb1 = new StringBuffer(str.substring(0, (str.length()/2)+1));	sb2 = new StringBuffer(str.substring((str.length()/2)+1, str.length()));
			}
			else{
				sb1 = new StringBuffer(str.substring(0, str.length()/2));	sb2 = new StringBuffer(str.substring(str.length()/2, str.length()));
			}
			str = new StringBuffer();
			for (int i = 0; i < sb1.length(); i++) {
				str.append(sb1.charAt(i)+"");	if(i<sb2.length()) str.append(sb2.charAt(i)+"");}
			lvl--;
		}
		System.out.println("Plain Text: "+str.toString());
	}
}