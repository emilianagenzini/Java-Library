package Swng;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controllore.Controllore; 

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

public class Home extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Controllore controller; 
	public JButton btnART;
	public JButton btnINT;
	public JButton btnLIB;

	AddArticoloScientifico addart = new AddArticoloScientifico(controller);
	AddIntervista addint = new AddIntervista(controller);
	AddLibro addlibro = new AddLibro(controller);
	RimuoviLibro r_libro = new RimuoviLibro(controller);
Pubblicazioni pubblicazioni = new Pubblicazioni(controller);
	
	
	 /*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public Home(Controllore cntrl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 582);
		controller = cntrl;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 250, 525);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel pnl_home = new JPanel();
		pnl_home.setBackground(new Color(102, 0, 153));
		pnl_home.setBounds(0, 205, 249, 59);
		panel.add(pnl_home);
		
		JPanel pnl_pub = new JPanel();
		pnl_pub.setBounds(0, 322, 249, 59);
		pnl_pub.setBackground(new Color(102, 0, 153));
		panel.add(pnl_pub);
		
		JPanel pnl_LogOut = new JPanel();
		pnl_LogOut.setBackground(new Color(102, 0, 153));
		pnl_LogOut.setBounds(0, 476, 178, 49);
		panel.add(pnl_LogOut);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setForeground(new Color(51,153,204));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Login log = new Login(controller);
			log.setVisible(true);
			dispose();
			}
		});
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(102, 0, 153));
		btnLogOut.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		btnLogOut.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/logout2.png")));
		pnl_LogOut.add(btnLogOut);
		
		JPanel pnl_prof = new JPanel();
		pnl_prof.setBackground(new Color(102, 0, 153));
		pnl_prof.setBorder(null);
		pnl_prof.setBounds(0, 261, 249, 59);
		panel.add(pnl_prof);
		pnl_prof.setLayout(null);
		
	
		
		
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/logo.png")));
		lblNewLabel.setBounds(74, 10, 113, 113);
		panel.add(lblNewLabel);
		
		
		
		JPanel bg_profilo = new JPanel();
		bg_profilo.setBackground(new Color(0, 0,153));
		bg_profilo.setBounds(177, 0, 570, 545);
		
		setResizable(false);
		
		JPanel bg_pub = new JPanel();
		bg_pub.setBackground(new Color(152, 2,183));
		bg_pub.setBounds(177, 0, 570, 545);
		
		setResizable(false);
		
		
		
		
		
		JLabel lblNOME = new JLabel("Library");
		lblNOME.setForeground(new Color(51, 153, 204));
		lblNOME.setFont(new Font("Garamond", Font.BOLD | Font.ITALIC, 60));
		lblNOME.setBounds(27, 73, 213, 108);
		panel.add(lblNOME);
		
		
		
		

		
		
		JButton btnINT = new JButton("Intervista");
		btnINT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.intervista.setVisible(true);
			    controller.as.setVisible(false);
				controller.addlibro.setVisible(false);
			
			}
		});
	    btnINT.setBorder(null);
		btnINT.setBackground(new Color(240, 248, 255));
		btnINT.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/icons8-aggiungi-40.png")));
		btnINT.setForeground(new Color(0, 206, 209));
		btnINT.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnINT.setBounds(372, 362, 218, 44);
		contentPane.add(btnINT);
		btnINT.setVisible(false);
		
		
		JButton btnART = new JButton("Articolo");
		btnART.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.as.setVisible(true);
				controller.intervista.setVisible(false);
				controller.addlibro.setVisible(false);
			}
		});
		btnART.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/icons8-aggiungi-40.png")));
		btnART.setForeground(new Color(0, 206, 209));
		btnART.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnART.setBorder(null);
		btnART.setBackground(new Color(240, 248, 255));
		btnART.setBounds(372, 263, 218, 44);
		contentPane.add(btnART);
		btnART.setVisible(false);
		
		JButton btnLIB = new JButton("Libro");
		btnLIB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Controllore controller = new Controllore();
				
				controller.addlibro.setVisible(true);
				controller.as.setVisible(false);
				controller.intervista.setVisible(false);
			}
		});
		btnLIB.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/icons8-aggiungi-40.png")));
		btnLIB.setForeground(new Color(0, 206, 209));
		btnLIB.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnLIB.setBorder(null);
		btnLIB.setBackground(new Color(240, 248, 255));
		btnLIB.setBounds(372, 172, 218, 44);
		contentPane.add(btnLIB);
		btnLIB.setVisible(false);
		
		
		
		
		
		
		JButton btnRimuoviLibro = new JButton("");
		btnRimuoviLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.r_libro.setVisible(true);
			
			}
		});
		btnRimuoviLibro.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/icons8-bin-40.png")));
		btnRimuoviLibro.setBorder(null);
		btnRimuoviLibro.setBackground(new Color(102,0, 153));
		btnRimuoviLibro.setBounds(461, 489, 65, 46);
		contentPane.add(btnRimuoviLibro);
		btnRimuoviLibro.setVisible(false);


	JButton btn_pub = new JButton("PUBBLICAZIONI  ");
	btn_pub.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	
			btnLIB.setVisible(false);
		    btnART.setVisible(false);
			btnINT.setVisible(false);
			btnRimuoviLibro.setVisible(false);
		 controller.pubblicazioni.setVisible(true);
		}
	});
    btn_pub.setBorder(null);
	pnl_pub.add(btn_pub);
	btn_pub.setBackground(new Color(102,0, 153));
	btn_pub.setForeground(new Color(51, 153, 204));
	btn_pub.setFont(new Font("Lucida Sans", Font.BOLD, 20));
	btn_pub.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/articoli.png")));
	
	
	JButton btn_profilo = new JButton(" PROFILO       ");
	btn_profilo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			btnLIB.setVisible(false);
			btnINT.setVisible(false);
			btnART.setVisible(false);
			btnRimuoviLibro.setVisible(false);
		    controller.profilo.setVisible(true);
		}
	});
	btn_profilo.setBorder(null);
	btn_profilo.setBounds(10, 5, 198, 49);
	pnl_prof.add(btn_profilo);
	btn_profilo.setBackground(new Color(102,0, 153));
	btn_profilo.setForeground(new Color(51, 153, 204));
	btn_profilo.setFont(new Font("Lucida Sans", Font.BOLD, 20));
	btn_profilo.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/user.png")));

	
	
	
	JButton btn_home = new JButton("  HOME                ");
	btn_home.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			

			btnLIB.setVisible(true);
			btnINT.setVisible(true);
			btnART.setVisible(true);
			btnRimuoviLibro.setVisible(true);
		
            
		}
	});
	btn_home.setBorder(null);
	pnl_home.add(btn_home);
	btn_home.setBackground(new Color(102, 0, 153));
	btn_home.setForeground(new Color(51, 153, 204));
	btn_home.setFont(new Font("Lucida Sans", Font.BOLD, 20));
	btn_home.setIcon(new ImageIcon(Home.class.getResource("/Swng/loghi/dashboard.png")));
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
