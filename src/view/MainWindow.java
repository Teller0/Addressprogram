package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import validation.NameValidator;
import validation.TelephonValidator;

import database.Address;
import database.DaoFactory;

public class MainWindow extends JFrame {

	public class P_HelpButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MainWindow.this, "You suck!");
		}

	}

	public class P_ShowButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

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
		setLayout(new GridLayout(5,2));
		lastNameField = new JTextField();
		givenNameField = new JTextField();
		phoneNumberField = new JTextField();
		
		JButton saveButton = new JButton("Save");
		JButton showButton = new JButton("Show");
		JButton helpButton = new JButton("Help");
		JButton quitButton = new JButton("Quit");

		saveButton.addActionListener(new P_SaveButtonListener());
		showButton.addActionListener(new P_ShowButtonListener());
		helpButton.addActionListener(new P_HelpButtonListener());
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
		add(showButton);
		add(helpButton);
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
