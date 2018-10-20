package mgessl.cipher;

public class KeywordChipher extends MonoAlphabeticCipher{
	private int countr;
	private String s;
	public KeywordChipher(String text) {
		this.s="ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß";
		setKeyword(text);
		String ausgabe="";
		for (int i=0; i<30; i++) {
			if (i+this.countr<30) {
				ausgabe = ausgabe + s.charAt(this.countr+i);
			} else {
				ausgabe= ausgabe +s.charAt(this.countr+i-30);
			}
		}
		super.setSecretAlphabet(ausgabe);
		System.out.println(this.countr);
	}
	
	public void setKeyword(String text) {
		this.countr=text.length()+s.indexOf(text.charAt(0)+1);
	}
	public static void main(String[] args) {
		 KeywordChipher k=new  KeywordChipher("Servus");
		 System.out.println(k.encrypt("ABC"));
	}
}
