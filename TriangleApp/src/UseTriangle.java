// AUTHOR: 			Forrest Collins
// LAST UPDATED: 	12/2/15
// PURPOSE: 		This class is the GUI for the Triangle class.
// 					Logic is also implemented for triangle side textField inputs.

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

public class UseTriangle {

	private JFrame frame;
	private static JTextField sideOneTextField;
	private static JTextField sideTwoTextField;
	private static JTextField sideThreeTextField; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseTriangle window = new UseTriangle();
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
	public UseTriangle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//--------------------
		// MARK: - Frame Setup
		//--------------------
		frame = new JFrame("Triangle App");
		frame.setBounds(100, 100, 400, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Make frame not resizable.
		frame.setResizable(false);
		
		// Background Color Hex Code
		// Source: http://www.coderanch.com/t/337333/GUI/java/hex-set-background-color
		Color myBackgroundColor = Color.decode("#42A5F5");
		frame.getContentPane().setBackground(myBackgroundColor);
		
		//-----------------------------
		// MARK: - Triangle Title Label
		//-----------------------------
		JLabel lblNameThatTriangle = new JLabel("Name that Triangle!");
		lblNameThatTriangle.setForeground(Color.WHITE);
		lblNameThatTriangle.setBackground(Color.WHITE);
		lblNameThatTriangle.setFont(new Font("Avenir Next", Font.PLAIN, 21));
		lblNameThatTriangle.setBounds(103, 18, 190, 29);
		frame.getContentPane().add(lblNameThatTriangle);
		
		//------------------------------
		// MARK: - Triangle Status Label
		//------------------------------
		JLabel triangleStatusLabel = new JLabel("No triangle data yet...");
		triangleStatusLabel.setForeground(Color.YELLOW);
		triangleStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		triangleStatusLabel.setFont(new Font("Avenir Next", Font.BOLD | Font.ITALIC, 15));
		triangleStatusLabel.setBounds(6, 59, 388, 21);
		frame.getContentPane().add(triangleStatusLabel);
			
		//----------------------------------
		// MARK: - Triangle TextFields Setup
		//----------------------------------
		sideOneTextField = new JTextField();
		//sideOneTextField.setText("Enter a side");
		sideOneTextField.setToolTipText("side One");
		sideOneTextField.setToolTipText("");
		sideOneTextField.setFont(new Font("Avenir Next", Font.PLAIN, 15));
		sideOneTextField.setBounds(101, 92, 192, 26);
		frame.getContentPane().add(sideOneTextField);
		sideOneTextField.setColumns(10);
		
		sideTwoTextField = new JTextField();
		//sideTwoTextField.setText("Enter a side");
		sideTwoTextField.setToolTipText("side Two");
		sideTwoTextField.setFont(new Font("Avenir Next", Font.PLAIN, 15));
		sideTwoTextField.setBounds(103, 130, 190, 26);
		frame.getContentPane().add(sideTwoTextField);
		sideTwoTextField.setColumns(10);
		
		sideThreeTextField = new JTextField();
		//sideThreeTextField.setText("Enter a side");
		sideThreeTextField.setToolTipText("side Three");
		sideThreeTextField.setFont(new Font("Avenir Next", Font.PLAIN, 15));
		sideThreeTextField.setBounds(103, 168, 190, 26);
		frame.getContentPane().add(sideThreeTextField);
		sideThreeTextField.setColumns(10);

		//-----------------------------------------
		// MARK: - Calculate Triangle Button Tapped
		//-----------------------------------------
		JButton calculateTriangleButton = new JButton("Calculate Triangle");
		
		calculateTriangleButton.setFont(new Font("Avenir Next", Font.PLAIN, 15));
		
		calculateTriangleButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// Assign variables to TextFields
				String sideOne = sideOneTextField.getText();
				String sideTwo = sideTwoTextField.getText();
				String sideThree = sideThreeTextField.getText();
				
				// if any TextField is empty, alert user
				if (sideOne.equals("") || sideTwo.equals("") || sideThree.equals("")) {
					
					triangleStatusLabel.setText("Please fill in all fields.");
					
					// Hex Color for "Empty TextFields" Warning Label
					Color emptyTextFieldsLabelColor = Color.decode("#FFCDD2");
					triangleStatusLabel.setForeground(emptyTextFieldsLabelColor);
					
				} else {
					
					// check if all textField inputs are numbers
					if ((isNumeric(sideOne) == true) && 
							(isNumeric(sideTwo) == true) && 
							(isNumeric(sideThree) == true)) {
						
						// if the textFields contain numbers, convert the String inputs to Doubles
						// and assign variables
						double sideOneAsDouble = Double.parseDouble(sideOne);
						double sideTwoAsDouble = Double.parseDouble(sideTwo);
						double sideThreeAsDouble = Double.parseDouble(sideThree);
						
						// Check if any sides less than or equal zero, and alert the user
						// the only issue to solve now is a user can type "08" for example, but I guess that's fine.
						if (sideOneAsDouble <= 0  || sideTwoAsDouble <= 0 || sideThreeAsDouble <= 0){
							
							triangleStatusLabel.setText("Triangles can't have sides less than or equal to 0.");
							
							// Hex Color for Input less than or Equal to 0 Warning Label
							Color lessThanOrZeroLabelColor = Color.decode("#FFCDD2");
							triangleStatusLabel.setForeground(lessThanOrZeroLabelColor);
						}
						
						// Triangle Theorem 1: The sum of the lengths of any two sides
						// of a triangle must be greater than the third side.
						else if ((sideOneAsDouble + sideTwoAsDouble <= sideThreeAsDouble) || 
								 (sideOneAsDouble + sideThreeAsDouble <= sideTwoAsDouble) ||
								 (sideTwoAsDouble + sideThreeAsDouble <= sideOneAsDouble)){
								
							triangleStatusLabel.setText("Sum of two sides must be greater than the third.");
							
							// Hex Color for Input less than or Equal to 0 Warning Label
							Color lessThanOrZeroLabelColor = Color.decode("#FFCDD2");
							triangleStatusLabel.setForeground(lessThanOrZeroLabelColor);
							
						} else {
							
							// Assign the Triangle class variables to the textField input variables.
							Triangle.sideOne = sideOneAsDouble;
							Triangle.sideTwo = sideTwoAsDouble;
							Triangle.sideThree = sideThreeAsDouble;
							
							// Testing check, ignore this unless you are testing for textField input.
							//System.out.println("side 1 is: " + Triangle.sideOne); //0
							//System.out.println("side 2 is: " + Triangle.sideTwo); //0
							//System.out.println("side 3 is: " + Triangle.sideThree); //0
							
							// Triangle class logic used to set the text of a displayed label.
							if (Triangle.isEquilateral()) {
								triangleStatusLabel.setText("Equilateral");
								triangleStatusLabel.setForeground(Color.YELLOW);
							}
							else if (Triangle.isScalene()) {
								triangleStatusLabel.setText("Scalene");
								triangleStatusLabel.setForeground(Color.YELLOW);
							}
							else if (Triangle.isIsosceles()) {
								triangleStatusLabel.setText("Isosceles");
								triangleStatusLabel.setForeground(Color.YELLOW);
							}
						}
							
					} else {
					
						// add a warning label to alert the user if they did not enter a number
						triangleStatusLabel.setText("Please enter numbers only.");
						
						// Hex Color for Enter Numbers Only Warning Label
						Color enterNumbersOnlyLabelColor = Color.decode("#FFCDD2");
						triangleStatusLabel.setForeground(enterNumbersOnlyLabelColor);
					}	
				}
			}
		});
		
		calculateTriangleButton.setBounds(103, 206, 190, 44);
		frame.getContentPane().add(calculateTriangleButton);
	}
	
	//---------------------------------------------------------
	// MARK: - Check Validity of TextField input being a Number
	//---------------------------------------------------------
	// Source: http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-a-numeric-type-in-java
	public static boolean isNumeric (String str)
	{
		//match a number with optional '-' and decimal.
		return str.matches("[-+]?\\d*\\.?\\d+");  
	}
}
