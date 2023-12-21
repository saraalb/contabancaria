package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	
	public static void main(String[] args) {
		
		int agencia, tipo, aniversario, numero = 0, numeroDestino;
		String titular;
		float saldo, limite, valor;
	
		ContaController contas = new ContaController();
		Scanner leia = new Scanner(System.in);
		int opcao=0;
		
			while(true) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "*****************************************************" + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND + "                                                     " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE +"             ◣  BANCO DO BRAZIL COM Z  ◥             " +Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND + "                                                     " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "*****************************************************" + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "                                                     " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "             1 - Criar Conta                         " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "             2 - Listar todas as Contas              " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "             3 - Buscar Conta por Numero             " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "             4 - Atualizar Dados da Conta            " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "             5 - Apagar Conta                        " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "             6 - Sacar                               " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "             7 - Depositar                           " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "             8 - Transferir valores entre Contas     " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "             9 - Sair                                " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW +  "                                                     " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "*****************************************************" + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_WHITE + "Entre com a opção desejada:                          " + Cores.RESET);
	        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_YELLOW + "                                                     " + Cores.RESET);
	        
	        
	            System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "*****************************************************" + Cores.RESET);
	        try {
	        	opcao = leia.nextInt();
	        } catch (InputMismatchException e) {
	        	System.out.println("Digite valores inteiros!");
	        	leia.nextLine();
	        	opcao = 0;
	        }
	        
	        

	       
			switch(opcao) {
	        case 1: 
	        	System.out.println(Cores.TEXT_YELLOW +"Criar Conta"+Cores.RESET);
	        	System.out.println("Digite o número da agência: ");
	        	agencia = leia.nextInt();
	        	System.out.println("Digite o nome do titular:");
	        	leia.skip("\\R?");
	        	titular = leia.nextLine();
	        	
	        	do {
	        		System.out.println("Digite o tipo de conta (1-CC ou 2-CP): ");
	        		tipo = leia.nextInt();
	        	}while(tipo <1 && tipo > 2);
	        	
	        	System.out.println("Digite o saldo da conta (R$): ");
	        	saldo = leia.nextFloat();
	        
	        	switch(tipo) {
	        	case 1 -> {
	        		System.out.println("Digite o limite de crédito (R$): ");
	        		limite = leia.nextFloat();
	        		contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
	        	}
	        	case 2 -> {
	        		System.out.println("Digite o dia do aniversario da conta: ");
	        		aniversario = leia.nextInt();
	        		contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
	        	}
	      
	        	}
	        	KeyPress();
	        	break;
	        case 2:
	        	System.out.println(Cores.TEXT_YELLOW +"Listar todas as contas:"+Cores.RESET);
	        	contas.listarTodas();
	        	KeyPress();
	        	break;
	        case 3:
	        	System.out.println(Cores.TEXT_YELLOW +"Consultar dados da Conta - por número\n\n");
	        	
	        	System.out.println("Digite o número da conta: ");
	        	numero = leia.nextInt();
	        	
	        	contas.procurarPorNumero(numero);
	        	
	        	KeyPress();
	        	break;
	        case 4:
	        	System.out.println(Cores.TEXT_YELLOW +"Atualizar dados da conta\n\n"+Cores.RESET);
	        	
	        	System.out.println("Digite o número da conta: ");
	        	numero = leia.nextInt();
	        	
	        	var buscaConta = contas.buscarNaCollection(numero);
	        	
	        	if(buscaConta != null) {
	        		tipo = buscaConta.getTipo();
	        		
	        		System.out.println("Digite o numero da agencia: ");
	        		agencia = leia.nextInt();
	        		System.out.println("Digite o nome do titular: ");
	        		leia.skip("\\R?");
	        		titular = leia.nextLine();
	        		
	        		System.out.println("Digite o saldo da conta (R$): ");
	        		saldo = leia.nextFloat();
	        		
	        		switch(tipo) {
	        			case 1 -> {
	        				System.out.println("Digite o limite de crédito (R$): ");
	        				limite = leia.nextFloat();
	        				
	        				contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
	        			}
	        			case 2 -> {
	        				System.out.println("Digite o dia do aniversario da conta:");
	        				aniversario = leia.nextInt();
	        				
	        				contas.atualizar(new ContaPoupanca(numero,agencia,tipo,titular,saldo,aniversario));
	        			}
	        			default -> {
	        				System.out.println("Tipo de conta inválido!");
	        			}
	        		}
	        	} else {
	        		System.out.println("A conta não foi encontrada!");
	        	}
	        	
	        	KeyPress();
	        	break;
	        case 5:
	        	System.out.println(Cores.TEXT_YELLOW +"Apagar a conta\n\n"+Cores.RESET);
	        	
	        	System.out.println("Digite o número da conta:");
	        	numero = leia.nextInt();
	        	
	        	contas.deletar(numero);
	        	
	        	KeyPress();
	        	break;
	        	
	        case 6:
	        	System.out.println(Cores.TEXT_YELLOW +"Saque\n\n"+Cores.RESET);
	        	
	        	System.out.println("Digite o número da conta:");
	        	numero = leia.nextInt();
	        	do {
	        		System.out.println("Digite o valor do saque (R$): ");
	        		valor = leia.nextFloat();
	        	}while(valor<=0);
	        	
	        	contas.sacar(numero, valor);
	        	
	        	KeyPress();
	        	break;
	        case 7:
	        	System.out.println(Cores.TEXT_YELLOW +"Depósito\n\n"+Cores.RESET);
	        	
	        	System.out.println("Digite o número da conta:");
	        	numero = leia.nextInt();
	        	
	        	do {
	        		System.out.println("Digite o valor do depósito (R$):");
	        		valor = leia.nextFloat();
	        	} while(valor<=0);
	        	
	        	contas.depositar(numero, valor);
	        	
	        	KeyPress();
	        	break;
	        case 8:
	        	System.out.println(Cores.TEXT_YELLOW +"Transferência entre contas\n\n"+Cores.RESET);
	        	
	        	System.out.println("Digite o número da conta de origem:");
	        	numero = leia.nextInt();
	        	System.out.println("Digite o número da conta de destino:");
	        	numeroDestino = leia.nextInt();
	        	
	        	do {
	        		System.out.println("Digite o valor da transferência (R$):");
	        		valor = leia.nextFloat();
	        	}while(valor <= 0);
	        	
	        	contas.transferir(numero, numeroDestino, valor);
	        	
	        	KeyPress();
	        	break;
	        case 9:
	        	System.out.println(Cores.TEXT_YELLOW +"Obrigado!"+Cores.RESET);
	        	leia.close(); 
	        	System.exit(0);
	        	break;
	        default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }

			}
	        
	}
	
	public static void KeyPress() {
		try {
			System.out.println("Pressione Enter para continuar..");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Voce pressionou uma tecla diferente de enter!");
		}
	}
}
