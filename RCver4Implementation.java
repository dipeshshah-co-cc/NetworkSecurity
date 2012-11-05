class RCver4{
	private int i=0, j=0;
	private int limit=256;
	private int[] s = new int[limit];  
	private int temp;

	
	RCver4(int[] key){
		int key_length=key.length;
		int temp;

		//key scheduling algorithm(KSA) 2 step process
		//step 1: Initialization
		System.out.println("initializing s....");
		for(i=0;i<limit;i++){
			s[i]=i;
		}
		i=0;

		//step 2: scrabling....
		for (i=0;i<limit;i++ ) {
			j=(j+s[i]+key[i%key_length])%(limit-1);

			//swap s[i] and s[j]
			temp=s[i];
			s[i]=s[j];
			s[j]=temp;
		}
	}

	//The pseudo-random generation algorithm(PRGA)
	public int getrandom(){
		i=0;
		j=0;

		i=(i+1)%(limit-1);
		j=(j+s[i])%(limit-1);

		//swap s[i] and s[j]
		temp=s[i];
		s[i]=s[j];
		s[j]=temp;
		System.out.print("Random number : "+s[(s[i]+s[j])%(limit-1)]+"\t");

		return (s[(s[i]+s[j])%(limit-1)]);
	}

	public void encrypt(byte []in){
		System.out.println("in encrypt");
		for (int c = 0; c < in.length; c++) {
			in[c] = (byte) (in[c] ^ (byte)getrandom());
			System.out.print(in[c]+"\t");
			System.out.println();
		}
	}
}

class RCver4Implmentation{
	public static void main(String[] args) {
		int key[]={3,5,1,4};
		byte in[]={5,34,9,18};

		RCver4 r=new RCver4(key);
		r.encrypt(in);
	}
}