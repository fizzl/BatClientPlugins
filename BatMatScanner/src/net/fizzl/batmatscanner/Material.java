package net.fizzl.batmatscanner;

public class Material {
	enum Type {
		NONE,
		DEPOSIT,
		TREE,
		HERB
	}
	public Type type = Type.NONE;
	public String description = ""; 
	public String substance = "";

}
