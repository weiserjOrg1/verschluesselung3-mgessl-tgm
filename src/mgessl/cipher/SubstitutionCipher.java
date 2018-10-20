package mgessl.cipher;

/**
 * Klasse erbt von MonoAlphabeticChiper. Verwendet die Methoden dieser Klasse.
 * @author micha
 * @version 12.10.28
 */
public class SubstitutionCipher extends MonoAlphabeticCipher{
	public SubstitutionCipher(String secretAlphabet){
		setSecretAlphabet(secretAlphabet);
	}
	/**
	 * Set für das SecretAlphabet
	 * @param text
	 */
	public void setSecretAlphabet(String secretAlphabet){
		super.setSecretAlphabet(secretAlphabet);
	}
	public static void main(String[] args) {
		SubstitutionCipher sC = new SubstitutionCipher("QWERTZUIOPÜASDFGHJKLÖÄYXCVBNMß");
		String text = sC.encrypt("MichaelGessl");
		System.out.println(text);
		System.out.println(sC.decrypt(text));
	}
}