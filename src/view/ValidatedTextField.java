package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import validation.IValidator;

public class ValidatedTextField extends JTextField {

	private static final long serialVersionUID = 1L;
	
	private IValidator validator;
	
	public ValidatedTextField(IValidator validator) {
		addKeyListener(new P_KeyListener());
		this.validator = validator;
	}
	
	
	private class P_KeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == '\n') {
				System.out.println(getText());
				if (validator.validate(getText())) {
					System.out.println(validator.getValidMessage());
				} else {
					System.out.println(validator.getInvalidMessage());
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
