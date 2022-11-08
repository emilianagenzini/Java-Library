package Swng;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllore.Controllore;

public class RimuoviTitolo extends JFrame {

	private JPanel contentPane;

	
	
		Controllore controller;
		private JTextField textField;
		private JTextField textField_1;
	
		
		public RimuoviTitolo(Controllore cntrl) {
			controller = cntrl;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 476, 202);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(128, 0, 153));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
			contentPane.setLayout(null);
			;
			
			JLabel lblNewLabel = new JLabel("Inserisci il titolo della categoria");
			lblNewLabel.setForeground(new Color(135, 206, 250));
			lblNewLabel.setBackground(new Color(245, 255, 250));
			lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 17));
			lblNewLabel.setBounds(10, 10, 418, 36);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(10, 42, 406, 19);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblInserisciIlTitolo = new JLabel("Inserisci il titolo del riferimento");
			lblInserisciIlTitolo.setForeground(new Color(135, 206, 250));
			lblInserisciIlTitolo.setFont(new Font("Lucida Sans", Font.BOLD, 17));
			lblInserisciIlTitolo.setBackground(new Color(245, 255, 250));
			lblInserisciIlTitolo.setBounds(10, 62, 418, 36);
			contentPane.add(lblInserisciIlTitolo);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(10, 93, 406, 19);
			contentPane.add(textField_1);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String categoria = textField.getText();
					String titolo = textField_1.getText(); 
					if((controller.checkriferimento(titolo,btnNewButton)) && (controller.categoriaDAO.checkcategoria(categoria, btnNewButton))){
						
						
						controller.categoriaDAO.rimuovi_riferimento(categoria, titolo, btnNewButton);
						textField_1.setText("");
						textField.setText("");
						controller.rimuovititolo.setVisible(false);
					}
					
					
				}
			});
			btnNewButton.setIcon(new ImageIcon(RimuoviTitolo.class.getResource("/Swng/loghi/icons8-cancella-simbolo-40.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(128, 0, 153));
			btnNewButton.setBounds(379, 112, 83, 53);
			contentPane.add(btnNewButton);
	
	}
	}
	



