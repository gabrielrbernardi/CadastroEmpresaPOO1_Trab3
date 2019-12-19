/*****************************************************************
 * Nome do projeto: 			  Trab3POO                       *
 * Nome, tipo de aquivo:		  MainFrame, JFrame              *
 * Autor(es): 					  Gabriel Ribeiro Bernardi,      *
 * 								  Guilherme Soares Correa,       *
 * 								  Antonio Pedro Rodrigues Santos *
 * Matricula: 					  11821BCC036                    *
 * 								  11821BCC026				     *
 * 								  11821BCC021		    	     *
 * Data de inicio: 				  06/12/2019				     *
 * Data final de desenvolvimento: 18/12/2019      		         *
 * Data da ultima modificacao: 	  18/12/2019				     *
 * Dias de desenvolvimento:       13                             *
 * Linguagem utilizada:			  Java						     *
 * Plataforma Java utilizada:     Java SE Development Kit 13     *
 ****************************************************************/

package trab3POO;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Component OutFileFrame = null;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnCliente;
	private JRadioButton rdbtnFuncionario;
	private JRadioButton rdbtnFornecedor;
	private JLabel lblStatusGravacao;
	private File file;
	private JMenuItem mntmImprimir;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Inicio");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOutpuFile = new JMenuItem("Output File");
		mntmOutpuFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Escolha o arquivo de saida");
//				File file1 = "/home/gabriel/UFU/3 periodo/POO/Trab3POO/src/";
				fc.setCurrentDirectory(new File (System.getProperty("user.home") + "/UFU/3 periodo/POO/Trab3POO/src/"));		//Pasta default de saida para melhorar a UX, pode ser customizada
				int returnVal = fc.showOpenDialog(OutFileFrame);				// Abrindo janela para selecao do arquivo de saida
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					Pessoa.setNomeArquivoOut(file);
					JOptionPane.showMessageDialog(null, "O arquivo de saida foi alterado", "Informacao", JOptionPane.INFORMATION_MESSAGE);
				}else if(returnVal == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "O arquivo de saida nao foi alterado", "Warning", JOptionPane.WARNING_MESSAGE);
				}
//				setVisible(false);
//				OutFileFrame OFF = new OutFileFrame();
//				OFF.setVisible(true);
			}
		});
		
		mntmImprimir = new JMenuItem("Imprimir");								//Botao utilizado para imprimir dados no arquivo de saida
		mnFile.add(mntmImprimir);
		mntmImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pessoa.armazenaBuffer();
				} catch (Exception e) {											// Exception para caso de erro na impressao do arquivo
					JOptionPane.showMessageDialog(null, e + "\n" + "Erro na impressao\n", "Error", JOptionPane.ERROR_MESSAGE);
					lblStatusGravacao.setText("Deu errado");
//					e.printStackTrace();
				}
			}
		});
		mnFile.add(mntmOutpuFile);
		
		JMenu mnHelp = new JMenu("Options");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						// JMenuItem para seccao about
				about();
			}
		});
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmHelp = new JMenuItem("Help");								// JMenuItem para seccao about
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				help();
			}
		});
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{63, 0, 68, 96, 92, 0};
		gbl_contentPane.rowHeights = new int[]{17, 25, 27, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblPessoa = new JLabel("Selecione o tipo de cadastro:");
		GridBagConstraints gbc_lblPessoa = new GridBagConstraints();
		gbc_lblPessoa.anchor = GridBagConstraints.NORTH;
		gbc_lblPessoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblPessoa.gridwidth = 2;
		gbc_lblPessoa.gridx = 1;
		gbc_lblPessoa.gridy = 0;
		contentPane.add(lblPessoa, gbc_lblPessoa);
		
		rdbtnCliente = new JRadioButton("Cliente");
		enterTrigger(rdbtnCliente);
		buttonGroup.add(rdbtnCliente);
		GridBagConstraints gbc_rdbtnCliente = new GridBagConstraints();
		gbc_rdbtnCliente.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnCliente.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCliente.gridx = 1;
		gbc_rdbtnCliente.gridy = 1;
		contentPane.add(rdbtnCliente, gbc_rdbtnCliente);
		
		rdbtnFuncionario = new JRadioButton("Funcionário");
		enterTrigger(rdbtnFuncionario);
		buttonGroup.add(rdbtnFuncionario);
		GridBagConstraints gbc_rdbtnFuncionario = new GridBagConstraints();
		gbc_rdbtnFuncionario.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnFuncionario.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFuncionario.gridx = 2;
		gbc_rdbtnFuncionario.gridy = 1;
		contentPane.add(rdbtnFuncionario, gbc_rdbtnFuncionario);
		
		rdbtnFornecedor = new JRadioButton("Fornecedor");
		enterTrigger(rdbtnFornecedor);
		buttonGroup.add(rdbtnFornecedor);
		GridBagConstraints gbc_rdbtnFornecedor = new GridBagConstraints();
		gbc_rdbtnFornecedor.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFornecedor.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnFornecedor.gridx = 3;
		gbc_rdbtnFornecedor.gridy = 1;
		contentPane.add(rdbtnFornecedor, gbc_rdbtnFornecedor);
		
		JButton btnSubmit = new JButton("Enviar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			submitForm();
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.anchor = GridBagConstraints.NORTH;
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 2;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
		JButton btnImprimir = new JButton("Imprimir");							// Botao sera habilitado somente para testes
		btnImprimir.setEnabled(false);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pessoa.armazenaBuffer();
				} catch (Exception e) {											// Exception para caso de erro na impressao do arquivo
					JOptionPane.showMessageDialog(null, e + "\n" + "Erro na impressao\n", "Error", JOptionPane.ERROR_MESSAGE);
					lblStatusGravacao.setText("Deu errado");
//					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.insets = new Insets(0, 0, 5, 5);
		gbc_btnImprimir.gridx = 2;
		gbc_btnImprimir.gridy = 3;
		contentPane.add(btnImprimir, gbc_btnImprimir);
		
		lblStatusGravacao = new JLabel("");
		GridBagConstraints gbc_lblStatusGravacao = new GridBagConstraints();
		gbc_lblStatusGravacao.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatusGravacao.gridx = 1;
		gbc_lblStatusGravacao.gridy = 4;
		contentPane.add(lblStatusGravacao, gbc_lblStatusGravacao);
	}
	
	public void enterTrigger(JRadioButton val) {
		val.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					submitForm();
				}
			}
		});
	}
	
	public void submitForm() {													// Conforme for selecionado o tipo de cadastro, o programa ira redirecionaro o usuario para o cadastramento correto
		if(rdbtnCliente.isSelected()) {
			setVisible(false);													// Janela atual eh 'destruida'
			ClienteFrame CF = new ClienteFrame();
			CF.setVisible(true);
		}else if(rdbtnFuncionario.isSelected()) {
			setVisible(false);
			FuncionarioFrame FF = new FuncionarioFrame();
			FF.setVisible(true);
		}else if(rdbtnFornecedor.isSelected()) {
			setVisible(false);
			FornecedorFrame FF = new FornecedorFrame();
			FF.setVisible(true);
		}else {																	// Erro gerado para caso nao tenha sido selecionado nenhum tipo de cadastro
			JOptionPane.showMessageDialog(null, "Selecione o tipo de cadastro!", "Main Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void about() {
		JOptionPane.showMessageDialog(null, "Comeco do desenvolvimento: 06/12/2019" + "\n" +
											"Termino do desenvolvimento: 18/12/2019" + "\n" +
											"Versao: 1.0.1",
											"About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void help() {
		JOptionPane.showMessageDialog(null, "Selecione o tipo de cadastro que deseja fazer" + "\n" +
											"Após isso, preencha os dados" + "\n" +
											"Quantidade de impressoes permitidas: 1", 
											"Help", JOptionPane.QUESTION_MESSAGE);
	}
}
