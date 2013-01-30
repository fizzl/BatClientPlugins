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
