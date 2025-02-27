package estrutura.linear.lista;

import java.util.Comparator;
import java.util.Iterator;
import estrutura.linear.NoComUnicaLigacao;
import estrutura.linear.Processo;
public class ListaDePrioridade implements Iterable<Processo> {
    private NoComUnicaLigacao cabeca;

    public ListaDePrioridade() {
        this.cabeca = null;
    }

    public void inserir(Processo processo) {
        NoComUnicaLigacao novoNo = new NoComUnicaLigacao(processo);

        Comparator<Processo> comparator = new Comparator<Processo>() {
            @Override
            public int compare(Processo p1, Processo p2) {
                return Integer.compare(p1.getPrioridade(), p2.getPrioridade());
            }
        };

        if (cabeca == null || comparator.compare(processo, cabeca.processo) < 0) {
            novoNo.proximo = cabeca;
            cabeca = novoNo;
        } else {
            NoComUnicaLigacao atual = cabeca;
            while (atual.proximo != null && comparator.compare(processo, atual.proximo.processo) >= 0) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
        }
    }

    public void remover() {
        if (cabeca != null) {
            cabeca = cabeca.proximo;
        }
    }

    public void imprimir() {
        NoComUnicaLigacao atual = cabeca;
        while (atual != null) {
            System.out.println(atual.processo.getIdentificador() + " - Prioridade: " + atual.processo.getPrioridade());
            atual = atual.proximo;
        }
    }

    @Override
    public Iterator<Processo> iterator() {
        return new Iterator<Processo>() {
            private NoComUnicaLigacao atual = cabeca;

            @Override
            public boolean hasNext() {
                return atual != null;
            }

            @Override
            public Processo next() {
                if (!hasNext()) {
                    throw new IllegalStateException("Não há mais elementos.");
                }
                Processo processo = atual.processo;
                atual = atual.proximo;
                return processo;
            }
        };
    }
}
