package mgessl.cipher;
/**
 * Modelklasse für Verschlüssel2
 * @author micha
 * @version 18.10.2018 
 */
public class M {
	private SubstitutionCipher c1;
	private ShiftChipher c2;
	private KeywordCipher c3;
	private TranspositionCipher c4;
	private String output;
	public M() {
		this.output="";
	}
	/**
	 * Checkt die Einstellungen und setzt das neue Secretalphabet
	 * @param string
	 */
	public void checkSub(String string) {
		this.c1= new SubstitutionCipher(string);
		
	}
	/**
	 * Checkt die Einstellungen und setzt das neue Secretalphabet
	 * @param string
	 */
	public void checkShift(String string) {
		int i=0;
		try {
			i= Integer.parseInt(string);
		} catch (NumberFormatException e) {
			System.out.println("Gib eine Zahl ein");
		}
		if (i!=0) {
			this.c2= new ShiftChipher(i);
		}
	}
	/**
	 * Checkt die Einstellungen und setzt das neue Secretalphabet
	 * @param string
	 */
	public void checkKey(String string) {
		this.c3= new KeywordCipher(string);
	}
	/**
	 * Checkt die Einstellungen und setzt das neue Secretalphabet
	 * @param string
	 */
	public void checkTrans(String string) {
		int i=0;
		try {
			i= Integer.parseInt(string);
		} catch (NumberFormatException e) {
			System.out.println("Gib eine Zahl ein");
		}
		if (i!=0) {
			this.c4= new TranspositionCipher(i);
		}
		
	}
	
	/**
	 * Liefert den output
	 * @return String output
	 */
	public String getOutput() {
		return this.output;
	}
	/** 
	 * encrypt des inputs
	 * @param text
	 */
	public void enSub(String text) {
		this.output=this.c1.encrypt(text);
	}
	/** 
	 * encrypt des inputs
	 * @param text
	 */
	public void enShift(String text) {
		this.output=this.c2.encrypt(text);
		
	}
	/** 
	 * encrypt des inputs
	 * @param text
	 */
	public void enKey(String text) {
		this.output=this.c3.encrypt(text);
		
	}
	/** 
	 * encrypt des inputs
	 * @param text
	 */
	public void enTrans(String text) {
		this.output=this.c4.encrypt(text);
		
	}
	/** 
	 * decrypt des inputs
	 * @param text
	 */
	public void deSub(String text) {
		this.output=this.c1.decrypt(text);	
	}
	/** 
	 * decrypt des inputs
	 * @param text
	 */
	public void deShift(String text) {
		this.output=this.c2.decrypt(text);
	}
	/** 
	 * decrypt des inputs
	 * @param text
	 */
	public void deKey(String text) {
		this.output=this.c3.decrypt(text);
	}
	/** 
	 * decrypt des inputs
	 * @param text
	 */
	public void deTrans(String text) {
		this.output=this.c4.decrypt(text);
	}	
}
