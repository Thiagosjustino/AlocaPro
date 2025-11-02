package com.alocaproapi.modelo;

public class Colaborador {

	public String nome;
    public int horasDiarias;
    public double custoHora;
    public boolean projetoCritico;
	
    public Colaborador() {
    }
    
    public void verificarDisponibilidadeSemanal() {
        
        int horasDisponiveis = calcularPotencialSemanal();

        System.out.println("Nome do colaborador: " + this.nome);
        System.out.println("Potencial de horas semanais: " + horasDisponiveis + "h.");
        
        if (this.projetoCritico) {
            System.out.println("Alerta: Colaborador está associado a projetos críticos. Alocação não recomendada.");
        }
}
    
    private int calcularPotencialSemanal() {
        final int DIAS_UTEIS_SEMANA = 5;
        return this.horasDiarias * DIAS_UTEIS_SEMANA; 
    }
    
    public void exibirDadosCadastrados() {
        System.out.println("\n== DADOS DO COLABORADOR CADASTRADO ==");
        System.out.println("Nome: " + this.nome);
        System.out.println("Horas Diárias: " + this.horasDiarias + "h");
        System.out.println("Custo por Hora: R$" + String.format("%.2f", this.custoHora));
        System.out.println("Em Projeto Crítico: " + (this.projetoCritico ? "Sim" : "Não"));
    }
    
    
}
