/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmapper.data;

public class Item {
	private String shortDesc;
	private String longDesc;
	private ItemType type;
	
	public enum ItemType {
		GENERIC,
		ARMOUR,
		WEAPON
	}
}
