package br.ufma.ecp.geo;

public class PlaneCircle extends Circle {

	private double cx, cy;

	public PlaneCircle(double r, double x, double y) {
		super(r);
		this.cx = x;
		this.cy = y;
		
	}
	public double distance(double x, double y) {
		double dx = x - cx, dy = y - cy;
		double distance = Math.sqrt(dx*dx + dy*dy);
		return (distance);
	}
}
