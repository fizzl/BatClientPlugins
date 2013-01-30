/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batmapper.ui;

import javax.swing.JPanel;

import net.fizzl.batmapper.ui.mapcanvas.MapCanvas;
import net.fizzl.batmapper.ui.mapcanvas.SideShelfPanel;
import net.miginfocom.swing.MigLayout;

public class MapperPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public MapperPanel() {
		setLayout(new MigLayout("debug", "[][grow][]", "[grow]"));
		add(sideShelf, "width 100px, growy");
		add(mapCanvas, "grow");
		add(editorPanel, "width 200px, growy");
	}
	private SideShelfPanel sideShelf = new SideShelfPanel();
	private MapCanvas mapCanvas = new MapCanvas();
	private EditorContainer editorPanel = new EditorContainer();

	public SideShelfPanel getSideShelf() {
		return sideShelf;
	}
	public MapCanvas getMapCanvas() {
		return mapCanvas;
	}
	public EditorContainer getEditorPanel() {
		return editorPanel;
	}
}
