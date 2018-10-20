package mgessl.cipher;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Viewklasse für Verschlüssel2
 * @author micha
 * @version 18.10.2018 
 */
public class V extends JFrame {
	private M m1;
	private C c1;
	private JPanel selection;
	private JPanel settings;
	private JPanel inputOutput;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private ButtonGroup radioGroup;
	private JTextField inputSettings;
	private JLabel settingLabel;
	private JPanel subPanelSetting;
	private JButton BCheck;
	private JTextField input;
	private JTextField output;
	private JButton encrypt;
	private JButton decrypt;
	private JLabel inputLabel; 
	private JPanel subPanelInput; 
	private JLabel outputLabel;
	private JPanel subPanelOutput;
	private JFrame f;
	
	public V(M m, C c) {
		this.m1=m;
		this.c1=c;
		this.f= new JFrame("Verschlüsselung 3");
		this.f.setResizable(false);
		this.f.setLocationRelativeTo(null);
		this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.f.setSize(300, 300);
		this.f.setLayout(new BoxLayout(this.f.getContentPane(), BoxLayout.Y_AXIS));
		
		this.rb1 = new JRadioButton("Substitution", true);
		this.rb2 = new JRadioButton("ShiftCipher");
		this.rb1.addActionListener(this.c1);
		this.rb2.addActionListener(this.c1);
		this.radioGroup = new ButtonGroup();
		this.radioGroup.add(this.rb1);
		this.radioGroup.add(this.rb2);
		this.selection = new JPanel();
		this.selection.setBorder(BorderFactory.createTitledBorder("Method"));
		this.selection.add(this.rb1);
		this.selection.add(this.rb2);
		this.selection.setMaximumSize(new Dimension(300, 70));
		
		
		this.settings = new JPanel();
		this.settings.setBorder(BorderFactory.createTitledBorder("Settings"));
		this.settings.setMaximumSize(new Dimension(300, 150));
		this.settings.setLayout(new GridLayout(2, 1));
		this.settingLabel = new JLabel("Values: ");
		this.inputSettings = new JTextField();
		this.subPanelSetting = new JPanel();
		this.subPanelSetting.setLayout(new GridLayout(1, 2));
		this.subPanelSetting.add(this.settingLabel);
		this.subPanelSetting.add(this.inputSettings);
		this.BCheck = new JButton("Apply");
		this.BCheck.addActionListener(this.c1);
		this.settings.add(this.subPanelSetting);
		this.settings.add(this.BCheck);

		this.inputOutput = new JPanel();
		this.inputOutput.setBorder(BorderFactory.createTitledBorder("Input & Output"));
		this.inputOutput.setLayout(new GridLayout(4, 1));
		this.input = new JTextField();
		this.inputLabel = new JLabel("Input: ");
		this.subPanelInput = new JPanel();
		this.subPanelInput.setLayout(new GridLayout(1, 2));
		this.subPanelInput.add(this.inputLabel);
		this.subPanelInput.add(this.input);
		this.output = new JTextField(m1.getOutput());
		this.outputLabel = new JLabel("Output: ");
		this.subPanelOutput = new JPanel();
		this.subPanelOutput.setLayout(new GridLayout(1, 2));
		this.subPanelOutput.add(this.outputLabel);
		this.subPanelOutput.add(this.output);
		this.output.setEditable(false);
		this.encrypt = new JButton("Encrypt");
		this.encrypt.addActionListener(this.c1);
		this.decrypt = new JButton("Decrypt");
		this.decrypt.addActionListener(this.c1);
		this.inputOutput.add(subPanelInput);
		this.inputOutput.add(subPanelOutput);
		this.inputOutput.add(this.encrypt);
		this.inputOutput.add(this.decrypt);

		this.f.add(this.selection);
		this.f.add(this.settings);
		this.f.add(this.inputOutput);
		this.f.setVisible(true);
	}
	/**
	 * Prüft Button
	 * @param e
	 * @return boolean
	 */
	public boolean isBCheck (ActionEvent e) {
		 if (e.getSource() == this.BCheck) return true;
		 return false;
	 }
	/**
	 * Prüft Button
	 * @param e
	 * @return boolean
	 */
	public boolean isEncrypt (ActionEvent e) {
		 if (e.getSource() == this.encrypt) return true;
		 return false;
	 }
	/**
	 * Prüft Button
	 * @param e
	 * @return boolean
	 */
	public boolean isDecrypt (ActionEvent e) {
		 if (e.getSource() == this.decrypt) return true;
		 return false;
	 }
	/**
	 * get für InputSettingText
	 * @return String
	 */
	public String getInputSettingText() {
		return this.inputSettings.getText();
	}
	/**
	 * Prüft ob rb1 selcted ist 
	 * @return boolean
	 */
	public boolean isRb1Selected() {
		return this.rb1.isSelected();
	}
	/**
	 * Prüft ob rb1 selcted ist 
	 * @return boolean
	 */
	public boolean isRb2Selected() {
		return this.rb2.isSelected();
	}
	/**
	 * Gibt den Output an den Benutzter zurück
	 */
	public void refresh() {
		this.output.setText(m1.getOutput());
	}
	/**
	 * get für Input
	 * @return String
	 */
	public String getInputText() {
		return this.input.getText();
	}
}
