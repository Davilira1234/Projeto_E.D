package estrutura.linear.dicionario;

import java.util.LinkedList;

public class DicionarioDados {
    private static final int TAMANHO = 10;
    private LinkedList<Entrada>[] tabela;

    private static class Entrada {
        String chave;
        String valor;

        public Entrada(String chave, String valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    @SuppressWarnings("unchecked")
    public DicionarioDados() {
        tabela = new LinkedList[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new LinkedList<>();
        }
    }
    private int hash(String chave) {
        return Math.abs(chave.hashCode() % TAMANHO);
    }

    public void inserir(String chave, String valor) {
        int indice = hash(chave);
        for (Entrada entrada : tabela[indice]) {
            if (entrada.chave.equals(chave)) {
                entrada.valor = valor;
                return;
            }
        }
        tabela[indice].add(new Entrada(chave, valor));
    }

    public void remover(String chave) {
        int indice = hash(chave);
        tabela[indice].removeIf(entrada -> entrada.chave.equals(chave));
    }

    public String buscar(String chave) {
        int indice = hash(chave);
        for (Entrada entrada : tabela[indice]) {
            if (entrada.chave.equals(chave)) {
                return entrada.valor;
            }
        }
        return null;
    }

    public void imprimir() {
        System.out.println("Dicionário de Dados:");
        for (int i = 0; i < TAMANHO; i++) {
            if (!tabela[i].isEmpty()) {
                System.out.print("Índice " + i + ": ");
                for (Entrada entrada : tabela[i]) {
                    System.out.print("[" + entrada.chave + " -> " + entrada.valor + "] ");
                }
                System.out.println();
            }
        }
    }
}


