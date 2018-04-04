package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.*;

public class StudenteDAO {
	
	public Studente getStudente(int matricola) {
		final String sql = "SELECT * " + 
				"		FROM studente " + 
				"		WHERE matricola = ?" ;

		Studente s = null ;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");

								
				// Crea un nuovo JAVA Bean Corso
				s = new Studente(matricola, cognome, nome, cds);
			}

			conn.close() ;
			return s ;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	
	
	/*
	 * Ottengo tutti i corsi a cui è iscritto lo Studente  
	 */
	public List<Corso> getCorsiACuiIscrittoStudente(int matricola) {
		
		final String sql = "SELECT DISTINCT c.codins, c.crediti, c.nome, c.pd " + 
							"FROM iscrizione i, corso c " + 
							"WHERE i.codins = c.codins AND matricola = ?";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins") ;
				int crediti = rs.getInt("crediti") ;
				String nome = rs.getString("nome") ;
				int pd = rs.getInt("pd") ;
				
				// Crea un nuovo JAVA Bean Corso
				Corso c = new Corso(codins, crediti, nome, pd);
				
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


}
