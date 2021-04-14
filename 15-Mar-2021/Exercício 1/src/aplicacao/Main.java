package aplicacao;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int flag = 0;

		while (flag == 0) {
			Pessoa p = obtemDados();
			resultado(p);
			flag = JOptionPane.showConfirmDialog(null, "Novo Cálculo?", "Confirmação", JOptionPane.YES_NO_OPTION);
			if (flag == JOptionPane.NO_OPTION) {
				flag = 1;
				break;
			}
		}

	}

	// Obtém os dados das Pessoas
	protected static Pessoa obtemDados() {
		// Obtém dados para criação de pessoa
		String nome = JOptionPane.showInputDialog("Informe o Nome:", "");
		double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso:"));
		double altura = Double.parseDouble(JOptionPane.showInputDialog("Informe a Altura:"));

		// Cria Instância de Pessoa
		Pessoa p = new Pessoa(nome, altura, peso);
		return p;
	}

	// Retorna o resultado de cada Pessoa Individualmente
	protected static void resultado(Pessoa p) {
		JOptionPane.showMessageDialog(null, p.getNome() + ", " + p.calcula());
	}

}
