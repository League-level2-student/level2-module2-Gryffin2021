package _06_overloading;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Overloading is when we have multiple methods with the SAME name, but DIFFERENT parameters.
 * This can mean a different number of parameters, or the parameter types can differ, or both!
 * An overloaded method can also have a different return type, in addition to changing the parameters.
 * 
 * GOAL: Create your own custom pop-up messages
 */
public class LeagueOptionPane {
	
	public static void showMessageDialog(String message) {
		// 1. Open example.png and make a GUI that looks like that
		//    The message parameter is what we want to show on our pop-up
		JFrame frame = new JFrame();
		frame.setTitle("Message");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JLabel image = new JLabel();
		image.setIcon(loadImage("league.png"));
		panel.add(image);
		JLabel text = new JLabel();
		text.setText(message);
		panel.add(text);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		// 2. Uncomment the line of code below. It sets the location of our frame to the center of the screen
		frame.setLocationRelativeTo(null);
	}
	
	// 3. Call this method in the Runner class
	

	// 4. Create another showMessageDialog() method that lets us also choose the Message and Title 
	//    2 String parameters (one for the message and one for the title)
	public static void showMessageDialog(String message, String title) {
		JFrame frame = new JFrame();
		frame.setTitle(title);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JLabel image = new JLabel();
		image.setIcon(loadImage("league.png"));
		panel.add(image);
		JLabel text = new JLabel();
		text.setText(message);
		panel.add(text);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	// 5. Call this method in the Runner class
	
	}
	// 6. Create another showMessageDialog() method that lets us choose the Message, Title, and Image
	//    3 String parameters (one for the message, one for the title, and one for the fileName)
	public static JPanel showMessageDialog(String message, String title, String imageIcon) {
		JFrame frame = new JFrame();
		frame.setTitle(title);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());	
		JLabel image = new JLabel();
		image.setIcon(loadImage(imageIcon));
		panel.add(image);
		JLabel text = new JLabel();
		text.setText(message);
		panel.add(text);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	// 7. Call this method in the Runner class
		return panel;
	
	}
	
	public static void showMessageDialog(String message, String title, String imageIcon, Color color) {
		JFrame frame = new JFrame();
		frame.setTitle(title);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JLabel image = new JLabel();
		image.setIcon(loadImage("league.png"));
		panel.add(image);
		JLabel text = new JLabel();
		text.setText(message);
		panel.add(text);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		JPanel panel2 = showMessageDialog("The League is the Best", "Message", "league.png");
		panel2.setBackground(color);
	}
	// CHALLENGE: 
		//	1. Create another showMessageDialog() method that lets us choose the Message, Title, Image, and Background Color
		//     3 String parameters (one for the message, one for the title, and one for the fileName)
		//	   1 Color parameter for the backgroundColor
		//			
		//	2. Change the return type of the 3rd showMessageDialog() method(the one right above) to JPanel
		//	   Make sure to return your panel at the end of that method
		//	
		//	3. Call the showMessageDialog() method you just modified in this method
		//	   Set the method equal to a JPanel
		//	
		//	4. Set the background of your panel to the backgroundColor parameter
		//
		//	5. Call this method in the Runner class
		//
		// WHY DID WE DO THIS? - because we were able to overload this method by calling one of the other methods inside of it
	
	
	public static ImageIcon loadImage(String fileName) {
		try {
			return new ImageIcon(ImageIO.read(new LeagueOptionPane().getClass().getResourceAsStream(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
