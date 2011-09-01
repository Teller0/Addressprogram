package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import validation.TelephonValidator;

public class ValidatedTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	public ValidatedTextField() {
		addKeyListener(new P_KeyListener());
	}
	
	
	private class P_KeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == '\n') {
				System.out.println(getText());
				TelephonValidator validator = new TelephonValidator();
				if (validator.validate(getText())) {
					System.out.println("Is phonenumber");
				} else {
					System.out.println("Error, no phonenumber");
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

	}

}
