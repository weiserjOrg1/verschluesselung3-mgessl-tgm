package mgessl.cipher;
/**
 * Verschlüüselt nach Cesar-Methode
 * @author micha
 * @version 12.10.2018
 */
public class ShiftChipher extends MonoAlphabeticCipher{
	private int ShiftValue;
	public ShiftChipher(int inumb) {
		String s="ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß";
		String ausgabe="";
		setShiftValue(inumb);
		for (int i=0; i<30; i++) {
			if (i+inumb<30) {
				ausgabe = ausgabe + s.charAt(inumb+i);
			} else {
				ausgabe= ausgabe +s.charAt(inumb+i-30);
			}
		}
		super.setSecretAlphabet(ausgabe);
	}
	/**
	 * Set für das SecretAlphabet
	 * @param inumb
	 */
	public void setShiftValue(int inumb) {
		if (inumb>0 && inumb<30) {
			this.ShiftValue=inumb;
		} else {
			System.out.println("Die Zahl ist falsch");
		}
	}
	public static void main(String[] args) {
		ShiftChipher sC=new ShiftChipher(4);
		String text = sC.encrypt("MichaelGessl");
		System.out.println(text);
		System.out.println(sC.decrypt(text));
	}
}
