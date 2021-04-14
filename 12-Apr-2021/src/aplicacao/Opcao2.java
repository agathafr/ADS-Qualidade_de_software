package aplicacao;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import aplicacao.Atendimento.Atende;

public class Opcao2 extends OpcaoMenu {

    private Atende inicio;
    private Atende aux;
    private Atende fim;
    private OpcaoMenu op;

    private int ID = 2;

    public Opcao2(OpcaoMenu op, Atende inicio, Atende fim, Atende aux) {
        this.op = op;
        this.inicio = inicio;
        this.aux = aux;
    }

    @Override
    public OpcaoMenu acao(int id) {
        if (id != this.ID) {
            return this.op;
        }

        consultarClientesASeremAtendidos(this.inicio, this.aux);
        LOGGER.info("Acessou opção: Consultar clientes a serem atendidos - " + getDateTime());
        return null;
    }

    private static void consultarClientesASeremAtendidos(Atende inicio, Atende aux) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, NAO_HA_ATENDIMENTOS, MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
        } else {
            JTextArea saida = new JTextArea(6, 45); // HEIGHT X WIDTH
            JScrollPane scroll = new JScrollPane(saida);
            saida.append("CARTÃO\t" + NOME + "SOBRENOME\t" + "VALOR\n");
            saida.append("-------------------------------------------------------------------------\n");
            aux = inicio;
            while (aux != null) {
                saida.append(aux.cartao + "\t" + aux.nome + "\t" + aux.sobreNome + "\t" + aux.valor + "\n");
                aux = aux.prox;
            }
            saida.append("\n");
            JOptionPane.showMessageDialog(null, scroll, "CONSULTAR DADOS DO ATENDIMENTO", JOptionPane.CLOSED_OPTION);
        }
    }

}
