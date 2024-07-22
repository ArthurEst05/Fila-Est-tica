public class Cliente {
    private String nome;
    private int codigo;
    private String dataNascimento;
    private String endereco;

    public Cliente(String nome, int codigo, String dataNascimento, String endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Cliente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "----Cliente----" +
                "\nnome : " + nome + " |" +
                " codigo : " + codigo + " |" +
                " dataNascimento : " + dataNascimento + " |" +
                " endereco : " + endereco;
    }

}
