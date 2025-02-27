package estrutura.linear.lista;

import estrutura.linear.Processo;

public class MainListaDePrioridade {
    public static void main(String[] args) {
        ListaDePrioridade lista = new ListaDePrioridade();

        lista.inserir(new Processo("Processo 1", 3));
        lista.inserir(new Processo("Processo 2", 1));
        lista.inserir(new Processo("Processo 3", 2));
        lista.inserir(new Processo("Processo 4", 5));
        lista.inserir(new Processo("Processo 5", 4));

        System.out.println("Lista de Prioridade após inserções:");
        lista.imprimir();

        lista.remover();
        System.out.println("\nLista de Prioridade após remover o de maior prioridade:");
        lista.imprimir();
    }
}
