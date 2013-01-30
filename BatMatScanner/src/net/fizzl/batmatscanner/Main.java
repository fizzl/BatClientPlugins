package net.fizzl.batmatscanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static NetClient nc;
	public static void main(String args[]) throws IOException {
		if(args.length != 2) {
			System.out.println("Usage: batmat <host> <port>");
			return;
		}
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		Parser p = new Parser();
		nc = new NetClient(p, host, port);
		CommandLine cli = new CommandLine();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		nc.connect();
		nc.start();
		System.out.println(
				"Scanner started.\nPlease consider donating in game to Fizzl "+
				"If you find this tool useful.\n\nType #help for introduction.\n\n");
		String line = null;
		while((line = in.readLine()) != null) {
			if(!cli.parse(line))
				nc.send(line);
		}
	}
}
