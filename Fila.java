package estrutura.linear.fila;

import estrutura.linear.Processo;

public class Fila {
    private No frente;
    private No tras;

    private static class No {
        Processo processo;
        No proximo;

        public No(Processo processo) {
            this.processo = processo;
            this.proximo = null;
        }
    }

    public Fila() {
        this.frente = null;
        this.tras = null;
    }

    public void inserir(Processo processoNovo) {
        No novoNo = new No(processoNovo);

        if (vazia()) {
            frente = novoNo;
            tras = novoNo;
        } else {
            tras.proximo = novoNo;
            tras = novoNo;
        }
    }

    public Processo remover() {
        if (vazia()) {
            System.out.println("Fila vazia! Nada para remover.");
            return null;
        }

        Processo removido = frente.processo;
        frente = frente.proximo;

        if (frente == null) {
            tras = null;
        }

        return removido;
    }

    public boolean vazia() {
        return frente == null;
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }

        No atual = frente;
        System.out.print("Fila: ");
        while (atual != null) {
            System.out.print(atual.processo.getIdentificador() + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}
