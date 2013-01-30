package net.fizzl.batioproxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class IOThread extends Thread {
	Socket s;
	PrintWriter out = null;
	BufferedReader in = null;
	NetworkCallback parent = null;

	public IOThread() {
		
	}

	IOThread(Socket s, NetworkCallback parent) throws IOException {
		this();
		this.s = s;
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(), false);
		this.parent = parent;
	}

	void Send(String msg) {
		out.print(msg);
		out.print("\r");
		out.flush();
	}

	@Override
	public void run() {
		String read = null;
		try {
			while((read = in.readLine()) != null) {
				parent.Send(read);
			}
		}
		catch(IOException e) {
			Log.d("IOThread::Run CRASH");
			e.printStackTrace();
		}
		parent.Disconnect(this);
	}
}
