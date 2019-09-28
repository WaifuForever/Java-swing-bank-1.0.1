package conta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.Banco;
import banco.Menu2;
import sistema.Funcionario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Saque extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saque frame = new Saque();
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
	public Saque() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(10, 88, 198, 63);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Menu2.opcao1.setEnabled(false);
		Menu2.opcao2.setEnabled(false);
		Menu2.opcao3.setEnabled(false);
		Menu2.opcao4.setEnabled(false);
		Menu2.opcao5.setEnabled(false);
		Menu2.opcao6.setEnabled(false);
		Menu2.opcao7.setEnabled(false);		
		Menu2.opcao8.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Digite a quantia a ser sacada:");
		lblNewLabel.setBounds(10, 40, 198, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				if(Menu2.eDouble(textField.getText())) {
					Menu2.opcao1.setEnabled(true);
					Menu2.opcao2.setEnabled(true);
					Menu2.opcao3.setEnabled(true);
					Menu2.opcao4.setEnabled(true);
					Menu2.opcao5.setEnabled(true);
					Menu2.opcao6.setEnabled(true);
					Menu2.opcao7.setEnabled(true);
					if(Banco.contaLogada instanceof Funcionario)
						Menu2.opcao8.setEnabled(true);
					
					double valor2 = Double.parseDouble(textField.getText());
					Banco.contaLogada.sacar2(valor2);
					String str = "Seu Saldo: " + String.format("%.2f", Banco.contaLogada.getSaldo());
					JOptionPane.showMessageDialog(null, str);
					Banco.contaLogada.setExtrato(Banco.contaLogada.titular.nome, "sacou", valor2);
					dispose();
					
				}
				else
					JOptionPane.showMessageDialog(null,"Valor invalido!!");
			}
		});
		btnSacar.setBounds(135, 191, 89, 23);
		contentPane.add(btnSacar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnLimpar.setBounds(235, 191, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnCancelar.setBounds(335, 191, 89, 23);
		contentPane.add(btnCancelar);
	}
}
