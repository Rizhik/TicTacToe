package org.perova.TicTacToe;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class UI implements Runnable {

	// @Override
	public void run() {
		// Create the window
		JFrame f = new JFrame("Tic Tac Toe");

		// Sets the behavior for when the window is closed
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add a layout manager so that the button is not placed on top of the
		// label
		f.setLayout(new FlowLayout());

		// Add a label and a button
		f.add(new JLabel("Hello, world!"));
		f.add(new JButton("Press me!"));

		// Arrange the components inside the window
		f.pack();

		// By default, the window is not visible. Make it visible.
		f.setVisible(true);
	}

	public static void main(String[] args) {
		UI se = new UI();

		// Schedules the application to be run at the correct time in the event
		// queue.
		SwingUtilities.invokeLater(se);

	}

}
