package com.miloscabrilo.ble;

import javax.swing.JOptionPane;


public class SendingData {
	private String header;
	// Data length.
	private int data_length;
	// Data type. Available formats are int, byte and long.
	private String data_type;
	// Data sample value.
	private int data_sample_value;
	// The average time for the last N successfully received packets.
	private int last_N_average_time;
	
	public SendingData(int data_length, String data_type, int data_sample_value, int last_N_average_time) {
		this.data_length = data_length;
		this.data_type = data_type;
		this.data_sample_value = data_sample_value;
		this.last_N_average_time = last_N_average_time;
		this.header = "s" + Integer.toString(data_length) + "s";
	}
	
	
	// Method for sending packets. HEADER will be sent first and then all packets.
	public void startSending() {
		
		// Use system time to calculate sending time.
		long finish;
		long start = System.nanoTime();
		
		
		// Sending HEADER first when method sendData(String) is implemented.
		// sendData(header);
		
		
		for (int i = 0; i < data_length; i++)
		{
			//start = System.nanoTime();
			if( i%last_N_average_time == 0 && i!=0)
			{
				finish = System.nanoTime();
				MainForm.lTime.setText(Long.toString((finish-start)/Integer.toUnsignedLong(last_N_average_time)) + " ms");
				start = System.nanoTime();
				
			}
								
			// Send one data to Mobile App BLE when method sendData(int) is implemented.
			// sendData(i);
		}
	
	}
	
	//Sending data
	public void sendData(int data) {
		// TODO: Implement this method.
	}
	
	// Sending HEADER
	public void sendData(String data) {
		// TODO: Implement this method.
	}
	
	
	public int getSampleValue() {
		return this.data_sample_value;
	}
	
	
};
