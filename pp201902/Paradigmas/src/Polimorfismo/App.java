package Polimorfismo;

public class App {
	public static void main(String args[]) {
		Mamifero m1 = new Elefante();
		Mamifero m2 = new Rato();
		System.out.println(m1.leite());
		System.out.println(m2.leite());
		
	}

}
