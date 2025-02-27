package estrutura.linear.fila;

import estrutura.linear.Processo;

public class MainFila {
    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.inserir(new Processo("Processo 1"));
        fila.inserir(new Processo("Processo 2"));
        fila.inserir(new Processo("Processo 3"));

        System.out.println("\nFila após inserções:");
        fila.imprimir();

        fila.remover();
        System.out.println("\nFila após remover o primeiro processo:");
        fila.imprimir();
    }
}
