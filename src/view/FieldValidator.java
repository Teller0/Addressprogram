package view;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import validation.IValidator;

public class FieldValidator {
	private IValidator validator;
	private JTextField textField;

	public FieldValidator(IValidator validator, JTextField textField) {
		this.validator = validator;
		this.textField = textField;
	}

	public boolean validate() {
		if (validator.validate(textField.getText())) {
			return true;
		} else {
			JOptionPane.showMessageDialog(textField.getParent(), validator.getInvalidMessage());
			return false;
		}
	}

}
