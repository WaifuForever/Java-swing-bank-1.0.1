package banco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conta.Depositar;
import conta.Extrato;
import conta.Log;
import conta.Saque;
import conta.Transferencia;
import sistema.Funcionario;
import sistema.MenuFuncionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu2 extends JFrame {

	private JPanel contentPane;
	public static boolean isLog, isLog2, isLog3, isLog4;

	JLabel lblNewLabel = new JLabel("Bem vindo ao Banco");

	public static JLabel lblNewLabel_1 = new JLabel();

	public static JLabel lblNewLabel_2 = new JLabel();
	public static Menu2 frame;

	
	public static JButton opcao1 = new JButton("Acessar Sua Conta");
	public static JButton opcao2 = new JButton("Deposito");
	public static JButton opcao3 = new JButton("Saque");
	public static JButton opcao4 = new JButton("Saldo");
	public static JButton opcao5 = new JButton("Extrato");
	public static JButton opcao6 = new JButton("Transferencia");
	public static JButton opcao7 = new JButton("Sair");
	public static JButton opcao8 = new JButton("Mais opcoes");


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Menu2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public Menu2() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		opcao1.setBounds(15, 89, 150, 23);

		isLog = false;
		isLog2 = false;
		isLog3 = false;
		isLog4 = false;

		opcao1.addActionListener(new ActionListener() {//Conectar na conta
			public void actionPerformed(ActionEvent arg0) {
				if (Banco.contaLogada.contaequals(Banco.reg1.contaPublic)) {

					new Log().setVisible(true); 

				}

				else {
					String tchau = Banco.reg1.getDespedidaCliente1() + " " + Banco.contaLogada.titular.nome;
					JOptionPane.showMessageDialog(null, tchau);
					Banco.contaLogada = Banco.reg1.contaPublic;
					lblNewLabel_1.setText(null);
					lblNewLabel_2.setText(null);
					opcao8.setVisible(false);
					opcao8.setEnabled(false);
					opcao1.setText("Acessar Sua Conta");
				}

			}
		});

		
		opcao2.addActionListener(new ActionListener() {//Depositar
			public void actionPerformed(ActionEvent arg0) {
				new Depositar().setVisible(true);
			}
		});
		opcao2.setBounds(15, 119, 150, 23);

		
		opcao3.addActionListener(new ActionListener() {//Sacar
			public void actionPerformed(ActionEvent e) {

				if(Banco.contaLogada.contaequals(Banco.reg1.contaPublic)) {
					JOptionPane.showMessageDialog(null, "Por favor entre na sua conta.");
					isLog = true;				
					new Log().setVisible(true); 
				}
				else 
					new Saque().setVisible(true);

			}
		});
		opcao3.setBounds(15, 149, 150, 23);


		
		opcao4.addActionListener(new ActionListener() {//Consultar Saldo
			public void actionPerformed(ActionEvent e) {

				if(Banco.contaLogada.contaequals(Banco.reg1.contaPublic)) {
					JOptionPane.showMessageDialog(null, "Por favor entre na sua conta.");
					isLog2 = true;
					new Log().setVisible(true);
				}
				else {
					String str = String.format("%.2f", Banco.contaLogada.getSaldo());
					JOptionPane.showMessageDialog(null, "Seu Saldo: " + str);
				}
			}
		});
		opcao4.setBounds(15, 179, 150, 23);

		
		opcao5.addActionListener(new ActionListener() {//Extrato
			public void actionPerformed(ActionEvent e) {

				if(Banco.contaLogada.contaequals(Banco.reg1.contaPublic)) {
					JOptionPane.showMessageDialog(null, "Por favor entre na sua conta.");
					isLog3 = true;
					new Log().setVisible(true);
				}
				else {
					new Extrato().setVisible(true);
				}
			}
		});
		opcao5.setBounds(175, 89, 150, 23);

		
		opcao6.addActionListener(new ActionListener() {//Transferencia
			public void actionPerformed(ActionEvent e) {


				if(Banco.contaLogada.contaequals(Banco.reg1.contaPublic)) {
					JOptionPane.showMessageDialog(null, "Por favor entre na sua conta.");
					isLog4 = true;				
					new Log().setVisible(true);
				}
				else if (Banco.contaLogada.getSaldo() > 0) {
					new Transferencia().setVisible(true);

				}
				else
					JOptionPane.showMessageDialog(null, "Seu Saldo: " + Banco.contaLogada.getSaldo() + "\nNao e possivel realizar essa operacao");

			}
		});
		opcao6.setBounds(175, 119, 150, 23);

										//Sair
		opcao7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		opcao7.setBounds(175, 149, 150, 23);
		opcao8.addActionListener(new ActionListener() {//Opcoes funcionario
			public void actionPerformed(ActionEvent e) {
				new sistema.MenuFuncionario().setVisible(true);
			}
		});
		
		opcao8.setBounds(175, 179, 150, 23);
		
		opcao8.setVisible(false);
		opcao8.setEnabled(false);
		
		contentPane.setLayout(null);
		lblNewLabel.setBounds(15, 5, 129, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(15, 25, 129, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setBounds(15, 45, 129, 14);
		contentPane.add(lblNewLabel_2);
		contentPane.add(opcao1);
		contentPane.add(opcao2);
		contentPane.add(opcao3);
		contentPane.add(opcao4);
		contentPane.add(opcao6);
		contentPane.add(opcao5);
		contentPane.add(opcao7);
		contentPane.add(opcao8);

		JLabel lblEscolhaAOpcao = new JLabel("Escolha a opcao desejada:");
		lblEscolhaAOpcao.setBounds(15, 70, 183, 14);
		contentPane.add(lblEscolhaAOpcao);
		
	}
	public static boolean eInteger(String str) {

		try {
			int i = Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean eInteger(char [] str) {

		try {
			for (int i = 0; i < str.length; i++) {
				int n1 = (int)str[i];
			}
			
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}


	public static boolean eDouble(String str) {

		try {
			str = str.replaceAll(",", ".");
			double i = Double.parseDouble(str);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
}
