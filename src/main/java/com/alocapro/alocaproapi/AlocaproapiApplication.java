package com.alocapro.alocaproapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alocaproapi.modelo.Colaborador;
import java.util.Scanner;

@SpringBootApplication
public class AlocaproapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlocaproapiApplication.class, args);
		
	Colaborador colaborador = new Colaborador();
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("\n==========================================");
    System.out.println("  ALOCAPRO - INTERAÇÃO COM CONSOLE (FEATURE 1)");
    System.out.println("==========================================");

    // Coleta String: Nome
    System.out.print("1. Digite o Nome do Colaborador: ");
    // Acesso DIRETO ao atributo: colaborador.nome = ...
    colaborador.nome = scanner.nextLine(); 

    // Coleta int: Horas Diárias (Com validação hasNextInt e while)
    int horas = 0;
    boolean entradaValida = false;
    while (!entradaValida) {
        System.out.print("2. Horas Diárias Padrão de Trabalho (ex: 8): ");
        if (scanner.hasNextInt()) {
            horas = scanner.nextInt();
            if (horas > 0 && horas <= 12) {
                // Acesso DIRETO ao atributo: colaborador.horasDiariasPadrao = ...
                colaborador.horasDiariasPadrao = horas; 
                entradaValida = true;
            } else {
                System.out.println("!ERRO: Horas inválidas. Digite um número entre 1 e 12.");
            }
        } else {
            System.out.println("!ERRO: Entrada inválida. Digite um número inteiro.");
            scanner.next(); 
        }
    }
    
    // Coleta double: Custo por Hora (Com validação hasNextDouble e while)
    double custo = 0.0;
    entradaValida = false;
    // Consome a quebra de linha pendente após nextInt
    scanner.nextLine(); 

    while (!entradaValida) {
        System.out.print("3. Custo por Hora (ex: 50.50): R$");
        
        if (scanner.hasNextDouble()) { 
            custo = scanner.nextDouble();
            if (custo >= 0) {
                // Acesso DIRETO ao atributo: colaborador.custoHora = ...
                colaborador.custoHora = custo; 
                entradaValida = true;
            } else {
                System.out.println("!ERRO: O custo deve ser um valor não negativo.");
            }
        } else {
            System.out.println("!ERRO: Entrada inválida. Por favor, digite um valor numérico (ex: 50.50).");
            scanner.next(); 
        }
    }
    
    // Consome a quebra de linha pendente após nextDouble
    scanner.nextLine(); 

    // Coleta boolean: Em Projeto Crítico
    System.out.print("4. O Colaborador está em Projeto Crítico? (S/N): ");
    String criticoInput = scanner.nextLine().trim().toUpperCase();
    // Acesso DIRETO ao atributo: colaborador.emProjetoCritico = ...
    colaborador.emProjetoCritico = criticoInput.equals("S"); 
    
    // Fecha o Scanner
    scanner.close(); 
    
    // Acesso DIRETO para exibir
    System.out.println("\n>>> Coleta de dados concluída para " + colaborador.nome + " <<<");

    // 5. Exibir Informações (Mostrando os dados coletados)
    colaborador.exibirDadosColetados();

    // 6. Invocar o método público (Que, por sua vez, chama o método privado)
    colaborador.verificarDisponibilidadeSemanal();
    
    System.out.println("\n*** FIM DA EXECUÇÃO DA FEATURE 1 ***");

	}

}
