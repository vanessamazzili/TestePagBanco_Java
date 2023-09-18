package IfandElse;

import java.util.Scanner;

public class programabanco {

	private static double saldo = 5000.0;
    private static double faturaCartao = 1500.0;
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in); 	
    	
    // Página inicial -  Solicitação de agência, conta e senha 	
    	System.out.println ("Bem vindo(a) ao Banco Code!");
    	System.out.print("Agência: ");
    	int agencia = scanner.nextInt();
    	
    	System.out.println ("Conta: ");
    	int conta = scanner.nextInt();
    	
    	System.out.println ("Senha: ");
    	int senha = scanner.nextInt();
    	
    // Validação dos dados informados e lógica para Menu Principal 	
    	if (autenticar(agencia,conta,senha)) {
    		exibirMenu();
    		int opcao = scanner.nextInt();
    		
    		switch (opcao) {
    		case 1: 
    			consultarSaldo();
    			break;
    		case 2:
    			consultarFatura();
    			break;
    		case 3:
    			pagarFatura();
    			break;
    		case 0:
    			System.out.println("Obrigada por usar nossos serviços!");
    			break;
    		default:
    			System.out.println("Opção inválida. Tente novamente");
    			break;
    		}
    	} else {
    		System.out.println("Agência, conta ou senha inválida. Tente novamente");
    				
    	}
    	scanner.close();
    }
    
    
    // Lógica para autenticação de dados no banco de dados  
    private static boolean autenticar(int agencia, int conta, int senha) {
    
    	return agencia == 1234 && conta == 5678 && senha == 123456;
    	
    }
    
    // Exibição do Menu Principal 
    private static void exibirMenu() {
        System.out.println("Menu Principal");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Consultar fatura do Cartão de Crédito");
        System.out.println("3. Pagar fatura do Cartão de Crédito");
        System.out.println("0. Sair");
        System.out.println("Digite a opção desejada: ");
    }

    // Consulta de Saldo 
    private static void consultarSaldo() {
        System.out.println("Seu saldo é: R$" + saldo);
        exibirMenu();
    }

    // Consulta de Fatura 
    private static void consultarFatura() {
        System.out.println("Fatura atual do cartão de crédito é: R$" + faturaCartao);
        exibirMenu();

    }

    // Pagar Fatura   
        
    private static void pagarFatura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione a opção de pagamento:");
        System.out.println("1. Utilizar saldo em conta corrente");
        System.out.println("2. Pagar por boleto");
        
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                if (saldo >= faturaCartao) {
                    saldo -= faturaCartao;
                    faturaCartao = 0.0;
                    System.out.println("Pagamento efetuado com sucesso usando saldo em conta corrente!");
                    
                } else {
                    System.out.println("Saldo insuficiente para pagar a fatura.");
                }
                break;
            case 2:
                System.out.println("O boleto será enviado no endereço de email cadastrado.");
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        scanner.close();	
    		
    	}

}