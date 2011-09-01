package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import validation.NameValidator;
import validation.TelephonValidator;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public MainWindow() {
		setSize(800, 400);
		textField = new ValidatedTextField(new NameValidator());
		add(textField);
		setVisible(true);
		setSize(800, 400);
		textField = new ValidatedTextField(new NameValidator());
		add(textField);
		setVisible(true);
		setSize(800, 400);
		textField = new ValidatedTextField(new TelephonValidator());
		add(textField);
		setVisible(true);
	}
}
