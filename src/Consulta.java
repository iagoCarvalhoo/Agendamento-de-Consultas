// Classe Consulta
class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String dataHora;

    public Consulta(Paciente paciente, Medico medico, String dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String detalhesConsulta() {
        return "Data e Hora da Consulta: " + dataHora + "\n" + "Médico: " + medico.getNome() + " (" + medico.getEspecialidade() + ")";
    }
}
