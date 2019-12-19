/*****************************************************************
 * Nome do projeto: 			  Trab3POO                       *
 * Nome, tipo de aquivo:		  OutFileFrame, JFrame           *
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

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;

public class OutFileFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OutFileFrame() {
		setTitle("Out File");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JFileChooser fileChooser = new JFileChooser();
		contentPane.add(fileChooser, BorderLayout.CENTER);
	}

}
