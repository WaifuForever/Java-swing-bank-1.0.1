package conta;

import javax.swing.JOptionPane;

import banco.Banco;
import banco.Cliente;
import banco.Time;

public class Conta {
	public int numero;
	protected double saldo;
	protected double limite;
	public String extrato[] = new String [100];
	public Cliente titular = new Cliente();
	public Time dataDeAbertura = new Time();
	protected String nameClass;
	
	
	public String getNameClass() {
		return nameClass;
	}

	public void depositar (double saldo){
		this.saldo += saldo;
		if (limite < saldo)
			saldo = limite;

	}


	//metodos get	
	public double getSaldo(){
		return saldo;
	}

	public void getExtrato () {
		for (int i = 0; i < extrato.length; i++) {
			if (extrato[i] == null){
				break;
			}
			else
				System.out.println(extrato[i]);
		}
	}
	
	public String[] getExtrato2 () {
		return extrato;
	}
	

	//metodos set	
	public void setExtrato(String nome, String atividade, double valor) {
		String extrato = "Horario " + dataDeAbertura.horaNow() + " Data " + dataDeAbertura.dataNow() + " " + nome + " " + atividade + " " + Double.toString(valor);
		for (int i = 0; i < this.extrato.length; i++) {
			if (this.extrato[i] == null) {

				this.extrato[i] = extrato;
				break;
			}

		}
	}
	
	public void setExtrato(String nome, String atividade, double valor, String nome2) {
		String extrato = "Horario " + dataDeAbertura.horaNow() + " Data " + dataDeAbertura.dataNow() + " " + nome + " " + atividade + " " + Double.toString(valor) +" para "+ nome2;
		for (int i = 0; i < this.extrato.length; i++) {
			if (this.extrato[i] == null) {

				this.extrato[i] = extrato;
				break;
			}
		}
	}

	
	//validacao
	protected boolean podeSacar(double valor){

		if (saldo < valor)
			return false;
		else
			return true; 

	}

	public void sacar (double valor){
		if (podeSacar(valor)) {
			saldo -= valor;
			System.out.println("Novo Saldo: ");
			System.out.print(this.getSaldo());
			System.out.println("");

		}    
		else 
			System.out.println("Saldo indisponivel");

	}
	
	public void sacar2 (double valor){
		if (podeSacar(valor)) {

			saldo -= valor;
			
		}    
		else 
			JOptionPane.showMessageDialog(null, "Voce nao possui Saldo suficiente para efetuar o saque requisitado!!");

	}


	public void transferencia (Conta c2, double valor){
		c2.depositar(valor);
		this.depositar(-valor);
	}
	
	public String toString() {
		return String.valueOf(Banco.reg1.getIndexOf(this)) + " - " + dataDeAbertura.dataTexto + " " + nameClass + " nConta " + titular.nConta + ", " + titular.nome + ", login " + titular.login + ", saldo " + this.getSaldo();
	}

	public boolean contaequals(Conta a){

		return (this.titular.login == a.titular.login);        
	}
}

