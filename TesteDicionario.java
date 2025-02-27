package estrutura.linear.dicionario;

public class TesteDicionario {
    public static void main(String[] args) {
        DicionarioDados dicionario = new DicionarioDados();

        dicionario.inserir("Nome", "Carlos");
        dicionario.inserir("Idade", "25");
        dicionario.inserir("Cidade", "São Paulo");

        System.out.println("\nDicionário após inserções:");
        dicionario.imprimir();

        System.out.println("\nBuscando 'Nome': " + dicionario.buscar("Nome"));

        dicionario.remover("Idade");
        System.out.println("\nDicionário após remover 'Idade':");
        dicionario.imprimir();
    }
}
