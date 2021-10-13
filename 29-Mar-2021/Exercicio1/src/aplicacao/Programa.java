package aplicacao;

import entidades.Moto;
import entidades.MotoFactory;
import javax.swing.JOptionPane;

public class Programa {

  public static void main(String[] args) {
    MotoFactory factory = new MotoFactory();
    while (true) {
      try {
        String nome = JOptionPane.showInputDialog(
          "Informe a marca [Cancelar] para sair: "
        );

        Moto moto = factory.create(nome);

        exibeDados(moto);
      } catch (Exception e) {
        break;
      }
    }
    System.out.println("\nPROGRAMA FINALIZADO!");
  }

  public static void exibeDados(Moto moto) {
    JOptionPane.showMessageDialog(
      null,
      "\nNome: " +
      moto.getNome() +
      "\nCilindrada: " +
      moto.getCilindrada() +
      "\nCor: " +
      moto.getCor(),
      "Dados da moto",
      JOptionPane.CLOSED_OPTION
    );
  }
}
