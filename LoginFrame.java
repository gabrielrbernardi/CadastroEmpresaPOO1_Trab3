/*****************************************************************
 * Nome do projeto: 			  Trab3POO                       *
 * Nome, tipo de aquivo:		  LoginFrame, JFrame             *
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

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Component OutFileFrame = null;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblStatusLogin;
	private JLabel statusLogin;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JMenuItem mntmTeste;
	private File file;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Login");
		
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
		
		mntmTeste = new JMenuItem("Login Teste");
		mntmTeste.setEnabled(true);												// MenuItem de teste desabilitado por padrao, sera habilitado somente para testes
		mntmTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				selectFile();
				Pessoa.setNomeArquivoOut(new File("/home/gabriel/UFU/3 periodo/POO/Trab3POO/src/out.txt"));
				MainFrame MF = new MainFrame();
				MF.setVisible(true);
				setVisible(false);
			}
		});
		mnHelp.add(mntmTeste);
//		GridBagConstraints gbc_mntmTeste = new GridBagConstraints();
//		gbc_mntmTeste.insets = new Insets(0, 0, 5, 5);
//		gbc_mntmTeste.gridx = 2;
//		gbc_mntmTeste.gridy = 2;
//		contentPane.add(mntmTeste, gbc_mntmTeste);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 146, 30, 0, 0, 114, 0};
		gbl_contentPane.rowHeights = new int[] {15, 0, 0, 0, 15, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		usernameField = new JTextField();
		enterTrigger(usernameField);
		usernameField.requestFocus();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.gridwidth = 3;
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.anchor = GridBagConstraints.NORTH;
		gbc_usernameField.gridx = 1;
		gbc_usernameField.gridy = 0;
		contentPane.add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.anchor = GridBagConstraints.WEST;
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 1;
		contentPane.add(lblSenha, gbc_lblSenha);
		
		passwordField = new JPasswordField();
		enterTrigger(passwordField);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		contentPane.add(passwordField, gbc_passwordField);
		
		btnLogin = new JButton("Login");
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 2;
		contentPane.add(btnLogin, gbc_btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		
		lblStatusLogin = new JLabel("Status Login:");
		GridBagConstraints gbc_lblStatusLogin = new GridBagConstraints();
		gbc_lblStatusLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatusLogin.gridx = 1;
		gbc_lblStatusLogin.gridy = 3;
		contentPane.add(lblStatusLogin, gbc_lblStatusLogin);
		
		statusLogin = new JLabel("Nao conectado");
		GridBagConstraints gbc_statusLogin = new GridBagConstraints();
		gbc_statusLogin.insets = new Insets(0, 0, 5, 5);
		gbc_statusLogin.gridx = 2;
		gbc_statusLogin.gridy = 3;
		contentPane.add(statusLogin, gbc_statusLogin);
	}
	
	public void enterTrigger(JTextField val) {
		val.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
	}
	
	public void login() {
		String usr = usernameField.getText();
		String pwd = new String(passwordField.getPassword());
		String correctUsr = "admin";											// String usada para autenticacao de usuario no sistema
		String correctPwd = "admin";											// String usada para autenticacao de senha no sistema
		if(usr.equals(correctUsr) && pwd.equals(correctPwd)) {
			selectFile();
//			statusLogin.setText("Conectado");
//			setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos\nDigite novamente", "Error Login", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void selectFile() {													// Metodo usado para fazer a selecao do arquivo de saida de dados
		setVisible(false);
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Escolha o arquivo de saida");
//		File file1 = "/home/gabriel/UFU/3 periodo/POO/Trab3POO/src/";
		fc.setCurrentDirectory(new File (System.getProperty("user.home") + "/UFU/3 periodo/POO/Trab3POO/src/"));		// Diretorio padrao para arquivo de saida
		int returnVal = fc.showOpenDialog(OutFileFrame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			Pessoa.setNomeArquivoOut(file);
		}else if(returnVal == JFileChooser.CANCEL_OPTION) {						// Se arquivo de saida nao for escolhido, nao sera possivel prosseguir com o sistema. E necessario que escolha um arquivo para a saida de dados
			JOptionPane.showMessageDialog(null, "Nao e possivel continuar sem escolher um arquivo de saída", "Fatal Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		MainFrame MF = new MainFrame();
		MF.setVisible(true);
	}
	
	public void about() {
		JOptionPane.showMessageDialog(null, "Comeco do desenvolvimento: 06/12/2019" + "\n" +
											"Termino do desenvolvimento: 18/12/2019" + "\n" +
											"Versao: 1.0.1",
											"About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void help() {
		JOptionPane.showMessageDialog(null, "Primeiramente faca o login na plataforma" + "\n" + 
											"Usuario padrao: admin" + "\n" + "Senha padrao: admin" + "\n" +
											"Apos isso, selecione um arquivo para a saida/impressao dos dados" + "\n" +
											"Depois selecione o tipo de cadastro que deseja fazer" + "\n" +
											"Após isso, preencha os dados", 
											"Help", JOptionPane.QUESTION_MESSAGE);
	}
}
