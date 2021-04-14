package aplicacao;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		float[] notas = new float[4];

		inputDados(sc, notas);

		ApuracaoNotas apuracao = new ApuracaoNotas(notas[0], notas[1], notas[2], notas[3]);
		apuracao.status();
	}

	private static void inputDados(Scanner sc, float[] notas) {
		for (int i = 0; i < 4; i++) {
			System.out.println("Informe a nota " + (i + 1) + " (entre 0 e 10): ");
			notas[i] = sc.nextFloat();
			
			/*Barra entradas menores que 0 e maiores que 10*/
			if ((notas[i] < 0) || (notas[i] > 10)) {
				System.out.println("Valor inválido!");
				i = (i - 1);
			}
		}
		sc.close();
	}

}
