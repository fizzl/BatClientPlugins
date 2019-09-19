/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmatscanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements IDataParser {
	enum EParserState {
		PS_NONE,
		PS_READ_SHORT,
		PS_READ_EXITS,
		PS_READ_LONG
	};
	String shortdesc = "";
	String longdesc = "";
	String exits = "";
	int lbcount = 0;
	static MatMap m = new MatMap();
	EParserState state = EParserState.PS_NONE;
	static int x,y, gx, gy, px, py; // Current coordinates
	Pattern pLocation, pShort, pExits;
	
	Parser() {
		pLocation = Pattern.compile(".*\\(Coordinates: (.*)x, (.*)y; Global: (.*)x, (.*)y\\)");
		pShort = Pattern.compile("Loc:(.*)");
		pExits = Pattern.compile("Exits:(.*)");
	}
	
	@Override
	public void feed(String arg) {
		//System.out.println(arg);
		Matcher m;
		switch(state) {
		case PS_NONE:
			m = pLocation.matcher(arg);
			if(m.matches()) {
				String x = m.group(1);
				String y = m.group(2);
				String gx = m.group(3);
				String gy = m.group(4#);
				Parser.x = Integer.parseInt(x);
				Parser.y = Integer.parseInt(y);
				Parser.gx = Integer.parseInt(gx);
				Parser.gy = Integer.parseInt(gy);
			}
			parsePeer(arg);
			break;
		case PS_READ_SHORT:
			m = pShort.matcher(arg);
			if(m.matches()) {
				shortdesc = m.group(1).trim();
				state = EParserState.PS_READ_EXITS;
			}
			break;
		case PS_READ_EXITS:
			m = pExits.matcher(arg);
			if(m.matches()) {
				exits = m.group(1).trim();
				state = EParserState.PS_READ_LONG;
			}
			break;
		case PS_READ_LONG:
			
			if(arg.equals("")) {
				lbcount++;
				if(lbcount > 1) {
					createRoom();
					lbcount = 0;
				}
				break;
			}
			lbcount = 0;
			longdesc += arg.trim()+" ";
			break;
		default:
			state = EParserState.PS_NONE;
		}
	}

	private void createRoom() {
		Room r = new Room();
		r.x = px;
		r.y = py;
		r.shortdesc = shortdesc;
		r.longdesc = longdesc;
		r.exits = exits;
		m.push(r);
		shortdesc = "";
		longdesc = "";
		exits = "";
		state = EParserState.PS_NONE;
		if(r.mat != null)
			r.print();
	}

	private void parsePeer(String arg) {
		if(!arg.startsWith("You peer"))
			return;
		state = EParserState.PS_READ_SHORT;
		if(arg.equals("You peer north:")) {
			px = x;
			py = y - 1;
		}
		else if(arg.equals("You peer northeast:")) {
			px = x + 1;
			py = y - 1;			
		}
		else if(arg.equals("You peer east:")) {
			px = x;
			py = y + 1;
			
		}
		else if(arg.equals("You peer southeast:")) {
			px = x + 1;
			py = y + 1;
		}
		else if(arg.equals("You peer south:")) {
			px = x;
			py = y + 1;			
		}
		else if(arg.equals("You peer southwest:")) {
			px = x - 1;
			py = y + 1;			
		}
		else if(arg.equals("You peer west:")) {
			px = x - 1;
			py = y;			
		}
		else if(arg.equals("You peer northwest:")) {
			px = x - 1;
			py = y - 1;			
		}
	}

}
