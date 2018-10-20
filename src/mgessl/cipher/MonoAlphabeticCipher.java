package mgessl.cipher;

/**
 * Klasse erbt von Interface Cipher. Die Klasse implementiert Klassen zum verschlüsseln von Texten
 * @author micha
 * @version 12.10.28
 */
public class MonoAlphabeticCipher implements Cipher{
	private String secretAlphabet;
	private String alphabet;
	
	public MonoAlphabeticCipher() {
		setAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß");
	}
	/**
	 * Set für das normale Alphabet
	 * @param String
	 */
	private void setAlphabet(String text) {
		this.alphabet=text;
	}
	/**
	 * Set für das SecretAlphabet
	 * @param text
	 */
	protected void setSecretAlphabet(String text){
		if (text.length()==30){
			for (int i=0;i<text.length();i++) {
				for (int j=0; j<text.length();j++) {
					if(i != j) {
						if(text.charAt(j) == text.charAt(i)) {
							System.out.println("Ein Buchstabe ist doppelt");
						}
					}
					
				}
			}
			for(int i = 0;i<alphabet.length();i++) {
				if(text.indexOf(alphabet.charAt(i))==-1) {
					System.out.println("Ein Buchstabe ist nicht erlaubt");
				}
			}
		} else {
			System.out.println("Buchstaben fehlen");
		}
		this.secretAlphabet=text;
	}
	
	/**
	 * Verschlüsselt einen text
	 * @param text zum verschlüsseln
	 * @return String
	 */
	public String encrypt(String text) {
		StringBuilder x = new StringBuilder();
		for(int i = 0;i<text.length();i++) {
			x.append(secretAlphabet.charAt(alphabet.indexOf(text.toUpperCase().charAt(i))));
		}
		return x.toString();
	}
	/**
	 * Entschlüsselt einen text
	 * @param text zum entschlüsseln
	 * @return String
	 */
	public String decrypt(String text) {
		StringBuilder x = new StringBuilder();
		for(int i = 0;i<text.length();i++) {
			x.append(alphabet.charAt(secretAlphabet.indexOf(text.toUpperCase().charAt(i))));
		}
		return x.toString();
	}
}
