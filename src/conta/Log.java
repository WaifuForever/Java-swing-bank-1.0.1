package conta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import banco.Banco;
import banco.Menu2;
import sistema.Funcionario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Log extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
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
	public Log() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblDigiteONome = new JLabel("Login:");
		lblDigiteONome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDigiteONome.setBounds(15, 41, 86, 20);

		textField = new JTextField();
		textField.setBounds(15, 66, 86, 20);
		textField.setColumns(10);


		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(15, 97, 86, 20);
		
		Menu2.opcao1.setEnabled(false);
		Menu2.opcao2.setEnabled(false);
		Menu2.opcao3.setEnabled(false);
		Menu2.opcao4.setEnabled(false);
		Menu2.opcao5.setEnabled(false);
		Menu2.opcao6.setEnabled(false);
		Menu2.opcao7.setEnabled(false);		
		Menu2.opcao8.setEnabled(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(15, 120, 86, 20);
		contentPane.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(153, 222, 86, 23);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				if(Menu2.eInteger(textField.getText()) && Menu2.eInteger(passwordField.getPassword()))   {
					String login = textField.getText();
					

					Banco.contaLogada = Banco.contaLogada.titular.entrarConta(login, passwordField.getPassword());
					


				}

				else
					JOptionPane.showMessageDialog(null,"Preeencha corretamente o codigo!"); 

				if(!Banco.contaLogada.contaequals(Banco.reg1.contaPublic)) {
					
					Menu2.opcao1.setEnabled(true);
					Menu2.opcao2.setEnabled(true);
					Menu2.opcao3.setEnabled(true);
					Menu2.opcao4.setEnabled(true);
					Menu2.opcao5.setEnabled(true);
					Menu2.opcao6.setEnabled(true);
					Menu2.opcao7.setEnabled(true);
					
				
					
					
					Menu2.opcao1.setText("Desconectar");
					Menu2.lblNewLabel_1.setText(Banco.contaLogada.getNameClass() + " N:" + Banco.contaLogada.titular.nConta );
					Menu2.lblNewLabel_2.setText(Banco.contaLogada.titular.nome);
					
					if(Banco.contaLogada instanceof Funcionario) {
						Menu2.opcao8.setVisible(true);
						Menu2.opcao8.setEnabled(true);
					}
					else {
						Menu2.opcao8.setVisible(false);
						Menu2.opcao8.setEnabled(false);
					}

					if (Menu2.isLog) {
						new Saque().setVisible(true);
						Menu2.isLog = false;
					}


					else if (Menu2.isLog2) {
						String str = String.format("%.2f", Banco.contaLogada.getSaldo());
						JOptionPane.showMessageDialog(null, "Seu Saldo: " + str);
						Menu2.isLog2 = false;
					}

					else if (Menu2.isLog3) {
						new Extrato().setVisible(true);
						Menu2.isLog3 = false;
					}					

					else if (Menu2.isLog4) {

						if (Banco.contaLogada.getSaldo() > 0) {
							new Transferencia().setVisible(true);
							Menu2.isLog4 = false;

						}
						else
							JOptionPane.showMessageDialog(null, "Seu Saldo: " + Banco.contaLogada.getSaldo() + "\nNao e possivel realizar essa operacao");

					}
					dispose();
					
				}

				
				




			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(249, 222, 86, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		contentPane.setLayout(null);
		contentPane.add(textField);
		contentPane.add(lblDigiteONome);
		contentPane.add(lblNewLabel);
		contentPane.add(btnEntrar);
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
		btnCancelar.setBounds(345, 222, 86, 23);
		contentPane.add(btnCancelar);
		
		
	}
}
