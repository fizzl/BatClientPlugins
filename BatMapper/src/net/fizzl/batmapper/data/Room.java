package net.fizzl.batmapper.data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Room {
	private String shortDesc = "";
	private String longDesc = "";
	private Note note = new Note();
	
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	public List<Monster> getMonsters() {
		return monsters;
	}
	public void setMonsters(List<Monster> monsters) {
		this.monsters = monsters;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Point getMapPos() {
		return mapPos;
	}
	public void setMapPos(Point mapPos) {
		this.mapPos = mapPos;
	}
	private List<Monster> monsters = new ArrayList<Monster>();
	private List<Item>	items = new ArrayList<Item>();
	private Point mapPos = new Point();
}
