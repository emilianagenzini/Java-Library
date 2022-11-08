package Swng;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllore.Controllore;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class Profilo extends JFrame {

	private JPanel contentPane;
  private Controllore controller;
  private JTextField txtcategoria;
	
	public Profilo(Controllore cntrl) {
		controller= cntrl; 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 0, 153));
		contentPane.setBackground(new Color(102, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.profilo.setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Profilo.class.getResource("/Swng/loghi/icons8-cerchiato-su-a-sinistra-2-40.png")));
		btnNewButton_2.setForeground(new Color(75, 0, 130));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(102, 0, 153));
		btnNewButton_2.setBounds(443, 512, 74, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Crea una nuova categoria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.creacategoria.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 19));
		btnNewButton.setIcon(new ImageIcon(Profilo.class.getResource("/Swng/loghi/icons8-aggiungi-cartella-40.png")));
		btnNewButton.setBounds(88, 32, 340, 56);
		contentPane.add(btnNewButton);
		
		JButton btnInserisciElementi = new JButton("Inserisci elementi");
		btnInserisciElementi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.inseriscititolo.setVisible(true);
				
			}
		});
		btnInserisciElementi.setIcon(new ImageIcon(Profilo.class.getResource("/Swng/loghi/icons8-aggiungi-40.png")));
		btnInserisciElementi.setForeground(new Color(75, 0, 130));
		btnInserisciElementi.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnInserisciElementi.setBorder(null);
		btnInserisciElementi.setBounds(10, 112, 242, 48);
		contentPane.add(btnInserisciElementi);
		
		JButton btnRimuoviElementi = new JButton("Rimuovi elementi");
		btnRimuoviElementi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.rimuovititolo.setVisible(true);
			}
		});
		btnRimuoviElementi.setIcon(new ImageIcon(Profilo.class.getResource("/Swng/loghi/icons8-bin-40.png")));
		btnRimuoviElementi.setForeground(new Color(75, 0, 130));
		btnRimuoviElementi.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnRimuoviElementi.setBorder(null);
		btnRimuoviElementi.setBounds(275, 112, 242, 48);
		contentPane.add(btnRimuoviElementi);
		
		JButton btnRimuoviUnaCategoria = new JButton("Rimuovi una categoria");
		btnRimuoviUnaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.rimuovicategoria.setVisible(true);
			}
		});
		btnRimuoviUnaCategoria.setIcon(new ImageIcon(Profilo.class.getResource("/Swng/loghi/icons8-elimina-cartella-40.png")));
		btnRimuoviUnaCategoria.setForeground(new Color(75, 0, 130));
		btnRimuoviUnaCategoria.setFont(new Font("Lucida Sans", Font.BOLD, 19));
		btnRimuoviUnaCategoria.setBorder(null);
		btnRimuoviUnaCategoria.setBounds(88, 184, 340, 56);
		contentPane.add(btnRimuoviUnaCategoria);
		
		JLabel lblLeMieCategoria = new JLabel("Le mie categorie:");
		lblLeMieCategoria.setForeground(new Color(135, 206, 250));
		lblLeMieCategoria.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		lblLeMieCategoria.setBackground(new Color(245, 255, 250));
		lblLeMieCategoria.setBounds(10, 284, 170, 36);
		contentPane.add(lblLeMieCategoria);
		
		JList list = new JList();
		list.setForeground(new Color(75, 0, 130));
		list.setBackground(new Color(176, 196, 222));
		list.setBounds(10, 319, 150, 184);
		contentPane.add(list);
		
		JButton btnNewButton_1 = new JButton("Mostra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.categoriaDAO.lemiecategorie(list);
			}
		});
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		btnNewButton_1.setBounds(41, 512, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTitoliCheFanno = new JLabel("Elementi Categoria:");
		lblTitoliCheFanno.setForeground(new Color(135, 206, 250));
		lblTitoliCheFanno.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		lblTitoliCheFanno.setBackground(new Color(245, 255, 250));
		lblTitoliCheFanno.setBounds(181, 284, 170, 36);
		contentPane.add(lblTitoliCheFanno);
		
		txtcategoria = new JTextField();
		txtcategoria.setBounds(362, 296, 140, 19);
		contentPane.add(txtcategoria);
		txtcategoria.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setForeground(new Color(75, 0, 130));
		list_1.setBackground(new Color(176, 196, 222));
		list_1.setBounds(190, 319, 314, 184);
		contentPane.add(list_1);
		
		JButton btnNewButton_1_1 = new JButton("Mostra");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoria = txtcategoria.getText();
						controller.categoriaDAO.elementicategoria(list_1, categoria);;
				}
		});
		btnNewButton_1_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1_1.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1_1.setBounds(297, 512, 85, 21);
		contentPane.add(btnNewButton_1_1);
	}
}
