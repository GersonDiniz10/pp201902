package olaMundoSwing;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface OlaMundoSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		
		JPanel puts = new JPanel();
		puts.setLayout(new FlowLayout());
		frame.add(puts);
		
		puts.add(new JLabel("Nome"));
		JTextField txtNome = new JTextField(15);
		puts.add(txtNome);
		
		JPanel puts2 = new JPanel();
		puts2.setLayout(new FlowLayout());
		frame.add(puts2);
		
		puts2.add(new JLabel("Senha"));
		JTextField txtNome2 = new JTextField(15);
		puts2.add(txtNome2);		
		/*JButton btn1 = new JButton("Gol do Baguigol");
		JButton btn2 = new JButton("OH DUM DUM");
		frame.setLayout(new FlowLayout());
		frame.add(btn1);
		frame.add(btn2);
		*/
		frame.setVisible(true);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
