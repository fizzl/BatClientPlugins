/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmapper;

import java.io.File;

import javax.swing.JFrame;

import net.fizzl.batmapper.ui.StandaloneFrame;

public class Main {
	public static void main(String[] args) {
		File f = new File(".");
		path = f.getAbsolutePath();
		JFrame frm = new StandaloneFrame();
		frm.setVisible(true);
	}
	public static String path = "./";
}
