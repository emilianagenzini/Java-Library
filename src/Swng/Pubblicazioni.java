package Swng;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllore.Controllore;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Pubblicazioni extends JFrame {

	private JPanel contentPane;
	private Controllore controller;
	private JTextField txtAutore;
	private JTextField txtDescrizione;
	
	
	public Pubblicazioni(Controllore cntrl) {
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
		
		JList list = new JList();
		list.setForeground(new Color(75, 0, 130));
		list.setBackground(new Color(176, 196, 222));
		list.setBounds(214, 35, 303, 505);
		contentPane.add(list);
		
		
		JButton btnNewButton = new JButton("Libro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*DefaultListModel DLM = new DefaultListModel();
				DLM.addElement("ciao");
				list.setModel(DLM); */ 
				controller.filtralibri(list);
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnNewButton.setBounds(27, 55, 134, 33);
		contentPane.add(btnNewButton);
		
		JButton btnIntervista = new JButton("Intervista");
		btnIntervista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.filtraintervista(list);
			}
		});
		btnIntervista.setForeground(new Color(75, 0, 130));
		btnIntervista.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnIntervista.setBorder(null);
		btnIntervista.setBackground(new Color(176, 196, 222));
		btnIntervista.setBounds(27, 98, 134, 33);
		contentPane.add(btnIntervista);
		
		JButton btnRivista = new JButton("Rivista");
		btnRivista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.filtrarivista(list);
			}
		});
		btnRivista.setForeground(new Color(75, 0, 130));
		btnRivista.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnRivista.setBorder(null);
		btnRivista.setBackground(new Color(176, 196, 222));
		btnRivista.setBounds(27, 141, 134, 33);
		contentPane.add(btnRivista);
		
		JButton btnConferenza = new JButton("Conferenza");
		btnConferenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.filtraconferenza(list);
			}
		});
		btnConferenza.setForeground(new Color(75, 0, 130));
		btnConferenza.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnConferenza.setBorder(null);
		btnConferenza.setBackground(new Color(176, 196, 222));
		btnConferenza.setBounds(27, 184, 134, 33);
		contentPane.add(btnConferenza);

		JButton btnRiferimentiBibliografici = new JButton("Bibliografia");
		btnRiferimentiBibliografici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.filtrabibliografia(list);
			}
		});
		btnRiferimentiBibliografici.setForeground(new Color(75, 0, 130));
		btnRiferimentiBibliografici.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnRiferimentiBibliografici.setBorder(null);
		btnRiferimentiBibliografici.setBackground(new Color(176, 196, 222));
		btnRiferimentiBibliografici.setBounds(27, 227, 134, 33);
		contentPane.add(btnRiferimentiBibliografici);
		
		JLabel lblNewLabel = new JLabel("Filtra per...");
		lblNewLabel.setForeground(new Color(176, 196, 222));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(27, 10, 134, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autore");
		lblNewLabel_1.setForeground(new Color(176, 196, 222));
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblNewLabel_1.setBounds(58, 258, 74, 33);
		contentPane.add(lblNewLabel_1);
		
		txtAutore = new JTextField();
		txtAutore.setBounds(27, 285, 134, 19);
		contentPane.add(txtAutore);
		txtAutore.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cerca");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String autore = txtAutore.getText();
				controller.filtraautore(list, autore);
			}
		});
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(47, 312, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descrizione");
		lblNewLabel_1_1.setForeground(new Color(176, 196, 222));
		lblNewLabel_1_1.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(47, 337, 114, 33);
		contentPane.add(lblNewLabel_1_1);
		
		txtDescrizione = new JTextField();
		txtDescrizione.setColumns(10);
		txtDescrizione.setBounds(27, 368, 134, 19);
		contentPane.add(txtDescrizione);
		
		JButton btnNewButton_1_1 = new JButton("Cerca");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descrizione = txtDescrizione.getText();
				controller.filtradescrizione(list, descrizione);
			}
		});
		btnNewButton_1_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1_1.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBounds(47, 392, 85, 21);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDescrizione.setText("");
				txtAutore.setText("");
				controller.pubblicazioni.setVisible(false);
			}
		});
		btnNewButton_2.setBackground(new Color(102, 0, 153));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setForeground(new Color(75, 0, 130));
		btnNewButton_2.setIcon(new ImageIcon(Pubblicazioni.class.getResource("/Swng/loghi/icons8-cerchiato-su-a-sinistra-2-40.png")));
		btnNewButton_2.setBounds(58, 499, 74, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Crescente");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ordinacrescente(list);
			}
		});
		btnNewButton_1_1_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1_1_1.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1_1_1.setBounds(10, 468, 85, 21);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Decrescente");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ordinadecrescente(list);
			}
		});
		btnNewButton_1_1_2.setForeground(new Color(75, 0, 130));
		btnNewButton_1_1_2.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnNewButton_1_1_2.setBorder(null);
		btnNewButton_1_1_2.setBackground(new Color(176, 196, 222));
		btnNewButton_1_1_2.setBounds(105, 469, 85, 21);
		contentPane.add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ordina per  n\u00B0 citazioni");
		lblNewLabel_1_1_1.setForeground(new Color(176, 196, 222));
		lblNewLabel_1_1_1.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 426, 194, 33);
		contentPane.add(lblNewLabel_1_1_1);
		
		
	}
}
