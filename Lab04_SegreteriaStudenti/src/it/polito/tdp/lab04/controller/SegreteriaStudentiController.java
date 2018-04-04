package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.* ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import it.polito.tdp.lab04.model.*;

public class SegreteriaStudentiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cbxCorsi;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtFieldMatricola;

    @FXML
    private Button btnAutoCompletamento;

    @FXML
    private TextField txtFieldNome;

    @FXML
    private TextField txtFieldCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtAreaResult;

    @FXML
    private Button btnReset;
    
    private Model model; 
    private List<String> elencoCorsi = model.elencoCorsi() ;
    private ObservableList<String> corsi = FXCollections.observableArrayList(elencoCorsi) ;
    
    

    @FXML
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    }
    
    @FXML
    void doCompleta(ActionEvent event) {
    	String nome = "" ;
    	String cognome = "" ;
    	String matricolaS = txtFieldMatricola.getText() ;
    	
    	if (matricolaS.equals("")) {
    		txtFieldNome.setText("");
    		txtFieldCognome.setText("");
    		return;
    	}
    		
    	int matricola = Integer.parseInt(matricolaS) ;
    	
    	System.out.println(matricola) ;
    	
    	Studente s = model.getStudente(matricola) ;
   	
    	if (s != null) {
    		nome = s.getNome() ;
    		cognome = s.getCognome() ;
    	}
    	txtFieldNome.setText(nome);
    	txtFieldCognome.setText(cognome);
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	System.out.println("Ciao");
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtFieldMatricola.setText("");
    	txtFieldNome.setText("");
    	txtFieldCognome.setText("");
    	txtAreaResult.setText("");
    }

    @FXML
    void initialize() {
        assert cbxCorsi != null : "fx:id=\"cbxCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        cbxCorsi.getItems().removeAll(cbxCorsi.getItems());
        cbxCorsi.getItems().addAll("(vuoto)");
        cbxCorsi.getItems().addAll(corsi);
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtFieldMatricola != null : "fx:id=\"txtFieldMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnAutoCompletamento != null : "fx:id=\"btnAutoCompletamento\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtFieldNome != null : "fx:id=\"txtFieldNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtFieldCognome != null : "fx:id=\"txtFieldCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtAreaResult != null : "fx:id=\"txtAreaResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
    }

	public void setModel(Model model) {
		this.model=model;		
	}
}
