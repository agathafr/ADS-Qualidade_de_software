package aplicacao;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int flag = 0;

		while (flag == 0) {
			Pessoa p = obtemDados();
			resultado(p);
			flag = JOptionPane.showConfirmDialog(null, "Novo C�lculo?", "Confirma��o", JOptionPane.YES_NO_OPTION);
			if (flag == JOptionPane.NO_OPTION) {
				flag = 1;
				break;
			}
		}

	}

	// Obt�m os dados das Pessoas
	protected static Pessoa obtemDados() {
		// Obt�m dados para cria��o de pessoa
		String nome = JOptionPane.showInputDialog("Informe o Nome:", "");
		double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso:"));
		double altura = Double.parseDouble(JOptionPane.showInputDialog("Informe a Altura:"));

		// Cria Inst�ncia de Pessoa
		Pessoa p = new Pessoa(nome, altura, peso);
		return p;
	}

	// Retorna o resultado de cada Pessoa Individualmente
	protected static void resultado(Pessoa p) {
		JOptionPane.showMessageDialog(null, p.getNome() + ", " + p.calcula());
	}

}
