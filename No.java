package estrutura.linear.lista;

import estrutura.linear.Processo;

class No {
    Processo processo;
    estrutura.linear.lista.No anterior;
    estrutura.linear.lista.No proximo;

    public No(Processo processo, estrutura.linear.lista.No anterior, estrutura.linear.lista.No proximo) {
        this.processo = processo;
        this.anterior = anterior;
        this.proximo = proximo;
    }
}