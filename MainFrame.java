package trab3POO;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Inicio");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Options");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about();
			}
		});
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				help();
			}
		});
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][][]", "[::20px,grow][][][][][]"));
		
		JLabel lblPessoa = new JLabel("Selecione o tipo de cadastro:");
		contentPane.add(lblPessoa, "cell 1 0");
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		buttonGroup.add(rdbtnCliente);
		contentPane.add(rdbtnCliente, "flowx,cell 1 1");
		
		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionário");
		buttonGroup.add(rdbtnFuncionario);
		contentPane.add(rdbtnFuncionario, "cell 1 1");
		
		JRadioButton rdbtnFornecedor = new JRadioButton("Fornecedor");
		buttonGroup.add(rdbtnFornecedor);
		contentPane.add(rdbtnFornecedor, "cell 1 1");
		
		JButton btnSubmit = new JButton("Enviar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnCliente.isSelected()) {
//					JOptionPane.showMessageDialog(null, "Foi selecionado: Cliente");
					setVisible(false);
//					LoginFrame LF = new LoginFrame();
//					LF.setVisible(true);
					ClienteFrame CF = new ClienteFrame();
					CF.setVisible(true);
				}else if(rdbtnFuncionario.isSelected()) {
//					JOptionPane.showMessageDialog(null, "Foi selecionado: Funcionario");
					setVisible(false);
					FuncionarioFrame FF = new FuncionarioFrame();
					FF.setVisible(true);
				}else if(rdbtnFornecedor.isSelected()) {
					setVisible(false);
					FornecedorFrame FF = new FornecedorFrame();
					FF.setVisible(true);
//					JOptionPane.showMessageDialog(null, "Foi selecionado: Fornecedor");
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o tipo de cadastro!", "Main Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnSubmit, "cell 1 2,alignx center");
	}
	public void about() {
		JOptionPane.showMessageDialog(null, "Comeco do desenvolvimento: 06/12/2019" + "\n" +
											"Termino do desenvolvimento: 07/12/2019" + "\n" +
											"Versao: 1.0.1",
											"About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void help() {
		JOptionPane.showMessageDialog(null, "Primeiramente faca o login na plataforma" + "\n" + 
											"Depois selecione o tipo de cadastro que deseja fazer" + "\n" +
											"Após isso, preencha os dados", 
											"Help", JOptionPane.QUESTION_MESSAGE);
	}
}
