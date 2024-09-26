import java.util.ArrayList;
import java.util.List;

// Classe Sistema de Agendamento
class SistemaAgendamento {

    // Declaração das variáveis do tipo List
    public List<Paciente> pacientes;
    public List<Medico> medicos;
    private List<Consulta> consultas;

    // Referenciar as listas da classe
    public SistemaAgendamento() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    // Método para cadastrar pacientes
    public void cadastrarPaciente(String nome, String email, String cpf, int idade) {
        pacientes.add(new Paciente(nome, email, cpf, idade));
        System.out.println("Paciente " + nome + " cadastrado com sucesso.");
    }

    // Método para cadastrar médicos
    public void cadastrarMedico(String nome, String especialidade, String crm, String cpf, int idade) {
        medicos.add(new Medico(nome, especialidade, crm, cpf, idade));
        System.out.println("Médico " + nome + " cadastrado com sucesso.");
    }

    // Método para agendar consutas
    public void agendarConsulta(String pacienteCpf, String medicoNome, String dataHora) {
        Paciente paciente = encontrarPacientePorCpf(pacienteCpf);
        Medico medico = encontrarMedico(medicoNome);

        if (paciente != null && medico != null) {
            Consulta novaConsulta = new Consulta(paciente, medico, dataHora);
            consultas.add(novaConsulta);
            paciente.adicionarConsulta(novaConsulta.detalhesConsulta());
            enviarEmail(paciente.getEmail(), "'Consulta agendada com Dr(a)." + medico.getNome() + " para " + dataHora + "'");
            System.out.println("Consulta agendada com sucesso.");
        } else {
            System.out.println("Paciente ou Médico não encontrado.");
        }
    }

    // Método para cancelar consulta
    public void cancelarConsulta(String pacienteCpf, String dataHora) {
        Consulta consultaParaCancelar = null;

        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getCpf().equals(pacienteCpf) && consulta.getDataHora().equals(dataHora)) {
                consultaParaCancelar = consulta;
                break;
            }
        }

        if (consultaParaCancelar != null) {
            consultas.remove(consultaParaCancelar);
            System.out.println("Consulta cancelada com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }

    }

    // Método para visualizar o histórico de consultas
    public void visualizarHistoricoConsultas(String pacienteCpf) {
        Paciente paciente = encontrarPacientePorCpf(pacienteCpf);
        if (paciente != null) {
            System.out.println("Histórico de consultas de " + paciente.getNome() + ": ");
            for (String consulta : paciente.getHistoricoConsultas()) {
                System.out.println(consulta);
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    // Método para encontar o paciente por meio do cpf
    private Paciente encontrarPacientePorCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    // Método para listar os médicos cadastrados
    public void listarMedicos(List<Medico> medicos) {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico encontrado.");
        } else {
            System.out.println("Medicos encontrados: ");
            for (Medico medico : medicos) {
                System.out.println("Nome: " + medico.getNome());
                System.out.println("Especialidade: " + medico.getEspecialidade());
                System.out.println("Crm: " + medico.getCrm());
                System.out.println("CPF: " + medico.getCpf());
                System.out.println("Idade: " + medico.getIdade());
            }
        }
    }

    // Método para listar os pacientes cadastrados
    public void listarPacientes(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente encontrado.");
        } else {
            System.out.println("Paceintes encontrados: ");
            for (Paciente paciente : pacientes) {
                System.out.println("Nome: " + paciente.getNome());
                System.out.println("Email: " + paciente.getEmail());
                System.out.println("CPF: " + paciente.getCpf());
                System.out.println("Idade: " + paciente.getIdade());
            }
        }
    }

    // Método para encontrar o médicos pelo nome
    private Medico encontrarMedico(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equals(nome)) {
                return medico;
            }
        }
        return null;
    }

    // Método para simular um envio de meio ao paciente
    private void enviarEmail(String email, String mensagem) {
        // Simulando envio de e-mail
        System.out.println("Enviando e-mail para " + email + ": " + mensagem);
    }

    // Método para inicializar as classes
    public void inicializarDados() {
        // Cadastro de médicos
        cadastrarMedico("Pedro", "Cardiologia", "1235469870", "07582102380", 34);
        cadastrarMedico("Ana", "Pediatria", "1354689623", "87456932100", 29);
        cadastrarMedico("José", "Dermatologia", "1354158749", "56932014580", 30);
        cadastrarMedico("Maria", "Neurologia", "2547896301", "01236584795", 38);
        cadastrarMedico("Lucas", "Ortopedia", "1587496320", "87456932101", 28);
        cadastrarMedico("Carla", "Oftalmologia", "4896320145", "58963214870", 40);

        // Cadastro de pacientes
        cadastrarPaciente("João Silva", "joao@email.com", "04587412320", 23);
        cadastrarPaciente("Maria Oliveira", "maria@email.com", "98563210144", 34);
        cadastrarPaciente("Carlos Santos", "carlos@email.com", "74589632015", 65);
        cadastrarPaciente("Ana Lima", "ana@email.com", "85236974100", 29);
        cadastrarPaciente("Lucas Ferreira", "lucas@email.com", "98745632101", 45);
        cadastrarPaciente("Camila Costa", "camila@email.com", "84961523047", 19);

        // Agendamento de consultas
        agendarConsulta("04587412320", "Pedro", "2023-10-01 10:00");
        agendarConsulta("98563210144", "Ana", "2023-10-02 11:00");
        agendarConsulta("74589632015", "José", "2023-10-03 09:00");
        agendarConsulta("85236974100", "Maria", "2023-10-04 14:00");
        agendarConsulta("98745632101", "Lucas", "2023-10-05 15:00");
        agendarConsulta("84961523047", "Carla", "2023-10-06 16:00");
    }

}
