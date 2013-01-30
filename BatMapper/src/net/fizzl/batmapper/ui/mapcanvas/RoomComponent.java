package net.fizzl.batmapper.ui.mapcanvas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JComponent;

import net.fizzl.batmapper.data.Room;
import net.fizzl.batmapper.ui.MapperPanel;

public class RoomComponent extends JComponent implements DragGestureListener, DragSourceListener, Transferable {

	private static final long serialVersionUID = 1L;

	public RoomComponent() {
		updateBounds();
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(
	            this, DnDConstants.ACTION_MOVE, this);
		setRoom(new Room());
		addMouseListener(new ClickListener());
	}
	
	private void updateBounds() {
		setBounds(new Rectangle(
				pos.x-size.width/2, 
				pos.y-size.height/2,
				size.width,
				size.height));
	}
	public void move(Point newPos) {
		pos = newPos;
		getRoom().setMapPos(pos);
		updateBounds();
	}
	public Point getPos() {
		return pos;
	}
	private Point pos = new Point();
	Dimension size = new Dimension(15, 15);
	
	// Overrides
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	private Room room;
	private DragSource dragSource;
	
	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		dragSource.startDrag(dge, DragSource.DefaultMoveDrop, this, this);
		Container c = getParent();
		if(c != null) {
			c.remove(this);
			c.repaint();
		}
		
	}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DragSourceEvent dse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if(flavor.equals(new RoomComponentFlavor())) {
			return this;
		}
		return null;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor[] farr = new DataFlavor[1];
		farr[0] = new RoomComponentFlavor();
		return farr;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		DataFlavor f = new RoomComponentFlavor();
		if(flavor.equals(f)) {
			return true;
		}
		return false;
	}

	public void snap(int gridSize) {
		int deltaX = pos.x % gridSize;
		int deltaY = pos.y % gridSize;
		if(deltaX < gridSize / 2) {
			pos.x -= deltaX;
		} else {
			pos.x += (gridSize-deltaX);
		}
		if(deltaY < gridSize / 2) {
			pos.y -= deltaY;
		} else {
			pos.y += (gridSize - deltaY);
		}
		updateBounds();
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Room getRoom() {
		return room;
	}
	
	private class ClickListener implements MouseListener  {
		@Override
		public void mouseClicked(MouseEvent e) {
			Object o = getParent().getParent();
			if(o instanceof MapperPanel) {
				MapperPanel mp = (MapperPanel) o;
				mp.getEditorPanel().showObject(room);
			}
			else {
				o = getParent().getParent().getParent();
				if(o instanceof MapperPanel) {
					MapperPanel mp = (MapperPanel) o;
					mp.getEditorPanel().showObject(room);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
