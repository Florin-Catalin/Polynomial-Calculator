package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



/**
 *
 * @author Ungureanu Florin
 *
 *
 */

public class View extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField leftBound;
	private JTextField rightBound;
	private JTextField firstPolynomial;
	private JTextField secondPolynomial;
	private JTextField rezultat;
	private JTextField rezultat2;
	private JButton additionBtn;
	private JButton multiplicationBtn;
	private JButton divisionBtn;
	private JButton derivationBtn;
	private JButton subtractionBtn;
	private JButton integrationBtn;
	private JRadioButton rdbtnNewRadioButton;

	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = View.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file " + path);
			return null;
		}
	}

	public View() {
		ImageIcon plusButton = createImageIcon("plus.png");
		ImageIcon multiplicationButton = createImageIcon("multiplication.png");
		ImageIcon derivativeButton = createImageIcon("derivative.png") ;
		ImageIcon integrateButton = createImageIcon ("integrate.png");
		ImageIcon minusButton = createImageIcon ("minus.png");
		ImageIcon divideButton = createImageIcon ("divide.png");
		ImageIcon uniLabel = createImageIcon("uni.png") ;
		ImageIcon background = createImageIcon("math.jpg");
		
		

		frame = new JFrame("Polynomial Calculator");
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setContentPane(new JLabel(background));
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// subtraction button

		subtractionBtn = new JButton("Subtraction",minusButton);
		subtractionBtn.setVerticalTextPosition(AbstractButton.CENTER);
		subtractionBtn.setHorizontalTextPosition(AbstractButton.LEADING);
		subtractionBtn.setForeground(Color.DARK_GRAY);
		subtractionBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		subtractionBtn.setBackground(Color.RED);
		subtractionBtn.setBounds(460, 54, 200, 30);
		subtractionBtn.setOpaque(true);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(subtractionBtn);

		// addition button

		additionBtn = new JButton("Addition", plusButton);
		additionBtn.setVerticalTextPosition(AbstractButton.CENTER);
		additionBtn.setHorizontalTextPosition(AbstractButton.LEADING);
		additionBtn.setForeground(Color.DARK_GRAY);
		additionBtn.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		additionBtn.setBackground(Color.RED);
		additionBtn.setBounds(250, 54, 200, 30);
		frame.getContentPane().add(additionBtn);
		additionBtn.setToolTipText("Click this button to add two polynomials");

		// multiplication button

		multiplicationBtn = new JButton("Multiplication", multiplicationButton);
		multiplicationBtn.setVerticalTextPosition(AbstractButton.CENTER);
		multiplicationBtn.setHorizontalTextPosition(AbstractButton.LEADING);
		multiplicationBtn.setForeground(Color.DARK_GRAY);
		multiplicationBtn.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		multiplicationBtn.setBackground(Color.RED);
		multiplicationBtn.setBounds(250, 100, 200, 40);
		frame.getContentPane().add(multiplicationBtn);

		
		// division button
		divisionBtn = new JButton("Division",divideButton);
		divisionBtn.setVerticalTextPosition(AbstractButton.CENTER);
		divisionBtn.setHorizontalTextPosition(AbstractButton.LEADING);

		divisionBtn.setForeground(Color.DARK_GRAY);
		divisionBtn.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		divisionBtn.setBackground(Color.RED);
		divisionBtn.setBounds(460, 100, 200, 30);
		frame.getContentPane().add(divisionBtn);

		  // integration button 
		 
		integrationBtn = new JButton("Integration",integrateButton);
		integrationBtn.setVerticalTextPosition(AbstractButton.CENTER);
		integrationBtn.setHorizontalTextPosition(AbstractButton.LEADING);
		integrationBtn.setForeground(Color.DARK_GRAY);
		integrationBtn.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		integrationBtn.setBackground(Color.RED);
		integrationBtn.setBounds(250, 150, 200, 30);
		frame.getContentPane().add(integrationBtn);

		
	
		derivationBtn = new JButton("Derivative",derivativeButton);
		derivationBtn.setVerticalTextPosition(AbstractButton.CENTER);
		derivationBtn.setHorizontalTextPosition(AbstractButton.LEADING);
		derivationBtn.setForeground(Color.DARK_GRAY);
		derivationBtn.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		derivationBtn.setBackground(Color.RED);
		derivationBtn.setBounds(460, 150, 200, 30);
		frame.getContentPane().add(derivationBtn);

		rdbtnNewRadioButton = new JRadioButton("[A,B]");
		rdbtnNewRadioButton.setBackground(Color.RED);
		rdbtnNewRadioButton.setForeground(Color.DARK_GRAY);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		rdbtnNewRadioButton.setBounds(480, 300, 50, 50);
		frame.getContentPane().add(rdbtnNewRadioButton);

		leftBound = new JTextField();
		leftBound.setBounds(273, 300, 77, 20);
		frame.getContentPane().add(leftBound);
		leftBound.setColumns(10);

		rightBound = new JTextField();
		rightBound.setColumns(10);
		rightBound.setBounds(387, 300, 77, 20);
		frame.getContentPane().add(rightBound);

		JLabel lblA = new JLabel(" A=");
		lblA.setForeground(Color.BLACK);
		lblA.setBounds(250, 300, 27, 20);
		frame.getContentPane().add(lblA);

		JLabel lblB = new JLabel(" B=");
		lblB.setForeground(Color.BLACK);
		lblB.setBounds(364, 300, 27, 20);
		frame.getContentPane().add(lblB);

		firstPolynomial = new JTextField();
		firstPolynomial.setBounds(45, 54, 195, 20);
		frame.getContentPane().add(firstPolynomial);
		firstPolynomial.setColumns(10);

		JLabel lblP = new JLabel("P1(x)=");
		lblP.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblP.setForeground(Color.RED);
		lblP.setBounds(10, 54, 37, 20);
		frame.getContentPane().add(lblP);

		JLabel lblP_1 = new JLabel("P2(x)=");
		lblP_1.setForeground(Color.RED);
		lblP_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblP_1.setBounds(10, 90, 37, 20);
		frame.getContentPane().add(lblP_1);

		secondPolynomial = new JTextField();
		secondPolynomial.setColumns(10);
		secondPolynomial.setBounds(45, 90, 195, 20);
		frame.getContentPane().add(secondPolynomial);

		rezultat = new JTextField();
		rezultat.setEditable(false);
		rezultat.setBounds(10, 126, 230, 31);
		frame.getContentPane().add(rezultat);
		rezultat.setColumns(10);

		rezultat2 = new JTextField();
		rezultat2.setEditable(false);
		rezultat2.setBounds(10, 161, 230, 31);
		frame.getContentPane().add(rezultat2);
		rezultat2.setColumns(10);
        
		
		JLabel symbol = new JLabel(uniLabel) ;
		symbol.setBounds(80, 8, 50, 40);
		frame.getContentPane().add(symbol);
		frame.setVisible(true);
		
		JLabel title = new JLabel("Polynomial calculator");
		title.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		title.setForeground(Color.RED);
		title.setBounds(300, 4, 300, 30);
	
		frame.getContentPane().add(title);
		frame.setVisible(true);
		
		
		
		JLabel author = new JLabel("Ungureanu Florin");
		author.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		author.setForeground(Color.RED);
		author.setBounds(10, 300, 200, 30);
	
		frame.getContentPane().add(author);
		frame.setVisible(true);
	}

	public void addAdditionListeners(ActionListener a) {
		additionBtn.addActionListener(a);
	}

	public void addSubtractionListener(ActionListener a) {
		subtractionBtn.addActionListener(a);
	}

	public void addDerivationListener(ActionListener a) {
		derivationBtn.addActionListener(a);
	}

	public void addIntegrationListeners(ActionListener a) {
		integrationBtn.addActionListener(a);
	}

	public void addDivisionListener(ActionListener a) {
		divisionBtn.addActionListener(a);
	}

	public void addMultiplicationListener(ActionListener a) {
		multiplicationBtn.addActionListener(a);
	}


}