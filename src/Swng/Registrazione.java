package Swng;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controllore.Controllore;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registrazione extends JFrame implements ActionListener {
      
	private boolean nascondi = true;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtnome;
	private JTextField txtnome2;
	private JPasswordField txtpassword;
	private JPasswordField txtpassword2;
	private Controllore controller;
 
	Login login = new Login(controller);
	
	public Registrazione(Controllore cntrl) {
       
		setName("Registrazione");
		setTitle("Registrazione");
		controller = cntrl;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 0, 153));
		contentPane.setBackground(new Color(102, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnRegistrazione = new JButton("ACCEDI!");
		contentPane.add(btnRegistrazione);
		JPanel panel_username = new JPanel();
		panel_username.setBackground(new Color(102, 0, 153)); // COLORE NOME
		panel_username.setBounds(110, 228, 330, 40);
		contentPane.add(panel_username);
		panel_username.setLayout(null);

		txtnome2 = new JTextField();
		txtnome2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtnome2.setBackground(new Color(255, 255, 255));
		txtnome2.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtnome2.setForeground(new Color(0, 0, 102));
		txtnome2.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		txtnome2.setText("USERNAME");
		txtnome2.setBounds(10, 10, 285, 22);
		panel_username.add(txtnome2);
		txtnome2.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 0, 153));
		panel_1.setBounds(110, 360, 330, 40);
		contentPane.add(panel_1);

		txtpassword2 = new JPasswordField();
		txtpassword2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtpassword2.setBorder(null);
		txtpassword2.setBounds(7, 11, 291, 19);
		panel_1.add(txtpassword2);

		JPanel panel_password = new JPanel();
		panel_password.setBorder(null);
		panel_password.setLayout(null);
		panel_password.setBackground(new Color(102, 0, 153));
		panel_password.setBounds(110, 297, 330, 40);
		contentPane.add(panel_password);

		txtpassword = new JPasswordField();
		txtpassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtpassword.setBounds(10, 10, 289, 19);

		panel_password.add(txtpassword);

		JLabel lblNOME = new JLabel("Library");
		lblNOME.setForeground(new Color(51, 153, 204));
		lblNOME.setFont(new Font("Garamond", Font.BOLD | Font.ITALIC, 60));
		lblNOME.setBounds(158, 82, 282, 134);
		contentPane.add(lblNOME);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Registrazione.class.getResource("/Swng/loghi/logo.png")));
		lblNewLabel.setBounds(198, 51, 169, 73);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(60, 228, 45, 40);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Registrazione.class.getResource("/Swng/loghi/user.png")));

		JCheckBox check = new JCheckBox("");
		check.setBounds(60, 297, 44, 40);
		contentPane.add(check);
		check.setIcon(new ImageIcon(Registrazione.class.getResource("/Swng/loghi/password.png")));
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check.isSelected()) {
					txtpassword.setEchoChar((char) 0);

				} else {
					txtpassword.setEchoChar('*');

				}

			}
		});
		check.setFont(new Font("Tahoma", Font.PLAIN, 10));
		check.setBackground(new Color(102, 0, 153));

		JCheckBox check2 = new JCheckBox("");
		check2.setBounds(60, 360, 44, 40);
		contentPane.add(check2);
		check2.setIcon(new ImageIcon(Registrazione.class.getResource("/Swng/loghi/password.png")));
		check2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check2.isSelected()) {

					txtpassword2.setEchoChar((char) 0);

				} else {

					txtpassword2.setEchoChar('*');
				}

			}
		});
		check2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		check2.setBackground(new Color(102, 0, 153));

		//JButton btnRegistrazione = new JButton("ACCEDI!");
		btnRegistrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtnome2.getText();
				String pwd = txtpassword.getText();
				String pwd2 = txtpassword2.getText();

				 if (controller.registrautente(nome, pwd, pwd2, btnRegistrazione) ) {
					 dispose();
					 controller.login.setVisible(true);
				 }
				 
						
			}
		});
		btnRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrazione.setForeground(new Color(102, 153, 255));
		btnRegistrazione.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
		btnRegistrazione.setBorder(null);
		btnRegistrazione.setBackground(new Color(102, 0, 153));
		btnRegistrazione.setBounds(110, 426, 315, 100);
		 //contentPane.add(btnRegistrazione);

		/*
		 * JButton btnRegistrazione = new JButton("ACCEDI");
		 * 
		 * btnRegistrazione.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { String nome = txtnome2.getText(); String pwd
		 * = txtpassword.getText(); String pwd2 = txtpassword2.getText();
		 * controller.registrautente(nome, pwd, pwd2, btnRegistrazione);
		 */

		/*
		 * if (!pwd.equals(pwd2)) { JOptionPane.showMessageDialog(btnRegistrazione,
		 * "Le due password non corrispondono!"); } else if (pwd.length() == 0 ||
		 * pwd2.length() == 0 || nome.length() == 0) {
		 * 
		 * JOptionPane.showMessageDialog(btnRegistrazione,
		 * "Tutti i campi devono essere compilati!"); } else {
		 * 
		 * try { Connection connection =
		 * DriverManager.getConnection("jdbc:postgresql:Progetto-OO-BD", "postgres",
		 * "laika"); String sql = "INSERT INTO public.Utente  values ('" + nome + "','"
		 * + pwd + "','" + pwd2 + "')";
		 * 
		 * Statement sta = connection.createStatement();
		 * 
		 * int x = sta.executeUpdate(sql);
		 * 
		 * if (x == 0) { JOptionPane.showMessageDialog(btnRegistrazione,
		 * "Account già esistente!");
		 * 
		 * } else { JOptionPane.showMessageDialog(btnRegistrazione,
		 * "Account creato con successo!");
		 * 
		 * Login log = new Login(); log.setVisible(true); dispose(); }
		 * 
		 * connection.close(); } catch (Exception exception) {
		 * exception.printStackTrace(); }
		 * 
		 * } } });
		 */

		/*
		 * btnRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 * btnRegistrazione.setForeground(new Color(102, 153, 255));
		 * btnRegistrazione.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC,
		 * 20)); btnRegistrazione.setBorder(null); btnRegistrazione.setBackground(new
		 * Color(102, 0, 153)); btnRegistrazione.setBounds(110, 426, 315, 100);
		 * contentPane.add(btnRegistrazione); }
		 * 
		 * });
		 */
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
