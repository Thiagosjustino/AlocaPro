package com.alocaproapi.modelo;

public class Colaborador {

	public String nome;
    public int horasDiariasPadrao;
    public double custoHora;
    public boolean emProjetoCritico;
	
    public Colaborador() {
    }
    
    public void verificarDisponibilidadeSemanal() {
        
        int horasDisponiveis = calcularPotencialSemanal();

        System.out.println("\n--- EXECUÇÃO DO MÉTODO PÚBLICO ---");
        System.out.println("Nome do Colaborador: " + this.nome);
        System.out.println("O Potencial de Horas Semanais Padrão é de: " + horasDisponiveis + "h.");
        
        if (this.emProjetoCritico) {
            System.out.println("AVISO: O colaborador está em projeto crítico. Alocação NÃO RECOMENDADA.");
        }
}
    
    private int calcularPotencialSemanal() {
        // Lógica: Horas diárias * 5 dias
        final int DIAS_UTEIS_SEMANA = 5;
        // Acessamos o atributo DIRETAMENTE (sem Getter)
        return this.horasDiariasPadrao * DIAS_UTEIS_SEMANA; 
    }
    
    public void exibirDadosColetados() {
        System.out.println("\n===== DADOS DO COLABORADOR CADASTRADO =====");
        System.out.println("Nome: " + this.nome);
        System.out.println("Horas Diárias Padrão: " + this.horasDiariasPadrao + "h");
        System.out.println("Custo por Hora: R$" + String.format("%.2f", this.custoHora));
        System.out.println("Em Projeto Crítico: " + (this.emProjetoCritico ? "Sim" : "Não"));
        System.out.println("===========================================");
    }
    
    
}
