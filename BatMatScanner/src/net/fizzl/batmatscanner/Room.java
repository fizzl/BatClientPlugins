/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmatscanner;


public class Room {
	public int x,y;
	public String shortdesc;
	public String longdesc;
	public String exits;
	Material mat = null;

	void update(Room r) {
		this.x = r.x;
		this.y = r.y;
		this.shortdesc = r.shortdesc;
		this.longdesc = r.longdesc;
		this.mat = r.mat;
	}

	void longprint() {
		System.out.println("Coords: "+Integer.toString(x)+" "+Integer.toString(y));
		System.out.println("Exits : "+exits);
		System.out.println(shortdesc);
		System.out.println(longdesc);
		if(mat != null) {
			System.out.println(mat.description);	
		}
	}
	void print() {
		String msg = Integer.toString(x)+" "+Integer.toString(y);
		if(mat != null) {
			msg += ": "+mat.description;	
		}
		System.out.println(msg);
	}
}
