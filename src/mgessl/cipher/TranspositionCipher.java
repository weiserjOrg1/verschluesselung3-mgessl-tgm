package mgessl.cipher;

public class TranspositionCipher implements Cipher{
	private int lvl;
	public TranspositionCipher(int numb) {
		 setTranspositionLevel(numb);
	}
	public void setTranspositionLevel(int numb) {
		if (numb<5 && numb>1) {
			this.lvl=numb;
		}
	}
	public String encrypt(String text) {
		if (this.lvl<5 && this.lvl>1) {
			text.toUpperCase();
			String one = "";
			String two="";
			String three="";
			String four="";
			if (this.lvl==2) {
				for (int i=0; i<text.length();i++) {
					if (i%2==0) {
						one= one +text.charAt(i);
					} else {
						two =two + text.charAt(i);
					}
				}
				return one+" "+two;
			}
			if (this.lvl==3) {
				int countr = 0;
				for (int i=0; i<text.length();i++) {
					if (countr==0) {
						one= one +text.charAt(i);
					} else if (countr==1) {
						two =two + text.charAt(i);
					} else if (countr==2) {
						three =three + text.charAt(i);
					}
					countr++;
					if (countr==3) countr=0;
				}
				return one+" "+two+" "+three;
			}
			if (this.lvl==4) {
				int countr = 0;
				for (int i=0; i<text.length();i++) {
					if (countr==0) {
						one= one +text.charAt(i);
					} else if (countr==1) {
						two =two + text.charAt(i);
					} else if (countr==2) {
						three =three + text.charAt(i);
					}  else if (countr==3) {
						four =four + text.charAt(i);
					}
					countr++;
					if (countr==4) countr=0;
				}
				return one+" "+two+" "+three+" "+four;
			}
		}
		return "";
	}
	
	public String decrypt(String text) {
		if (this.lvl<5 && this.lvl>1) {
			text.toUpperCase();
			String one = "";
			String two="";
			String three="";
			String four="";
			int countr=0;
			int countr2=0;
			for (int i=0; i<text.length();i++) {
				if (text.charAt(i)== ' ') {
					if (countr==0) {
						one=text.substring(0, i);
						countr++;
						countr2=i+1;
					} else if (countr==1) {
						two=text.substring(countr2, i);
						countr++;
						countr2=i+1;
					}else if (countr==2) {
						three=text.substring(countr2, i);
						countr++;
						countr2=i+1;
					}else if (countr==3) {
						four=text.substring(countr2, text.length()-1);
					}
				}
			}
			System.out.println(one);
			System.out.println(two);
			System.out.println(three);
			System.out.println(four);

			
		}
		return null;
	}
	public static void main(String[] args) {
		TranspositionCipher t= new TranspositionCipher(4);
		System.out.println(t.decrypt("ENIKIHEWREDRATNAN IWRLCVRIRNEGREZU"));
	}
}
