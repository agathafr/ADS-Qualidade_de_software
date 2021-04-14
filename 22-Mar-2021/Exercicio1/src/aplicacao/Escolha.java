package aplicacao;

import java.util.Scanner;

public class Escolha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double a = 0;
		double b = 0;
		double resultado = 0;

		System.out.println("Informe o primeiro n�mero: ");
		a = sc.nextDouble();
		System.out.println("Informe o segundo n�mero: ");
		b = sc.nextDouble();

		System.out.println("\nPara os n�meros informados, voc� deseja: ");
		menu();
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			resultado = (a + b);
			System.out.println("A soma �: " + resultado);
			break;
		case 2:
			resultado = (a - b);
			System.out.println("A subtra��o �: " + resultado);
			break;
		case 3:
			resultado = (a * b);
			System.out.println("A multiplica��o �: " + resultado);
			break;
		case 4:
			if (b == 0) {
				System.out.println("Imposs�vel dividir por zero");
				break;
			}
			resultado = (a / b);
			System.out.println("A divis�o �: " + resultado);
			break;
		default:
			System.out.println("Op��o Inv�lida!");
			break;
		}
		sc.close();
		System.out.println("~~~ PROGRAMA - FINALIZADO ~~~");
	}

	public static void menu() {
		System.out.println("1 - Somar?");
		System.out.println("2 - Subtrair?");
		System.out.println("3 - Multiplicar?");
		System.out.println("4 - Dividir?");
	}

}
