package entidades;

public class ContaCorrente extends Conta{
	
	public ContaCorrente(Pessoa pessoa) {
		super(pessoa);
	}
	
	public String toString() {
		String informacoes = super.toString();
		
		informacoes += "\nTipo de conta: Corrente \n";
		
		return informacoes;
	}
	
	public void pagarMensalidade() {
		float mensalidade = 12;
		if(this.getSaldo() > mensalidade) {
			this.setSaldo(this.getSaldo() - mensalidade);
			System.out.println("Mensalidade paga com sucesso! ");
		} else {
			System.out.println("Erro! Saldo e menor que a mensalidade a ser paga.");
		}
	}
	
	public void renderSaldo() {
		float taxa = 0.12f;
		
		System.out.println("Rentabilidade da conta corrente: 12%");
		System.out.println("Saldo atual da conta: " + this.getSaldo());
		
		this.setSaldo(getSaldo()*taxa + getSaldo());
		
		System.out.println("Rentabilidade aplicada com sucesso!");
	}
}
