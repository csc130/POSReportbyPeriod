package pointOfSale;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SalesReportGUI extends JFrame implements ActionListener {

	private JButton[] buttons;
	private JTextField display;
	private JPanel buttonPanel;
	private JPanel displayPanel;
	private Container contentPane;
	private JLabel prompt;
	private String toEntered;
	private String fromEntered;
	private JButton request;
	private JButton restart;
	private JButton change;
	


	public SalesReportGUI ( )
	{
		setSize (800,350);
		setTitle ("Sales Report Date Period");

		contentPane = getContentPane ( );
		contentPane.setLayout (new BorderLayout ( ));

		display = new JTextField (10);
		displayPanel= new JPanel();
		displayPanel.setLayout(new FlowLayout());
		displayPanel.setSize(450, 100);
		prompt= new JLabel ("From: yyyy-mm-dd");
		change= new JButton("Click to enter end period");
		change.addActionListener(this);
		
		request= new JButton ("Generate requested sales report");
		request.addActionListener(this);
		request.setVisible(false);

		restart= new JButton ("Restart");
		restart.addActionListener(this);
		
		displayPanel.add(prompt);
		displayPanel.add(display);
		displayPanel.add(change);
		displayPanel.add(request);
		displayPanel.add(restart);
		contentPane.add (displayPanel,BorderLayout.NORTH);


		buttonPanel = new JPanel ( );
		contentPane.add (buttonPanel, BorderLayout.CENTER);

		buttonPanel.setLayout (new GridLayout (4,3));

		buttons = new JButton[12];

		for (int i = 0; i < 10; i++)
		{
			buttons[i] = new JButton((new Integer (i)).toString ( ));
			buttons[i].addActionListener (this);
			buttons[i].setPreferredSize(new Dimension(5, 5));
			buttonPanel.add (buttons[i]);
		}


		buttons[10] = new JButton ("-");
		buttons[10].addActionListener (this);
		buttonPanel.add (buttons[10]);
		buttons[11] = new JButton ("C");
		buttons[11].addActionListener (this);
		buttonPanel.add (buttons[11]);
		buttonPanel.setSize(30, 30);
		setDefaultCloseOperation (DISPOSE_ON_CLOSE);

	}


public static void main(String[]args){
   SalesReportGUI a= new SalesReportGUI();
   a.setVisible(true);
}

public void restart() {
	prompt.setText("From: yyyy-mm-dd");
	 display.setText("");
	 change.setVisible(true);
	 request.setVisible(false);
	 
}


@Override
public void actionPerformed(ActionEvent e) {
	String which="";
	which = e.getActionCommand();

	if (which.equalsIgnoreCase("Generate requested sales report")){
		 toEntered=display.getText();
		 if (!toEntered.substring(0,4).matches("[0-9]+") || toEntered.charAt(4)!='-'||
				 !toEntered.substring(5,7).matches("[0-9]+") || toEntered.charAt(7)!='-' || !toEntered.substring(8).matches("[0-9]+")) {
			 JOptionPane.showMessageDialog(null, "Incorrect format, try again.");
			 restart();
			 return;
		 }
		 else {
		 which="";
		 display.setText("Calculating....");
		 SearchPanel a= new SearchPanel(fromEntered,toEntered);
		 which="";
		a.ShowGUI();	
		 }
		/*JFrame searchPanel = new JFrame();
			searchPanel.add(a);
			searchPanel.setVisible(true);
			searchPanel.setSize(new Dimension(400,400));*/
	}
	
	if (which.equalsIgnoreCase("Click to enter end period")){
		 fromEntered= display.getText();
		 if (!fromEntered.substring(0,4).matches("[0-9]+") || fromEntered.charAt(4)!='-'||
				 !fromEntered.substring(5,7).matches("[0-9]+") || fromEntered.charAt(7)!='-' || !fromEntered.substring(8).matches("[0-9]+")) {
			 JOptionPane.showMessageDialog(null, "Incorrect format, try again.");
			 restart();
			 return;
		 }
		 else{	 
		 prompt.setText("To: yyyy-mm-dd");
		 display.setText("");
		 request.setVisible(true);
		 change.setVisible(false);
		 which="";
		 }
	}
	
	if (which.equalsIgnoreCase("Restart")){
		 prompt.setText("From: yyyy-mm-dd");
		 display.setText("");
		 change.setVisible(true);
		 request.setVisible(false);
		 which="";
	}
	
	
	if (which.equals ("C")){
		display.setText ("");
	}
	
	else{
		if (which.equals("0")||which.equals("1")|| which.equals("2")||which.equals("3")|| 
				which.equals("4")||which.equals("5")  || which.equals("6")||which.equals("7")
				|| which.equals("8")||which.equals("9")||which.equals("-")); 
		{
			display.setText (display.getText( )+ which);
		}
	}
	
	
	
}

}