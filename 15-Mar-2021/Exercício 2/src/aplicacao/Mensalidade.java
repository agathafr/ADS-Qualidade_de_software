package aplicacao;

import java.util.Calendar;
import java.util.Scanner;

public class Mensalidade {
	private static final int QUANTIDADE = 3;
	static Calendar calendario;
	static double mensalidade = 0;
	static double novaMensalidade = 0;
	static int mes = 0;
	static int mesAtual = 0;

	static public void main(String[] arguments) {
		Scanner sc = new Scanner(System.in);
		int contador = 1;
		while (contador <= QUANTIDADE) {
			// ENTRADA DE DADOS
			System.out.println("\nValor da mensalidade: ");
			mensalidade = sc.nextInt();
			System.out.println("\nMês de referência: ");
			mes = sc.nextInt();
			calendario = Calendar.getInstance();
			mesAtual = calendario.get(Calendar.MONTH) + 1;
			calculoMensalidade();
			imprimirResultado();
			contador++;
		}
		System.out.println("PROGRAMA FINALIZADO!");
		sc.close();
	}

	private static void imprimirResultado() {
		System.out.println("RESULTADO");
		System.out.println("Mês atual: " + mesAtual);
		System.out.println("Referência: " + mes);
		System.out.println("Mensalidade: " + mensalidade);
		System.out.println("Novo valor: " + novaMensalidade);
	}

	private static void calculoMensalidade() {
		if (mes < mesAtual) {
			double calculo = mensalidade * 1.10;
			novaMensalidade = calculo;
		} else if (mes >= mesAtual)
			novaMensalidade = mensalidade;
	}
}