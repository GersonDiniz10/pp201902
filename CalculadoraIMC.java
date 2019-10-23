package calculadoraIMC;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.GridLayout;
import javax.swing.BoxLayout;


class Tela extends JFrame {
	
	//Declarando as variáveis
	public JLabel lblP, lblA, lblR;
	public JTextField txtP, txtA;
	public JButton btC, btF, btL;
	
	public Tela(){
		setTitle("Calcule o seu Índice de Massa Corpórea");
		setSize(600,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//chamando os construtores
		lblP = new JLabel("Massa Corpórea:(Kg)");
		txtP = new JTextField();
		lblA = new JLabel("Altura:(m)");
		txtA = new JTextField();
		lblR = new JLabel();
		btC = new JButton("Calcule");
		btF = new JButton("Fechar");
		btL = new JButton("Limpar");

		setLayout(new GridLayout(0,2));		
		
		//adicionando os botões, caixas de texto e informativos
		add(lblP);
		add(txtP);
		add(lblA);
		add(txtA);
		add(lblR);
		add(btC);
		add(btF);
		add(btL);
		
		
		//Adicionando a funcionalidade do botão de calcular
		btC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double p = Double.parseDouble(txtP.getText());
				double a = Double.parseDouble(txtA.getText());
				//pegando a mensagem captada em String e transformando em float
				double imc = p/(a * a);
				//Fazendo o cálculo do IMC
				
				
				//Fazendo a comparação do valor encontrado com valores tabelados de IMC
				DecimalFormat df = new DecimalFormat("#0.0");
				String res = "O seu IMC é: " + df.format(imc);
				
				if(imc < 18.5){
					res+=". Abaixo do peso";}
                else if(imc < 24.9){
                	res+=". Peso ideal.";}
                else if(imc < 29.9){
                	res+=". Levemente acima do peso";}
                else if(imc < 34.9){
                	res+=". Primeiro grau de obesidade";}
                else if(imc < 39.9){
                	res+=". Segundo grau de obesidade";}
                else 
                	res+=". Obesidade mórbida";
				
				//Retorno de resultado do cálculo de IMC
				lblR.setText(res);
			}});
		//Adicionando a funcionalidade do botão de limpar
		btL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtP.setText(null);
				txtA.setText(null);
			}
		});
		//Adicionando a funcionalidade do botão de fechar
		btF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
	}
}

//Aplicativo de Execução
public class CalculadoraIMC {
	public static void main (String[] args) {
		Tela interf = new Tela();
		interf.setVisible(true);
	}
}