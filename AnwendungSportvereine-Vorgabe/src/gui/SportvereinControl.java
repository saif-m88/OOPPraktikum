package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Sportverein;
import business.SportvereinModel;
import javafx.stage.Stage;

public class SportvereinControl {
    private SportvereinView sportvereinView;
    private SportvereinModel sportvereinModel;
	
    
	
	  public SportvereinControl(Stage stage) {
		super();
		this.sportvereinModel = new SportvereinModel();
		this.sportvereinView = new SportvereinView(stage, this, sportvereinModel);
		
	}

	  void nehmeSportvereinAuf(){
	    	try{ 
	    		this.sportvereinModel.setSportverein(new Sportverein(
	    			sportvereinView.getTxtName().getText(), 
	    			sportvereinView.getTxtOrt().getText(),
	   	            Integer.parseInt(sportvereinView.getTxtAnzahlMitglieder().getText()),
	   	        	Integer.parseInt(sportvereinView.getTxtAnzahlEhemaligerMitglieder().getText()),
	   	        	sportvereinView.getTxtSportarten().getText().split(";")));
	    		sportvereinView.zeigeInformationsfensterAn("Der Sportverein wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		sportvereinView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	  
	     void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      			sportvereinModel.leseAusDatei(typ);
	      			sportvereinView.zeigeInformationsfensterAn(
	      	  	   			"Der Sportverein wurde gelesen!");
	      		}
	       		else{
	       			sportvereinView.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
		   		}
			}
			catch(IOException exc){
				sportvereinView.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				sportvereinView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
	     void schreibeSportvereineInCsvDatei() {
			try {
				 sportvereinModel.schreibeSportvereineInCsvDatei();
				sportvereinView.zeigeInformationsfensterAn(
		   			"Die Sportvereine wurden gespeichert!");
			}	
			catch(IOException exc){
				sportvereinView.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				sportvereinView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}

}
