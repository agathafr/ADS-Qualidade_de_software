package entidades;

public class MotoFactory {
	private Moto moto;

	public Moto create(String tipo) {
		switch (tipo) {
		case "Honda":
			this.moto = new Honda();
			break;
		case "Yamaha":
			this.moto = new Yamaha();
			break;
		case "Suzuki":
			this.moto = new Suzuki();
			break;
		}
		return this.moto;
	}
}
