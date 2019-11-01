package HoraDoSistema;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ResolucaoDeTel {
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	int lar =  tela.getWiadth();
	int alt =  tela.getHeight();
	System.out.println("Sua tela em resolução" + lar + "x" + alt);
	
}
