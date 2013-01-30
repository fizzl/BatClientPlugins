/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmatscanner;

import java.util.Iterator;
import java.util.Vector;

public class MatMap {
	Vector<Room> rooms = null;
	MatMap() {
		rooms = new Vector<Room>();
	}
	
	void push(Room r) {
		synchronized(rooms) {
			Iterator<Room> i = rooms.iterator();
			while(i.hasNext()) {
				Room a = i.next();
				if(a.x == r.x && a.y == r.y) {
					a.update(r);
					a.mat = DescMatcher.match(r.longdesc);
					return;
				}
			}
			r.mat = DescMatcher.match(r.longdesc);
			rooms.add(r);
		}
	}
}
