package aplicacao;

public class Comparador {
	private float a,b;

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}
	
	public float compara() {
		if(this.a>this.b) {
			return a;
		}
		else {
			return b;
		}
	}
	public Comparador(float a, float b) {
		this.setA(a);
		this.setB(b);
	}
}
