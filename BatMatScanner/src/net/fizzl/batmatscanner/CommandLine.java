/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmatscanner;

import java.util.Iterator;

public class CommandLine {
	public boolean parse(String arg) {
		if(!arg.startsWith("#"))
			return false;
		MatMap m = Parser.m;
		if(arg.equals("#help")) {
			help();
		}
		if(arg.equals("#setup")) {
			setup();
		}		
		else if(arg.equals("#dump")) {
			Iterator<Room> i = m.rooms.iterator();
			while(i.hasNext()) {
				i.next().longprint();
			}
		}
		if(arg.equals("#clear")) {
			Parser.m = new MatMap();
		}		
		else if(arg.equals("#mats")) {
			Iterator<Room> i = m.rooms.iterator();
			while(i.hasNext()) {
				Room r = i.next(); 
				if(r.mat != null) {
					r.print();	
				}
			}
		}
		else if(arg.startsWith("#search")) {
			String args[] = arg.split(" ");
			if(args.length != 2)
				return true;
			String what = args[1]; 
			Iterator<Room> i = m.rooms.iterator();
			while(i.hasNext()) {
				Room r = i.next(); 
				if(r.mat != null && r.mat.description.contains(what)) {
					r.print();	
				}
			}
		}
		else if(arg.startsWith("#tsearch")) {
			String args[] = arg.split(" ");
			if(args.length != 2)
				return true;
			String what = args[1];
			Iterator<Room> i = m.rooms.iterator();
			while(i.hasNext()) {
				Room r = i.next(); 
				if(r.mat != null && r.mat.type.toString().equals(what)) {
					r.print();	
				}
			}
		}	
		else if(arg.startsWith("#go")) {
			String args[] = arg.split(" ");
			if(args.length != 3)
				return true;
			int x = Integer.parseInt(args[1]);
			int y = Integer.parseInt(args[2]);
			Main.nc.send("set look_on_move off");
			while(x < Parser.x) {
				Main.nc.send("w");
				Parser.x--;
			}
			while(x > Parser.x) {
				Main.nc.send("e");
				Parser.x++;
			}
			while(y < Parser.y) {
				Main.nc.send("n");
				Parser.y--;
			}
			while(y > Parser.y) {
				Main.nc.send("s");
				Parser.y++;
			}
			Main.nc.send("set look_on_move on");
		}
		else if(arg.equals("#sturdy")) {
			Iterator<Room> i = m.rooms.iterator();
			while(i.hasNext()) {
				Room r = i.next(); 
				if(r.mat != null) {
					for(int ii=0;ii < sturdy.length;ii++){
						if(r.mat.description.contains(sturdy[ii])) {
							r.print();
						}	
					}
					
				}
			}
		}
		else if(arg.equals("#wood")) {
			Iterator<Room> i = m.rooms.iterator();
			while(i.hasNext()) {
				Room r = i.next(); 
				if(r.mat != null) {
					for(int ii=0;ii < wood.length;ii++){
						if(r.mat.description.contains(wood[ii])) {
							r.print();
						}	
					}
					
				}
			}
		}
		else if(arg.equals("#gemcutting")) {
			Iterator<Room> i = m.rooms.iterator();
			while(i.hasNext()) {
				Room r = i.next(); 
				if(r.mat != null) {
					for(int ii=0;ii < gemcutting.length;ii++){
						if(r.mat.description.contains(gemcutting[ii])) {
							r.print();
						}	
					}
					
				}
			}
		}
		else if(arg.equals("#rare")) {
			Iterator<Room> i = m.rooms.iterator();
			while(i.hasNext()) {
				Room r = i.next(); 
				if(r.mat != null) {
					for(int ii=0;ii < rare.length;ii++){
						if(r.mat.description.contains(rare[ii])) {
							r.print();
						}	
					}
					
				}
			}
		}
		return true;
	}
	
	private void setup() {
		Main.nc.send("set ultra_verbose on");
		Main.nc.send("set text_only on");
	}

	private void help() {
		System.out.println(
				"Type 'whereami' followed by peer to all directions.\n "+
				"This will scan the rooms around you and save any found \n "+
				"materials.\n\n"+
				"#setup\n"+
				"Send some commands to batmud, to set up for scanner usage.\n\n"+
				"#help\n"+
				"This Message\n\n"+
				"#dump\n"+
				"Dump all saved rooms\n\n"+
				"#clear\n"+
				"Clear all saved data and start from scratch.\n\n"+
				"#mats\n"+
				"Print all found materials and locations.\n\n"+
				"#search <material>\n"+
				"Search for certain material from the data.\n"+
				"Example: #search diamond\n\n"+
				"#tsearch <TREE|DEPOSIT|HERB>\n"+
				"Print all materials of certain type.\n"+
				"Example #tsearch TREE\n\n"+
				"#go <x> <y>\n"+
				"Walk to certain location on current continent.\n"+
				"Very simple and dumb. Only walks right angles and doesn't "+
				"know how to stop if blocked etc. Use with care."+
				"Example: #walk 452 543\n\n"+
				"#sturdy\n"+
				"List all materials found that are considered sturdy.\n\n"+
				"#wood\n"+
				"List all materials that produce wood when cut down.\n\n"+				
				"#gemcutting\n"+
				"List all materials perfect for gem cutting.\n\n"+				
				"#rare\n"+
				"List all materials considered rare.\n\n"				

		);
		
	}

	static String sturdy[] = {
		"laen",
		"adamantium",
		"garnet",
		"bloodstone",
		"durandium",
		"cobalt",
		"chrysoberyl",
		"nickel",
		"mithril",
		"diamond",
		"vanadium",
		"water",
		"zhentorium",
		"alexandrite",
		"diggalite",
		"emerald",
		"titanium",
		"topaz"
	};
	static String wood[] = {
		"pear",
		"plum",
		"apple",
		"elder",
		"pine",
		"holly"
		
	};
	static String gemcutting[] = {
		"emerald",
		"ruby",
		"diamond"
	};
	static String rare[] = {
		"dragonscale", 
		"sapphire", 
		"molybdenum", 
		"diamond", 
		"rhodium", 
		"zhentorium", 
		"starmetal", 
		"ivory", 
		"tadmium", 
		"kryptonite", 
		"petrified wood"
	};
}
