package com.buksuit.sis;
/*
 * Abler, Andrew Kevin M.
 * 24/11/2022
 * OOP-Module-3-Practical-Exam
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame {
	
	JFrame mainFrame;
	JTabbedPane tabbedPane;
	JPanel studentPanel;
	JPanel studentOptionPanel;
	JPanel studentContentPanel;
	JButton addStudent;
	JScrollPane scrollPane;
	JTable TableforStudent;
	DefaultTableModel model;
	
	//Objects for column and rows in table
	Object[] column = {"STUDENT ID", "NAME", "ADDRESS", "AGE"};
	Object[] rows = new Object[4];
	
	MainFrame() {
		
		//Creates main frame
		mainFrame = new JFrame("Student Information System");
		mainFrame.setMinimumSize(new Dimension(900,600));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		
		//Creates tabbed pane
		tabbedPane = new JTabbedPane();
		mainFrame.add(tabbedPane);
		
		//Creates Panel1 for tabbed panel
		studentPanel = new JPanel();
		studentPanel.setBackground(Color.red);
		studentPanel.setSize(tabbedPane.getWidth(), tabbedPane.getHeight());
		studentPanel.setLayout(new BorderLayout());
		tabbedPane.addTab("Student", studentPanel);
		tabbedPane.addTab("Subject", null);
		
		//Creates Panel2 for options panel
		studentOptionPanel = new JPanel();
		studentOptionPanel.setBackground(Color.blue);
		studentOptionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		studentOptionPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		studentPanel.add(studentOptionPanel, BorderLayout.NORTH);
		
		//Creates Panel3 for content panel
		studentContentPanel = new JPanel();
		studentContentPanel.setLayout(new BorderLayout());
		studentContentPanel.setBackground(Color.cyan);
		studentPanel.add(studentContentPanel, BorderLayout.CENTER);
		
		//Creates button for adding students
		addStudent = new JButton("Add Student");
		studentOptionPanel.add(addStudent);
		addStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame newtab = new JFrame("Add Student");

				/*
				 * Sets default close operation.
				 * Sets size of the tab.
				 * Sets layout to null.
				 * Sets location to he main frame.
				 */
				newtab.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				newtab.setSize(650, 200);
				newtab.setLayout(null);
				newtab.setLocationRelativeTo(mainFrame);
				
				JPanel panel1 = new JPanel();
				panel1.setBounds(0, 0, 650, 125);
				panel1.setLayout(null);
				
				JTextField	id = new JTextField();
				id.setBounds(50, 25, 90, 20);
				panel1.add(id);
				
				JLabel	idlbl = new JLabel("ID:");
				idlbl.setBounds(30, 20, 35, 35);
				panel1.add(idlbl);
				
				JTextField	 name = new JTextField();
				name.setBounds(230, 25, 85, 20);
				panel1.add(name);
				
				JLabel	namelbl = new JLabel("NAME:");
				namelbl.setBounds(185, 10, 40, 50);
				panel1.add(namelbl);
				
				JTextField	address = new JTextField();
				address.setBounds(410, 25, 85,20 );
				panel1.add(address);
				
				JLabel		addresslbl = new JLabel("ADDRESS:");
				addresslbl.setBounds(340, 10, 75, 50);
				panel1.add(addresslbl);
				
				JTextField	age = new JTextField();
				age.setBounds(560, 25, 40, 20);
				panel1.add(age);
				
				JLabel		agelbl = new JLabel("AGE:");
				agelbl.setBounds(520, 10, 75, 50);
				panel1.add(agelbl);

				JButton add = new JButton("Save");
				add.setBounds(240, 90, 120, 40);
				add.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						//If any text field is blank it will show a message dialog to please fill all components
						if (id.getText().equals("") || name.getText().equals("") || address.getText().equals("") || age.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please fill all Components");
						}
						else {
							//Gets the user input
							rows[0] = id.getText();
							rows[1] = name.getText();
							rows[2] = address.getText();
							rows[3] = age.getText();
							model.addRow(rows);
							
					
							
							
							id.setText("");
							name.setText("");
							address.setText("");
							age.setText("");
						}
					}
					
				});
					panel1.add(add);
				
				
				newtab.add(panel1);
				newtab.setVisible(true);
			}
		});
		
		//Creates Scroll Pane
		scrollPane = new JScrollPane();
		studentContentPanel.add(scrollPane, BorderLayout.CENTER);
		
		//Creates JTable for student
		TableforStudent = new JTable();
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		TableforStudent.setModel(model);
		scrollPane.setViewportView(TableforStudent);
		
		
		
		
		
		mainFrame.setVisible(true);
	}
	
}

