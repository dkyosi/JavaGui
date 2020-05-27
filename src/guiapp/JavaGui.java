package guiapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JavaGui extends JFrame{

	JPanel mainPanel,resultsPanel,buttonsPanel;
	JLabel firstNoLabel,secondNoLabel,thirdNoLabel,fourthNoLabel;
	JTextField txtfirstNumber,txtsecondNumber,txtthirdNumber,txtfourthNumber;
	JButton calculateBtn,exitBtn;
	JLabel sumLabel,productLabel,smallestLabel,largestLabel;
	JTextField txtSum,txtProduct,txtSmallest,txtLargest;
	
	//create an empty constructor
	JavaGui(){
		//set the title of the JFrame
		super("Java GUI Application ");
		
		/*
		 * This is the main panel(sPanel). All other panels are added to this panel.
		 * BorderLayout manager is used to ensure that methods such as add
		 * panel to SOUTH,NORTH,CENTER,EAST & WEST
		
		 */
		JPanel sPanel = new JPanel(new BorderLayout());
		
		/*
		 This panel (mainPanel) contains all input related fields.
		 TextFields and Labels
		 GridLayout manager used.
		 */
		mainPanel = new JPanel(new GridLayout(2,4,4,4));
		TitledBorder tborder = BorderFactory.createTitledBorder("Enter the Inputs below");
		tborder.setTitleJustification(TitledBorder.CENTER);
		mainPanel.setBorder(tborder);
		
	
		firstNoLabel = new JLabel("First Number");
		secondNoLabel = new JLabel("Second Number");
		thirdNoLabel = new JLabel("Third Number");
		fourthNoLabel = new JLabel("Fourth Number");
	
		txtfirstNumber = new JTextField(20);
		txtsecondNumber = new JTextField(20);
		txtthirdNumber = new JTextField(20);
		txtfourthNumber = new JTextField(20);
		
		//adding Labels & TextFields to the panel
		mainPanel.add(firstNoLabel);
		mainPanel.add(txtfirstNumber);
		mainPanel.add(secondNoLabel);
		mainPanel.add(txtsecondNumber);
		mainPanel.add(thirdNoLabel);
		mainPanel.add(txtthirdNumber);
		mainPanel.add(fourthNoLabel);
		mainPanel.add(txtfourthNumber);
		
		
		//results panel
		resultsPanel = new JPanel(new GridLayout(4,2,3,3));
		resultsPanel.setBorder(new EmptyBorder(10,10,10,10));
		sumLabel = new JLabel("Sum of the four values :");
		productLabel = new JLabel("Product of the four values :");
		smallestLabel = new JLabel("The smallest value :");
		largestLabel = new JLabel("The largest of the values :");
		
		txtSum = new JTextField(20);
		txtSum.setEditable(false);
		txtProduct = new JTextField(20);
		txtProduct.setEditable(false);
		txtSmallest = new JTextField(20);
		txtSmallest.setEditable(false);
		txtLargest = new JTextField(20);
		txtLargest.setEditable(false);
		
		//adding labels and text fields to the results panel
		resultsPanel.add(sumLabel);
		resultsPanel.add(txtSum);
		resultsPanel.add(productLabel);
		resultsPanel.add(txtProduct);
		resultsPanel.add(smallestLabel);
		resultsPanel.add(txtSmallest);
		resultsPanel.add(largestLabel);
		resultsPanel.add(txtLargest);
		
		//buttons panel
		buttonsPanel = new JPanel(new GridLayout(1,2,6,6));
		buttonsPanel.setBorder(new EmptyBorder(10,10,10,10));
		exitBtn=new JButton("Exit");
		exitBtn.setBackground(Color.RED);
		
		calculateBtn =new JButton("Calculate");
		
		//adding buttons to the buttons panel
		buttonsPanel.add(exitBtn);
		buttonsPanel.add(calculateBtn);
		
		//adding the panels to the MAIN PANEL (sPanel) and their location
		sPanel.add(mainPanel,BorderLayout.NORTH);
		sPanel.add(resultsPanel,BorderLayout.CENTER);
		sPanel.add(buttonsPanel,BorderLayout.SOUTH);
		
		//adding the sPanel to JFrame
		add(sPanel);
		
		//set frame properties
		setSize(500,250);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//adding action listener to exit button
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		//adding action listener to calculate button
		calculateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//start check if the text field is empty
					if(txtfirstNumber.getText().equals("")) {
						//show dialog
						JOptionPane.showMessageDialog(mainPanel, "Please enter First Number !");
						return;
					}
	               if(txtsecondNumber.getText().equals("")) {
	            	 //show dialog
	            		JOptionPane.showMessageDialog(mainPanel, "Please enter Second Number !");
						return;
					}
	               if(txtthirdNumber.getText().equals("")) {
	            	 //show dialog
	            		JOptionPane.showMessageDialog(mainPanel, "Please enter Third Number !");
						return;
					}
	               if(txtfourthNumber.getText().equals("")) {
	            	 //show dialog
	            		JOptionPane.showMessageDialog(mainPanel, "Please enter Fourth Number !");
						return;
					}
	               
	               //end of input check
	               
	     
	                     
	               
	               //declare variables to hold the values in the textFields
	               
	                int numOne = Integer.parseInt(txtfirstNumber.getText());
					int numTwo = Integer.parseInt(txtsecondNumber.getText());
					int numThree = Integer.parseInt(txtthirdNumber.getText());
					int numFour = Integer.parseInt(txtfourthNumber.getText());
					
					//set the results of the calculations to the results textFields
					
					int sum = sumOfNumbers(numOne,numTwo,numThree,numFour);
					txtSum.setText(String.valueOf(sum));
					
					int product = productOfNumbers(numOne,numTwo,numThree,numFour);
					txtProduct.setText(String.valueOf(product));
					
					int smallest = findSmallestNumber(numOne,numTwo,numThree,numFour);
					txtSmallest.setText(String.valueOf(smallest));
					
					int largest = findLargestNumber(numOne,numTwo,numThree,numFour);
					txtLargest.setText(String.valueOf(largest));
					//end of displaying results
			}
		});
		
		
	}
	
	//method to perform addition of the four numbers and return the value
	private int sumOfNumbers(int n1,int n2,int n3,int n4) {
		int result = n1+n2+n3+n4;
		return result;
	}
	
	//method to perform product of the four numbers and return the value
		private int productOfNumbers(int n1,int n2,int n3,int n4) {
			int result = n1*n2*n3*n4;
			return result;
		}
		
	//method to find smallest of the four numbers and return the value
	private int findSmallestNumber(int n1,int n2,int n3,int n4) {
		int smallest = n1;
	    if(n2<smallest) {
	    	smallest=n2;
	    }
	    if(n3<smallest) {
	    	smallest=n3;
	    }
	    if(n4<smallest) {
	    	smallest=n4;
	    }
		return smallest;
	}
		
	//method to find largest of the four numbers and return the value
	private int findLargestNumber(int n1,int n2,int n3,int n4) {
		int largest = n1;
	    if(n2>largest) {
	    	largest=n2;
	    }
	    if(n3>largest) {
	    	largest=n3;
	    }
	    if(n4>largest) {
	    	largest=n4;
	    }
		return largest;
	}
	
	/*The main function*/
	public static void main(String[]args) {
		new JavaGui();
	}
	
	
	
}
