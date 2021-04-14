package entidades;

public class Triangulo extends Poligono {
	private double base, altura;

	public Triangulo() {
		this.nome = "Tri�ngulo";
		this.autoConstruct();
	}

	@Override
	public double area() {
		return this.base * this.altura;
	}

	@Override
	protected void autoConstruct() {
		System.out.println("Informe a base e a altura do tri�ngulo");
		this.base = sc.nextDouble();
		this.altura = sc.nextDouble();
	}

}
