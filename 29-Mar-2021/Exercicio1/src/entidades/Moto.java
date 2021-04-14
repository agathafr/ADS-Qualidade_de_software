package entidades;

public abstract class Moto {
	protected String nome;
	protected String cilindrada;
	protected String cor;

	public String getNome() {
		return this.nome;
	}

	public String getCilindrada() {
		return this.cilindrada;
	}

	public String getCor() {
		return this.cor;
	}
}
