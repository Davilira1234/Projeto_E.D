package estrutura.linear.lista;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ListaDuplamente<T> implements Iterable<T> {
    private No<T> cabeca;
    private No<T> cauda;
    private Comparator<T> comparator;

    public ListaDuplamente(Comparator<T> comparator) {
        this.cabeca = null;
        this.cauda = null;
        this.comparator = comparator;
    }
    class No<T> {
        T dado;
        No<T> anterior;
        No<T> proximo;

        public No(T dado) {
            this.dado = dado;
            this.anterior = null;
            this.proximo = null;
        }
    }

    public void inserir(T dado) {
        No<T> novoNo = new No<>(dado);

        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            No<T> atual = cabeca;
            while (atual != null && comparator.compare(dado, atual.dado) > 0) {
                atual = atual.proximo;
            }

            if (atual == null) {
                cauda.proximo = novoNo;
                novoNo.anterior = cauda;
                cauda = novoNo;
            } else if (atual == cabeca) {
                novoNo.proximo = cabeca;
                cabeca.anterior = novoNo;
                cabeca = novoNo;
            } else {
                novoNo.anterior = atual.anterior;
                novoNo.proximo = atual;
                atual.anterior.proximo = novoNo;
                atual.anterior = novoNo;
            }
        }
    }

    public void remover(T dado) {
        No<T> atual = cabeca;
        while (atual != null) {
            if (atual.dado.equals(dado)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    cabeca = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    cauda = atual.anterior;
                }
                return;
            }
            atual = atual.proximo;
        }
    }

    public void imprimirEstado() {
        No<T> atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " <-> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private No<T> atual = cabeca;

            @Override
            public boolean hasNext() {
                return atual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dado = atual.dado;
                atual = atual.proximo;
                return dado;
            }
        };
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compare;
        ListaDuplamente<Integer> lista = new ListaDuplamente<>(comparator);

        lista.inserir(5);
        lista.inserir(2);
        lista.inserir(8);
        lista.inserir(1);

        System.out.println("\nLista após inserções ordenadas:");
        lista.imprimirEstado();

        lista.remover(2);
        System.out.println("\nLista após remoção do 2:");
        lista.imprimirEstado();

        System.out.println("\nIterando pela lista:");
        for (Integer num : lista) {
            System.out.println(num);
        }
    }
}
