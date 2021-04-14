package aplicacao;

import java.util.logging.Logger;

import javax.swing.JOptionPane;

import aplicacao.Atendimento.Atende;

public class Opcao1 extends OpcaoMenu {

    private static final String VALOR = "VALOR: ";
    private static final String MENSAGEM_DO_PROGRAMA = "MENSAGEM DO PROGRAMA";
    private static final String NOME_INPUT = "NOME: ";
    private static final String SOBRENOME = "SOBRENOME: ";
    public static final Logger LOGGER = Logger.getLogger(DashBoard.class.getName());

    private Atende inicio;
    private Atende fim;
    private Atende aux;
    private OpcaoMenu op;

    private int ID = 1;

    public Opcao1(OpcaoMenu op, Atende inicio, Atende fim, Atende aux) {
        this.op = op;
        this.inicio = inicio;
        this.fim = fim;
        this.aux = aux;
    }

    @Override
    public OpcaoMenu acao(int id) {

        if (id != this.ID) {
            return this.op;
        }

        int numero = 0;
        try {
            numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO CARTÃO: ", "0"));
        } catch (NumberFormatException e) {
            agenteDeErro(e);
        }
        aux = inicio;
        boolean achou = false;
        while (aux != null) {
            if (aux.cartao == numero) {
                achou = true;
                JOptionPane.showMessageDialog(null, "Esse número do cartão já foi usado.\nFavor verificar!");
                break;
            }
            aux = aux.prox;
        }
        if (!achou) {
            Atende novo = new Atende();
            novo.cartao = numero;

            try {
                recebeDadosUsuario(novo);
            } catch (NumberFormatException e) {
                agenteDeErro(e);
            }

            if (inicio == null) {
                inicio = novo;
                fim = novo;
            } else {
                fim.prox = novo;
                fim = novo;
            }

            JOptionPane.showMessageDialog(null, "O cartão número " + novo.cartao + ", foi inserido para atendimento: ",
                    MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
        }
        LOGGER.info("Acessou opção: Recepcionar cliente - " + getDateTime());
        return new OpcaoNula();
    }

    private static void recebeDadosUsuario(Atende novo) {
        novo.nome = JOptionPane.showInputDialog(NOME_INPUT, "");
        novo.sobreNome = JOptionPane.showInputDialog(SOBRENOME, "");

        novo.nome = novo.nome.toUpperCase();
        novo.sobreNome = novo.sobreNome.toUpperCase();

        novo.valor = Double.parseDouble(JOptionPane.showInputDialog(VALOR, "0"));
    }

}
