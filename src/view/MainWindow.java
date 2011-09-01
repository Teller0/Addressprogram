package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public MainWindow() {
		setSize(800, 400);
		textField = new ValidatedTextField();
		add(textField);
		setVisible(true);
	}
}
