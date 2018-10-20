package mgessl.cipher;
import java.awt.event.*;
/**
 * Controllerklasse für Verschlüssel2
 * @author micha
 * @version 18.10.2018 
 */
public class C implements ActionListener{
	private M m1;
	private V v1;
	public C() {
		this.m1= new M();
		this.v1=new V(this.m1, this);
	}
	/**
	 * Führt verschiedene Aufgaben bei events durch
	 */
	public void actionPerformed(ActionEvent e) {
		if (v1.isBCheck(e)) {
			if (v1.getInputSettingText()!=null) {
				if (v1.isRb1Selected()) {
					m1.checkSub(v1.getInputSettingText());
				}
				if (v1.isRb2Selected()) {
					m1.checkShift(v1.getInputSettingText());
				}
			}
			
		}
		if (v1.isEncrypt(e)) {
			if (v1.isRb1Selected()) {
				m1.enSub(v1.getInputText());
				v1.refresh();
			}
			if (v1.isRb2Selected()) {
				m1.enShift(v1.getInputText());
				v1.refresh();
			}
		}
		if (v1.isDecrypt(e)) {
			if (v1.isRb1Selected()) {
				m1.deSub(v1.getInputText());
				v1.refresh();
			}
			if (v1.isRb2Selected()) {
				m1.deShift(v1.getInputText());
				v1.refresh();
			}
		}
	}
	public static void main(String[] args) {
		C c1= new C();
	}
}
