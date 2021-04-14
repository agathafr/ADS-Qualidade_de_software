package entidades;

public class Trapezio extends Poligono {
	private double medidaA, medidaB, medidaC;

	public Trapezio() {
		this.nome = "Trapezio";
		this.autoConstruct();
	}

	@Override
	public double area() {
		return ((this.medidaA + this.medidaB) * this.medidaC) / 2;
	}

	@Override
	protected void autoConstruct() {
		System.out.println("Informe as medidas do trapézio: ");
		this.medidaA = sc.nextDouble();
		this.medidaB = sc.nextDouble();
		this.medidaC = sc.nextDouble();
	}
}
