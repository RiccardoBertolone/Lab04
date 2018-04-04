package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

								
				// Crea un nuovo JAVA Bean Corso
				Corso c = new Corso(codins, numeroCrediti, nome, periodoDidattico) ;
				
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(c) ;
			}

			conn.close() ;
			return corsi ;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorso(String codins) {
		final String sql = "SELECT * " + 
				"		FROM corso " + 
				"		WHERE codins = ?" ;

		Corso c = null ;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codins);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

								
				// Crea un nuovo JAVA Bean Corso
				c = new Corso(codins, numeroCrediti, nome, periodoDidattico) ;
			}

			conn.close() ;
			return c ;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(String codins) {
				
		final String sql = "SELECT DISTINCT s.matricola, nome, cognome, CDS " + 
							"FROM iscrizione i, studente s " + 
							"WHERE i.matricola = s.matricola AND i.codins = ?";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codins);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola") ;
				String nome = rs.getString("nome") ;
				String cognome = rs.getString("cognome") ;
				String cds = rs.getString("CDS") ;
				
				// Crea un nuovo JAVA Bean Studente
				Studente s = new Studente(matricola, cognome, nome, cds) ;
				
				// Aggiungi il nuovo oggetto Studente alla lista studenti
				studenti.add(s) ;
			}

			conn.close() ;
			return studenti ;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/* NON FUNZIONANTE
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(int matricola, String codins) {
		
		
		final String sql = "SELECT DISTINCT matricola, codins\n" + 
							"FROM iscrizione\n" + 
							"WHERE codins = ? AND matricola = ?";
		
		// verificare che esista lo studente e che esista il corso.......
		
		final String sql2 = "INSERT INTO `iscritticorsi`.`iscrizione` (`matricola`, `codins`) VALUES (?, ?);";


		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codins);
			st.setInt(2, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				return false ;
			}

			conn.close() ;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql2);
			
			st.setInt(1, matricola);
			st.setString(2, codins);
			
			st.executeQuery();
			conn.close() ;
			return true ;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		

	}
}
