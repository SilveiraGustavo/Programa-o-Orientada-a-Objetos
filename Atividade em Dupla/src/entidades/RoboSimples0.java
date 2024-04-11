package entidades;

public class RoboSimples0 {
	public String nome;
	public  int posicaox;
	public int posicaoy;
	public String direcaorobo;
	 /////
	public RoboSimples0(String nome, int posicaox,int posicaoy, String direcaorobo) {
		this.nome = nome;
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.direcaorobo = direcaorobo;	
	}
	/////
	public RoboSimples0(String nome){
		this("Nome", 0,0,"Norte"); // Simplificação de codigo como "THIS"
	}
	/////
	public RoboSimples0() {
		this("Sem nome", 0,0,"Norte");
	}
	////
	public void  moverX() {
		if (direcaorobo == "Leste") {
			posicaox++;
		}else if (direcaorobo == "Oeste") {
			posicaox--;
		}	
	}
	////
	public void  moverY() {
		if (direcaorobo == "Norte") {
			posicaoy++;
		}else if (direcaorobo == "Sul") {
			posicaoy--;
		}
	}
	/////
	public void  moverX(int passos) {
		if (direcaorobo == "Leste") {
			posicaox = posicaox + passos;
		}else if (direcaorobo == "Sul") {
			posicaox = posicaox - passos;
		}
	}
	////
	public void moverY(int passos) {
		if (direcaorobo == " Norte") {
			posicaoy = posicaoy + passos;
		}else if (direcaorobo == "Sul") {
			posicaoy = posicaoy - passos;
		}		
	}
	////
	public  void mudardirecao(String direcaorobo) {
		this.direcaorobo = direcaorobo;
	}
	////
	public void mostrar() {
		System.out.println(" ----- ANTES DOS MOVIMENTOS -----");
		
		System.out.println("NOME DO ROBO:"+nome);
		System.out.println("POSICAO ATUAL DO ROBO: ("+posicaox+","+posicaoy+")");
		System.out.println("DIRECAO ATUAL DO ROBO:" +direcaorobo);
	}
	/////
	public String toString() {		 
		System.out.println(" ----- DEPOIS DOS MOVIMENTOS -----");
		String pos  = "Nome do Robo:"+ nome+ "\n";
		pos = pos + "Posicao do robo: ("+posicaox+","+posicaoy+") \n";
		pos = pos +"Direcao do robo:"+direcaorobo;
		return pos;
	}
}
