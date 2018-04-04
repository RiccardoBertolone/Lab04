package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.*;

public class Model {
	
	public List<Corso> listaCorsi() {
		CorsoDAO dao = new CorsoDAO() ;
		return dao.getTuttiICorsi() ;
	}
	
	public List<String> elencoCorsi() {
		List<Corso> corsi = this.listaCorsi() ;
		List<String> elenco = new LinkedList<String>() ;
		String s = "" ;
		for (Corso c : corsi) {
			s = c.getCodIns()+" - "+c.getNome()+"\n" ;
			elenco.add(s) ;
		}
		return elenco ;
	}
	
	public List<Studente> listaStudentiDelCorso (Corso c) {
		CorsoDAO dao = new CorsoDAO() ;
		return dao.getStudentiIscrittiAlCorso(c.getCodIns()) ;
	}
	
	public Studente getStudente(int matricola) {
		StudenteDAO dao = new StudenteDAO() ;
		return dao.getStudente(matricola) ;
	}

}
