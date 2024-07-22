import java.util.Scanner;

public class FilaEstatica {
    private Cliente[] item;
    private int inicio;
    private int fim;

    public FilaEstatica(int maxTam) {
        this.item = new Cliente[maxTam];
        this.inicio = 0;
        this.fim = this.inicio;
    }

    public void enfileira(Cliente x) throws Exception {
        if ((this.fim + 1) % this.item.length == this.inicio)
            throw new Exception("Erro: A fila está cheia");
        this.item[this.fim] = x;
        this.fim = (this.fim + 1) % this.item.length;
    }

    public Object desenfileira() throws Exception {
        if (this.vazia())
            throw new Exception("Erro: A fila está vazia");
        Object item = this.item[this.inicio];
        this.inicio = (this.inicio + 1) % this.item.length;
        return item;
    }

    public boolean vazia() {
        return (this.inicio == this.fim);
    }

    public void imprime() {
        if (!this.vazia()) {
            int i = inicio;
            while (i != fim) {
                System.out.print(item[i] + " ");
                i = (i + 1) % this.item.length;
                if (i >= this.item.length)
                    i = 0;
            }
            System.out.println();
        }
    }

    public Cliente buscarNome(FilaEstatica fila, String nome) throws Exception {
        FilaEstatica filaaux = new FilaEstatica(fila.item.length);
        Cliente cliente = new Cliente();
        Cliente clienteEncontrado = null;
        while (!fila.vazia()) {
            cliente = (Cliente) fila.desenfileira();
            if (nome.equals(cliente.getNome())) {
                filaaux.enfileira(cliente);
                clienteEncontrado = cliente;
            } else {
                filaaux.enfileira(cliente);
            }
        }
        while (!filaaux.vazia()) {
            Object elemento = filaaux.desenfileira();
            fila.enfileira((Cliente) elemento);
        }
        return clienteEncontrado;
    }

    public Cliente buscarCodigo(FilaEstatica fila, int codigo) throws Exception {
        FilaEstatica filaaux = new FilaEstatica(fila.item.length);
        Cliente cliente = new Cliente();
        Cliente clienteEncontrado = null;
        while (!fila.vazia()) {
            cliente = (Cliente) fila.desenfileira();
            if (codigo == cliente.getCodigo()) {
                filaaux.enfileira(cliente);
                clienteEncontrado = cliente;
            } else {
                filaaux.enfileira(cliente);
            }
        }
        while (!filaaux.vazia()) {
            Object elemento = filaaux.desenfileira();
            fila.enfileira((Cliente) elemento);
        }
        return clienteEncontrado;
    }

    public Cliente buscarCidade(FilaEstatica fila, String endereco) throws Exception {
        FilaEstatica filaaux = new FilaEstatica(fila.item.length);
        Cliente cliente = new Cliente();
        Cliente clienteEncontrado = null;
        while (!fila.vazia()) {
            cliente = (Cliente) fila.desenfileira();
            if (endereco.equals(cliente.getEndereco())) {
                filaaux.enfileira(cliente);
                clienteEncontrado = cliente;
            } else {
                filaaux.enfileira(cliente);
            }
        }
        while (!filaaux.vazia()) {
            Object elemento = filaaux.desenfileira();
            fila.enfileira((Cliente) elemento);
        }
        return clienteEncontrado;
    }

    public void remocao(FilaEstatica fila, int codigo) throws Exception {
        FilaEstatica filaaux = new FilaEstatica(fila.item.length);
        while (!fila.vazia()) {
            Cliente elemento = (Cliente) fila.desenfileira();
            if (!(elemento.getCodigo() == codigo)) {
                filaaux.enfileira(elemento);
            }
        }
        while (!filaaux.vazia()) {
            Cliente elemento = (Cliente) filaaux.desenfileira();
            fila.enfileira(elemento);
        }
    }

    public void insercao(FilaEstatica fila) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do cliente: ");
        String nome = sc.nextLine();
        System.out.println("Digite o codigo do cliente: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.println("Data de Nascimento: ");
        String dataNascimento = sc.nextLine();
        System.out.println("Endereço do Cliente: ");
        String endereco = sc.nextLine();
        Cliente cliente = new Cliente(nome, codigo, dataNascimento, endereco);
        fila.enfileira(cliente);
        sc.close();
    }

    public int tamanho(FilaEstatica fila) throws Exception {
        FilaEstatica filaaux = new FilaEstatica(fila.item.length);
        int tamanho = 0;
        while (!fila.vazia()) {
            Cliente elemento = (Cliente) fila.desenfileira();
            tamanho++;
            filaaux.enfileira(elemento);
        }

        while (!filaaux.vazia()) {
            Cliente elemento = (Cliente) filaaux.desenfileira();
            fila.enfileira(elemento);
        }

        return tamanho;
    }

}
