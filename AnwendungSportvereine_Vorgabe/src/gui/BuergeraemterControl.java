package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.BuergeraemterModel;
import business.Sportverein;
import javafx.stage.Stage;

public class BuergeraemterControl {
	public BuergeraemterModel model;
	public BuergeraemterView view;
	
	public void nehmeSportvereinAuf(String name, String ort, 
			int anzahlMitglieder, int anzahlehmaligerMitglieder,
			String[] sportarten){
    	try{ 
    		model.nehmeSportvereinAuf(name, ort, anzahlMitglieder, anzahlehmaligerMitglieder, sportarten);
    				view.zeigeInformationsfensterAn("Der Sportverein wurde aufgenommen!");
    	 	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }

	public BuergeraemterControl(Stage primarystage) {
		super();
		this.model = new BuergeraemterModel();
		this.view = new BuergeraemterView(primaryStage, this);
	}
	public void leseAusDatei(String typ){
		BuergeraemterModel amt = new BuergeraemterModel();
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Sportverein.csv"));
      			String[] zeile = ein.readLine().split(";");
      			amt.sportverein = new Sportverein(zeile[0], 
      				zeile[1], 
      				Integer.parseInt(zeile[2]), 
      				Integer.parseInt(zeile[3]), 
      				zeile[4].split("_"));
      				ein.close();
      	  			view.zeigeInformationsfensterAn(
      	  	   			"Der Sportverein wurde gelesen!");
      		}
       		else{
	   			view.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
	public void schreibeSportvereineInCsvDatei() {
    	BuergeraemterModel amt2 = new BuergeraemterModel();
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("SportvereineAusgabe.csv", true));
			aus.write(amt2.gibSportvereinZurueck(';'));
			aus.close();
   			view.zeigeInformationsfensterAn(
	   			"Die Sportvereine wurden gespeichert!");
		}	
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	
	
	
	

}
