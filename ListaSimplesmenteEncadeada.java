package estrutura.linear.lista;

import java.util.Comparator;
import java.util.Iterator;

public class ListaSimplesmenteEncadeada {

    private Node cabeca;
    private class Node {
        int valor;
        Node proximo;

        public Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public void inserir(int valor) {
        Node novoNode = new Node(valor);
        if (cabeca == null) {
            cabeca = novoNode;
        } else {
            Node atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNode;
        }
    }

    public void remover(int valor) {
        if (cabeca == null) return;

        if (cabeca.valor == valor) {
            cabeca = cabeca.proximo;
            return;
        }

        Node atual = cabeca;
        while (atual.proximo != null && atual.proximo.valor != valor) {
            atual = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo = atual.proximo.proximo;
        }
    }


    public void imprimirEstado() {
        if (cabeca == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Node atual = cabeca;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public void ordenar(Comparator<Integer> comparator) {
        if (cabeca == null || cabeca.proximo == null) return;

        boolean trocou;
        do {
            trocou = false;
            Node atual = cabeca;
            while (atual.proximo != null) {
                if (comparator.compare(atual.valor, atual.proximo.valor) > 0) {
                    int temp = atual.valor;
                    atual.valor = atual.proximo.valor;
                    atual.proximo.valor = temp;
                    trocou = true;
                }
                atual = atual.proximo;
            }
        } while (trocou);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node atual = cabeca;

            @Override
            public boolean hasNext() {
                return atual != null;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new IllegalStateException("Não há mais elementos.");
                int valor = atual.valor;
                atual = atual.proximo;
                return valor;
            }
        };
    }

    public static void main(String[] args) {
        ListaSimplesmenteEncadeada lista = new ListaSimplesmenteEncadeada();

        lista.inserir(10);
        lista.inserir(30);
        lista.inserir(20);

        System.out.println("Antes da ordenação:");
        lista.imprimirEstado();

        lista.ordenar(Integer::compare);

        System.out.println("Após ordenação:");
        lista.imprimirEstado();

        lista.remover(20);
        System.out.println("Após remoção de 20:");
        lista.imprimirEstado();

        System.out.println("Percorrendo a lista com o Iterator:");
        Iterator<Integer> iterator = lista.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
