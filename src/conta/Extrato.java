package conta;

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

public class Extrato extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Extrato frame = new Extrato();
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
	public Extrato() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String extrato[] = Banco.contaLogada.getExtrato2();
		String allExt = "";
		for (int i = 0; i < extrato.length; i++) {
			if (extrato[i] == null){
				break;
			}
			else
				allExt += extrato[i] + "\n";
		}
		
		
		Menu2.opcao1.setEnabled(false);
		Menu2.opcao2.setEnabled(false);
		Menu2.opcao3.setEnabled(false);
		Menu2.opcao4.setEnabled(false);
		Menu2.opcao5.setEnabled(false);
		Menu2.opcao6.setEnabled(false);
		Menu2.opcao7.setEnabled(false);
		Menu2.opcao8.setEnabled(false);

		
		JLabel lblSuaMovimentacao = new JLabel("Sua movimentacao:");
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
		btnOk.setBounds(242, 227, 89, 23);
		contentPane.add(btnOk);
		
		
		
	}
}
