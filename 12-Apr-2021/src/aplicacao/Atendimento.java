package aplicacao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Atendimento {
    private static final String NAO_HA_ATENDIMENTOS = "NÃO HÁ ATENDIMENTOS";
    private static final String VALOR = "VALOR: ";
    private static final String MENSAGEM_DO_PROGRAMA = "MENSAGEM DO PROGRAMA";
    private static final String NOME_INPUT = "NOME: ";
    private static final String NOME = "NOME\t";
    private static final String SOBRENOME = "SOBRENOME: ";
    public static final Logger LOGGER = Logger.getLogger(DashBoard.class.getName());

    public static class Atende {
        public int cartao;
        public String nome;
        public String sobreNome;
        double valor;
        public Atende prox;
    }

    static Atende inicio = null;
    static Atende fim = null;
    static Atende aux;

    public static void main(String[] args) {

        int op = 0;
        do {
            try {

                op = menu();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "A tecla <<Cancelar>> foi acionada!\nEscolha a opção 6 para encerrar.", "Mensagem",
                        JOptionPane.CLOSED_OPTION);
                continue;
            }
            opcaoInvalida(op);
            if (op == 1) {
                int numero = 0;
                try {
                    numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO CARTÃO: ", "0"));
                } catch (NumberFormatException e) {
                    agenteDeErro(e);
                    continue;
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
                        continue;
                    }

                    if (inicio == null) {
                        inicio = novo;
                        fim = novo;
                    } else {
                        fim.prox = novo;
                        fim = novo;
                    }

                    JOptionPane.showMessageDialog(null,
                            "O cartão número " + novo.cartao + ", foi inserido para atendimento: ",
                            MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
                }
                LOGGER.info("Acessou opção: Recepcionar cliente - " + getDateTime());
            }
            if (op == 2) {

                consultarClientesASeremAtendidos();
                LOGGER.info("Acessou opção: Consultar clientes a serem atendidos - " + getDateTime());
            }
            if (op == 3) {
                atenderCliente();
                LOGGER.info("Acessou opção: Atender cliente - " + getDateTime());
            }
            if (op == 4) {
                liberarTodosOsClientes();
                LOGGER.info("Acessou opção: Liberar todos os clientes - " + getDateTime());
            }
            if (op == 5) {
                verificarQuantidadeDeClientesAAtender();
                LOGGER.info("Acessou opção: Verificar quantidade de clientes a atender - " + getDateTime());
            }
            if (op == 6) {
                localizarClientePorNumero();
                LOGGER.info("Acessou opção: Localizar cliente por número - " + getDateTime());

            }
            if (op == 7) {
                localizarClientePorNome();
                LOGGER.info("Acessou opção: Localizar cliente por nome - " + getDateTime());

            }
            if (op == 8) {
                emitirRelatorioDeClientes();
                LOGGER.info("Acessou opção: Emitir relatório de clientes - " + getDateTime());
            }
            if (op == 9) {
                verRelatorioDeClientes();
                LOGGER.info("Acessou opção: Ver relatório de clientes - " + getDateTime());
            }
            if (op == 10) {
                filtrarClientesPorValor();
                LOGGER.info("Acessou opção: Filtrar clientes por valor - " + getDateTime());
            }
            if (op == 11) {
                verEnderecosHash();
                LOGGER.info("Acessou opção: Ver endereços hash - " + getDateTime());

            }
            if (op == 12) {
                sobre();
                LOGGER.info("Acessou opção: Sobre - " + getDateTime());
            }
        } while (op != 13);
        sair();

    }

    private static void opcaoInvalida(int op) {
        if (op < 1 || op > 13) {
            LOGGER.warning("Opção Inválida!!");
        }
    }

    private static void recebeDadosUsuario(Atende novo) {
        novo.nome = JOptionPane.showInputDialog(NOME_INPUT, "");
        novo.sobreNome = JOptionPane.showInputDialog(SOBRENOME, "");

        novo.nome = novo.nome.toUpperCase();
        novo.sobreNome = novo.sobreNome.toUpperCase();

        novo.valor = Double.parseDouble(JOptionPane.showInputDialog(VALOR, "0"));
    }

    private static int menu() {
        int op;
        String texto = "\nMENU DE OPÇÕES\n" + "\n1  - Recepcionar cliente"
                + "\n2  - Consultar clientes a serem atendidos" + "\n3  - Atender cliente"
                + "\n4  - Liberar todos os clientes" + "\n5  - Verificar quantidade de clientes a atender"
                + "\n6  - Localizar cliente por número" + "\n7  - Localizar cliente por nome"
                + "\n8  - Emitir relatório de clientes" + "\n9  - Ver relatório de clientes"
                + "\n10 - Filtrar clientes por valor" + "\n11 - Ver endereços hash" + "\n12 - Sobre" + "\n13 - Sair\n";

        op = Integer.parseInt(JOptionPane.showInputDialog(texto, "1"));
        return op;
    }

    private static void sair() {
        LOGGER.info("Programa finalizado em: " + getDateTime());
        JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO!");
    }

    private static void sobre() {
        JTextArea saida = new JTextArea(8, 30); // HEIGHT X WIDTH
        saida.append("\n");
        saida.append("PROGRAMA DE ATENDIMENTO AO CLIENTE\n");
        saida.append("-------------------------------------------------------------\n");
        saida.append("Copyright (c) Byta Bug Informática Ltda\n");
        saida.append("Programadores: Asdrubal, Zemprônia e Gilmar\n");
        saida.append("Versão 1.0\n");
        saida.append("Data: Abril de 2021\n");
        saida.append("Necessita refatoração URGENTE!");
        saida.append("\n");
        JOptionPane.showMessageDialog(null, saida, "SOBRE O PROGRAMA", JOptionPane.CLOSED_OPTION);
    }

    private static void verEnderecosHash() {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, NAO_HA_ATENDIMENTOS, MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
        } else {
            JTextArea saida = new JTextArea(7, 45); // HEIGHT X WIDTH
            JScrollPane scroll = new JScrollPane(saida);
            saida.append(NOME + "ENDEREÇO\tPROX\t\n");
            saida.append("-------------------------------------------------------------\n");
            aux = inicio;
            while (aux != null) {
                if (aux.prox != null)
                    saida.append(aux.nome + "\t" + aux.hashCode() + "\t" + aux.prox.hashCode() + "\n");
                else
                    saida.append(aux.nome + "\t" + aux.hashCode() + "\tfim\n");

                aux = aux.prox;
            }
            saida.append("\n");
            JOptionPane.showMessageDialog(null, scroll, "CONSULTAR DADOS DO ATENDIMENTO", JOptionPane.CLOSED_OPTION);
        }
    }

    private static void filtrarClientesPorValor() {
        double filtro = Double
                .parseDouble(JOptionPane.showInputDialog("FILTRAR ATENDIMENTOS PARA VALORES SUPERIORES A: ", ""));
        JTextArea saida = new JTextArea(6, 45); // HEIGHT X WIDTH
        JScrollPane scroll = new JScrollPane(saida);
        saida.append("CARTÃO\t" + NOME + "SOBRENOME\t" + "VALOR\n");
        saida.append("----------------------------------------------------------------------------\n");
        aux = inicio;
        while (aux != null) {
            if (aux.valor > filtro) {
                saida.append(aux.cartao + "\t" + aux.nome + "\t" + aux.sobreNome + "\t" + aux.valor + "\n");
            }
            aux = aux.prox;
        }
        saida.append("\n");
        JOptionPane.showMessageDialog(null, scroll, "ATENDIMENTOS COM VALORES SUPERIORES A: " + filtro,
                JOptionPane.CLOSED_OPTION);
    }

    private static void verRelatorioDeClientes() {
        int resposta = JOptionPane.showConfirmDialog(null, "DESEJA VER ARQUIVO?", "MENSAGEM",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                Process pro = Runtime.getRuntime().exec("cmd.exe /c  c://Dados//Atendimento.txt");
                pro.waitFor();
            } catch (Exception e) {
                LOGGER.warning("Erro . . . ");
            }
        }
    }

    private static void emitirRelatorioDeClientes() {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, NAO_HA_ATENDIMENTOS, MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
        } else {
            aux = inicio;

            // Verifica se a pasta existe, se não existe, cria!
            File file = new File("C:/DADOS");
            if (!file.exists()) {
                file.mkdirs();
            }

            try {
                FileWriter arq = new FileWriter("c:\\Dados\\Atendimento.txt");
                PrintWriter gravar = new PrintWriter(arq);

                while (aux != null) {

                    gravar.printf("%d, %s, %s, %.2f %n", aux.cartao, aux.nome, aux.sobreNome, +aux.valor);
                    aux = aux.prox;
                }
                gravar.printf("%s %n", "--------------------------");
                gravar.printf("%s %n", "copyright (c) by: Fulano de Tal, Sicrano de Tal");
                arq.close();
            } catch (IOException e) {
                LOGGER.warning("MENSAGEM / CLASS ArquivoTexto:\nErro ao tentar gravar no arquivo");
            }

            JOptionPane.showMessageDialog(null, "ARQUIVO GRAVADO COM SUCESSO", "MENSAGEM DO SISTEMA",
                    JOptionPane.CLOSED_OPTION);
        }
    }

    private static void localizarClientePorNome() {
        String nome = JOptionPane.showInputDialog("Nome do cliente", "");
        aux = inicio;
        int posicao = 1;
        while (aux != null) {
            if (aux.nome.equals(nome)) {
                String texto = "CARTÃO: " + aux.cartao + "\n" + NOME_INPUT + aux.nome + "\n" + SOBRENOME + aux.sobreNome
                        + "\n" + VALOR + aux.valor + "\n" + "POSIÇÃO: " + posicao + "a. POSIÇÃO";
                JOptionPane.showMessageDialog(null, "DADOS DO CLIENTE: \n\n" + texto, MENSAGEM_DO_PROGRAMA,
                        JOptionPane.CLOSED_OPTION);
            }
            posicao++;
            aux = aux.prox;
        }
    }

    private static void localizarClientePorNumero() {
        int cartao = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do cartão", "0"));
        aux = inicio;
        int posicao = 1;
        while (aux != null) {
            if (cartao == aux.cartao) {
                String texto = "CARTÃO: " + aux.cartao + "\n" + NOME_INPUT + aux.nome + "\n" + SOBRENOME + aux.sobreNome
                        + "\n" + VALOR + aux.valor + "\n" + "POSIÇÃO: " + posicao + "a. POSIÇÃO";
                JOptionPane.showMessageDialog(null, "DADOS DO CLIENTE: \n\n" + texto, MENSAGEM_DO_PROGRAMA,
                        JOptionPane.CLOSED_OPTION);
            }
            posicao++;
            aux = aux.prox;
        }
    }

    private static void verificarQuantidadeDeClientesAAtender() {
        aux = inicio;
        int n = 0;
        double soma = 0;
        while (aux != null) {
            soma = soma + aux.valor;
            aux = aux.prox;
            n++;
        }
        JOptionPane.showMessageDialog(null, "O ATENDIMENTO CONTÉM: " + n + " ELEMENTOS.\nVALOR TOTAL: " + soma + "\n",
                MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
    }

    private static void liberarTodosOsClientes() {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, NAO_HA_ATENDIMENTOS, MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
        } else {
            inicio = null;
            JOptionPane.showMessageDialog(null, " * * O ATENDIMENTO FOI LIBERADO * *", MENSAGEM_DO_PROGRAMA,
                    JOptionPane.CLOSED_OPTION);
        }
    }

    private static void atenderCliente() {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, NAO_HA_ATENDIMENTOS, MENSAGEM_DO_PROGRAMA, JOptionPane.CLOSED_OPTION);
        } else {
            JOptionPane.showMessageDialog(null,
                    "CARTÃO:  " + inicio.cartao + ", NOME: " + inicio.nome + " foi atendido(a)!", MENSAGEM_DO_PROGRAMA,
                    JOptionPane.CLOSED_OPTION);
            inicio = inicio.prox;
        }
    }

    private static void consultarClientesASeremAtendidos() {
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

    private static void agenteDeErro(NumberFormatException e) {
        JOptionPane.showMessageDialog(null,
                "ERRO AO TENTAR CONVERTER UM VALOR\nFAVOR VERIRIFICAR\nMENSAGEM ORIGINAL: " + e.getMessage(),
                "AGENTE DE ERRO", JOptionPane.CLOSED_OPTION);
    }

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
