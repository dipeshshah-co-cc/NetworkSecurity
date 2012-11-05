	/**
	 * Author: Dipesh
	 */

public class KeyedColumnar {

	static StringBuffer st,ct; 
	static String []parts;
	static String key;
	static int pos, pad;
	
	public static void main(String[] args) {
		st = new StringBuffer(args[0]);
		key = args[1];
		
		pad = 5 - (st.length()%5);
		for (int i = 0; i < pad; i++)
			st.append("q");
		parts = st.toString().split("(?<=\\G.....)");
		ct=new StringBuffer();
		
		for (int i = 0; i < 5; i++) {
			pos = Integer.parseInt(key.charAt(i)+"");
			for (int j = 0; j < parts.length; j++) {
				ct.append(parts[j].charAt(pos-1));
			}
		}
		System.out.println("Cipher Text: "+ct.toString());
	}
}