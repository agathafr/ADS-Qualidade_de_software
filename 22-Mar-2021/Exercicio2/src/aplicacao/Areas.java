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
				System.out.println("Opção inválida!\n");
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
		System.out.println("A área do " + forma.getNome() + " é: " + String.format("%.2f", forma.area()));
		System.out.println("---------------------------");
	}

	private static void finaliza() {
		System.out.println("-----------------------");
		System.out.println("* PROGRAMA FINALIZADO *");
		System.out.println("-----------------------");
	}

	private static void menu() {
		String cabecalho = "Opções\n" + "1-Calcular área do quadrado\n" + "2-Calcular área do retângulo\n"
				+ "3-Calcular área do triângulo\n" + "4-Calcular área do Trapézio\n" + "5-Sair\n";
		System.out.println(cabecalho);
		System.out.println("Informe a opção: ");
	}

}