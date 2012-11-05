	/**
	 * Author: Dipesh
	 */
public class Columnar {
	static StringBuffer st,ct=new StringBuffer();
	static String []parts;
	public static void main(String[] args) {
		st = new StringBuffer(args[0]);
		int pad = 5 - (st.length()%5);
		for (int i = 0; i < pad; i++)
			st.append("q");

		parts = st.toString().split("(?<=\\G.....)");

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < parts.length; j++) 
				ct.append(parts[j].charAt(i));
			
		System.out.println("Cipher Text: "+ct.toString());
	}
}