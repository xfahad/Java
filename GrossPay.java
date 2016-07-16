/*
 * File name:		GrossPay.java
 * Author:		xFahad

 * Date:		03/24/16
 * Description:		This a GUI program calculates the gross pay of an employee using JFrame windows, Action Listener, and events. It has 
 * 					a window that contain labels and text fields that help the user to enter the input. There are two buttons that
 * 					perform an action when they are clicked, Cancel and Calculate.
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class GrossPay extends JFrame implements ActionListener 
{


	JLabel  lblFirstName,			// describe the first name text field
			lblLastName,			// describe the last name text field
			lblRegularHours,		// describe the regular hours text field
			lblOvertimeHours,		// describe the overtime hours text field
			lblPayRate,				// describe the pay rate text field
			lblFullName,			// describe the full name text field
			lblGrossPay,			// describe the gross pay text field
			lblRegularHoursResult,	// describe the regular hours result text field
			lblOvertimeHoursResult;	// describe the overtime hours result text field
	
// input text fields
	JTextField  txtFirstName,			// text field to get input of employee's first name
				txtLastName,			// text field to get input of employee's last name
				txtRegularHours,		// text field to get input of employee's regular hours
				txtOvertimeHours,		// text field to get input of employee's overtime hours
				txtPayRate,				// text field to get input of employee's pay rate
				
// output text fields
				txtFullName,			// text field to show output of employee's full name
				txtGrossPay,			// text field to show output of employee's gross pay
				txtRegularHoursResult,	// text field to show output of employee's regular hours result
				txtOvertimeHoursResult;	// text field to show output of employee's overtime  hours result
	
	JButton cmdCalculate, 	// button that execute the process of calculation
			cmdCancel,		// exits the program
			cmdClear;		// button to clear text fields
	
	public GrossPay() // constructor for the Gross pay class
	
	{
		// TODO Auto-generated constructor stub
		
		lblFirstName = new JLabel(" First Name:");				// texts that will be displayed in the label
		lblLastName = new JLabel(" Last Name:");
		lblRegularHours = new JLabel(" Regular Hours:");
		lblOvertimeHours = new JLabel(" Overtime Hours:");
		lblPayRate = new JLabel(" Pay Rate:");
		lblFullName = new JLabel(" Employee's Full Name:");
		lblRegularHoursResult = new JLabel(" Regular Hours:");
		lblOvertimeHoursResult = new JLabel(" Overtime Hours:");
		lblGrossPay = new JLabel(" Gross Pay:");


		
		txtFirstName = new JTextField(10);				// creating text fields
		txtLastName = new JTextField(10);
		txtRegularHours = new JTextField(10);
		txtOvertimeHours = new JTextField(10);
		txtPayRate = new JTextField(10);
		txtFullName = new JTextField(10);
		txtRegularHoursResult = new JTextField(10);
		txtOvertimeHoursResult = new JTextField(10);
		txtGrossPay = new JTextField(10);
		
		txtFullName.setBackground(null);					// set transparent background for textfields to differentiate between input text field and output
		this.txtFullName.setEditable(false);				// to control the text field and not to tempt user to enter data
		this.txtRegularHoursResult.setBackground(null);
		this.txtRegularHoursResult.setEditable(false);
		this.txtOvertimeHoursResult.setBackground(null);
		this.txtOvertimeHoursResult.setEditable(false);
		this.txtGrossPay.setBackground(null);
		this.txtGrossPay.setEditable(false);
		
		cmdCalculate = new JButton("Calculate");		// calculate the gross pay and set information in the result section
		cmdCancel = new JButton("Cancel");				// exit program
		cmdClear = new JButton("Clear");				// clear text fields

		
// add items to window 
		add(lblFirstName); 
		add(txtFirstName);
		
		add(lblLastName);
		add(txtLastName);
		
		add(lblRegularHours);
		add(txtRegularHours);
		
		add(lblOvertimeHours);
		add(txtOvertimeHours);
		
		add(lblPayRate);
		add(txtPayRate);
		
		add(cmdCalculate);
		add(cmdCancel);
		
		add(lblFullName);
		add(txtFullName);


		add(lblRegularHoursResult);
		add(txtRegularHoursResult);

		add(lblOvertimeHoursResult);
		add(txtOvertimeHoursResult);
		
		add(lblGrossPay);
		add(txtGrossPay);
		add(cmdClear);
		
		
// window design
		cmdCancel.addActionListener(this); 		// call the action listener  (switch) for cmdCancel button
		cmdCalculate.addActionListener(this); 	// call the action listener  (switch) for cmdCalculate button
		cmdClear.addActionListener(this);
		final int WIDTH = 280 , HEIGHT = 330;	// constant variables that are responsible for the size
		this.setTitle("Gross Pay Calculator");	// set title
	
		this.setLayout(new GridLayout(11,2));	// GridLayout is more organized than flowLayout
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 200); 			// set the location 
		this.setSize(WIDTH, HEIGHT); 			// set the size of the window
	}
	
	public void actionPerformed(ActionEvent ae) // responsible for the action when an event happened 
	{
		double dRegularHours = 0;		// hold the regular hours
		double dOvertimeHours = 0; 		// hold the overtime hours
		double dPayRate = 0;			// hold the pay rate
		double dGrossPay = 0;			// hold the total (Gross pay)
		String strGrossPay;		// to convert the gross pay to a String to be able to display it in the text field
		
	
		
		switch(ae.getActionCommand()) // as the word written 
		{
		
		case "Calculate": // if this button clicked, do what's below
			
			
			dRegularHours = Double.parseDouble(txtRegularHours.getText()); 				// get regular hours input 
			dOvertimeHours = Double.parseDouble(txtOvertimeHours.getText()); 			// get overtime hours input 
			dPayRate = Double.parseDouble(txtPayRate.getText());						// get pay rate input
			dGrossPay = (dRegularHours * dPayRate) + (dOvertimeHours * dPayRate * 1.5);	// set gross pay calculation to this variable
			
			strGrossPay = String.valueOf(dGrossPay); 										// convert gross pay to the string
			txtFullName.setText(txtFirstName.getText() + " " + txtLastName.getText());		// display full name of employee
			txtRegularHoursResult.setText(txtRegularHours.getText());						// display regular hours
			txtOvertimeHoursResult.setText(txtOvertimeHours.getText());						// display overtime hours
			txtGrossPay.setText("$" + strGrossPay); 										// display gross pay
			break;
			
		case "Cancel": //  if this button clicked, do what's below
			System.exit(0); // exit the program
			break;
		case "Clear":
			txtFirstName.setText(null);
			txtLastName.setText(null);
			txtRegularHours.setText(null);
			txtOvertimeHours.setText(null);
			txtPayRate.setText(null);
			txtFullName.setText(null);
			txtRegularHoursResult.setText(null);
			txtOvertimeHoursResult.setText(null);
			txtGrossPay.setText(null);
			break;

		
		} // ends switch
		
		
	} // end actionPerformed
	

	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		GrossPay employee = new GrossPay(); // create an object 
		employee.setVisible(true); 			// set the GrossPay() window to visible
		employee.setResizable(false);		// do not allow user to change size
		

	} // ends main

} // ends class
