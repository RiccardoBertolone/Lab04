package it.polito.tdp.lab04.DAO;

import java.util.List;

import it.polito.tdp.lab04.model.*;

public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
//		List<Corso> corsi = cdao.getTuttiICorsi();
//		for (Corso c : corsi)
//			System.out.println(c);
		
//		Corso c = cdao.getCorso("01KSUPG") ;
//		System.out.println(c);
		
//		List<Studente> studenti = cdao.getStudentiIscrittiAlCorso("01KSUPG") ;
//		
//		for (Studente s : studenti)
//			System.out.println(s);
//		

//		boolean result = cdao.inscriviStudenteACorso(190480, "09AQGPG") ;
//		if (result)
//			System.out.println("Studente iscritto correttamente");
//		else
//			System.out.println("Errore nell'iscrizione");
//		
		
		StudenteDAO sdao = new StudenteDAO();
//		Studente s = sdao.getStudente(146101) ;
//		System.out.println(s);
		
		List<Corso> corsi = sdao.getCorsiACuiIscrittoStudente(161245) ;
		for (Corso c : corsi ) {
			System.out.println(c) ;
		}
		
	}

}
