package Swng;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import Controllore.Controllore;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException; 

public class Login extends JFrame implements ActionListener{
	
	

	private JPanel contentPane;
	private JTextField txtnome;
	private JPasswordField password;
	private Controllore controller;
	Home home = new Home(controller);
	
	/* public Login(Controllore ctrl) {
			setName("Login");
			setTitle("Login");
			controller= ctrl; 
	 }
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	public Login(Controllore ctrl) {
		
		
		setName("Login");
		setTitle("Login");
		controller= ctrl; 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541,600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 204));
		contentPane.setBackground(new Color(102, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(110, 266, 330, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtnome = new JTextField();
		txtnome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtnome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtnome.setBackground(new Color(255, 255, 255));
		txtnome.setBorder(null);
		txtnome.setForeground(new Color(0, 51, 51));
		txtnome.setFont(new Font("Lucida Console", Font.ITALIC, 15));
		txtnome.setText("USERNAME");
		txtnome.setBounds(10, 10, 285, 22);
		panel.add(txtnome);
		txtnome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 0, 153));
		panel_1.setBounds(110, 316, 330, 40);
		contentPane.add(panel_1);
		
		password = new JPasswordField();
		
		password.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		password.setBorder(null);
		password.setBackground(new Color(255, 255, 255));
		password.setText("Password");
		password.setFont(new Font("Helvetica", Font.PLAIN, 15));
		password.setBounds(10, 10, 285, 22);
		panel_1.add(password);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setForeground(new Color(51, 102, 51));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(102, 0, 153));
		panel_2.setBounds(110, 380, 330, 56);
		contentPane.add(panel_2);
		
		JButton btnNewButton = new JButton("ACCEDI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtnome.getText();
				String pwd = password.getText();
				 try {
					if (controller.checkutente(nome, pwd, btnNewButton)) {
						 dispose();
						 controller.home.setVisible(true);
					 } else {
						 JOptionPane.showMessageDialog(btnNewButton, "Inserire username/password validi");
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/* Home home = new Home(controller);
				home.setVisible(true);
				dispose(); */ 
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(102, 0, 153));
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(51, 152, 204));
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(10, 10, 244, 36);
		panel_2.add(btnNewButton);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(179, 26, 204, 161);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/Swng/loghi/logo.png")));
		
		JLabel lblNOME = new JLabel("Library");
		lblNOME.setForeground(new Color(51, 153, 204));
		lblNOME.setFont(new Font("Garamond", Font.BOLD | Font.ITALIC, 60));
		lblNOME.setBounds(131, 110, 296, 108);
		contentPane.add(lblNOME);
		
		
		JButton btnRegistrazione = new JButton("REGISTRATI!");
		
		btnRegistrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Registrazione reg =new Registrazione(controller);
				dispose();
				reg.setVisible(true);
			}
		});
	
		
		
		
		
		btnRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnRegistrazione.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 18));
		btnRegistrazione.setBorder(null);
		btnRegistrazione.setForeground(new Color(51, 153, 204));
		btnRegistrazione.setBackground(new Color(102, 0, 153));
		btnRegistrazione.setBounds(131, 446, 239, 36);
		contentPane.add(btnRegistrazione);
		
		
		JCheckBox check = new JCheckBox("");
		check.setBounds(58, 316, 43, 40);
		contentPane.add(check);
		check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		check.setIcon(new ImageIcon(Login.class.getResource("/Swng/loghi/password.png")));
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check.isSelected()) 
				{
					password.setEchoChar((char)0);
					
					
					}
				else 
				{
					password.setEchoChar('*');
					
				}
				
				
				
			}
		});
		check.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		check.setBackground(new Color(102, 0,153));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Swng/loghi/user.png")));
		lblNewLabel.setBounds(58, 266, 42, 40);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
