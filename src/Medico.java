// Classe Medico
class Medico {

    // Declaração de variáveis
    private String nome;
    private String especialidade;
    private String crm;
    private String cpf;
    private int idade;

    // Referenciar as variáveis da classe atual
    public Medico(String nome, String especialidade, String crm, String cpf, int idade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }
}