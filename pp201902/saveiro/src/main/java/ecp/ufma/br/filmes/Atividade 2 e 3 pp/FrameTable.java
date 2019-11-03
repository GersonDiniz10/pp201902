package ecp.ufma.br.filmes;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FrameTable() {
		super("Filmes");
		FilmeTableModel tm = new FilmeTableModel(dao);
		JTable t = new JTable(tm);
		scroll.setViewportView(tm);
		add(scroll);
		setSize(800, 250);
		setLocationRelativeTo(null);
	}
}
