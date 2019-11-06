package ecp.ufma.br.filmes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FilmeDAO dao = new FilmeDAO();

	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblCodigo;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtCodigo;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnSair;
	private JButton btnMostra;

	private JPanel jpnNome;
	private JPanel jpnGenero;
	private JPanel jpnCodigo;
	private JPanel jpnButton;
	private JPanel jpnButton1;
	private JPanel jpnCN;
	private JPanel jpnCNA;
	private JPanel jpnCNAB;
	private JPanel jpnCNABB; 

	public FrameFilme() {
		
		setTitle("Cadastro de Livros");
		setSize(350, 180);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLocationRelativeTo(null); 

		
		lblNome = new JLabel("Nome do filme: ");
		lblGenero = new JLabel("Gênero: ");
		lblCodigo = new JLabel("Código: ");
		txtNome = new JTextField(20);
		txtGenero = new JTextField(20);
		txtCodigo = new JTextField(20);
		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		btnMostra = new JButton("Visualisar livros");

		jpnNome = new JPanel(new BorderLayout());
		jpnGenero = new JPanel(new BorderLayout());
		jpnCodigo = new JPanel(new BorderLayout());
		jpnButton = new JPanel(new FlowLayout());
		jpnButton1 = new JPanel(new BorderLayout());
		jpnCN = new JPanel(new BorderLayout());
		jpnCNA = new JPanel(new BorderLayout());
		jpnCNAB = new JPanel(new BorderLayout());
		jpnCNABB = new JPanel(new BorderLayout());
		

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Filme filme = new Filme(txtNome.getText(), txtGenero.getText(), Integer.parseInt(txtCodigo.getText()));
				dao.salvaNoBanco(filme);
				btnCadastrarActionPerformed();
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtGenero.setText("");
				txtCodigo.setText("");
			}
		});

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSairActionPerformed();
			}
		});

		btnMostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameTable frame = new FrameTable();
				frame.setVisible(true);
			}
		});

		
		jpnNome.add(lblNome, BorderLayout.WEST);
		jpnNome.add(txtNome, BorderLayout.EAST);
		jpnCN.add(jpnNome, BorderLayout.NORTH);

		jpnGenero.add(lblGenero, BorderLayout.WEST);
		jpnGenero.add(txtGenero, BorderLayout.EAST);
		jpnCN.add(jpnGenero, BorderLayout.SOUTH);

		jpnCodigo.add(lblCodigo, BorderLayout.WEST);
		jpnCodigo.add(txtCodigo, BorderLayout.EAST);
		jpnCNA.add(jpnCN, BorderLayout.NORTH);
		jpnCNA.add(jpnCodigo, BorderLayout.SOUTH);

		jpnButton.add(btnCadastrar, BorderLayout.WEST);
		jpnButton.add(btnLimpar, BorderLayout.CENTER);
		jpnButton.add(btnMostra, BorderLayout.EAST);
		jpnCNAB.add(jpnCNA, BorderLayout.NORTH);
		jpnCNAB.add(jpnButton, BorderLayout.SOUTH);

		jpnButton1.add(btnSair, BorderLayout.CENTER);
		jpnCNABB.add(jpnCNAB, BorderLayout.NORTH);
		jpnCNABB.add(jpnButton1, BorderLayout.SOUTH);

		
		add(jpnCNABB);
	}

	private void btnCadastrarActionPerformed() {
		JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso", "Cadastro de filmes",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void btnSairActionPerformed() {
		int confirm = JOptionPane.showConfirmDialog(this, "Deseja realemente fechar a aplicação?", "Sair - Contirmação",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			dao.desconectaBanco();
			System.exit(1);
		}
	}
}