package Swng;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllore.Controllore;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RimuoviLibro extends JFrame {
	Controllore controller;
	private JPanel contentPane;
	private JTextField txt_titolo;

	
	public RimuoviLibro(Controllore cntrl) {
		controller = cntrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 202);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_titolo = new JTextField();
		txt_titolo.setBounds(10, 56, 418, 28);
		contentPane.add(txt_titolo);
		txt_titolo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inserisci il titolo che vuoi rimuovere");
		lblNewLabel.setForeground(new Color(135, 206, 250));
		lblNewLabel.setBackground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 418, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnRimuovi = new JButton("");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = txt_titolo.getText();
		if( controller.rimuovilibro(titolo, btnRimuovi)) {
		 setVisible(false);
		 txt_titolo.setText("");
		 } else setVisible(true);
			}
		});
		btnRimuovi.setBorder(null);
		btnRimuovi.setBackground(new Color(128,0,153));
		btnRimuovi.setIcon(new ImageIcon(RimuoviLibro.class.getResource("/Swng/loghi/icons8-cancella-simbolo-40.png")));
		btnRimuovi.setBounds(367, 112, 85, 43);
		contentPane.add(btnRimuovi);
	}
}
