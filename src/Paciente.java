import java.util.ArrayList;
import java.util.List;

// Classe Paciente
class Paciente {

    // Declaração de variáveis
    private String nome;
    private String email;
    private String cpf;
    private int idade;
    private List<String> historicoConsultas;

    // Referenciar as variáveis da classe atual
    public Paciente(String nome, String email, String cpf, int idade) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
        this.historicoConsultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void adicionarConsulta(String consulta) {
        historicoConsultas.add(consulta);
    }

    public List<String> getHistoricoConsultas() {
        return historicoConsultas;
    }
}
