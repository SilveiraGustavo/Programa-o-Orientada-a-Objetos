package entidades;

public class Conta {
	private int numConta;
	private Pessoa pessoa;
	private float saldo;
	
	private static int ContadorDeContas = 1;
	
	public Conta() {
		
	}
	
	public Conta(int numConta, Pessoa pessoa, float saldo) {
		this.numConta = ContadorDeContas;
		this.pessoa = pessoa;
		this.saldo = saldo;
		ContadorDeContas += 1;
	}
	
	public Conta(Pessoa pessoa) {
		this.pessoa = pessoa;
		this.numConta = ContadorDeContas;
		ContadorDeContas += 1;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nNumero da conta: " + this.getNumConta() +
				"\nNome: " + this.getPessoa().getNome() +
				"\nCPF: " + this.getPessoa().getCpf() +
				"\nEndereco" + "\nRua: " + this.getPessoa().getEndereco().getRua() +
				"\nNumero: " + this.getPessoa().getEndereco().getNumero() +
				"\nBairro: " + this.getPessoa().getEndereco().getBairro() +
				"\nSaldo: " + this.getSaldo() +
				"\n";
	}
	
	public void transferir(Conta ContaDeposito, float valor) {
		if((valor > 0) && (this.getSaldo() >= valor)) {
			setSaldo(getSaldo() - valor);
			
			ContaDeposito.setSaldo(ContaDeposito.getSaldo() + valor);
			System.out.println("Transferencia de R$" + valor + " da conta " + this.getNumConta() + " para a conta " + ContaDeposito.getNumConta() + " realizada com sucesso!");
		} else if(valor < 0) {
			System.out.println("Erro! Valor da transferencia nao pode ser negativo.");
		} else if(this.getSaldo() < valor) {
			System.out.println("Erro! Conta nao possui dinheiro suficiente para realizar transferencia.");
		}
	}
	
	public void depositar(float deposito) {
		if(deposito > 0) {
			this.setSaldo(this.getSaldo() + deposito);
			System.out.println("Deposito de R$" + deposito + " na conta " + this.getNumConta() + " realizado com sucesso!");
		} else if(deposito < 0) {
			System.out.println("Erro! Nao e possivel valor de deposito negativo.");
		} else if(deposito == 0) {
			System.out.println("Erro! Nao e possivel valor de deposito nulo.");
		}
	}
	
	public void sacar(float saque) {
	if(saque > 0) {
		if(this.getSaldo() > saque) {
			this.setSaldo(this.getSaldo() - saque);
			System.out.println("Saque de R$" + saque + " na conta " + this.getNumConta() + " realizado com sucesso!");
		} else if(this.getSaldo() < saque){
			System.out.println("Erro! O saque e maior que o saldo disponivel.");
		} else if (saque < 0) {
			System.out.println("Erro! O valor de saque nao pode ser negativo.");
		} else if(saque == 0) {
			System.out.println("Erro! Nao e possivel valor de saque nulo.");
		}
	}
	}
	
	public void pagarMensalidade() {
		
	}
	
	public void renderSaldo() {
		
	}
}
