package net.fizzl.batmapper.ui.mapcanvas;

import java.awt.datatransfer.DataFlavor;

public class RoomComponentFlavor extends DataFlavor{
	public RoomComponentFlavor() {
		super(RoomComponent.class, "Room");
	}

	@Override
	public boolean isFlavorSerializedObjectType() {
		return false;
	}
	
}