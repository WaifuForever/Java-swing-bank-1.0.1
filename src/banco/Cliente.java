package banco;

import javax.swing.JOptionPane;

import conta.Conta;

public class Cliente {
	public String nome;
	public String cpf;
	public int nConta;
	public int login;
	public int senha;

	

	public void Welcome() {
		System.out.printf("%s %s!",Banco.reg1.getBoasVindasCliente(), nome);
		System.out.println();
	}

	private Conta getConta(int log, int pass){

		for (int i = 0; i < Banco.reg1.getTotalContas(); i++) {

			if (Banco.reg1.getConta(i).titular.login == log && Banco.reg1.getConta(i).titular.senha == pass) {
				Banco.contaLogada = Banco.reg1.getConta(i);//deixa a conta logada para o proximo loop
				pass = 0;
				log = 0;
				return Banco.reg1.getConta(i);
			}
		}   		
		pass = 0;
		log = 0;
		JOptionPane.showMessageDialog(null,"Login e/ou senha incorretos");
		return Banco.reg1.contaPublic;               
	}
	
	private Conta getConta(int log, int pass, int nConta){//usado em AlterarConta

		for (int i = 0; i < Banco.reg1.getTotalContas(); i++) {

			if (Banco.reg1.getConta(i).titular.login == log && Banco.reg1.getConta(i).titular.senha == pass && Banco.reg1.getConta(i).titular.nConta == nConta) {
				pass = 0;
				log = 0;
				nConta = 0;
				
				return Banco.reg1.getConta(i);
			}
			
		}  
		pass = 0;
		log = 0;
		nConta = 0;
		JOptionPane.showMessageDialog(null,"Login e/ou senha incorretos");
		return Banco.reg1.contaPublic;               
	}

	public Conta getContaLogada() {
		if (Banco.contaLogada.titular.nome == null)
			return Banco.reg1.contaPublic;

		else
			return Banco.contaLogada;

	}

	public Conta getConta(int log, String nome){
		for (int i = 0; i < Banco.reg1.getTotalContas(); i++) {
			
			if (Banco.reg1.getConta(i).titular.login == log && Banco.reg1.getConta(i).titular.nome.equalsIgnoreCase(nome)) {
				nome = null;
				log = 0;
				return Banco.reg1.getConta(i);
			}

		}

		return Banco.reg1.contaPublic;
	}

	
	public Conta entrarConta(String login, char[] senha){
		int log = 0, pass = 0;
			log = Integer.parseInt(login);
			String str = "";
			for (int i = 0; i < senha.length; i++) {
				str += senha[i]; 
			}
			pass = Integer.parseInt(str);
			str = null;
			senha = null;
			login = null;
		return this.getConta(log, pass);
	}
	
	public Conta entrarConta(String login, char[] senha, String nConta){//usado em AlterarConta
		int log = 0, pass = 0, numConta;
			log = Integer.parseInt(login);
			String str = "";
			for (int i = 0; i < senha.length; i++) {
				str += senha[i]; 
			}
			pass = Integer.parseInt(str);
			str = null;
			senha = null;
			login = null;
			numConta = Integer.parseInt(nConta);
		return this.getConta(log, pass, numConta);
	}
}
