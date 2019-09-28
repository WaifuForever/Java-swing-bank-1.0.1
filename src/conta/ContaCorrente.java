package conta;

public class ContaCorrente extends Conta{
	
	public ContaCorrente() {
		super.nameClass = "Conta Corrente";
		super.dataDeAbertura.setNowTime();
	}
	
	private double taxaDeOperacao;
	
	private void setTaxaDeOperacao(Conta cc) {
		taxaDeOperacao = cc.saldo / 1000;
	}
	
	public void sacar (double valor, Conta conta){
		setTaxaDeOperacao (conta);
        if (podeSacar(valor)) {
        	
            saldo -= valor + taxaDeOperacao;
            System.out.println("Novo Saldo: ");
            System.out.print(conta.getSaldo());
            System.out.println("");
            
        }    
        else 
            System.out.println("Saldo indisponivel");
            
    }
}
