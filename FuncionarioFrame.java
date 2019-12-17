package trab3POO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class FuncionarioFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField idadeField;
	private JTextField salarioField;
	private JButton btnEnviar;
	private JLabel lblStatusGravacao;
	private JButton btnVoltar;
	private JProgressBar pBar;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmHelp;

	/**
	 * Create the frame.
	 */
	public FuncionarioFrame() {
		setTitle("Cadastro de Funcionario");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmImprimir = new JMenuItem("Imprimir");
		mntmImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Pessoa.closeBuffer();
				} catch (Exception e1) {
					lblStatusGravacao.setText("Deu errado");
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mntmImprimir);
		
		mnHelp = new JMenu("Options");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about();
			}
		});
		mnHelp.add(mntmAbout);
		
		mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				help();
			}
		});
		mnHelp.add(mntmHelp);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{95, 321, 0};
		gbl_contentPane.rowHeights = new int[]{21, 21, 21, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		contentPane.add(lblNome, gbc_lblNome);
		
		nomeField = new JTextField();
		enterTrigger(nomeField);
		GridBagConstraints gbc_nomeField = new GridBagConstraints();
		gbc_nomeField.anchor = GridBagConstraints.NORTH;
		gbc_nomeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeField.insets = new Insets(0, 0, 5, 0);
		gbc_nomeField.gridx = 1;
		gbc_nomeField.gridy = 0;
		contentPane.add(nomeField, gbc_nomeField);
		nomeField.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		GridBagConstraints gbc_lblIdade = new GridBagConstraints();
		gbc_lblIdade.anchor = GridBagConstraints.WEST;
		gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdade.gridx = 0;
		gbc_lblIdade.gridy = 1;
		contentPane.add(lblIdade, gbc_lblIdade);
		
		idadeField = new JTextField();
		enterTrigger(idadeField);
		GridBagConstraints gbc_idadeField = new GridBagConstraints();
		gbc_idadeField.anchor = GridBagConstraints.NORTH;
		gbc_idadeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_idadeField.insets = new Insets(0, 0, 5, 0);
		gbc_idadeField.gridx = 1;
		gbc_idadeField.gridy = 1;
		contentPane.add(idadeField, gbc_idadeField);
		idadeField.setColumns(10);
		
		JLabel lblVa = new JLabel("Valor do salario:");
		GridBagConstraints gbc_lblVa = new GridBagConstraints();
		gbc_lblVa.anchor = GridBagConstraints.WEST;
		gbc_lblVa.insets = new Insets(0, 0, 5, 5);
		gbc_lblVa.gridx = 0;
		gbc_lblVa.gridy = 2;
		contentPane.add(lblVa, gbc_lblVa);
		
		salarioField = new JTextField();
		enterTrigger(salarioField);
		GridBagConstraints gbc_salarioField = new GridBagConstraints();
		gbc_salarioField.insets = new Insets(0, 0, 5, 0);
		gbc_salarioField.anchor = GridBagConstraints.NORTH;
		gbc_salarioField.fill = GridBagConstraints.HORIZONTAL;
		gbc_salarioField.gridx = 1;
		gbc_salarioField.gridy = 2;
		contentPane.add(salarioField, gbc_salarioField);
		salarioField.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadastrarFuncionario();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame MF = new MainFrame();
				MF.setVisible(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(0, 0, 5, 5);
		gbc_btnVoltar.gridx = 0;
		gbc_btnVoltar.gridy = 3;
		contentPane.add(btnVoltar, gbc_btnVoltar);
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnviar.gridx = 1;
		gbc_btnEnviar.gridy = 3;
		contentPane.add(btnEnviar, gbc_btnEnviar);
		
		pBar = new JProgressBar();
		pBar.setStringPainted(true);
		GridBagConstraints gbc_pBar = new GridBagConstraints();
		gbc_pBar.fill = GridBagConstraints.BOTH;
		gbc_pBar.insets = new Insets(0, 0, 5, 0);
		gbc_pBar.gridx = 1;
		gbc_pBar.gridy = 4;
		contentPane.add(pBar, gbc_pBar);
		
		lblStatusGravacao = new JLabel("");
		GridBagConstraints gbc_lblStatusGravacao = new GridBagConstraints();
		gbc_lblStatusGravacao.insets = new Insets(0, 0, 5, 0);
		gbc_lblStatusGravacao.gridx = 1;
		gbc_lblStatusGravacao.gridy = 5;
		contentPane.add(lblStatusGravacao, gbc_lblStatusGravacao);
	}
	public void enterTrigger(JTextField val) {
		val.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						cadastrarFuncionario();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	public void cadastrarFuncionario() throws Exception{
		Funcionario func = new Funcionario();
		String nome, idade, salario;
		nome = nomeField.getText();
		idade = idadeField.getText();
		salario = salarioField.getText();
		if(nome.equals("") || idade.equals("") || salario.equals("")) {
			lblStatusGravacao.setText("Ha dados vazios");
			JOptionPane.showMessageDialog(null, "Há campos vazios\nVerifique!", "Cliente Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			salario = salario.replace(",", ".");								//Fazendo o tratamento para valores de salario digitados com virgula, para que o programa consiga processar esses dados
			Funcionario.setNome(nome);
			Funcionario.setIdade(Integer.parseInt(idade));
			func.setValSalario(Float.parseFloat(salario));
			progressBar();
			Funcionario.cadastro.add(func);
//			Funcionario.armazenaBuffer();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "\nEntrada(s) invalida(s)\nDigite novamente", "Cliente Error", JOptionPane.ERROR_MESSAGE);
			lblStatusGravacao.setText("Falha na gravacao dos dados");
		}
	}
	Timer timer;
	private void progressBar() {
		ActionListener listener = new ActionListener() {
			int value = 0;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				value++;
				pBar.setValue(value);
				btnEnviar.setEnabled(false);
				nomeField.setEditable(false);
				idadeField.setEnabled(false);
				salarioField.setEnabled(false);
				if(value >= 100) {
					btnEnviar.setEnabled(true);
					nomeField.setEditable(true);
					idadeField.setEnabled(true);
					salarioField.setEnabled(true);
					lblStatusGravacao.setText("Dados gravados com sucesso");
					timer.stop();
					return;
				}
			}
		};
		timer = new Timer(10, listener);
		timer.start();
	}
	
	public void about() {
		JOptionPane.showMessageDialog(null, "Comeco do desenvolvimento: 06/12/2019" + "\n" +
											"Termino do desenvolvimento: 10/12/2019" + "\n" +
											"Versao: 1.0.1",
											"About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void help() {
		JOptionPane.showMessageDialog(null, "Para que o cadastro seja efetuado, digite o NOME do Cliente" + "\n" +
											"Para IDADE, digite apenas valores inteiros" + "\n" +
											"Para VALOR DO SALARIO digite qualquer valores reais",
											"FUNCIONARIO Help", JOptionPane.QUESTION_MESSAGE);
	}

}
