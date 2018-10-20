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
			text.toUpperCase();
			
			String one = "";
			String two="";
			String three="";
			String four="";
			String output="";
			int countr=0;
			int countr2=0;
			int blanks=0;
			for (int i=0;i<text.length();i++) {
				if (text.charAt(i)==' ') blanks++;
			}
			if (blanks==1) {
				for (int i=0; i<text.length();i++) {
					if (text.charAt(i)==' '){
						one= text.substring(0, i);
						two=text.substring(i+1,text.length());
					}
				}
				for (int i=0; i<one.length();i++) {
					output=output+one.charAt(i);
					if (i==two.length()) break;
					output= output+two.charAt(i);
				}
			}
			if (blanks==2) {
				int blank1=0;
				int blank2=0;
				for (int i=0; i<text.length();i++) {
					if (text.charAt(i)==' ' && blank1==0) {
						blank1=i;
					} else if (text.charAt(i)==' ') {
						blank2=i;
					}	
				}
				one=text.substring(0,blank1);
				two=text.substring(blank1+1, blank2);
				three=text.substring(blank2+1, text.length());
				for (int i=0; i<one.length();i++) {
					output=output+one.charAt(i);
					if (i==two.length()) break;
					output= output+two.charAt(i);
					if (i==three.length()) break;
					output= output+three.charAt(i);
				}
			}
			if (blanks==3) {
				int blank1=0;
				int blank2=0;
				int blank3=0;
				for (int i=0; i<text.length();i++) {
					if (text.charAt(i)==' ' && blank1==0) {
						blank1=i;
					} else if (text.charAt(i)==' '&& blank2==0) {
						blank2=i;
					}	else if (text.charAt(i)==' ') {
						blank3=i;
					}	
				}
				one=text.substring(0,blank1);
				two=text.substring(blank1+1, blank2);
				three=text.substring(blank2+1, blank3);
				four=text.substring(blank3+1, text.length());
				for (int i=0; i<one.length();i++) {
					output=output+one.charAt(i);
					if (i==two.length()) break;
					output= output+two.charAt(i);
					if (i==three.length()) break;
					output= output+three.charAt(i);
					if (i==four.length()) break;
					output= output+four.charAt(i);
				}
				
			}
		return output;
	}
	public static void main(String[] args) {
		TranspositionCipher t= new TranspositionCipher(4);
		System.out.println(t.decrypt("RSO AP MO MP"));
	}
}
