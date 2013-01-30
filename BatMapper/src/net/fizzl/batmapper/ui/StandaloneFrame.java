/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmapper.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class StandaloneFrame extends JFrame {
	private static final long serialVersionUID = 19683183083686386L;
	public StandaloneFrame() {
		setTitle("BatMapper");
		setLayout(new BorderLayout());
		setSize(new Dimension(800, 600));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width-800, dim.height-600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MapperPanel());
	}
}
