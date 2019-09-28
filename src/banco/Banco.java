package banco;

import conta.Conta;
import sistema.Sistema;

public class Banco {
	public static int repeat = 0;
	public static boolean nextBreak = false;


	public static Conta contaLogada = new Conta();
	public static Sistema reg1 = new Sistema();


	public static void main(String[] args){


		reg1.bancoDeDados();
		new Menu2().setVisible(true);





		while(repeat == 0){


			contaLogada = contaLogada.titular.getContaLogada();

			if (nextBreak)
				break;



		}



	}
}
