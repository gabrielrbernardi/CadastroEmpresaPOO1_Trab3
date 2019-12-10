package trab3POO;

import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class FornecedorFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField idadeField;
	private JTextField avaliacaoField;
	private JLabel lblStatusGravacao;
	private JProgressBar pBar;
	private JButton btnEnviar;

	/**
	 * Create the frame.
	 */
	public FornecedorFrame() {
		setTitle("Cadastro de Fornecedor");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{120, 307, 0};
		gbl_contentPane.rowHeights = new int[]{21, 21, 21, 27, 0, 0, 0, 0};
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
		gbc_idadeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_idadeField.insets = new Insets(0, 0, 5, 0);
		gbc_idadeField.gridx = 1;
		gbc_idadeField.gridy = 1;
		contentPane.add(idadeField, gbc_idadeField);
		idadeField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Indice de qualidade");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainFrame MF = new MainFrame();
				MF.setVisible(true);
			}
		});
		
		avaliacaoField = new JTextField();
		GridBagConstraints gbc_avaliacaoField = new GridBagConstraints();
		gbc_avaliacaoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_avaliacaoField.insets = new Insets(0, 0, 5, 0);
		gbc_avaliacaoField.gridx = 1;
		gbc_avaliacaoField.gridy = 2;
		contentPane.add(avaliacaoField, gbc_avaliacaoField);
		avaliacaoField.setColumns(10);
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(0, 0, 5, 5);
		gbc_btnVoltar.gridx = 0;
		gbc_btnVoltar.gridy = 3;
		contentPane.add(btnVoltar, gbc_btnVoltar);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				qualidadeField.getSelectedItem();
				cadastrarFornecedor();
			}
		});
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnviar.gridx = 1;
		gbc_btnEnviar.gridy = 3;
		contentPane.add(btnEnviar, gbc_btnEnviar);
				
		pBar = new JProgressBar();
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
					cadastrarFornecedor();
				}
			}
		});
	}
	
	public void cadastrarFornecedor() {
		Funcionario func = new Funcionario();
		String nome, idade, avaliacao;
		nome = nomeField.getText();
		idade = idadeField.getText();
		avaliacao = avaliacaoField.getText();
		if(nome.equals("") || idade.equals("") || avaliacao.equals("")) {
			lblStatusGravacao.setText("Ha dados vazios");
			JOptionPane.showMessageDialog(null, "Há campos vazios\nVerifique!", "Cliente Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			func.setNome(nome);
			func.setIdade(Integer.parseInt(idade));
			func.setValSalario(Integer.parseInt(avaliacao));
			progressBar();
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
				if(value >= 100) {
					btnEnviar.setEnabled(true);
					lblStatusGravacao.setText("Dados gravados com sucesso");
					timer.stop();
					return;
				}
			}
		};
		timer = new Timer(10, listener);
		timer.start();
	}

}
