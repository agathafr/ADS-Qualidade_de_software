package entidades;

public class Retangulo extends Poligono {
	private double ladoA, ladoB;

	public Retangulo() {
		this.nome = "Retângulo";
		this.autoConstruct();
	}

	@Override
	public double area() {
		return this.ladoA * this.ladoB;
	}

	@Override
	protected void autoConstruct() {
		System.out.println("Informe os dois lados do retângulo: ");
		this.ladoA = sc.nextDouble();
		this.ladoB = sc.nextDouble();
	}

}
