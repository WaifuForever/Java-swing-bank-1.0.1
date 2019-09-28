package sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.Banco;
import banco.Menu2;
import sistema.Funcionario;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExibirContas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirContas frame = new ExibirContas();
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
	public ExibirContas() {
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

		
		String extrato[] = Banco.contaLogada.getExtrato2();
		String allExt = "";
		for (int i = 0; i < Banco.reg1.contas.size(); i++) {
			allExt += Banco.reg1.getConta(i).toString() + "\n";
		}
		
		
	
		
		JLabel lblSuaMovimentacao = new JLabel("Contas cadastradas:");
		lblSuaMovimentacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSuaMovimentacao.setBounds(39, 32, 250, 14);
		contentPane.add(lblSuaMovimentacao);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 58, 374, 159);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea(allExt);
		scrollPane_1.setViewportView(textArea);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnOk.setBounds(242, 227, 89, 23);
		contentPane.add(btnOk);
		
		
		
	}
}
