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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Controllore.Controllore;
import javax.swing.JCheckBox;


public class AddArticoloScientifico extends JFrame implements ActionListener {
	Controllore controller;
	

	private JPanel contentPane;
	private JTextField txt_titolo;
	private JTextField txt_numpag;
	private JButton btnInserisci;
	private JTextField txt_datainserimento;
	private JTextField txt_datapubblicazione;
	private JTextField txtAutore;
	private JTextField txtCita;
	private JTextField txtTipo;

	public AddArticoloScientifico(Controllore cntrl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setName("AddArticoloScientifico");
		setTitle("AddArticoloScientifico");
		controller = cntrl;
		setResizable(false);
       setBounds(10, 10, 400, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 0, 153));
		contentPane.setBackground(new Color(102, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_titolo = new JTextField();
		txt_titolo.setBorder(null);
		txt_titolo.setBounds(10, 28, 213, 25);
		contentPane.add(txt_titolo);
		txt_titolo.setColumns(10);
		
		JLabel lblTitolo = new JLabel("Titolo");
		lblTitolo.setForeground(new Color(135, 206, 235));
		lblTitolo.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblTitolo.setBounds(10, 10, 69, 13);
		contentPane.add(lblTitolo);
		
		
		
		txt_numpag = new JTextField();
		txt_numpag.setBorder(null);
		txt_numpag.setBounds(252, 28, 110, 25);
		contentPane.add(txt_numpag);
		txt_numpag.setColumns(10);
		
		JLabel lblTitolo_1 = new JLabel("Numero pagine");
		lblTitolo_1.setForeground(new Color(135, 206, 235));
		lblTitolo_1.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblTitolo_1.setBounds(252, 5, 126, 23);
		contentPane.add(lblTitolo_1);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setForeground(new Color(135, 206, 235));
		lblDescrizione.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblDescrizione.setBounds(10, 92, 126, 25);
		contentPane.add(lblDescrizione);
		
		JTextPane txt_descrizione = new JTextPane();
		txt_descrizione.setBounds(10, 115, 366, 85);
		contentPane.add(txt_descrizione);
		
		JLabel lblDataInserimento = new JLabel("Data Inserimento");
		lblDataInserimento.setForeground(new Color(135, 206, 235));
		lblDataInserimento.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblDataInserimento.setBounds(10, 226, 148, 25);
		contentPane.add(lblDataInserimento);
		
		JLabel lblDataPubblicazione = new JLabel("Data Pubblicazione");
		lblDataPubblicazione.setForeground(new Color(135, 206, 235));
		lblDataPubblicazione.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblDataPubblicazione.setBounds(149, 226, 165, 25);
		contentPane.add(lblDataPubblicazione);
		
		txt_datainserimento = new JTextField();
		txt_datainserimento.setColumns(10);
		txt_datainserimento.setBounds(10, 261, 126, 19);
		contentPane.add(txt_datainserimento);
		
		txt_datapubblicazione = new JTextField();
		txt_datapubblicazione.setColumns(10);
		txt_datapubblicazione.setBounds(149, 261, 139, 19);
		contentPane.add(txt_datapubblicazione);
		JLabel lblAutore = new JLabel("Autore");
		lblAutore.setForeground(new Color(135, 206, 235));
		lblAutore.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblAutore.setBounds(10, 301, 69, 13);
		contentPane.add(lblAutore);
		
		JLabel lblCita = new JLabel("Riferimenti ");
		lblCita.setForeground(new Color(135, 206, 235));
		lblCita.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblCita.setBounds(10, 358, 185, 13);
		contentPane.add(lblCita);
		
		

		txtAutore = new JTextField();
		txtAutore.setColumns(10);
		txtAutore.setBorder(null);
		txtAutore.setBounds(10, 323, 213, 25);
		contentPane.add(txtAutore);
		
		txtCita = new JTextField();
		txtCita.setColumns(10);
		txtCita.setBorder(null);
		txtCita.setBounds(10, 376, 213, 25);
		contentPane.add(txtCita);
		
		JButton btnAutore = new JButton("");
		btnAutore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = txt_titolo.getText();
				String autore = txtAutore.getText();
				if(autore.length()>0) {
					controller.articoloDAO.inserisciautore(titolo, autore, btnAutore);
				} else {
					JOptionPane.showMessageDialog(btnAutore, "Il campo autore non può essere nullo");
				}
				
			}
		});
		btnAutore.setIcon(new ImageIcon(AddIntervista.class.getResource("/Swng/loghi/icons8-add-34.png")));
		btnAutore.setEnabled(false);
		btnAutore.setBorder(null);
		btnAutore.setBackground(new Color(102, 0, 153));
		btnAutore.setBounds(230, 311, 35, 48);
		contentPane.add(btnAutore);
		
		JButton btnRiferimenti = new JButton("");
		btnRiferimenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = txt_titolo.getText();
				String cita = txtCita.getText();
				if(cita.length()>0  && controller.articoloDAO.checkriferimento(titolo, cita, btnRiferimenti)) {
					controller.articoloDAO.inserisciriferimento(titolo, cita, btnRiferimenti);
				} else {
					JOptionPane.showMessageDialog(btnAutore, "Il campo riferimenti non può essere nullo");
				}
			}
		});
		btnRiferimenti.setIcon(new ImageIcon(AddIntervista.class.getResource("/Swng/loghi/icons8-add-34.png")));
		btnRiferimenti.setEnabled(false);
		btnRiferimenti.setBorder(null);
		btnRiferimenti.setBackground(new Color(102, 0, 153));
		btnRiferimenti.setBounds(233, 367, 35, 48);
		contentPane.add(btnRiferimenti);
		
		JButton btnInserisci2 = new JButton("");
		btnInserisci2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = txt_titolo.getText();
				String autore = txtAutore.getText();
				String cita = txtCita.getText();
				if (controller.articoloDAO.checkautore( titolo,autore,btnInserisci2 )) {
					JOptionPane.showMessageDialog(btnInserisci2, "Operazione andata buon fine");
					txtCita.setText("");
					txtAutore.setText("");
					txt_titolo.setText("");
					txt_datainserimento.setText("");
					txt_datapubblicazione.setText("");
					txt_numpag.setText("");
					txtTipo.setText("");
					controller.as.setVisible(false);
				}
				
			}
		});
		btnInserisci2.setIcon(new ImageIcon(AddIntervista.class.getResource("/Swng/loghi/icons8-aggiungi-40.png")));
		btnInserisci2.setBorder(null);
		btnInserisci2.setEnabled(false);
		btnInserisci2.setBackground(new Color(176, 196, 222));
		btnInserisci2.setBounds(313, 333, 65, 38);
		contentPane.add(btnInserisci2);
        String tipo;

		
		
		
		JLabel lbltipo = new JLabel("Tipo");
		lbltipo.setForeground(new Color(135, 206, 235));
		lbltipo.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lbltipo.setBounds(10, 63, 69, 19);
		contentPane.add(lbltipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(57, 63, 166, 19);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		 btnInserisci = new JButton("");
			btnInserisci.setBorder(null);
			btnInserisci.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String titolo = txt_titolo.getText();
					String numpag = txt_numpag.getText();
					
		            String descrizione = txt_descrizione.getText();
		            String dins = txt_datainserimento.getText();
		            String datapubblicazione = txt_datapubblicazione.getText();
		            String autore = txtAutore.getText();
		            String riferimento = txtCita.getText();
		            String tipo =txtTipo.getText();
		           if((controller.checktitolo(titolo, btnInserisci))&&
		            (controller.checknumpagart(numpag, btnInserisci)) &&
		          
		           (controller.checkdate(dins, datapubblicazione, btnInserisci))) {
		        	   System.out.println("ok");
		        	   controller.registraarticolo(titolo, numpag, descrizione, dins, datapubblicazione,tipo, btnInserisci);
		        	   btnAutore.setEnabled(true);
		        	   btnRiferimenti.setEnabled(true);
		        	   btnInserisci2.setEnabled(true);
		           }
	        			}    	
	        		});
	               
				
			
			btnInserisci.setBackground(new Color(119, 136, 153));
			btnInserisci.setIcon(new ImageIcon(AddLibro.class.getResource("/Swng/loghi/icons8-aggiungi-40.png")));
			btnInserisci.setForeground(new Color(135, 206, 250));
			btnInserisci.setFont(new Font("Lucida Sans", Font.BOLD, 17));
			btnInserisci.setBounds(311, 245, 67, 38);
			contentPane.add(btnInserisci);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
   

    