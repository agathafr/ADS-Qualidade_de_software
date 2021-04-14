package entidades;

public class Quadrado extends Poligono {
	private double lado;

	public Quadrado() {
		this.nome = "Quadrado";
		this.autoConstruct();
	}

	@Override
	public double area() {
		return Math.pow(this.lado, 2);
	}

	@Override
	protected void autoConstruct() {
		System.out.println("Informe o lado: ");
		this.lado = sc.nextDouble();
	}

}
