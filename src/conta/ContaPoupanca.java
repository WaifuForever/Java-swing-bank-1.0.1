package conta;



public class ContaPoupanca extends Conta{
	
	private double numerosRendimentos = 0;
	private double limite = 5000;
	
	public ContaPoupanca() {
		super.nameClass = "Conta Poupanca";
		super.dataDeAbertura.setNowTime();
	}
	
	
	
	private void setRendimento() {
			
		while (this.dataDeAbertura.subtrairDataMeses() > numerosRendimentos) {
			this.saldo = this.saldo * 0.03;
			numerosRendimentos++;
		}
	}
	
	public void depositar (double saldo){
		super.depositar(saldo);
		setRendimento();

	}
	
	public double getSaldo(){
		setRendimento();
		return this.saldo;
	}
	
	public void sacar (double valor, Conta conta){
		super.sacar(valor);
		setRendimento();
	}

	
	
}
