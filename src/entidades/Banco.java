package entidades;

import java.util.Scanner;
import java.util.ArrayList;

public class Banco {
	static ArrayList<Conta> ContasBancarias = new ArrayList<>();
	static Scanner input = new Scanner(System.in);
	
	public static void operacoes() {
		System.out.println("===========================================");
		System.out.println("======= Bem-vindo a agencia Olimpia =======");
		System.out.println("===========================================");
		System.out.println("Selecione uma operacao que deseja realizar: ");
		System.out.println("===========================================");
		System.out.println("[1] Criar conta");
		System.out.println("[2] Apagar conta");
		System.out.println("[3] Listar");
		System.out.println("[4] Transferir");
		System.out.println("[5] Depositar");
		System.out.println("[6] Sacar");
		System.out.println("[7] Pagar mensalidade");
		System.out.println("[8] Aplicar rendimento");
		System.out.println("[9] Sair");
		
		int opcao = input.nextInt();
		
		switch(opcao) {
		case 1:
			abrirConta();
			break;
		case 2:
			apagarConta();
			break;
		case 3:
			listar();
			break;
		case 4:
			transferir();
		case 5:
			depositar();
		case 6:
			sacar();
		case 7:
			pagarMensalidade();
		case 8:
			renderSaldo();
		case 9:
			System.out.println("Saindo.....");
			System.out.println("Agradecemos a preferencia :)");
			System.exit(0);
		
		default:
			System.out.println("Opcao invalida!");
			operacoes();
			break;
		}
	}
	
	public static void abrirConta() {
		System.out.println("========== Abrindo conta ==========");
		System.out.println("\nNome: ");
		input.nextLine();
		String nome = input.nextLine();
		
		System.out.println("\nInserindo endereco... ");
		System.out.println("Rua: ");
		String rua = input.nextLine();
		
		System.out.println("Numero: ");
		int numero = input.nextInt();
		
		System.out.println("Bairro: ");
		input.nextLine();
		String bairro = input.nextLine();
		
		System.out.println("CPF: ");
		String cpf = input.next();
		
		System.out.println("RG: ");
		String rg = input.next();
		
		System.out.println("Numero de celular: ");
		String numero_celular = input.next();
		
		Endereco endereco = new Endereco(rua, numero, bairro);
		
		Pessoa pessoa = new Pessoa(nome, endereco, cpf, rg, numero_celular);
		
		System.out.println("Qual sera o tipo de conta?");
		System.out.println("(Digite C para Corrente ou P para Poupanca)");
		String tipo = input.next();
		
		if(tipo.equals("C") || tipo.equals("c")){
			ContaCorrente contac = new ContaCorrente(pessoa);
			
			ContasBancarias.add(contac);
			
			System.out.println("Sua conta foi criada com sucesso!");
			System.out.println(contac.toString());
			operacoes();
		} else if (tipo.equals("P") || tipo.equals("p")) {
			ContaPoupanca contap = new ContaPoupanca(pessoa);
			
			ContasBancarias.add(contap);
			
			System.out.println("Sua conta foi criada com sucesso!");
			System.out.println(contap.toString());
			operacoes();
		} else {
			System.out.println("Erro! Insira uma resposta valida.");
			abrirConta();
		}
		
	}
	
	public static void apagarConta() {
		if(ContasBancarias.size() > 0) {
			System.out.println("Numero da conta a ser removida: ");
			int numConta = input.nextInt();
			
			ContasBancarias.remove(numConta - 1);
			
			System.out.println("Conta " + numConta + " removida com sucesso! ");
		} else {
			System.out.println("Nao ha nenhuma conta cadastrada.");
		}
		operacoes();
	}
	
	public static void listar() {
		if(ContasBancarias.size() > 0) {
			for(Conta conta: ContasBancarias) {
				System.out.println(conta);
			} 
		} else {
				System.out.println("Nao ha contas cadastradas");
		}
		operacoes();
	}
	
	public static Conta encontrarConta(int numConta) {
		Conta conta = null;
		
		if(ContasBancarias.size() > 0) {
			for(Conta c: ContasBancarias) {
				if(c.getNumConta() == numConta) {
					conta = c;
				}
			}
		}
		
		return conta;
	}
	
	public static void transferir() {
		System.out.println("Numero da conta do remetente: ");
		int numContaRemetente = input.nextInt();
		
		Conta contaRemetente = encontrarConta(numContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Numero da conta do destinatario: ");
			int numContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Valor da transferencia: ");
				float valor = input.nextFloat();
				
				contaRemetente.transferir(contaDestinatario, valor);
				operacoes();
			} else {
				System.out.println("Conta destinataria nao encontrada! Insira uma conta valida.");
				transferir();
			}	
		} else {
			System.out.println("Conta remetente nao encontrada! Insira uma conta valida.");
			transferir();
		}
	}
	
	public static void depositar() {
		System.out.println("Numero da conta: ");
		int numConta = input.nextInt();
		
		Conta conta = encontrarConta(numConta);
		
		if(conta != null) {
			System.out.println("Insira o valor a ser depositado: ");
			float valorDeposito = input.nextFloat();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!");
			operacoes();
		} else {
			System.out.println("Conta nao encontrada! Insira um numero de conta valido.");
			depositar();
		}
	}
	
	public static void sacar() {
		System.out.println("Numero da conta: ");
		int numConta = input.nextInt();
		
		Conta conta = encontrarConta(numConta);
		
		if(conta != null) {
			System.out.println("Insira o valor a ser sacado: ");
			float valorSacado = input.nextFloat();
			conta.sacar(valorSacado);
			System.out.println("Valor sacado com sucesso!");
			operacoes();
		} else {
			System.out.println("Conta nao encontrada! Insira um numero de conta valido.");
			sacar();
		}
	}
	
	public static void pagarMensalidade() {
		System.out.println("Numero da conta: ");
		int numConta = input.nextInt();
		
		Conta conta = encontrarConta(numConta);
		
		if(conta != null) {
			conta.pagarMensalidade();
			operacoes();
		} else {
			System.out.println("Conta nao encontrada! Insira um numero de conta valido.");
			pagarMensalidade();
		}
	}
	
	public static void renderSaldo() {
		System.out.println("Numero da conta: ");
		int numConta = input.nextInt();
		
		Conta conta= encontrarConta(numConta);
		
		if(conta != null) {
			conta.renderSaldo();
			operacoes();
		} else {
			System.out.println("Conta nao encontrada! Insira um numero de conta valido.");
			renderSaldo();
		}
	}
}

