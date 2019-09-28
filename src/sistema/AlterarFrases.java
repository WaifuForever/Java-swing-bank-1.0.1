package sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.Banco;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarFrases extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarFrases frame = new AlterarFrases();
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
	public AlterarFrases() {
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
		
		JLabel lblNewLabel = new JLabel("Frases de Boas Vindas");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 0, 168, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblFrasesDeDespedida = new JLabel("Frases de Despedida");
		lblFrasesDeDespedida.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblFrasesDeDespedida.setBounds(10, 100, 168, 31);
		contentPane.add(lblFrasesDeDespedida);
		
		JLabel lblNewLabel_1 = new JLabel(Banco.reg1.boasVindasCliente);
		lblNewLabel_1.setBounds(10, 60, 168, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel(Banco.reg1.boasVindasInicial);
		label.setBounds(10, 30, 180, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(Banco.reg1.despedidaCliente1);
		label_1.setBounds(10, 130, 168, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(Banco.reg1.despedidaCliente2);
		label_2.setBounds(10, 160, 168, 25);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(188, 32, 151, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 62, 151, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(188, 132, 151, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(188, 162, 151, 20);
		contentPane.add(textField_3);
		
		JButton btnAlterarMensagens = new JButton("Alterar Mensagens");
		btnAlterarMensagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Confirmar", "Cancelar" };
				int is = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informacao", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				
				if(is == 0) {
					String message = "";
					
					if(!textField.getText().isEmpty()) {
						Banco.reg1.boasVindasCliente = textField.getText();
						message += "Boas Vindas Cliente foi alterado\n";
					}
					if(!textField_1.getText().isEmpty()) {
						Banco.reg1.boasVindasInicial = textField_1.getText();	
						message += "Boas Vindas Cliente Inicial foi alterado\n";
					}
					if(!textField_2.getText().isEmpty()) {
						Banco.reg1.despedidaCliente1 = textField_2.getText();
						message += "Despedida Cliente_1 foi alterado\n";
					}
					if(!textField_3.getText().isEmpty()) {
						Banco.reg1.despedidaCliente2 = textField_3.getText();
						message += "Despedida Cliente_2 foi alterado\n";
					}
					
					if(message.equalsIgnoreCase("")) {
						message += "Nenhuma alteracao foi realizada.";
						JOptionPane.showMessageDialog(null, message);
						
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
						JOptionPane.showMessageDialog(null, message);
						
						MenuFuncionario.btnNewButton.setEnabled(true);
						MenuFuncionario.btnNewButton_1.setEnabled(true);
						MenuFuncionario.btnNewButton_2.setEnabled(true);
						MenuFuncionario.btnNewButton_3.setEnabled(true);
						MenuFuncionario.btnNewButton_4.setEnabled(true);
						MenuFuncionario.btnNewButton_5.setEnabled(true);
						MenuFuncionario.btnNewButton_6.setEnabled(true);
						dispose();
					}
				}
				
				else {
					
				}
				
			}
				
		});
		btnAlterarMensagens.setBounds(10, 227, 134, 23);
		contentPane.add(btnAlterarMensagens);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnLimpar.setBounds(154, 227, 134, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
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
		btnCancelar.setBounds(298, 227, 134, 23);
		contentPane.add(btnCancelar);
	}
}
