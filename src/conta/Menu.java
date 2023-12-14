package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.util.Cores;

public class Menu {
	
	public static void main(String[] args) {
		Conta c1 = new Conta(1234,5678,1,"Sara", 99999.9f, true);
		
		c1.visualizar();

			System.out.println(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLUE + "*****************************************************" + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLUE + "                                                     " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLUE_BOLD + "                BANCO DO BRAZIL COM Z                " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLUE + "                                                     " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLUE + "*****************************************************" + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLUE + "                                                     " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLACK_BOLD + "            1 - Criar Conta                          " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "            2 - Listar todas as Contas               " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "            3 - Buscar Conta por Numero              " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "            4 - Atualizar Dados da Conta             " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "            5 - Apagar Conta                         " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "            6 - Sacar                                " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "            7 - Depositar                            " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "            8 - Transferir valores entre Contas      " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "            9 - Sair                                 " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLUE + "                                                     " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLUE + "*****************************************************" + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLACK_BOLD + "Entre com a opção desejada:                          " + Cores.RESET);
	        System.out.println(Cores.ANSI_YELLOW_BACKGROUND +Cores.TEXT_BLUE + "                                                     " + Cores.RESET);

	}
}
