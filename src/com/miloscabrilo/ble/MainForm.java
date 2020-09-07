package com.miloscabrilo.ble;

import tinyb.*;

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
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.List;

import javax.swing.Action;
import tinyb.*;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;


public class MainForm implements ActionListener{

	private JFrame frame;
	private JTextField tfLength;
	private JTextField tfSampleValue;
	private JTextField tfNParameter;
	private JButton bScan, bConnect, bStart;
	private JComboBox cbPackageType;
	private JList listType;
	//private String stringValue[] = {};
	private ArrayList<String> stringValue = new ArrayList<String>();
	
	private final Action action = new SwingAction();
	private JLabel lAverageTime;
	public static JLabel lTime;
	private ArrayList<BluetoothDevice> listBleDevices;
	//private BluetoothGattCharacteristic mBleGatt = new BluetoothGattCharacteristic();
	
	static boolean running = true;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
					//BluetoothManager manager = BluetoothManager.getBluetoothManager();
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
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lAvailableDevice = new JLabel("Available Devices:");
		lAvailableDevice.setBounds(25, 15, 120, 15);
		frame.getContentPane().add(lAvailableDevice);
		
		bScan = new JButton("Scan");
		//scan_button.setAction(action);
		bScan.setBounds(185, 10, 100, 25);
		frame.getContentPane().add(bScan);
		bScan.addActionListener(this);
		
		bConnect = new JButton("Connect");
		bConnect.setBounds(315, 10, 100, 25);
		frame.getContentPane().add(bConnect);
		bConnect.addActionListener(this);
		
		bStart = new JButton("Start");
		bStart.setBounds(315, 240, 100, 25);
		frame.getContentPane().add(bStart);
		bStart.addActionListener(this);
		
		JLabel lPackageLength = new JLabel("Length:");
		lPackageLength.setHorizontalAlignment(SwingConstants.CENTER);
		lPackageLength.setBounds(315, 45, 100, 20);
		frame.getContentPane().add(lPackageLength);
		
		tfLength = new JTextField();
		tfLength.setHorizontalAlignment(SwingConstants.CENTER);
		tfLength.setBounds(315, 65, 100, 20);
		frame.getContentPane().add(tfLength);
		tfLength.setColumns(10);
		
		JLabel lPackageType = new JLabel("Type:");
		lPackageType.setHorizontalAlignment(SwingConstants.CENTER);
		lPackageType.setBounds(315, 90, 100, 20);
		frame.getContentPane().add(lPackageType);
		
		cbPackageType = new JComboBox();
		cbPackageType.setModel(new DefaultComboBoxModel(new String[] {"Byte", "Int", "Long"}));
		cbPackageType.setBounds(315, 110, 100, 25);
		frame.getContentPane().add(cbPackageType);
		
		JLabel lSampleValue = new JLabel("Sample:");
		lSampleValue.setHorizontalAlignment(SwingConstants.CENTER);
		lSampleValue.setBounds(315, 140, 100, 20);
		frame.getContentPane().add(lSampleValue);
		
		tfSampleValue = new JTextField();
		tfSampleValue.setHorizontalAlignment(SwingConstants.CENTER);
		tfSampleValue.setColumns(10);
		tfSampleValue.setBounds(315, 160, 100, 20);
		frame.getContentPane().add(tfSampleValue);
		
		JLabel lNParameter = new JLabel("N parameter:");
		lNParameter.setHorizontalAlignment(SwingConstants.CENTER);
		lNParameter.setBounds(315, 185, 100, 20);
		frame.getContentPane().add(lNParameter);
		
		tfNParameter = new JTextField();
		tfNParameter.setHorizontalAlignment(SwingConstants.CENTER);
		tfNParameter.setColumns(10);
		tfNParameter.setBounds(315, 205, 100, 20);
		frame.getContentPane().add(tfNParameter);
		
		lAverageTime = new JLabel("Average sending time:");
		lAverageTime.setHorizontalAlignment(SwingConstants.CENTER);
		lAverageTime.setBounds(35, 240, 240, 20);
		frame.getContentPane().add(lAverageTime);
		
		
		//String str[] = {};
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 50, 260, 175);
		frame.getContentPane().add(scrollPane);
		listType = new JList(stringValue.toArray());
		//listType = new JList(stringValue);
		scrollPane.setViewportView(listType);
		listType.setAutoscrolls(true);
		listType.setLayoutOrientation(JList.VERTICAL);
		listType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lTime = new JLabel("");
		lTime.setHorizontalAlignment(SwingConstants.CENTER);
		lTime.setBounds(105, 270, 100, 20);
		frame.getContentPane().add(lTime);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	// Button action
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// If the Button "Scan" is pressed.
		if(arg0.getSource() == bScan) {
			
			// TODO: Will be implemented.
			// Get list of Bluetooth devices.
			/*BluetoothManager manager = BluetoothManager.getBluetoothManager();
		    BluetoothDevice sensor = null;
		    for (int i = 0; (i < 15) && running; ++i) {
		        listBleDevices = (ArrayList<BluetoothDevice>) manager.getDevices();
		        
		        for (BluetoothDevice device : listBleDevices) {
		            printDevice(device);
		            
		            // Here we check if the address matches.
		             
		        }   
		    }
			
	        // The manager will try to initialize a BluetoothAdapter if any adapter is present in the system. To initialize
	        // discovery we can call startDiscovery, which will put the default adapter in discovery mode.
	      
	        //boolean discoveryStarted = manager.startDiscovery();

	        //System.out.println("The discovery started: " + (discoveryStarted ? "true" : "false"));
	        //BluetoothDevice sensor = getDevice(args[0]);
	        
	        */
		}
		
		// If the Button "Connect" is pressed.
		if(arg0.getSource() == bConnect) {
			
			int index = listType.getSelectedIndex();
			// Nothing is selected.
			if( index == -1 ) {
				JOptionPane.showMessageDialog(null, "Connection failed! Nothing is selected.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				// TODO: Try to connect to selected BLE device
			}
				
		}
		
		// If the Button "Start" is pressed.
		if(arg0.getSource() == bStart) {
			if(checkInputParameters()) {
				// Successfully
				JOptionPane.showMessageDialog(null, "Sending is started successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);
				lAverageTime.setText("Average sending time for " + tfNParameter.getText() + " packets: " );
				
				// Create sending packet.
				SendingData packet = new SendingData(Integer.parseInt(this.tfLength.getText()), (String)this.cbPackageType.getSelectedItem(),
										Integer.parseInt(this.tfSampleValue.getText()), Integer.parseInt(this.tfNParameter.getText()));
				packet.startSending();
				stringValue.add(this.tfSampleValue.getText());
			}
			else {
				JOptionPane.showMessageDialog(null, "Sending failed! Check input parameters.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	// Function for checking data conversion.
	public boolean checkInputParameters() {
		try {
			// Check the expected conversion.
			int packet_length = Integer.parseInt(this.tfLength.getText());
			String packet_type = (String)this.cbPackageType.getSelectedItem();
			int sample_value = Integer.parseInt(this.tfSampleValue.getText());
			int N_parameter = Integer.parseInt(this.tfNParameter.getText());
			// Conversion successful, next sending data.
			return true;
		}
        catch (NumberFormatException e) {
			return false;
        }
	}
	
	// Printing device status.
	static void printDevice(BluetoothDevice device) {
	    System.out.print("Address = " + device.getAddress());
	    System.out.print(" Name = " + device.getName());
	    System.out.print(" Connected = " + device.getConnected());
	    System.out.println();
	}
}
