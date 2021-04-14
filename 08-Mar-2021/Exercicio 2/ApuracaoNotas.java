package aplicacao;

public class ApuracaoNotas {
	private float a, b, c, d, soma;

	private float media() {
		float media = this.soma / 4;
		return media;
	}

	private String situacao() {
		float media = this.media();
		if (media < 6f) {
			return "* REPROVADO *";
		} else if (media < 7f) {
			return "* RECUPERACAO *";
		} else {
			return "* APROVADO *";
		}
	}

	public void status() {
		System.out.println("A soma das notas é " + this.soma + ", a média é " + this.media() + "\nSituação do aluno: "
				+ this.situacao());
	}

	public ApuracaoNotas(float a, float b, float c, float d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.soma = (this.a + this.b + this.c + this.d);
	}
}
