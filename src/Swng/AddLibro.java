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
import javax.swing.JTextPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;


public class AddLibro extends JFrame implements ActionListener {
	Controllore controller;
	

	private JPanel contentPane;
	private JTextField txt_titolo;
	private JTextField txt_numpag;
	private JButton btnInserisci;
	private JTextField txtdatainserimento;
	private JTextField txtdatapubblicazione;
	private JTextField txtAutore;
	private JTextField txtCita;
	
	public AddLibro(Controllore cntrl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setName("AddLibro");
		setTitle("AddLibro");
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
		lblDescrizione.setBounds(10, 80, 126, 25);
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
		lblDataPubblicazione.setBounds(153, 226, 148, 25);
		contentPane.add(lblDataPubblicazione);
		
		
		txtdatainserimento = new JTextField();
		txtdatainserimento.setBounds(10, 261, 132, 19);
		contentPane.add(txtdatainserimento);
		txtdatainserimento.setColumns(10);
		
		txtdatapubblicazione = new JTextField();
		txtdatapubblicazione.setColumns(10);
		txtdatapubblicazione.setBounds(152, 261, 149, 19);
		contentPane.add(txtdatapubblicazione);
		
		
		
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
		txtCita.setBounds(10, 381, 213, 25);
		contentPane.add(txtCita);
		
		JButton btnAutore = new JButton("");
		btnAutore.setEnabled(false);
		btnAutore.setBackground(new Color(102, 0, 153));
		btnAutore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = txt_titolo.getText();
				String autore = txtAutore.getText();
				if(autore.length()>0) {
					controller.libroDAO.inserisciautore(titolo, autore, btnAutore);
				} else {
					JOptionPane.showMessageDialog(btnAutore, "Il campo autore non può essere nullo");
				}
				
			}
		});
		btnAutore.setIcon(new ImageIcon(AddLibro.class.getResource("/Swng/loghi/icons8-add-34.png")));
		btnAutore.setBorder(null);
		btnAutore.setBounds(233, 310, 35, 48);
		contentPane.add(btnAutore);
		
		JButton btnRiferimenti = new JButton("");
		btnRiferimenti.setEnabled(false);
		btnRiferimenti.setBackground(new Color(102, 0, 153));
		btnRiferimenti.setIcon(new ImageIcon(AddLibro.class.getResource("/Swng/loghi/icons8-add-34.png")));
		btnRiferimenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = txt_titolo.getText();
				String cita = txtCita.getText();
				if(cita.length()>0 && controller.libroDAO.checkriferimento(titolo, cita, btnRiferimenti)) {
					controller.libroDAO.inserisciriferimento(titolo, cita, btnRiferimenti);
				} else {
					JOptionPane.showMessageDialog(btnAutore, "Il campo riferimenti non può essere nullo");
				}
			}
		});
		btnRiferimenti.setBorder(null);
		btnRiferimenti.setBounds(233, 368, 35, 48);
		contentPane.add(btnRiferimenti);
		
		JButton btnInserisci2 = new JButton("");
		btnInserisci2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = txt_titolo.getText();
				String autore = txtAutore.getText();
				String cita = txtCita.getText();
				if (controller.libroDAO.checkautore( titolo,autore,btnInserisci2 ) ) {
					JOptionPane.showMessageDialog(btnInserisci2, "Operazione andata buon fine");
					txtCita.setText("");
					txtAutore.setText("");
					txt_titolo.setText("");
					txtdatainserimento.setText("");
					txtdatapubblicazione.setText("");
					txt_numpag.setText("");
					controller.addlibro.setVisible(false);
				}
				
			}
		});
		btnInserisci2.setBackground(new Color(176, 196, 222));
		btnInserisci2.setBorder(null);
		btnInserisci2.setEnabled(false);
		btnInserisci2.setIcon(new ImageIcon(AddLibro.class.getResource("/Swng/loghi/icons8-aggiungi-40.png")));
		btnInserisci2.setBounds(313, 333, 65, 38);
		contentPane.add(btnInserisci2);
		
	
	JButton btnInserisci = new JButton("");
	btnInserisci.setBorder(null);
	btnInserisci.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Controllore controller = new Controllore();
			String titolo = txt_titolo.getText();
			String numpag = txt_numpag.getText();
			
            String descrizione = txt_descrizione.getText();
            String dins = txtdatainserimento.getText();
            String datapubblicazione = txtdatapubblicazione.getText();
            String autore = txtAutore.getText();
            String riferimento = txtCita.getText();
           if((controller.checktitolo(titolo, btnInserisci))&&
            (controller.checknumpag(numpag, btnInserisci)) &&
          
           (controller.checkdate(dins, datapubblicazione, btnInserisci))) {
        	   System.out.println("ok");
        	   controller.registralibro(titolo, numpag, descrizione, dins, datapubblicazione, btnInserisci);
        	   btnAutore.setEnabled(true);
        	   btnRiferimenti.setEnabled(true);
        	   btnInserisci2.setEnabled(true);
        	   //controller.addlibro.setVisible(false);
           }
               
		}    	
	});
	btnInserisci.setBackground(new Color(176, 196, 222));
	btnInserisci.setIcon(new ImageIcon(AddLibro.class.getResource("/Swng/loghi/icons8-aggiungi-40.png")));
	btnInserisci.setForeground(new Color(135, 206, 250));
	btnInserisci.setFont(new Font("Lucida Sans", Font.BOLD, 17));
	btnInserisci.setBounds(313, 242, 65, 38);
	contentPane.add(btnInserisci);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
	
	}
}
