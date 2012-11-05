	/** Author: Dipesh	*/
public class Des {
	static String ip= "26314857";	static String fp= "41357286";	static String eb= "41232341";
	static String pc1="35274101986";static String pc2="637485109";	static String f = "2431";
	static String pt= "11010101";	static String k = "1001011001";	static String kplus,k1,k2,c0,d0,c1,d1,c2,d2,ipdash,l0,r0,l1,r1,l2,r2,ct;
	static int [][] s0={{1,0,3,2},{3,2,1,0},{0,2,1,3},{3,1,0,2}}, s1={{0,1,2,3},{2,0,1,3},{3,0,1,0},{2,1,0,3}};
	static int pos,i;
	public static void main(String[] args) {
		kplus=new String(substitute(k,pc1));						System.out.println("K+: "+kplus);
		
		c0 = (String) kplus.subSequence(0, (kplus.length()/2));		d0 = (String) kplus.subSequence((kplus.length()/2), kplus.length());
		System.out.println("C0: "+c0.toString());					System.out.println("D0: "+d0.toString());
		
		c1 = new String(leftshift(c0,1));							d1 = new String(leftshift(d0,1));
		System.out.println("C1: "+c1);								System.out.println("D1: "+d1);
		
		k1 = new String(substitute(c1+d1, pc2));					System.out.println("K1: "+k1);

		c2 = new String(leftshift(c1,2));							d2 = new String(leftshift(d1,2));
		System.out.println("C2: "+c2);								System.out.println("D2: "+d2);
		
		k2 = new String(substitute(c2+d2, pc2));					System.out.println("K2: "+k2);
	
		ipdash = new String(substitute(pt, ip));					System.out.println("IP': "+ipdash);
		
		l0 = (String) ipdash.subSequence(0, (ipdash.length()/2));	r0 = (String) ipdash.subSequence((ipdash.length()/2), ipdash.length());
		System.out.println("L0: "+l0);								System.out.println("R0: "+r0);
		
		l1 = new String(r0);										System.out.println("L1: "+l1);
		
		r1 = new String(solution(l0,r0,k1));						System.out.println("R1: "+r1);
		
		l2 = new String(r1);										System.out.println("L2: "+l2);
		
		r2 = new String(solution(l1,r1,k2));						System.out.println("R2: "+r2);
		
		ct = new String(substitute(r2+l2, fp));						System.out.println("CT: "+ct);
	}

	private static String solution(String l, String r, String k) {
		StringBuffer sol;
		sol = new StringBuffer(substitute(r,eb)); 
		sol = new StringBuffer(xor(k,sol.toString()));
		sol = new StringBuffer(dec2bin(s0[bin2dec(sol.charAt(0)+""+sol.charAt(3))][bin2dec(sol.charAt(1)+""+sol.charAt(2))]).concat(dec2bin(s1[bin2dec(sol.charAt(4)+""+sol.charAt(7))][bin2dec(sol.charAt(5)+""+sol.charAt(6))])));
		sol = new StringBuffer(substitute(sol.toString(), f));
		sol = new StringBuffer(xor(l,sol.toString()));
		return sol.toString();
	}

	private static int bin2dec(String string) {
		if(string.equals("00"))	return 0;
		else if (string.equals("01"))	return 1;
		else if (string.equals("10"))	return 2;
		else	return 3;
	}

	private static String dec2bin(int j) {
		if(j == 0)	return "00";
		else if(j == 1)	return "01";
		else if(j == 2)	return "10";
		else	return "11";
	}

	private static String xor(String k, String sol) {
		StringBuffer x = new StringBuffer();
		for (i = 0; i < sol.length(); i++)
			x.append(k.charAt(i)^sol.charAt(i));
		return x.toString();
	}

	private static String leftshift(String str, int j) {
		return str.subSequence(j, str.length()).toString().concat(str.subSequence(0, j).toString());	}
	
	private static String substitute(String target, String with) {
		StringBuffer demo=new StringBuffer();	i=0;
		while(i < with.length()) {
			if((i+1)<with.length() && with.charAt(i+1)=='0'){
				pos=Integer.parseInt(with.charAt(i)+""+with.charAt(i+1))-1;		i++;
			}
			else 
				pos=Integer.parseInt(with.charAt(i)+"")-1;
			i++;
			demo.append(target.charAt(pos));
		}
		return demo.toString();
	}
}