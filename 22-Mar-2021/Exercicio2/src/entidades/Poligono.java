package entidades;

import java.util.Scanner;

public abstract class Poligono {
	protected String nome;
	protected Scanner sc = new Scanner(System.in);

	public String getNome() {
		return this.nome;
	}

	public abstract double area();

	protected abstract void autoConstruct();
}
