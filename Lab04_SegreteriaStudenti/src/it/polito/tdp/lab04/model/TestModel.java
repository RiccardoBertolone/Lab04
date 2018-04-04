package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		Studente s = model.getStudente(146101) ;
		
		if (s == null)
			System.out.println("E' null!!!");
		
		System.out.println(s) ;
		
		/*
		 * 	Write here your test model
		 */

	}

}
