package net.fizzl.batmapper.ui.mapcanvas;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class SideShelfPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	public SideShelfPanel() {
		setLayout(new MigLayout("debug", "[grow]", "[][grow]"));
		initComponents();
	}

	private void initComponents() {
		JButton btnNew = new JButton("New");
		btnNew.setActionCommand("new");
		btnNew.addActionListener(this);
		add(btnNew, "wrap");
		add(canvas, "grow");
	}
	SideShelfCanvas canvas = new SideShelfCanvas();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("new")) {
			createRoom();
		}
	}

	private void createRoom() {
		RoomComponent rc = new RoomComponent();
		rc.move(new Point((getWidth()/2)-(rc.getWidth()/2), 15*(canvas.getComponentCount()+1)));
		canvas.add(rc);
		canvas.repaint();
	}
}
