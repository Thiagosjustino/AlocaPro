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
	
    System.out.println("ALOCAPRO - FEATURE 1");

    System.out.print("1- Informe o nome do colaborador: ");

    colaborador.nome = scanner.nextLine(); 

    int horas = 0;
    boolean entradaValida = false;
    while (!entradaValida) {
        System.out.print("2- Horas diárias de trabalho (Exemplo: 8): ");
        if (scanner.hasNextInt()) {
            horas = scanner.nextInt();
            if (horas > 0 && horas <= 12) {
                colaborador.horasDiarias = horas; 
                entradaValida = true;
            } else {
                System.out.println("!Erro: Informa um número entre 1 e 12.");
            }
        } else {
            System.out.println("!Erro: Informe um número inteiro.");
            scanner.next(); 
        }
    }
    
    double custo = 0.0;
    entradaValida = false;
    scanner.nextLine(); 

    while (!entradaValida) {
        System.out.print("3- Custo por hora: R$");
        
        if (scanner.hasNextDouble()) { 
            custo = scanner.nextDouble();
            if (custo >= 0) {
                colaborador.custoHora = custo; 
                entradaValida = true;
            } else {
                System.out.println("!Erro: O custo deve ser um valor positivo.");
            }
        } else {
            System.out.println("!Erro: Informe um valor numérico (Exemplo: 150.50).");
            scanner.next(); 
        }
    }
    
    scanner.nextLine(); 

    System.out.print("4- O colaborador está em projeto crítico? (S/N): ");
    String criticoInput = scanner.nextLine().trim().toUpperCase();
    colaborador.projetoCritico = criticoInput.equals("S"); 
    
    scanner.close(); 
    
    System.out.println("\n>> Cadastramento de dados concluído para " + colaborador.nome + " <<");

    colaborador.exibirDadosCadastrados();

    colaborador.verificarDisponibilidadeSemanal();
    
	}

}

