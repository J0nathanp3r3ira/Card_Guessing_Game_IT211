import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	private int count = 0;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JButton buttonAdd;
	private JButton buttonReset;
	private JButton buttonSubtract;
	
	public GUI() {
		
		frame = new JFrame();
		
		buttonAdd = new JButton("Add me");
		buttonReset = new JButton("Reset me");
		buttonSubtract = new JButton("Subtract me");
		
		buttonAdd.setActionCommand("Add");
		buttonAdd.addActionListener(this);
		buttonReset.setActionCommand("Reset");
		buttonReset.addActionListener(this);
		buttonSubtract.setActionCommand("Subtract");
		buttonSubtract.addActionListener(this);
		
		label = new JLabel("Number of clicks: " + count);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(buttonAdd);
		panel.add(buttonSubtract);
		panel.add(buttonReset);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		new GUI();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("Reset")){
			count = 0;
		}else if (actionCommand.equals("Add")) {
			count++;
		}else if (actionCommand.equals("Subtract")) {
			count--;
		}
		
				
		label.setText("Number of clicks: " + count);
		
	}
	
	
	

}
