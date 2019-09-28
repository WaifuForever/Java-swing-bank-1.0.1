package conta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.Banco;
import banco.Menu2;
import conta.Conta;
import sistema.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transferencia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transferencia frame = new Transferencia();
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
	public Transferencia() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Menu2.opcao1.setEnabled(false);
		Menu2.opcao2.setEnabled(false);
		Menu2.opcao3.setEnabled(false);
		Menu2.opcao4.setEnabled(false);
		Menu2.opcao5.setEnabled(false);
		Menu2.opcao6.setEnabled(false);
		Menu2.opcao7.setEnabled(false);		
		Menu2.opcao8.setEnabled(false);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome do usuario beneficiado: ");
		lblDigiteONome.setBounds(10, 51, 203, 14);
		contentPane.add(lblDigiteONome);
		
		textField = new JTextField();
		textField.setBounds(10, 72, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteOLogin = new JLabel("Digite o login do usuario beneficiado:");
		lblDigiteOLogin.setBounds(10, 103, 203, 14);
		contentPane.add(lblDigiteOLogin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 131, 122, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Transferir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double valor = 0;
				int login = 0;
				if(Menu2.eInteger(textField_1.getText()))
					login = Integer.parseInt(textField_1.getText());
				String nome = textField.getText();
				Conta transferencia = Banco.contaLogada.titular.getConta(login, nome);
				
				if (!transferencia.contaequals(Banco.reg1.contaPublic)) {
					
					if (Menu2.eDouble(textField_2.getText()))
						valor = Double.parseDouble(textField_2.getText());
					if(valor > 0 && valor < Banco.contaLogada.getSaldo()) {
						transferencia.depositar(valor);
						//mensagem para o usuario
						if (!transferencia.contaequals(Banco.contaLogada) && !Banco.contaLogada.contaequals(Banco.reg1.contaPublic)) {
							Menu2.opcao1.setEnabled(true);
							Menu2.opcao2.setEnabled(true);
							Menu2.opcao3.setEnabled(true);
							Menu2.opcao4.setEnabled(true);
							Menu2.opcao5.setEnabled(true);
							Menu2.opcao6.setEnabled(true);
							
							Menu2.opcao7.setEnabled(true);
							if(Banco.contaLogada instanceof Funcionario)
								Menu2.opcao8.setEnabled(true);
							
							Banco.contaLogada.transferencia(transferencia, valor);
							String str = "O valor de " + String.format("%.2f", valor) + " foi deduzido da sua conta e creditado a conta de " + transferencia.titular.nome;
							JOptionPane.showMessageDialog(null, str);
							Banco.contaLogada.setExtrato(Banco.contaLogada.titular.nome, "transferiu o valor de", valor, transferencia.titular.nome);//coloca o extrato na conta logada
							transferencia.setExtrato(Banco.contaLogada.titular.nome, "transferiu o valor de", valor, " para sua conta");//coloca o extrato na conta transferencia
							dispose();
						}
						
						else {
							JOptionPane.showMessageDialog(null, "A conta logada e a conta alvo são a mesma!");
						}
							
					
						
					}
					else 
						JOptionPane.showMessageDialog(null, "Digite um valor valido!!");
				}
				
				else {
					JOptionPane.showMessageDialog(null, "A conta informada nao existe.");
				}
				
				
				

				
					
			}
		});
		btnNewButton.setBounds(100, 227, 116, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblValorDoDeposito = new JLabel("Valor da Transferencia:");
		lblValorDoDeposito.setBounds(10, 162, 168, 14);
		contentPane.add(lblValorDoDeposito);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 179, 122, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnLimpar.setBounds(226, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2.opcao1.setEnabled(true);
				Menu2.opcao2.setEnabled(true);
				Menu2.opcao3.setEnabled(true);
				Menu2.opcao4.setEnabled(true);
				Menu2.opcao5.setEnabled(true);
				Menu2.opcao6.setEnabled(true);
				Menu2.opcao7.setEnabled(true);
				if(Banco.contaLogada instanceof Funcionario)
					Menu2.opcao8.setEnabled(true);
				dispose();
			}
		});
		btnCancelar.setBounds(325, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}
