package mgessl.cipher;
/**
 * Verschlüsselt mit einem Keyword
 * @author micha
 * @version 20.10.2018
 */
public class KeywordCipher extends MonoAlphabeticCipher{
	private int countr;
	private String s;
	public KeywordCipher(String text) {
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
	}
	/**
	 * Set für das Keyword
	 * @param inumb
	 */
	public void setKeyword(String text) {
		this.countr=text.length()+s.indexOf(text.charAt(0)+1);
	}
	public static void main(String[] args) {
		 KeywordCipher k=new  KeywordCipher("Servus");
		 System.out.println(k.encrypt("ABC"));
	}
}
