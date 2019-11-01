package ecp.ufma.br.filmes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FrameFilmes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblCodigo;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtCodigo;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnSair;

	private JPanel jpnNome;
	private JPanel jpnGenero;
	private JPanel jpnCodigo;
	private JPanel jpnButton;

	public FrameFilmes() {
		// Config Jframe
		setTitle("Cadastro de filmes"); // Titulo
		setSize(400, 200); // Tamanho
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Fecha a aplicacao
		setLocationRelativeTo(null); // Centraliza o Jframe

		// Instanciando
		lblNome = new JLabel("Nome: ");
		lblGenero = new JLabel("Gênero: ");
		lblCodigo = new JLabel("Codigo: ");
		txtNome = new JTextField(15);
		txtGenero = new JTextField(15);
		txtCodigo = new JTextField(15);
		btnCadastrar = new JButton("Registrar");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		jpnNome = new JPanel();
		jpnGenero = new JPanel();
		jpnCodigo = new JPanel();
		jpnButton = new JPanel();

		// Adicionando acoes aos botoes
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Filmes filmes = new Filmes(txtNome.getText(), txtGenero.getText(), txtCodigo.getText());
				FilmesDAO dao = new FilmesDAO(); // Cria uma conexao com o banco de dados permitindo operacoes no
													// banco
				dao.salvaNoBanco(filmes); // salva os dados no banco
				dao.desconectaBanco(); // Fecha conexao com o banco
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

		// Adicionando componentes ao JFrame
		jpnNome.add(lblNome);
		jpnNome.add(txtNome);

		jpnGenero.add(lblGenero);
		jpnGenero.add(txtGenero);

		jpnCodigo.add(lblCodigo);
		jpnCodigo.add(txtCodigo);

		jpnButton.add(btnCadastrar);
		jpnButton.add(btnLimpar);
		jpnButton.add(btnSair);

		add(jpnNome);
		add(jpnGenero);
		add(jpnCodigo);
		add(jpnButton);
	}

	private void btnSairActionPerformed() {
		int confirm = JOptionPane.showConfirmDialog(this, "Deseja realemente fechar a aplicação?",
				"Sair - Contirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			System.exit(1);
		}
	}
	
	private void btnCadastrarActionPerformed() {
		JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso",
				"Cadastro de contatos", JOptionPane.PLAIN_MESSAGE);
	}
}