package olaMundoSwing;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;




public class CalculadoraIMC {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pl = new JPanel();
		//pl.setLayout(new FlowLayout());
		frame.add(pl);
		
		pl.add(new JLabel("Massa corporea:(Kg)"));
		JTextField txtNome = new JTextField(15);
		pl.add(txtNome);
		
		pl.setBounds(150, 100, 30, 100);
		
		JPanel pl2 = new JPanel();
		//pl.setLayout(new FlowLayout());
		frame.add(pl2);
		
		pl2.add(new JLabel("Altura:(m)"));
		JTextField txtNome2 = new JTextField(15);
		pl2.add(txtNome2);
		pl2.setBounds(150, 150, 30, 90);
		
		JButton btn = new JButton("Calcular");
		frame.add(btn);
		btn.setBounds(150, 200, 90, 25);
		
		
	}
}
