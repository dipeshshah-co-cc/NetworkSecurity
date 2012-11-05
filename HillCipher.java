/**
 * Author: Dipesh Shah.
 */

public class HillCipher {
	static String ct, abc = "abcdefghijklmnopqrstuvwxyz";
	static int[][] ctm, mul, key = { { 3, 7 }, { 15, 12 } };
	static int i, j, k;

	public static void main(String[] args) {
		ct = args[0];
		ctm = new int[1][ct.length()];
		for (i = 0; i < ct.length(); i++)
			ctm[0][i] = abc.indexOf(ct.charAt(i));

		mul = new int[1][ct.length()];
		for (i = 0; i < ct.length(); i++)
			mul[0][i] = ctm[0][0] * key[0][i] + ctm[0][1] * key[1][i];

		System.out.print("Cipher Text:");
		for (i = 0; i < ct.length(); i++) {
			mul[0][i] %= 26;
			System.out.print(abc.charAt(mul[0][i]));
		}
	}
}