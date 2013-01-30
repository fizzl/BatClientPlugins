/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmatscanner;

public class DescMatcher {	
	public static Material matchTree(String desc) {
		Material ret = null;
		for(int i=0;i<Tree.length;i++) {
			if(desc.contains(" "+Tree[i]+" ")) {
				ret = new Material();
				ret.description = Tree[i];
				ret.type = Material.Type.TREE;
				ret.substance = mapSubstance(ret.description);
				break;
			}
		}
		return ret;
	}

	public static Material matchDeposit(String desc) {
		Material ret = null;
		for(int i=0;i<Deposit.length;i++) {
			if(desc.contains(" "+Deposit[i]+" ")) {
				ret = new Material();
				ret.description = Deposit[i];
				ret.type = Material.Type.DEPOSIT;
				ret.substance = mapSubstance(ret.description);
				break;
			}
		}
		return ret;
	}

	public static Material matchHerb(String desc) {
		Material ret = null;
		for(int i=0;i<Herb.length;i++) {
			if(desc.contains(" "+Herb[i]+" ")) {
				ret = new Material();
				ret.description = Herb[i];
				ret.type = Material.Type.HERB;
				ret.substance = mapSubstance(ret.description);
				break;
			}
		}
		return ret;
	}
	public static Material match(String desc) {
		Material m = null;
		if((m = matchTree(desc)) != null) return m;
		if((m = matchDeposit(desc)) != null) return m;
		if((m = matchHerb(desc)) != null) return m;
		return m;
	}
	private static String mapSubstance(String description) {
		return "";
	}

	private static String Deposit[] = {
		// Bone
		"bone",
		"dragonscale",
		"ivory",
		// Metal
		"adamantium", 
		"aluminium", 
		"anipium", 
		"batium", 
		"cesium", 
		"chromium", 
		"cobalt", 
		"copper", 
		"diggalite", 
		"durandium", 
		"electrum", 
		"gold", 
		"hematite", 
		"illumium", 
		"indium", 
		"iridium", 
		"iron", 
		"kryptonite", 
		"lead", 
		"magnesium", 
		"mithril", 
		"molybdenum", 
		"mowglite", 
		"nickel", 
		"nullium", 
		"osmium", 
		"palladium", 
		"platinum", 
		"potassium", 
		"pyrite", 
		"rhodium", 
		"silicon", 
		"silver", 
		"starmetal", 
		"tadmium", 
		"tin", 
		"titanium", 
		"tormium", 
		"tungsten", 
		"uranium", 
		"vanadium", 
		"zhentorium", 
		"zinc", 
		// Stone
		"amber", 
		"basalt", 
		"chalk", 
		"clay", 
		"coal", 
		"earth", 
		"granite", 
		"marble", 
		"moonstone", 
		"petrified wood", 
		"slate", 
		"stone", 
		"sulphur", 
		// Glass
		"crystal", 
		"laen", 
		"obsidian", 
		// Gem
		"alexandrite", 
		"amethyst", 
		"aquamarine", 
		"bloodstone", 
		"carnelian", 
		"chrysoberyl", 
		"diamond", 
		"emerald", 
		"garnet", 
		"jade", 
		"malachite", 
		"moss agate", 
		"olivine", 
		"onyx", 
		"opal", 
		"quartz", 
		"rhodonite", 
		"ruby", 
		"sapphire", 
		"sunstone", 
		"topaz", 
		"turquoise", 
		"zircon"
	};
	
	private static String Tree[] = {
		"pear",
		"plum",
		"apple",
		"elder",
		"pine",
		"bamboo",
		"birch", 
		"cedar", 
		"cork",
		"ebony", 
		"elm", 
		"mahogany", 
		"mallorn", 
		"maple", 
		"oak",
	};	
	
	private static String Herb[] = {
		"lettuce", 
		"green grass", 
		"corn wheat", 
		"carrot", 
		"green moss", 
		"cauliflower", 
		"potato", 
		"appletree", 
		"birch", 
		"cedar", 
		"ebony", 
		"elm", 
		"mahogany", 
		"mallorn", 
		"maple", 
		"oak", 
		"papaya", 
		"pinetree", 
		"yellow grass", 
		"thistle", 
		"cabbage", 
		"garlic", 
		"onion", 
		"honeysuckle", 
		"strawberry", 
		"peartree", 
		"reed", 
		"plumtree", 
		"spinach", 
		"turnip", 
		"blueberry", 
		"rhubarb", 
		"buttercup", 
		"rose", 
		"gray lichen", 
		"tomato", 
		"date", 
		"death cap", 
		"mushroom", 
		"elder", 
		"raspberry", 
		"arnica", 
		"cotton", 
		"grape", 
		"vine", 
		"bearberry", 
		"wormwood", 
		"lobelia", 
		"chickweed", 
		"nightshade", 
		"barrel cactus", 
		"holly", 
		"costmary", 
		"barberry", 
		"hcliz", 
		"lingonberry", 
		"mangrel", 
		"mugwort", 
		"soapwort", 
		"sweet flag", 
		"chicory", 
		"borage", 
		"jimsonweed", 
		"cacao", 
		"lungwort", 
		"comfrey", 
		"bloodroot", 
		"mistletoe", 
		"wolfbane", 
		"yarrow", 
		"boneset", 
		"water lily", 
		"ginseng", 
		"burdock", 
		"foxglove", 
		"mandrake", 
		"crystalline", 
		"jaslah", 
		"baneberry", 
		"hemlock", 
		"henbane", 
		"blood moss", 
		"mystic spinach", 
		"mystic carrot"
	};	
}
