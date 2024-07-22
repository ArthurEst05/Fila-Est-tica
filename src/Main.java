//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        FilaEstatica fila = new FilaEstatica(10);
        Cliente cliente = new Cliente("Joao", 123, "21032005", "Centro");
        Cliente cliente1 = new Cliente("Ricardo", 321, "25092005", "Bv");
        Cliente cliente2 = new Cliente("Arthur", 432, "30122005", "St1");
        Cliente cliente3 = new Cliente("Savio", 569, "2102005", "St2");
        Cliente cliente4 = new Cliente("Rafael", 987, "2103200", "Vila");
        fila.enfileira(cliente);
        fila.enfileira(cliente1);
        fila.enfileira(cliente2);
        fila.enfileira(cliente3);
        fila.enfileira(cliente4);
        fila.imprime();
        System.out.println("-----------------------");

        System.out.println(fila.buscarNome(fila, "Arthur"));
        System.out.println(fila.buscarCodigo(fila, 123));
        System.out.println(fila.buscarCidade(fila, "Bv"));
        fila.insercao(fila);

        fila.remocao(fila, 321);

        System.out.println("Tamanho da fila : " + fila.tamanho(fila));

        fila.imprime(); // Imprime a fila após a remoção
    }

}