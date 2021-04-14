package aplicacao;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o primeiro número: ");
		float a = sc.nextFloat();
		System.out.print("Digite o segundo número: ");
		float b = sc.nextFloat();
		
		Comparador c = new Comparador(a,b);
		System.out.println("O maior número é: "+c.compara());
		sc.close();
	}

}
