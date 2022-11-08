package Controllore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.security.auth.login.LoginException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import DAO.ArticoloScientificoDAOimpl;
import DAO.CategoriaDAOimpl;
import DAO.IntervistaDAOimpl;
import DAO.LibroDAO;
import DAO.LibroDAOimpl;
import DAO.UtenteDAOimpl;
import DBConnection.Connessione;
import Elementi.ArticoloScientifico;
import Elementi.Libro;
import Elementi.Utenti;
import Swng.AddArticoloScientifico;
import Swng.AddIntervista;
import Swng.AddLibro;
import Swng.CreaCategoria;
import Swng.Home;
import Swng.InserisciTitolo;
import Swng.Login;
import Swng.Profilo;
import Swng.Pubblicazioni;
import Swng.Registrazione;
import Swng.RimuoviCategoria;
import Swng.RimuoviLibro;
import Swng.RimuoviTitolo;

public class Controllore {
	  static Connection connection;
   
	//frame
	 public Login login;
	 public Home home; 
	 Registrazione registrazione;
     public AddLibro addlibro;
     public AddIntervista intervista; 
     public AddArticoloScientifico as;
     public RimuoviLibro r_libro;
     public Pubblicazioni pubblicazioni;
     public Profilo profilo;
     public CreaCategoria creacategoria;
     public InserisciTitolo inseriscititolo;
     public RimuoviTitolo rimuovititolo;
     public RimuoviCategoria rimuovicategoria;
  
     
     
	//entità
	private Utenti utente; 
	private Libro libro;
	private ArticoloScientifico art;
	
	//DAO
	public UtenteDAOimpl utenteDAO;
	public LibroDAOimpl libroDAO;
	public IntervistaDAOimpl intervistaDAO;
	public ArticoloScientificoDAOimpl articoloDAO;
	public CategoriaDAOimpl categoriaDAO;
	
	public static void main(String[] args) {
		connection = Connessione.connect();
		System.out.println("1");
		Controllore controller= new Controllore();
		System.out.println("2");
		
		controller.login = new Login(controller);
		controller.addlibro = new AddLibro(controller);
		controller.creacategoria = new CreaCategoria(controller);
		controller.r_libro = new RimuoviLibro(controller);
		controller.as = new AddArticoloScientifico(controller);
		controller.intervista = new AddIntervista(controller);
		controller.rimuovicategoria = new RimuoviCategoria(controller);
		controller.utente = new Utenti(controller, getConnection());
		controller.home = new Home(controller);
		controller.profilo = new Profilo(controller);
		controller.rimuovititolo = new RimuoviTitolo(controller);
		controller.inseriscititolo = new InserisciTitolo(controller);
		controller.pubblicazioni = new Pubblicazioni(controller);
		controller.utenteDAO = new UtenteDAOimpl(controller, connection);
		controller.libroDAO = new LibroDAOimpl(controller, connection);
		controller.intervistaDAO = new IntervistaDAOimpl(controller, connection);
		controller.articoloDAO = new ArticoloScientificoDAOimpl(controller, connection);
		controller.categoriaDAO = new CategoriaDAOimpl(controller, connection);
		controller.login.setVisible(true);
	
		System.out.println("3");
		
	}

	
	 public void Controller() {
		 //Connessione DB
		 connection = Connessione.connect();
		 
		 //SWING 
		 login = new Login(this); 
		
		 registrazione = new Registrazione(this);
		 
		 rimuovicategoria = new RimuoviCategoria(this);
	     home = new Home(this);
	     inseriscititolo = new InserisciTitolo(this);
	     
	     addlibro = new AddLibro(this);
	     as = new AddArticoloScientifico(this);
	     intervista = new AddIntervista(this);
	     r_libro = new RimuoviLibro(this);
	     pubblicazioni = new Pubblicazioni(this);
	     profilo = new Profilo(this);
	     creacategoria = new CreaCategoria(this);
	     rimuovititolo= new RimuoviTitolo(this);
	     
	     //DAO
		utenteDAO = new UtenteDAOimpl(this,connection);
		libroDAO = new LibroDAOimpl(this,connection);
		intervistaDAO =new IntervistaDAOimpl(this,connection);
		articoloDAO  = new ArticoloScientificoDAOimpl(this,connection);
		categoriaDAO  = new CategoriaDAOimpl(this,connection);
		
	 }
	 

public boolean registrautente(String nome, String pwd, String pwd2 , JButton btnRegistrazione) {
	if (checknull(nome, pwd,pwd2 ,btnRegistrazione)){
		if (checkpwd(pwd,pwd2,btnRegistrazione)) {
			try {
				utenteDAO.inserisciutente(nome, pwd, pwd2 ,btnRegistrazione);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} return false;
	} return false;
}
 public boolean registralibro(String titolo, String npag, String descrizione, String dins, String datapubblicazione,JButton btnInserisci) {
	 try {
			libroDAO.inseriscilibro(titolo, npag, descrizione, dins, datapubblicazione, btnInserisci);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
 }
 public boolean registraarticolo(String titolo, String numpag, String descrizione, String dins, String datapubblicazione,String tipo,JButton btnInserisci) {
	 try {
			articoloDAO.inserisciarticolo(titolo, numpag, descrizione, dins, datapubblicazione, tipo, btnInserisci);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
 }
 public boolean registraintervista(String titolo, String npag, String descrizione, String dins, String datapubblicazione,JButton btnInserisci) {
	 try {
			intervistaDAO.inserisciintervista(titolo, npag, descrizione, dins, datapubblicazione, btnInserisci);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
 }
public boolean checkutente(String nome, String pwd , JButton btnAccedi) throws SQLException {
	if (checknull2(nome,pwd,btnAccedi)) {
		utente = utenteDAO.checkutente(nome, pwd, btnAccedi);
		if (utente != null) { 
			if(utenteDAO.accesso(nome, btnAccedi)) {
			return true;
			}
			
		}return false; 
	
	}return false;
}

public boolean checkpwd(String pwd , String pwd2 , JButton btnRegistrazione) {
	if (!pwd.equals(pwd2)) {
		JOptionPane.showMessageDialog(btnRegistrazione, "Le due password non corrispondono!");
		return  false; 
	} return true;
}

public boolean checknull(String nome,String pwd , String pwd2 , JButton btnRegistrazione) {
	if (pwd.length() == 0 || pwd2.length() == 0 || nome.length() == 0) {
     JOptionPane.showMessageDialog(btnRegistrazione, "Tutti i campi devono essere compilati!");
     return false;
	} 
	return true;
}

public boolean checknull2(String nome,String pwd , JButton btnAccedi) {
	if (pwd.length() == 0 || nome.length() == 0) {
     JOptionPane.showMessageDialog(btnAccedi, "Tutti i campi devono essere compilati!");
     return false;
	} 
	return true;
}
public boolean checknumpag(String numpag , JButton btnInserisci) {
	try {
		
		 int npag = Integer.parseInt(numpag);
		 if(npag<50 || npag>1000) {
			JOptionPane.showMessageDialog(btnInserisci, "Il numero inserito non può esssere inferiore a 50 e maggiore di 1000!");
		 return false;
		 } else 
		 return true;
	 } catch (NumberFormatException g) {
		 
	      JOptionPane.showMessageDialog(btnInserisci, "Il campo 'Numero pagine' non è compilato correttamente!");
	 return false;
			 }
}
public boolean checknumpagart(String numpag , JButton btnInserisci) {
	try {
		
		 int npag = Integer.parseInt(numpag);
		 if(npag<1 || npag>100) {
			JOptionPane.showMessageDialog(btnInserisci, "Il numero inserito non può esssere inferiore a 1 e maggiore di 100!");
		 return false;
		 } else 
		 return true;
	 } catch (NumberFormatException g) {
		 
	      JOptionPane.showMessageDialog(btnInserisci, "Il campo 'Numero pagine' non è compilato correttamente!");
	 return false;
			 }
}
public boolean checktitolo(String titolo, JButton btnInserisci) {
	if (titolo.length()==0) {
		JOptionPane.showMessageDialog(btnInserisci, "Il campo Titolo va compilato");
		return false;
	} else return true;
}
public boolean checkautore(String autore, JButton btnInserisci) {
	if (autore.length()==0) {
		JOptionPane.showMessageDialog(btnInserisci, "Il campo Autore va compilato");
		return false;
	} else return true;
}

public  static Connection getConnection() {
	return connection;
}


public void setConnection(Connection connection) {
	Controllore.connection = connection;
}
public boolean checknumpagint(String numpag , JButton btnInserisci) {
	try {
		
		 int npag = Integer.parseInt(numpag);
		 if(npag<1 || npag>30) {
			JOptionPane.showMessageDialog(btnInserisci, "Il numero inserito non può esssere inferiore a 1 e maggiore di 30!");
		 return false;
		 } else 
		 return true;
	 } catch (NumberFormatException g) {
		 
	      JOptionPane.showMessageDialog(btnInserisci, "Il campo 'Numero pagine' non è compilato correttamente!");
	 return false;
			 }
}

public boolean checknumpagas(String numpag , JButton btnInserisci) {
	try {
		
		 int npag = Integer.parseInt(numpag);
		 if(npag<1 || npag>5) {
			JOptionPane.showMessageDialog(btnInserisci, "Il numero inserito non può esssere inferiore a 1 e maggiore di 5!");
		 return false;
		 } else 
		 return true;
	 } catch (NumberFormatException g) {
		 
	      JOptionPane.showMessageDialog(btnInserisci, "Il campo 'Numero pagine' non è compilato correttamente!");
	 return false;
			 }
}
public boolean checkdate( String dins , String datapubblicazione , JButton btnInserisci) {
	LocalDate now = LocalDate.now();
	 String snow= now.toString();
	 String regex = "(18|19|20)\\d\\d[-](0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])";
	if(!(snow.equals(dins))) {
		   JOptionPane.showMessageDialog(btnInserisci, "La data di inserimento deve corrispondere alla data corrente!");
	    	return false; 
	    	} 
	if (!(datapubblicazione.matches(regex))) {
    	JOptionPane.showMessageDialog(btnInserisci, "Inserisci una data di pubblicazione valida!");
    	return false; 
    } 
	 if ((datapubblicazione.matches(regex))&&(snow.equals(dins))) {
		 return true;
	 }else return false;
}

public boolean checkriferimento(String titolo, JButton btnRimuovi) {
	  ResultSet rs = null;
	  String tit;
		Statement st;
		try {
			st = connection.createStatement();
			String check = "SELECT COUNT(\"Titolo\") AS num FROM"
					+ " public.\"riferimenti_bibliografici \""
					+ " WHERE \"Titolo\" =  '" + titolo + "'";
			rs= st.executeQuery(check);
			if (rs != null) {
			while(rs.next()) {
				int contr = (rs.getInt("num"));
				System.out.println(contr);
				if(contr != 0) {
				
					return true;
					
				} else  {
					JOptionPane.showMessageDialog(btnRimuovi, "Inserire un titolo valido");
					return false;
					
				}
					
				} }
			
			
			}   catch (SQLException e) {
			// TODO Auto-generated catch block
				
					JOptionPane.showMessageDialog(btnRimuovi, "Inserire un titolo valido");
					e.printStackTrace();
					return false;
			
			
		}
		return false;
	  
}
public boolean rimuovi_riferimento(String titolo, JButton btnRimuovi) {
	 ResultSet rs = null;
		Statement st;
	   if(titolo.length()>0) {
		   
				 String sql = "DELETE FROM  public.\"Intervista\"  WHERE \"Titolo\" = ?";
				 String sqllib = "DELETE FROM  public.libro  WHERE \"titolo\" = ?";
				String sqlart = "DELETE FROM  public.articoli_scientifici  WHERE titolo = ?";
					
				String sql2 = "DELETE FROM public.\"Citazione\"\r\n" +
						"	WHERE \"Titolo-Cita\" = ? ;";
				String sql3 = "DELETE FROM public.\"Citazione\"\r\n" +
						"	WHERE \"Titolo_Citato\" = ? ;";
				String sql4 = "DELETE FROM public.\"Scrive\"\r\n" + 
						"	WHERE \"Titolo\" = ?;";
				
				PreparedStatement pst;
				PreparedStatement pstlib;
				PreparedStatement pstart;
				PreparedStatement pst2;
				PreparedStatement pst3;
				PreparedStatement pst4;
				
				String sql5 = "DELETE FROM  public.\"riferimenti_bibliografici \"  WHERE \"Titolo\" = ?";
				PreparedStatement pst5; 
				
				try {
					pst = connection.prepareStatement(sql);
					pstlib = connection.prepareStatement(sqllib);
					pstart = connection.prepareStatement(sqlart);
					pst2= connection.prepareStatement(sql2);
					pst3 = connection.prepareStatement(sql3);
					pst4 = connection.prepareStatement(sql4); 
					 pst5 = connection.prepareStatement(sql5); 
					pst.setString(1, titolo);
					pstart.setString(1, titolo);
					pstlib.setString(1, titolo);
					pst3.setString(1, titolo);
					pst2.setString(1, titolo);
					pst4.setString(1, titolo);
					 pst5.setString(1, titolo); 
					pst.executeUpdate();
					pstart.executeUpdate();
					pstlib.executeUpdate();
					pst2.executeUpdate();
					pst3.executeUpdate();
					pst4.executeUpdate(); 
					 pst5.executeUpdate(); 
					JOptionPane.showMessageDialog(btnRimuovi, "Elemento rimosso con successo");
					return true;
				} catch (SQLException e) {
					//JOptionPane.showMessageDialog(btnRimuovi, "Errore rimozione");
					JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					//e.printStackTrace();
					return false;
				}
			
				
			}
			    else {
				JOptionPane.showMessageDialog(btnRimuovi, "Inserire il titolo");
			}return false;
	}


public boolean rimuovilibro(String titolo,JButton btnRimuovi) {

	if ((checkriferimento(titolo, btnRimuovi)&& rimuovi_riferimento(titolo, btnRimuovi))) {
		return true;
	}else return false;
	
}
public void filtralibri(JList list) {
	
	try {
		String sql ="SELECT num_pag, titolo FROM public.libro;" ;
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("titolo"));
	}
	list.setModel(DLM);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void ordinacrescente(JList list) {
	try {
		String sql = "SELECT \"Titolo_Citato\"\r\n" + 
				"	FROM public.\"Citazione\" "
				 + " GROUP BY \"Titolo_Citato\""
				+ "ORDER BY COUNT(\"Titolo_Citato\") ASC"; 
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("Titolo_Citato"));
	}
	list.setModel(DLM);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public void ordinadecrescente(JList list) {
	try {
		String sql = "SELECT \"Titolo_Citato\"\r\n" + 
				"	FROM public.\"Citazione\" "
				 + " GROUP BY \"Titolo_Citato\""
				+ "ORDER BY COUNT(\"Titolo_Citato\") DESC"; 
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("Titolo_Citato"));
	}
	list.setModel(DLM);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void filtraintervista(JList list) {
	
	try {
		String sql ="SELECT num_pag, \"Titolo\"\r\n" + 
				"	FROM public.\"Intervista\";" ;
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("titolo"));
	}
	list.setModel(DLM);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void filtrarivista(JList list) {
	
	try {
		String sql ="SELECT num_pag, titolo, tipo\r\n" + 
				"	FROM public.articoli_scientifici WHERE tipo = 'Rivista';";
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("titolo"));
	}
	list.setModel(DLM);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void filtraconferenza(JList list) {
	
	try {
		String sql ="SELECT num_pag, titolo, tipo\r\n" + 
				"	FROM public.articoli_scientifici WHERE tipo = 'conferenza';";
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("titolo"));
	}
	list.setModel(DLM);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void filtrabibliografia(JList list) {
	
	try {
		String sql ="SELECT \"Titolo\", \"Descrizione\", \"Utente\", data_inserimento, data_pubblicazione\r\n" + 
				"	FROM public.\"riferimenti_bibliografici \";";
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("titolo"));
	}
	list.setModel(DLM);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void filtraautore (JList list , String autore) {
	try {
		String sql ="SELECT \"Titolo\", \"Nome\"\r\n" + 
				"	FROM public.\"Scrive\" WHERE \"Nome\" = '" + autore + "';";
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("titolo"));
	}
	list.setModel(DLM);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void filtradescrizione (JList list , String descrizione) {
	try {
		String sql ="SELECT  \"Titolo\", \"Descrizione\", \"Utente\", "
				+ "data_inserimento, data_pubblicazione FROM public.\"riferimenti_bibliografici "
				+ "\"  WHERE \"Descrizione\" LIKE '%" + descrizione + "%';";
		PreparedStatement pst = connection.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	DefaultListModel DLM = new DefaultListModel();
	
	while(rs.next()) {
		DLM.addElement(rs.getString("titolo"));
		DLM.addElement(rs.getString("descrizione"));
	}
	list.setModel(DLM);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

	
	
	 
	


