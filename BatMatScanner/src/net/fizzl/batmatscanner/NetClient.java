package net.fizzl.batmatscanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetClient extends Thread {
	private String host = "localhost";
	private int port = 3526;
	Socket s = null;
	PrintWriter out = null;
	BufferedReader in = null;
	IDataParser parser = null;
	
	NetClient(IDataParser p, String h, int po) {
		host = h;
		port = po;
		this.parser = p;
	}
	
	public void connect() {
		try {
			s = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		if(s == null) {
			connect();
		}
		String read = null;
		try {
			while((read = in.readLine()) != null) {
				read = read.trim();
				parser.feed(read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		msg = msg.trim();
		out.print(msg+"\r\n");
		out.flush();
	}
}
