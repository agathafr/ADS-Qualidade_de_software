package aplicacao;

import java.util.Scanner;

import entidades.Poligono;
import entidades.Quadrado;
import entidades.Retangulo;
import entidades.Trapezio;
import entidades.Triangulo;

public class Areas {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcaoMenu = 1;

		do {
			menu();
			opcaoMenu = scanner.nextInt();

			if (opcaoMenu < 1 || opcaoMenu > 5) {
				System.out.println("Op��o inv�lida!\n");
			}

			fabricaPoligono(opcaoMenu);

		} while (opcaoMenu != 5);

		finaliza();
		scanner.close();
	}

	private static void fabricaPoligono(int opcaoMenu) {
		switch (opcaoMenu) {
		case 1:
			calculaAreaPoligono(new Quadrado());
			break;
		case 2:
			calculaAreaPoligono(new Retangulo());
			break;
		case 3:
			calculaAreaPoligono(new Triangulo());
			break;
		case 4:
			calculaAreaPoligono(new Trapezio());
			break;
		}
	}

	private static void calculaAreaPoligono(Poligono forma) {
		System.out.println("---------------------------");
		System.out.println("A �rea do " + forma.getNome() + " �: " + String.format("%.2f", forma.area()));
		System.out.println("---------------------------");
	}

	private static void finaliza() {
		System.out.println("-----------------------");
		System.out.println("* PROGRAMA FINALIZADO *");
		System.out.println("-----------------------");
	}

	private static void menu() {
		String cabecalho = "Op��es\n" + "1-Calcular �rea do quadrado\n" + "2-Calcular �rea do ret�ngulo\n"
				+ "3-Calcular �rea do tri�ngulo\n" + "4-Calcular �rea do Trap�zio\n" + "5-Sair\n";
		System.out.println(cabecalho);
		System.out.println("Informe a op��o: ");
	}

}