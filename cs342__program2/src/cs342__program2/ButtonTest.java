package cs342__program2;
/* Matt Borgelt & Jeet Patel */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;



public class ButtonTest extends JFrame{
	private JButton plainButton, fancyButton;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 200;
	
	public ButtonTest(){
		/* the title of the GUI */
		//super();
		/* window size */
		//setSize(WIDTH, HEIGHT);
		JFrame frame = new JFrame("Playing Minesweeper...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* default is HIDE ON CLOSE */
		//getContentPane().setBackground(Color.BLUE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.YELLOW);
		
		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new GridLayout(10, 10));
		firstPanel.setMaximumSize(new Dimension(300, 300));
		firstPanel.setBackground(Color.RED);
		JButton btn;
		
		
		Icon tile = new ImageIcon("tile.gif");
		Icon mine = new ImageIcon("mine.gif");
		Icon flag = new ImageIcon("flag.gif");
		Icon tile1 = new ImageIcon("1.gif");
		Icon tile2 = new ImageIcon("2.gif");
		Icon tile3 = new ImageIcon("3.gif");
		
		/* BUTTON ID (0-100) maps to 2-D array which simulates the GUI. Sort of like a bit vector
		 * randomly assigns 10 random numbers, 0-100. These are the mine locations.
		 */
		int i, j;
		int[] button_ID_map = new int[100];
		for(i=0; i<99; i++){
			button_ID_map[i] = 0;
		}
		
		Random rn = new Random();
		int r;
		for(i=0; i<99; i++){
			r  = rn.nextInt(99); /* generate random number 0..99 */
			if(button_ID_map[r] == 1){
				//collision! do again
				i--;
			} else {
				/* set the value to 1, indicating a mine */
				button_ID_map[r] = 1;
			}
			
		}
		
		
		
		/* happens when one of 100 buttons is pressed */
		ButtonHandler handler = new ButtonHandler();

		/* TODO: 10? randomly chosen buttons will have a "mine" "under" them. */
		
	
		/* create 10x10 grid */
		for(i=0; i<10; i++){
			for(j=0; j<10; j++){
				
				btn=new JButton( tile);
				btn.setPreferredSize(new Dimension(10, 10));
				firstPanel.add(btn);
				btn.addActionListener(handler);
				
				
				/* if(random_condition)==true then place mine
				 * else nothing */

			}
			
		}
		System.out.println( i);

		
	    mainPanel.add(firstPanel);
	    frame.setContentPane(mainPanel);
	    frame.setBackground(Color.BLUE);

	    frame.setSize(300, 300);
	    frame.setMinimumSize(new Dimension(300, 300));
	    
		
		frame.setVisible(true); /* for buttons */	
	}
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(ButtonTest.this, "you pressed: " + event.getActionCommand());
			/* if this button was one of the 10 chosen above that contains a mine... */
			//setVisible(false);
	
		}
	}
}
