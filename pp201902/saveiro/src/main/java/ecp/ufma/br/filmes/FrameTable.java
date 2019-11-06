package ecp.ufma.br.filmes;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ecp.ufma.br.filmes.GenericTableModel;
import ecp.ufma.br.filmes.ReflectFilmeDAO;

public class FrameTable extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FrameTable() {
		super("Livros");
		//LivroTableModel tm = new LivroTableModel(dao);
		//JTable t = new JTable(tm);
		JTable tm = new JTable(new GenericTableModel<Filme>(new ReflectFilmeDAO()));
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tm);
		add(scroll);
		setSize(800, 250);
		setLocationRelativeTo(null); // Centraliza o Jframe
	}
}
