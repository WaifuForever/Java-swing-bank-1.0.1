package sistema;

import conta.Conta;

public class ContaGerente extends Conta implements Funcionario{

	public ContaGerente() {

		super.nameClass = "Conta Gerente";
		super.dataDeAbertura.setNowTime();

	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub

	}

}
