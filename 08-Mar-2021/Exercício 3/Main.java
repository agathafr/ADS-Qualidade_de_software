package aplicacao;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Alturas alt = new Alturas();
		iterator(sc, alt);
	}

	private static void iterator(Scanner sc, Alturas alt) {
		boolean run = true;
		
		while(run == true) {
			System.out.println("Informe a Altura: ");
			float altura = sc.nextFloat();
			if(altura!=0) {
				alt.adicionaAltura(altura);
			}
			else {
				run = false;
				System.out.printf("\nMédia: %.2f \nMaior Altura: %.2f \nMenor Altura: %.2f \n",alt.getMedia(),alt.getMaior(),alt.getMenor());
				System.out.println("\n* * * FIM DO PROGRAMA * * *");
			}
		}
		sc.close();
	}

}
