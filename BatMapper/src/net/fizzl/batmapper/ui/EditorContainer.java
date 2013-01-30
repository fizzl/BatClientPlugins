package net.fizzl.batmapper.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import net.fizzl.batmapper.data.Area;
import net.fizzl.batmapper.data.Item;
import net.fizzl.batmapper.data.Monster;
import net.fizzl.batmapper.data.Note;
import net.fizzl.batmapper.data.Room;
import net.fizzl.batmapper.ui.editors.RoomEditor;

public class EditorContainer extends JPanel {
	private static final long serialVersionUID = 1L;
	public EditorContainer() {
		setLayout(new BorderLayout());
	}
	public void showObject(Object o) {
		removeAll();
		JPanel editor = null;
		if(o instanceof Area) {
			
		} 
		else if(o instanceof Room) {
			editor = new RoomEditor((Room) o);
		}
		if(o instanceof Monster) {
			
		} 
		else if(o instanceof Item) {
			
		}
		if(o instanceof Note) {
			
		} 
		add(editor);
		revalidate();
	}
}
