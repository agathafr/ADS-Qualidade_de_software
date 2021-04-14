package aplicacao;

public class Alturas {
	private float maior,menor,media;
	private int cont;
	
	public float getMaior() {
		return this.maior;
	}
	public float getMenor() {
		return this.menor;
	}
	public float getMedia() {
		this.media = (this.maior+this.menor)/this.cont;
		return this.media;
	}
	
	public void adicionaAltura(float altura) {
		if(this.cont==0) {
			/* A primeira altura é ao mesmo tempo a menor e a maior
				Não existem outras alturas para comparar*/
			this.menor = altura;
			this.maior = altura;
			this.cont++;
		}
		else if(altura<this.menor) {
			this.menor = altura;
			this.cont++;
		}
		else if(altura>this.maior) {
			this.maior = altura;
			this.cont++;
		}
	}	
	
	public Alturas() {
		this.maior=this.menor=this.media=0f;
		this.cont=0;
	}
}
