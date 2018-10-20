package mgessl.cipher;

/**
 * Interface f�r die Klassen encrypt und decrypt
 * @author micha
 * @version 12.10.28
 */
public interface Cipher {
	/**
	 * Verschl�sselt einen text
	 * @param text zum verschl�sseln
	 * @return String
	 */
	public String encrypt(String text);
	/**
	 * Entschl�sselt einen text
	 * @param text zum entschl�sseln
	 * @return String
	 * 
	 */
	public String decrypt(String text);
}
