package aplicacao;

import java.util.Scanner;

public class Escolha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double a = 0;
		double b = 0;
		double resultado = 0;

		System.out.println("Informe o primeiro número: ");
		a = sc.nextDouble();
		System.out.println("Informe o segundo número: ");
		b = sc.nextDouble();

		System.out.println("\nPara os números informados, você deseja: ");
		menu();
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			resultado = (a + b);
			System.out.println("A soma é: " + resultado);
			break;
		case 2:
			resultado = (a - b);
			System.out.println("A subtração é: " + resultado);
			break;
		case 3:
			resultado = (a * b);
			System.out.println("A multiplicação é: " + resultado);
			break;
		case 4:
			if (b == 0) {
				System.out.println("Impossível dividir por zero");
				break;
			}
			resultado = (a / b);
			System.out.println("A divisão é: " + resultado);
			break;
		default:
			System.out.println("Opção Inválida!");
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
