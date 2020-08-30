package com.miloscabrilo.ble;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;


public class MainForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final Action action = new SwingAction();
	//private BluetoothGattCharacteristic mBleGatt = new BluetoothGattCharacteristic();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Available Devices:");
		lblNewLabel.setBounds(33, 11, 90, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Scan");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(122, 7, 73, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(200, 7, 73, 23);
		frame.getContentPane().add(btnConnect);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(278, 7, 73, 23);
		frame.getContentPane().add(btnStart);
		
		JLabel lblNewLabel_1 = new JLabel("Package length:");
		lblNewLabel_1.setBounds(334, 36, 96, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(334, 55, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPackageType = new JLabel("Package type:");
		lblPackageType.setBounds(334, 86, 96, 14);
		frame.getContentPane().add(lblPackageType);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Byte", "Int", "Long"}));
		comboBox_1.setBounds(334, 100, 96, 23);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblSampleValue = new JLabel("Sample value:");
		lblSampleValue.setBounds(334, 144, 96, 14);
		frame.getContentPane().add(lblSampleValue);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(334, 163, 96, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNParameter = new JLabel("N parameter:");
		lblNParameter.setBounds(334, 202, 96, 14);
		frame.getContentPane().add(lblNParameter);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(334, 217, 96, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(122, 248, 151, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		String str[] = {"prvi", "drugi", "treci"};
		JList list = new JList(str);
		list.setBounds(43, 41, 270, 200);
		frame.getContentPane().add(list);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
