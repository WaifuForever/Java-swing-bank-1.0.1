package sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import banco.Banco;
import banco.Menu2;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarConta extends JFrame {
	Conta c1;
	private JPanel contentPane;
	private JTextField nConta;
	private JTextField login;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarConta frame = new AlterarConta();
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
	public AlterarConta() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MenuFuncionario.btnNewButton.setEnabled(false);
		MenuFuncionario.btnNewButton_1.setEnabled(false);
		MenuFuncionario.btnNewButton_2.setEnabled(false);
		MenuFuncionario.btnNewButton_3.setEnabled(false);
		MenuFuncionario.btnNewButton_4.setEnabled(false);
		MenuFuncionario.btnNewButton_5.setEnabled(false);
		MenuFuncionario.btnNewButton_6.setEnabled(false);


		nConta = new JTextField();
		nConta.setBounds(168, 77, 112, 20);
		nConta.setToolTipText("Digite um inteiro");
		contentPane.add(nConta);
		nConta.setColumns(10);

		login = new JTextField();
		login.setBounds(168, 108, 112, 20);
		login.setToolTipText("Digite um inteiro");
		contentPane.add(login);
		login.setColumns(10);

		senha = new JPasswordField();
		senha.setBounds(168, 139, 112, 20);
		senha.setToolTipText("Digite apenas numeros");
		contentPane.add(senha);
		senha.setColumns(10);


		JComboBox<String> comboBox = new JComboBox<String>(/*vetor*/);
		comboBox.addItem("Conta Corrente");
		comboBox.addItem("Conta Poupanca");
		if (Banco.contaLogada instanceof ContaDiretor) {
			comboBox.addItem("Conta Gerente");
			comboBox.addItem("Conta Diretor");
		}

		comboBox.setBounds(168, 170, 112, 20);
		contentPane.add(comboBox);

		JLabel lblDigiteONmero = new JLabel("Digite o numero da Conta:");
		lblDigiteONmero.setBounds(10, 80, 148, 14);
		contentPane.add(lblDigiteONmero);

		JLabel lblDigiteOLogin = new JLabel("Digite o Login do usuario:");
		lblDigiteOLogin.setBounds(10, 111, 148, 14);
		contentPane.add(lblDigiteOLogin);

		JLabel lblDigiteASenha = new JLabel("Digite a Senha do usuario:");
		lblDigiteASenha.setBounds(10, 142, 148, 14);
		contentPane.add(lblDigiteASenha);

		JButton btnCadastrar = new JButton("Alterar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!( nConta.getText().isEmpty() ||login.getText().isEmpty() || senha.getPassword().length == 0|| comboBox.getSelectedIndex() == -1)) {

					if(Menu2.eInteger(nConta.getText()) && Menu2.eInteger(login.getText()) && Menu2.eInteger(senha.getPassword())) {
						int pos = Banco.reg1.getContaIndex(Banco.contaLogada.titular.entrarConta(login.getText(), senha.getPassword(), nConta.getText()));

						if(!(Banco.contaLogada.contaequals(Banco.reg1.getConta(pos)) || Banco.reg1.getConta(pos).contaequals(Banco.reg1.contaPublic))) {
							if(!(Banco.contaLogada instanceof ContaGerente && Banco.reg1.getConta(pos) instanceof Funcionario)) {
								Object[] options = { "Confirmar", "Cancelar" };
								int is = JOptionPane.showOptionDialog(null, Banco.reg1.getConta(pos).toString() + "\nClique Confirmar para continuar", "Informacao", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

								if (is == 0) {	
									switch (comboBox.getSelectedIndex()){
									case 0:
										if(!(Banco.reg1.getConta(pos) instanceof ContaCorrente)) {
											login = null;
											senha = null;
											nConta = null;

											ContaCorrente ccnew = new ContaCorrente();
											ccnew.titular.nome = Banco.reg1.getConta(pos).titular.nome;
											ccnew.titular.cpf = Banco.reg1.getConta(pos).titular.cpf;
											ccnew.titular.nConta = Banco.reg1.getConta(pos).titular.nConta;
											ccnew.titular.login = Banco.reg1.getConta(pos).titular.login;
											ccnew.titular.senha = Banco.reg1.getConta(pos).titular.senha;
											ccnew.depositar(Banco.reg1.getConta(pos).getSaldo());
											String message = "A " + Banco.reg1.getConta(pos).getNameClass() + " especificada foi convertida em uma Conta Corrente";
											JOptionPane.showMessageDialog(null, message);
											MenuFuncionario.btnNewButton.setEnabled(true);
											MenuFuncionario.btnNewButton_1.setEnabled(true);
											MenuFuncionario.btnNewButton_2.setEnabled(true);
											MenuFuncionario.btnNewButton_3.setEnabled(true);
											MenuFuncionario.btnNewButton_4.setEnabled(true);
											MenuFuncionario.btnNewButton_5.setEnabled(true);
											MenuFuncionario.btnNewButton_6.setEnabled(true);
											Banco.reg1.contas.set(pos, ccnew);
											dispose();
										}
										else {
											String message = "A Conta especificada ja e um Conta Corrente.";
											JOptionPane.showMessageDialog(null, message);
										}

										break;

									case 1:
										if(!(Banco.reg1.getConta(pos) instanceof ContaPoupanca)) {
											login = null;
											senha = null;
											nConta = null;

											ContaPoupanca cpnew = new ContaPoupanca();
											cpnew.titular.nome = Banco.reg1.getConta(pos).titular.nome;
											cpnew.titular.cpf = Banco.reg1.getConta(pos).titular.cpf;
											cpnew.titular.nConta = Banco.reg1.getConta(pos).titular.nConta;
											cpnew.titular.login = Banco.reg1.getConta(pos).titular.login;
											cpnew.titular.senha = Banco.reg1.getConta(pos).titular.senha;
											cpnew.depositar(Banco.reg1.getConta(pos).getSaldo());
											String message = "A " + Banco.reg1.getConta(pos).getNameClass() + " especificada foi convertida em uma Conta Poupanca";
											Banco.reg1.contas.set(pos, cpnew);
											JOptionPane.showMessageDialog(null, message);
											MenuFuncionario.btnNewButton.setEnabled(true);
											MenuFuncionario.btnNewButton_1.setEnabled(true);
											MenuFuncionario.btnNewButton_2.setEnabled(true);
											MenuFuncionario.btnNewButton_3.setEnabled(true);
											MenuFuncionario.btnNewButton_4.setEnabled(true);
											MenuFuncionario.btnNewButton_5.setEnabled(true);
											MenuFuncionario.btnNewButton_6.setEnabled(true);
											dispose();
											break;
										}
										else {
											String message = "A Conta especificada ja e um Conta Poupança.";
											JOptionPane.showMessageDialog(null, message);
										}

										break;

									case 2:
										if(!(Banco.reg1.getConta(pos) instanceof ContaGerente)) {
											login = null;
											senha = null;
											nConta = null;

											ContaGerente cgnew = new ContaGerente();
											cgnew.titular.nome = Banco.reg1.getConta(pos).titular.nome;
											cgnew.titular.cpf = Banco.reg1.getConta(pos).titular.cpf;
											cgnew.titular.nConta = Banco.reg1.getConta(pos).titular.nConta;
											cgnew.titular.login = Banco.reg1.getConta(pos).titular.login;
											cgnew.titular.senha = Banco.reg1.getConta(pos).titular.senha;
											cgnew.depositar(Banco.reg1.getConta(pos).getSaldo());
											String message = "A " + Banco.reg1.getConta(pos).getNameClass() + " especificada foi convertida em uma Conta Gerente";
											JOptionPane.showMessageDialog(null, message);
											Banco.reg1.contas.set(pos, cgnew);
											MenuFuncionario.btnNewButton.setEnabled(true);
											MenuFuncionario.btnNewButton_1.setEnabled(true);
											MenuFuncionario.btnNewButton_2.setEnabled(true);
											MenuFuncionario.btnNewButton_3.setEnabled(true);
											MenuFuncionario.btnNewButton_4.setEnabled(true);
											MenuFuncionario.btnNewButton_5.setEnabled(true);
											MenuFuncionario.btnNewButton_6.setEnabled(true);
											dispose();
											break;
										}

										else {
											String message = "A Conta especificada ja e um Conta Gerente.";
											JOptionPane.showMessageDialog(null, message);
										}
										break;

									case 3:
										if(!(Banco.reg1.getConta(pos) instanceof ContaDiretor)) {
											login = null;
											senha = null;
											nConta = null;

											ContaDiretor cdnew = new ContaDiretor();
											cdnew.titular.nome = Banco.reg1.getConta(pos).titular.nome;
											cdnew.titular.cpf = Banco.reg1.getConta(pos).titular.cpf;
											cdnew.titular.nConta = Banco.reg1.getConta(pos).titular.nConta;
											cdnew.titular.login = Banco.reg1.getConta(pos).titular.login;
											cdnew.titular.senha = Banco.reg1.getConta(pos).titular.senha;
											cdnew.depositar(Banco.reg1.getConta(pos).getSaldo());
											String message = "A " + Banco.reg1.getConta(pos).getNameClass() + " especificada foi convertida em uma Conta Diretor";
											JOptionPane.showMessageDialog(null, message);
											Banco.reg1.contas.set(pos, cdnew);
											MenuFuncionario.btnNewButton.setEnabled(true);
											MenuFuncionario.btnNewButton_1.setEnabled(true);
											MenuFuncionario.btnNewButton_2.setEnabled(true);
											MenuFuncionario.btnNewButton_3.setEnabled(true);
											MenuFuncionario.btnNewButton_4.setEnabled(true);
											MenuFuncionario.btnNewButton_5.setEnabled(true);
											MenuFuncionario.btnNewButton_6.setEnabled(true);
											dispose();
											break;
										}
										else {
											String message = "A Conta especificada ja e um Conta Diretor.";
											JOptionPane.showMessageDialog(null, message);
										}
										break;

									default:
										String message = "Escolha o tipo de Conta";
										JOptionPane.showMessageDialog(null, message);
										break;
									}
								}


							}
							else {
								String message = "Voce nao tem permissao para alterar esta conta.";
								JOptionPane.showMessageDialog(null, message);
							}
						}


						else {
							String message;
							if(Banco.reg1.getConta(pos).contaequals(Banco.reg1.contaPublic)) {
								message = "Dados Incorretos!!";
							}
							else
								message = "Nao e possivel para o usuario alterar o tipo da propria conta";
							JOptionPane.showMessageDialog(null, message);
						}


					}

					else
						JOptionPane.showMessageDialog(null, "Digite valores validos!!");					
				}				
				else
					JOptionPane.showMessageDialog(null, "Nao deixe campos vazios!!");
			}
		});
		btnCadastrar.setBounds(65, 229, 112, 23);
		contentPane.add(btnCadastrar);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nConta.setText("");
				login.setText("");
				senha.setText("");
			}
		});
		btnNewButton.setBounds(187, 229, 112, 23);
		contentPane.add(btnNewButton);



		JLabel lblEscolhaOTipo = new JLabel("Escolha o tipo de Conta:");
		lblEscolhaOTipo.setBounds(10, 173, 148, 14);
		contentPane.add(lblEscolhaOTipo);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFuncionario.btnNewButton.setEnabled(true);
				MenuFuncionario.btnNewButton_1.setEnabled(true);
				MenuFuncionario.btnNewButton_2.setEnabled(true);
				MenuFuncionario.btnNewButton_3.setEnabled(true);
				MenuFuncionario.btnNewButton_4.setEnabled(true);
				MenuFuncionario.btnNewButton_5.setEnabled(true);
				MenuFuncionario.btnNewButton_6.setEnabled(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(309, 229, 112, 23);
		contentPane.add(btnNewButton_1);
	}
}
