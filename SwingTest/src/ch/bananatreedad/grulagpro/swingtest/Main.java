package ch.bananatreedad.grulagpro.swingtest;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Testclass for f.held which should explain functionality of FlowLayout.
 * 
 * @author bananatreedad
 *
 */
public class Main {

	public static void main(String args[]) {
		JFrame myFrame = new JFrame("Title of Form");

		// new labels
		JLabel jlbHelloWorld = new JLabel("Hello World");
		JLabel jlbHelloWorld1 = new JLabel("Hello World1");
		JLabel jlbHelloWorld3 = new JLabel("Hello World3");

		// setting the layouts on the Container (Frame)
		myFrame.setLayout(new FlowLayout());

		// add all Labels on the Container
		myFrame.add(jlbHelloWorld);
		myFrame.add(jlbHelloWorld1);
		myFrame.add(jlbHelloWorld3);

		myFrame.setSize(100, 100);

		myFrame.setVisible(true);
	}

}
