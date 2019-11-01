package br.ufma.ecp.geo;

public class App {
	static PlaneCircle pc = new PlaneCircle(4.0, 2.5, 3.0);
	static double ratio = pc.circumference()/pc.area();
	
	
	public static void main(String[] args){
		System.out.println(ratio);
		
		System.out.println(pc.distance(2.5, 3.0));
		
		
	}
	
}
