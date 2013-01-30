package net.fizzl.batioproxy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

import com.mythicscape.batclient.interfaces.BatClientPlugin;
import com.mythicscape.batclient.interfaces.BatClientPluginCommandTrigger;
import com.mythicscape.batclient.interfaces.BatClientPluginTrigger;
import com.mythicscape.batclient.interfaces.ClientGUI;
import com.mythicscape.batclient.interfaces.ParsedResult;

public class Plugin extends BatClientPlugin implements 
BatClientPluginTrigger, BatClientPluginCommandTrigger,
NetworkCallback{

	ServerSocket s = null;
	ClientGUI gui = null;
	Vector<IOThread> threads = null;

	@Override
	public String getName() {
		return "Bat I/O Proxy";
	}

	@Override
	public void loadPlugin() {
		gui = getClientGUI();
		Log.gui = gui;
		threads = new Vector<IOThread>();		
		new Thread() {
			public void run() {
				try {
					s = new ServerSocket(0);
				} catch (IOException e) {
					Log.i("BatIOPRoxy: Failed to create socket.");
				}
				Log.i("BatIOPRoxy: Listening on port "+Integer.toString(s.getLocalPort()));
				while(true) {
					try {
						Socket ss = s.accept();
						InetSocketAddress isa = (InetSocketAddress) ss.getRemoteSocketAddress();
						Log.i("BatIOPRoxy: Connect "+isa.getHostName());
						IOThread io = new IOThread(ss, Plugin.this); 
						synchronized(threads) {
							threads.add(io);
							io.start();
						}
					} catch (IOException e) {
						Log.i("BatIOPRoxy: Exception while listening. Bailing out.");
						break;
					}
				}
			}
		}.start();
	}

	@Override
	public ParsedResult trigger(ParsedResult arg0) {
		Log.d("public ParsedResult trigger(ParsedResult arg0)");
		if(threads == null) return arg0;
		String msg = arg0.getStrippedText();
		Log.d("public ParsedResult trigger(ParsedResult arg0)"+msg);
		Iterator<IOThread> i = threads.iterator();
		Log.d("public ParsedResult trigger(ParsedResult arg0)"+Boolean.toString((i.hasNext())));
		while(i.hasNext()) {
			i.next().Send(msg);
		}
		return arg0;
	}

	@Override
	public String trigger(String arg0) {
		if(threads == null) return arg0;
		Iterator<IOThread> i = threads.iterator();
		while(i.hasNext()) {
			i.next().Send(arg0);
		}
		return arg0;
	}

	@Override
	public void Send(String msg) {
		gui.doCommand(msg);
	}

	@Override
	public void Disconnect(IOThread t) {
		Log.i("BatIOPRoxy: Client disconnected.");
		synchronized(threads) {
			threads.remove(t);
		}
	}
}
