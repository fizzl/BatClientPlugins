/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batioproxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.mythicscape.batclient.interfaces.ClientGUI;

public class Log {
	public static ClientGUI gui = null;
	private static boolean DEBUG = false;
	
	public static void d(String msg) {
		if(!DEBUG) return;
		File f = new File("/batioproxy.log");
		try {
			FileWriter w = new FileWriter(f, true);
			w.append(msg+"\n");
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void i(String msg) {
		if(gui == null) return;
		gui.printText("Generic", msg+"\n");
	}
}
