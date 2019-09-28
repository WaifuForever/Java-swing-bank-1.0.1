package sistema;

import java.awt.BorderLayout;
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

public class Cadastrar extends JFrame {
	Conta c1;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
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
					Cadastrar frame = new Cadastrar();
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
	public Cadastrar() {
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
		

		nome = new JTextField();
		nome.setBounds(168, 33, 112, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		cpf = new JTextField();
		cpf.setBounds(168, 64, 112, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);

		nConta = new JTextField();
		nConta.setBounds(168, 95, 112, 20);
		nConta.setToolTipText("Digite um inteiro");
		contentPane.add(nConta);
		nConta.setColumns(10);

		login = new JTextField();
		login.setBounds(168, 126, 112, 20);
		login.setToolTipText("Digite um inteiro");
		contentPane.add(login);
		login.setColumns(10);

		senha = new JPasswordField();
		senha.setBounds(168, 157, 112, 20);
		senha.setToolTipText("Digite um inteiro");
		contentPane.add(senha);
		senha.setColumns(10);

		JLabel lblDigiteONome = new JLabel("Digite o nome do usuario:");
		lblDigiteONome.setBounds(10, 36, 148, 14);
		contentPane.add(lblDigiteONome);

		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do usuario:");
		lblDigiteOCpf.setBounds(10, 67, 148, 14);
		contentPane.add(lblDigiteOCpf);

		JLabel lblDigiteONmero = new JLabel("Digite o numero da Conta:");
		lblDigiteONmero.setBounds(10, 98, 148, 14);
		contentPane.add(lblDigiteONmero);

		/*String[] vetor = new String [2]; 
		vetor[0] = "Conta Corrente";
		vetor[1] = "Conta Poupanca";*/
		JComboBox<String> comboBox = new JComboBox<String>(/*vetor*/);
		comboBox.addItem("Conta Corrente");
		comboBox.addItem("Conta Poupanca");
		//comboBox.setToolTipText("");
		comboBox.setBounds(168, 188, 112, 20);
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {

			} 
		});
		contentPane.add(comboBox);

		JLabel lblDigiteOLogin = new JLabel("Digite o Login do usuario:");
		lblDigiteOLogin.setBounds(10, 129, 148, 14);
		contentPane.add(lblDigiteOLogin);

		JLabel lblDigiteASenha = new JLabel("Digite a Senha do usuario:");
		lblDigiteASenha.setBounds(10, 160, 148, 14);
		contentPane.add(lblDigiteASenha);

		JLabel lblEscolhaOTipo = new JLabel("Escolha o Tipo de Conta:");
		lblEscolhaOTipo.setBounds(10, 191, 148, 14);
		contentPane.add(lblEscolhaOTipo);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(nome.getText().isEmpty() || cpf.getText().isEmpty() || nConta.getText().isEmpty() 
						||login.getText().isEmpty() || senha.getPassword().length == 0 || comboBox.getSelectedIndex() == -1)) {
					
					if(Menu2.eInteger(nConta.getText()) && Menu2.eInteger(login.getText()) && Menu2.eInteger(senha.getPassword())) {
						switch (comboBox.getSelectedIndex()){
						case 0:
							c1 = new ContaCorrente();
							break;

						case 1:
							c1 = new ContaPoupanca();
							break;

						default:
							break;
						}					
						
						Object[] options = { "Confirmar", "Cancelar" };
						int is = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informacao", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
						
						if (is == 0) {
							Banco.reg1.contas.add(c1);
							Banco.reg1.getConta(Banco.reg1.contas.size() - 1).titular.nome = nome.getText();
							Banco.reg1.getConta(Banco.reg1.contas.size() - 1).titular.cpf = cpf.getText();
							Banco.reg1.getConta(Banco.reg1.contas.size() - 1).titular.nConta = Integer.parseInt(nConta.getText());
							Banco.reg1.getConta(Banco.reg1.contas.size() - 1).titular.login = Integer.parseInt(login.getText());
							String str = "";
							for (int i = 0; i < senha.getPassword().length; i++) {
								str += senha.getPassword()[i];
								
							}
							Banco.reg1.getConta(Banco.reg1.contas.size() - 1).titular.senha = Integer.parseInt(str);
							str = "";
							
							MenuFuncionario.btnNewButton.setEnabled(true);
							MenuFuncionario.btnNewButton_1.setEnabled(true);
							MenuFuncionario.btnNewButton_2.setEnabled(true);
							MenuFuncionario.btnNewButton_3.setEnabled(true);
							MenuFuncionario.btnNewButton_4.setEnabled(true);
							MenuFuncionario.btnNewButton_5.setEnabled(true);
							MenuFuncionario.btnNewButton_6.setEnabled(true);
							
							dispose();
						}
						else {
							
						}
						
						
					}
					
					else
						JOptionPane.showMessageDialog(null, "Digite valores validos!!");					
				}				
				else
					JOptionPane.showMessageDialog(null, "Nao deixe campos vazios!!");
			}
		});
		btnCadastrar.setBounds(76, 229, 112, 23);
		contentPane.add(btnCadastrar);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				cpf.setText("");
				nConta.setText("");
				login.setText("");
				senha.setText("");
			}
		});
		btnNewButton.setBounds(198, 229, 112, 23);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_1.setBounds(320, 229, 112, 23);
		contentPane.add(btnNewButton_1);
	}
}
