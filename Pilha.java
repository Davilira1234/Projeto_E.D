package estrutura.linear.pilha;

import estrutura.linear.Processo;

public class Pilha {
    private No topo;

    private static class No {
        Processo processo;
        No abaixo;

        public No(Processo processo, No abaixo) {
            this.processo = processo;
            this.abaixo = abaixo;
        }
    }

    public Pilha() {
        this.topo = null;
    }

    public void inserir(Processo processoNovo) {
        No novoNo = new No(processoNovo, topo);
        topo = novoNo;
    }
    public Processo remover() {
        if (vazia()) {
            System.out.println("Pilha vazia! Nada para remover.");
            return null;
        }

        Processo removido = topo.processo;
        topo = topo.abaixo;
        return removido;
    }

    public Processo topo() {
        if (vazia()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        return topo.processo;
    }

    public boolean vazia() {
        return topo == null;
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("Pilha vazia!");
            return;
        }

        No atual = topo;
        System.out.print("Pilha (topo -> base): ");
        while (atual != null) {
            System.out.print(atual.processo.getIdentificador() + " -> ");
            atual = atual.abaixo;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.inserir(new Processo("Processo 1"));
        pilha.inserir(new Processo("Processo 2"));
        pilha.inserir(new Processo("Processo 3"));

        System.out.println("\nPilha após inserções:");
        pilha.imprimir();

        pilha.remover();
        System.out.println("\nPilha após remover o topo:");
        pilha.imprimir();
    }
}
