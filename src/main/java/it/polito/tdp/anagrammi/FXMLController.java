package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AnagrammiModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtParola;

    
    /**
     * Il metodo si occupa di far apparire il risultato del calcolo degli anagrammi
     * @param event
     */
    @FXML
    void btnCalcolaAnagrammi(ActionEvent event) {
    	
    	String parola;
    	
    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	parola = txtParola.getText();
    	
    	if(parola.length() < 2) {
    		txtCorretti.appendText("Parola inserita troppo corta");
    		txtErrati.appendText("Parola inserita troppo corta");
    		return;
    	}
    	
    	if(parola.length() > 8) {
    		txtCorretti.appendText("Parola inserita troppo lunga");
    		txtErrati.appendText("Parola inserita troppo lunga");
    		return;
    	}
    	
    	Set<String> anagrammi = this.model.calcolaAnagrammi(parola);
    	
    	for(String anagramma : anagrammi) {
    		if(this.model.isCorrect(anagramma))
    			txtCorretti.appendText(anagramma + "\n");
    		else
    			txtErrati.appendText(anagramma + "\n");
    	}
    	
    }

    /**
     * Il metodo si occupa di resettare i campi di testo
     * @param event
     */
    @FXML
    void btnReset(ActionEvent event) {
    	
    	txtParola.clear();
    	txtErrati.clear();
    	txtCorretti.clear();
    }

    @FXML
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        txtCorretti.setEditable(false);
        txtErrati.setEditable(false);
    }

    /**
     * @param model - The model to set
     */
	public void setModel(AnagrammiModel model) {
		this.model = model;		
	}

}
