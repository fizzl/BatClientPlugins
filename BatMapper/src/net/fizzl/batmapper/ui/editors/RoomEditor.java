package net.fizzl.batmapper.ui.editors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.fizzl.batmapper.data.Room;
import net.miginfocom.swing.MigLayout;

public class RoomEditor extends JPanel {
	private static final long serialVersionUID = 1L;

	public RoomEditor(Room room) {
		this.room = room;
		setLayout(new MigLayout("debug", "[][grow]"));
		initComponents();
	}
	private Room room;

	private void initComponents() {
		add(lblShorDesc);
		txtShortDesc.setText(room.getShortDesc());
		add(txtShortDesc, "wrap,grow");
		add(lblLongDesc);
		txtLongDesc.setText(room.getLongDesc());
		add(txtLongDesc, "wrap,grow");
	}
	JLabel lblShorDesc		= new JLabel("Short:");
	JTextField txtShortDesc	= new JTextField();
	JLabel lblLongDesc		= new JLabel("Long:");
	JTextField txtLongDesc	= new JTextField();
	
}
