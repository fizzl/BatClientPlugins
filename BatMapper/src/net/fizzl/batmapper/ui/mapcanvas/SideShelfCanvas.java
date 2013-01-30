package net.fizzl.batmapper.ui.mapcanvas;

import java.awt.Color;
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

public class SideShelfCanvas extends JComponent implements DropTargetListener {
	private static final long serialVersionUID = 1L;
	
	public SideShelfCanvas() {
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		new DropTarget(this, this);
	}
	
	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paint(g);
	}

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
		// TODO Auto-generated method stub
		
	}

}
