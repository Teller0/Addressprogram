package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import validation.NameValidator;
import validation.TelephonValidator;
import database.Address;
import database.DaoFactory;

public class MainWindow extends JFrame {

	private class P_QuitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	private class P_SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Address address = new Address(lastNameField.getText(),givenNameField.getText(),phoneNumberField.getText());
			DaoFactory.getInstance().getDao().insertAddress(address);
		}

	}

	private static final long serialVersionUID = 1L;
	private JTextField lastNameField;
	private JTextField phoneNumberField;
	private JTextField givenNameField;

	public MainWindow() {
		setSize(400, 200);
		setLayout(new GridLayout(4,2));
		add(new JLabel("last name:"));
		lastNameField = new ValidatedTextField(new NameValidator());
		add(lastNameField);
		add(new JLabel("given name:"));
		givenNameField = new ValidatedTextField(new NameValidator());
		add(givenNameField);
		add(new JLabel("phonenumber:"));
		phoneNumberField = new ValidatedTextField(new TelephonValidator());
		add(phoneNumberField);
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new P_SaveButtonListener());
		add(saveButton);
		JButton quitButton = new JButton("Quit");
		add(quitButton);
		quitButton.addActionListener(new P_QuitButtonListener());
		setVisible(true);
		
	}
}
