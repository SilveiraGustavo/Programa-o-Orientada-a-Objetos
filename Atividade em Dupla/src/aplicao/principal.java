package aplicao;

import entidades.RoboSimples0;

public class principal {

	public static void main(String[] args) {
		RoboSimples0 robo1,robo2,robo3;
		
		robo1 = new RoboSimples0("Groucho", 20, 10, "Sul");
		robo2 = new RoboSimples0("Chico");
		robo3 = new RoboSimples0();
		
		robo1.moverY(10);
		robo2.mudardirecao("Leste");
		robo2.moverX(5);
		robo3.moverY();
		
		robo1.mostrar();
		robo2.mostrar();
		robo3.mostrar();
		

		System.out.println(robo1.toString());
		System.out.println(robo2.toString());
		System.out.println(robo3.toString());
	}

}
