package net.fizzl.batmapper.ui.mapcanvas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.JComponent;

import net.fizzl.batmapper.data.Area;
import net.fizzl.batmapper.data.Room;

public class MapCanvas extends JComponent implements DropTargetListener {
	private static final long serialVersionUID = 1L;

	public MapCanvas() {
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		new DropTarget(this, this);
	}

	public void paint(Graphics g) {
		drawGrid(g);
		super.paint(g);
	}

	private Area area = new Area();

	private void drawGrid(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(GRID_COLOR);
		for (int x = 0; x < getWidth(); x += GRID_SIZE) {
			g.drawLine(x, 0, x, getHeight());
		}
		for (int y = 0; y < getHeight(); y += GRID_SIZE) {
			g.drawLine(0, y, getWidth(), y);
		}
	}

	private void snap() {
		for (Component c : getComponents()) {
			if (c instanceof RoomComponent) {
				RoomComponent o = (RoomComponent) c;
				o.snap(GRID_SIZE);
			}
		}
	}

	private static final Color GRID_COLOR = Color.lightGray;
	private static final int GRID_SIZE = 20;

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		DataFlavor dt = new RoomComponentFlavor();

		Transferable t = dtde.getTransferable();
		if (t.isDataFlavorSupported(dt)) {
			RoomComponent c = null;
			try {
				c = (RoomComponent) t.getTransferData(dt);
				c.move((Point) dtde.getLocation().clone());
				add(c);
				snap();
				repaint();
			} catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {

	}

	public void setArea(Area area) {
		this.area = area;
		loadArea();
	}

	private void loadArea() {
		for (Component c : getComponents()) {
			remove(c);
		}
		for(Room r : area.getRooms()) {
			RoomComponent rc = new RoomComponent();
			rc.move(r.getMapPos());
			add(rc);
		}
	}

	public Area getArea() {
		return area;
	}
}
