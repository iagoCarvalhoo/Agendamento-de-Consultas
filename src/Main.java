import java.util.Scanner;

// Classe Principal
public class Main {

    // Método para limpar o concole
    public static void limparConsole() {
        for (int i = 0; i < 50; i++) System.out.println();
    }

    public static void main(String[] args) {
        // Declaro da classe SistemaAgendamento
        SistemaAgendamento sistema = new SistemaAgendamento();
        sistema.inicializarDados();

        // Declaração de variáveis
        Scanner scanner = new Scanner(System.in);
        int opcao, resposta;

        do {
            resposta = 0;

            // Exibir menu
            System.out.println("\n--- Sistema de Agendamento de Consultas ---");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Cancelar Consulta");
            System.out.println("5. Visualizar Histórico de Consultas por CPF");
            System.out.println("6. Visualizar médicos");
            System.out.println("7. Visualizar pacientes");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            limparConsole();

            // Cadastrar paciente
            if (opcao == 1) {
                while (resposta != 2){
                    System.out.print("Nome do Paciente: ");
                    String nomePaciente = scanner.nextLine();
                    System.out.print("E-mail do Paciente: ");
                    String emailPaciente = scanner.nextLine();
                    System.out.print("CPF do Paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    System.out.print("Idade do Paciente: ");
                    int idadePaciente = scanner.nextInt();
                    sistema.cadastrarPaciente(nomePaciente, emailPaciente, cpfPaciente, idadePaciente);

                    System.out.println("\nDeseja cadastrar outro Paciente?");
                    System.out.print("Digite 1 para continuar e 2 para sair: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            // Cadastrar médico
            else if (opcao == 2) {
                while (resposta != 2) {
                    System.out.print("Nome do Médico: ");
                    String nomeMedico = scanner.nextLine();
                    System.out.print("Especialidade do Médico: ");
                    String especialidadeMedico = scanner.nextLine();
                    System.out.print("CRM do médico: ");
                    String crmMedico = scanner.nextLine();
                    System.out.print("CPF do médico: ");
                    String cpfMedico = scanner.nextLine();
                    System.out.print("Idade do médico: ");
                    int idadeMedico = scanner.nextInt();
                    sistema.cadastrarMedico(nomeMedico, especialidadeMedico, crmMedico, cpfMedico, idadeMedico);

                    System.out.println("\nDeseja cadastrar outro Médico? s/n");
                    System.out.print("Digite 1 para continuar e 2 para sair: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            // Agendar consulta
            else if (opcao == 3) {
                while (resposta != 2) {
                    System.out.print("CPF do Paciente: ");
                    String cpfParaAgendamento = scanner.nextLine();
                    System.out.print("Nome do Médico: ");
                    String medicoParaAgendar = scanner.nextLine();
                    System.out.print("Data e Hora (ex: 2023-10-01 10:00): ");
                    String dataHoraAgendar = scanner.nextLine();
                    sistema.agendarConsulta(cpfParaAgendamento, medicoParaAgendar, dataHoraAgendar);

                    System.out.println("\nDeseja agendar outra consulta? s/n");
                    System.out.print("Digite 1 para agendar e 2 para sair: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            // Cancelar consulta
            else if (opcao == 4) {
                while (resposta != 2) {
                    System.out.print("CPF do Paciente: ");
                    String cpfParaCancelar = scanner.nextLine();
                    System.out.print("Data e Hora da Consulta: ");
                    String dataHoraCancelar = scanner.nextLine();
                    sistema.cancelarConsulta(cpfParaCancelar, dataHoraCancelar);

                    System.out.println("\nDeseja cancelar outra consulta? s/n");
                    System.out.print("Digite 1 para cancelar e 2 para sair: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            // Visualizar histórico de consultas
            else if (opcao == 5) {
                while (resposta != 2) {
                    System.out.print("CPF do Paciente: ");
                    String cpfParaHistorico = scanner.nextLine();
                    sistema.visualizarHistoricoConsultas(cpfParaHistorico);

                    System.out.println("\nDeseja ver o histórico de consultas novamente? s/n");
                    System.out.print("Digite 1 para ver e 2 para sair: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            // Listar médicos
            else if (opcao == 6) {
                while (resposta != 2) {
                    sistema.listarMedicos(sistema.medicos);

                    System.out.println("\nDeseja ver a lista de Médicos novamente? s/n");
                    System.out.print("Digite 1 para ver e 2 para sair: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            // Listar pacientes
            else if (opcao == 7) {
                while (resposta != 2) {
                    sistema.listarPacientes(sistema.pacientes);

                    System.out.println("\nDeseja ver a lista de Pacientes novamente? s/n");
                    System.out.print("Digite 1 para ver e 2 para sair: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            // Sair do sistema
            else if (opcao == 8) {
                System.out.println("Saindo do sistema...");
                scanner.close();
                System.exit(0);
            }
            // Erro caso não receba uma opção válida
            else {
                System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 8);
    }
}