package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

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
			if (validateInput()) {
				Address address = new Address(lastNameField.getText(),givenNameField.getText(),phoneNumberField.getText());
				DaoFactory.getInstance().getDao().insertAddress(address);
			}
		}

	}

	private static final long serialVersionUID = 1L;
	private JTextField lastNameField;
	private JTextField phoneNumberField;
	private JTextField givenNameField;
	private Collection<FieldValidator> validations = new ArrayList<FieldValidator>(); 

	public MainWindow() {
		setSize(400, 200);
		setLayout(new GridLayout(4,2));
		lastNameField = new JTextField();
		givenNameField = new JTextField();
		phoneNumberField = new JTextField();
		
		JButton saveButton = new JButton("Save");
		JButton quitButton = new JButton("Quit");

		saveButton.addActionListener(new P_SaveButtonListener());
		quitButton.addActionListener(new P_QuitButtonListener());
		
		validations.add(new FieldValidator(new NameValidator(), lastNameField));
		validations.add(new FieldValidator(new NameValidator(), givenNameField));
		validations.add(new FieldValidator(new TelephonValidator(), phoneNumberField));

		add(new JLabel("last name:"));
		add(lastNameField);
		add(new JLabel("given name:"));
		add(givenNameField);
		add(new JLabel("phonenumber:"));
		add(phoneNumberField);
		add(saveButton);
		add(quitButton);
		setVisible(true);
	}
	
	private boolean validateInput() {
		for (FieldValidator fv : validations) {
			if (!fv.validate()) {
				return false;
			}
		}
		return true;
	}
	
}
