package mgessl.cipher;

/**
 * Interface für die Klassen encrypt und decrypt
 * @author micha
 * @version 12.10.28
 */
public interface Cipher {
	/**
	 * Verschlüsselt einen text
	 * @param text zum verschlüsseln
	 * @return String
	 */
	public String encrypt(String text);
	/**
	 * Entschlüsselt einen text
	 * @param text zum entschlüsseln
	 * @return String
	 * 
	 */
	public String decrypt(String text);
}
