package aplicacao;

public class Pessoa {
	String nome;
	double altura, peso;

	public String getNome() {
		return this.nome;
	}

	public double getAltura() {
		return this.altura;
	}

	public double getPeso() {
		return this.peso;
	}

	public String calcula() {
		String message = null;
		double imc = (this.peso / (this.altura * 2));
		if (imc < 20) {
			message = "IMC: " + imc + ", Abaixo do Peso";
		} else if ((imc >= 20) && (imc < 24.9)) {
			message = "IMC: " + imc + ", Peso Normal";
		} else if ((imc >= 25) && (imc < 29.9)) {
			message = "IMC: " + imc + ", Sobrepeso";
		} else if ((imc >= 30) && (imc < 39.9)) {
			message = "IMC: " + imc + ", Obesidade";
		} else if (imc >= 40) {
			message = "IMC: " + String.format("%.2f", imc) + ", Obesidade Mórbida";
		}
		return message;
	}

	public Pessoa(String nome, double altura, double peso) {
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
	}
}
