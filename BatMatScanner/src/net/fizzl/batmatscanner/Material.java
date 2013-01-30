/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
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
