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

public class RimuoviCategoria extends JFrame {

	Controllore controller;
	private JPanel contentPane;
	private JTextField textField;

	
	public RimuoviCategoria(Controllore cntrl) {
		controller = cntrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 202);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
		contentPane.setLayout(null);
		;
		
		JLabel lblNewLabel = new JLabel("Inserisci il titolo");
		lblNewLabel.setForeground(new Color(135, 206, 250));
		lblNewLabel.setBackground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 418, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 56, 406, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoria = textField.getText();
				if(controller.categoriaDAO.checkcategoria(categoria, btnNewButton)) {
					controller.categoriaDAO.rimuovicategoria(categoria, btnNewButton);
					textField.setText("");
					controller.rimuovicategoria.setVisible(false);
				}
				
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(128, 0, 153));
		btnNewButton.setIcon(new ImageIcon(RimuoviCategoria.class.getResource("/Swng/loghi/icons8-cancella-simbolo-40.png")));
		btnNewButton.setBounds(367, 106, 85, 49);
		contentPane.add(btnNewButton);
	}
}