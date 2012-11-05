import java.io.DataInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class RSA {
	public static boolean isPrime(long a) {
		boolean flag = true;
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				flag = false;
				break;
			}
		}
		return (flag);
	}

	public static long getPublicKey(long fn) {
		long e;
		boolean flag = false;
		int i = 0, j = 0;

		ArrayList arrfn = new ArrayList();
		ArrayList arre = new ArrayList();

		Object x, y;
		arrfn = factor(fn);

		Random r = new Random();
		arre.add(1);
		do {
			e = r.nextInt((int) fn);
			arre.removeAll(arre);
			arre = factor(e);
			i = 0;
			if (arre.isEmpty())
				flag = false;
			else {
				while (i < arre.size()) {
					x = arre.get(i);
					j = 0;
					y = null;
					while (j < arrfn.size()) {
						y = arrfn.get(j);
						if (x.equals(y)) {
							flag = true;
							break;
						}
						j++;
					}
					i++;
				}
			}
		} while (flag);

		return e;
	}

	public static long getPrivateKey(long e, long fn) {
		long d = 0, i = 0;

		for (i = fn - 1; i > 3; i--) {
			d = (i * e);
			if (d % fn == 1)
				break;
		}
		return i;
	}

	public static ArrayList factor(long fn) {
		ArrayList fac = new ArrayList();

		for (int i = 2; i < Math.sqrt(fn); i++) {
			if (fn % i == 0) {
				if (isPrime(i))
					fac.add(i);
			}
		}
		return (fac);
	}

	// Convert int to equivalent alphabet 1 = a.... 26 = z
	static char intToChar(int n) {
		char val = (char) (n + 96);
		return val;
	}

	// Convert alphabet to equivalent int 1 = a.... 26 = z
	static int charToInt(char c) {
		int t, val = 0;
		t = (int) c;

		if (t >= 97 && t <= 122)
			val = t - 96;

		return val;
	}

	public static int encodeText(char ch, long e, long n) {
		int x = charToInt(ch);
		BigInteger pt = BigInteger.valueOf(x);
		BigInteger re = BigInteger.valueOf(n);

		pt = pt.pow((int) e);
		re = pt.mod(re);

		return (re.intValue());
	}

	public static char decodeText(int x, long d, long n) {
		BigInteger pt = BigInteger.valueOf(x);
		BigInteger re = BigInteger.valueOf(n);

		pt = pt.pow((int) d);

		re = pt.mod(re);

		return (intToChar(re.intValue()));
	}

	public static void main(String[] args) {
		long P, Q, N, FN, E, D;
		Random r = new Random();
		DataInputStream ip = new DataInputStream(System.in);
		String PT = "";
		int x[] = new int[50];

		// P should be prime number and greater than 2
		do {
			P = r.nextInt(1000);
		} while ((P == 0 || P == 1 || P == 2) || (!(isPrime(P))));

		// Q should be prime number and greater than 2 and P != Q
		do {
			Q = r.nextInt(1000);
		} while ((Q == P || Q == 0 || Q == 1 || Q == 2) || (!(isPrime(Q))));

		N = P * Q;
		FN = (P - 1) * (Q - 1);

		E = getPublicKey(FN);
		D = getPrivateKey(E, FN);

		System.out.println("P: " + P);
		System.out.println("Q: " + Q);
		System.out.println("N => (P*Q) : " + N);
		System.out.println("FN: => (P-1)*(Q-1): " + FN);
		System.out.println("Public Key [E]: " + E);
		System.out.println("Private Key [D]: " + D);

		System.out.print("Enter a Plain Text: ");
		try {
			PT = ip.readLine();
			x = new int[PT.length()];
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Encryption: ");
		for (int i = 0; i < PT.length(); i++) {
			x[i] = 0;
			x[i] = encodeText(PT.charAt(i), E, N);
			System.out.print(PT.charAt(i) + " " + x[i] + "\n");
		}

		System.out.println("\nDecryption: ");
		for (int i = 0; i < PT.length(); i++) {
			System.out.print(x[i] + " " + decodeText(x[i], D, N) + "\n");
		}
	}
}
