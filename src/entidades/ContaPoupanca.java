package entidades;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(Pessoa pessoa) {
		super(pessoa);
	}
	
	public String toString() {
		String informacoes = super.toString();
		
		informacoes += "\nTipo de Conta: Poupanca \n";
		
		return informacoes;
	}
	
	public void pagarMensalidade() {
		System.out.println("Conta do tipo poupanca e isenta de taxa de mensalidade.");
	}
	
	public void renderSaldo() {
		float taxa = 0.03f;
		
		System.out.println("Rentabilidade da conta poupanca: 3%");
		System.out.println("Saldo atual da conta: " + this.getSaldo());
		
		this.setSaldo(getSaldo()*taxa + getSaldo());
		
		System.out.println("Rentabilidade aplicada com sucesso!");
	}
}
