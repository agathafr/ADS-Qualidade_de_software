package aplicacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public abstract class OpcaoMenu {

    protected static final String NAO_HA_ATENDIMENTOS = "NÃO HÁ ATENDIMENTOS";
    protected static final String VALOR = "VALOR: ";
    protected static final String MENSAGEM_DO_PROGRAMA = "MENSAGEM DO PROGRAMA";
    protected static final String NOME_INPUT = "NOME: ";
    protected static final String NOME = "NOME\t";
    protected static final String SOBRENOME = "SOBRENOME: ";
    protected static final Logger LOGGER = Logger.getLogger(DashBoard.class.getName());

    public abstract OpcaoMenu acao(int id);

    protected static void agenteDeErro(NumberFormatException e) {
        JOptionPane.showMessageDialog(null,
                "ERRO AO TENTAR CONVERTER UM VALOR\nFAVOR VERIRIFICAR\nMENSAGEM ORIGINAL: " + e.getMessage(),
                "AGENTE DE ERRO", JOptionPane.CLOSED_OPTION);
    }

    protected static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
