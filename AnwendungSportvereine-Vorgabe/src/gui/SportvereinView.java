package gui;

import business.SportvereinModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class SportvereinView {
	
	private SportvereinControl sportvereinControl;
	private SportvereinModel sportvereinModel;
	
	 private Pane pane     					= new  Pane();
	    private Label lblEingabe    	 		= new Label("Eingabe");
	    private Label lblAnzeige   	 	    	= new Label("Anzeige");
	    private Label lblName 					= new Label("Name:");
	    private Label lblOrt   		 			= new Label("Ort:");
	    private Label lblAnzahlMitglieder  	 	= new Label("Anzahl Mitglieder:");
	    private Label lblAnzahlEhemaligerMitglieder   	
	     										= new Label("Anzahl ehemaliger Mitglieder:");
	    private Label lblSportarten  			= new Label("Sportarten:");
	    private TextField txtName 	 			= new TextField();
	    private TextField txtOrt				= new TextField();
	    private TextField txtAnzahlMitglieder	= new TextField();
	    private TextField txtAnzahlEhemaligerMitglieder	
	    										= new TextField();
	    private TextField txtSportarten	 		= new TextField();
	    private TextArea txtAnzeige  			= new TextArea();
	    private Button btnEingabe 		 		= new Button("Eingabe");
	    private Button btnAnzeige 		 		= new Button("Anzeige");
	    private MenuBar mnbrMenuLeiste  		= new MenuBar();
	    private Menu mnDatei             		= new Menu("Datei");
	    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
	    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
	    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
	    
	    
	    public SportvereinView(Stage primaryStage,SportvereinControl sportvereinControl,SportvereinModel sportvereinModel){
	    	Scene scene = new Scene(this.pane, 700, 340);
	    	primaryStage.setScene(scene);
	    	primaryStage.setTitle("Verwaltung von Sportvereinen");
	    	primaryStage.show();
	    	this.initKomponenten();
			this.initListener();
			this.sportvereinControl=sportvereinControl;
			this.sportvereinModel=sportvereinModel;
	    }
	    
	    private void initKomponenten(){
	       	// Labels
	    	lblEingabe.setLayoutX(20);
	    	lblEingabe.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	    	lblEingabe.setFont(font);
	    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeige.setLayoutX(400);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	       	lblName.setLayoutX(20);
	    	lblName.setLayoutY(90);
	    	lblOrt.setLayoutX(20);
	    	lblOrt.setLayoutY(130);
	    	lblAnzahlMitglieder.setLayoutX(20);
	    	lblAnzahlMitglieder.setLayoutY(170);
	    	lblAnzahlEhemaligerMitglieder.setLayoutX(20);
	    	lblAnzahlEhemaligerMitglieder.setLayoutY(210);
	    	lblSportarten.setLayoutX(20);
	    	lblSportarten.setLayoutY(250);    	
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	       		lblName, lblOrt, lblAnzahlMitglieder,
	       		lblAnzahlEhemaligerMitglieder, lblSportarten);
	    
	    	// Textfelder
	     	txtName.setLayoutX(170);
	    	txtName.setLayoutY(90);
	    	txtName.setPrefWidth(200);
	    	txtOrt.setLayoutX(170);
	    	txtOrt.setLayoutY(130);
	    	txtOrt.setPrefWidth(200);
	    	txtAnzahlMitglieder.setLayoutX(170);
	    	txtAnzahlMitglieder.setLayoutY(170);
	    	txtAnzahlMitglieder.setPrefWidth(200);
	      	txtAnzahlEhemaligerMitglieder.setLayoutX(170);
	    	txtAnzahlEhemaligerMitglieder.setLayoutY(210);
	    	txtAnzahlEhemaligerMitglieder.setPrefWidth(200);
	    	txtSportarten.setLayoutX(170);
	    	txtSportarten.setLayoutY(250);
	    	txtSportarten.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		txtName, txtOrt, txtAnzahlMitglieder,
	     		txtAnzahlEhemaligerMitglieder, txtSportarten);
	     	
	        // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvImport);
	  	    this.mnDatei.getItems().add(mnItmTxtImport);
	  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	 	    pane.getChildren().add(mnbrMenuLeiste);
	   }
	   
	   private void initListener() {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	        	   sportvereinControl.nehmeSportvereinAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		            zeigeSportvereineAn();
		        } 
	   	    });
		    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		       	 	sportvereinControl.leseAusDatei("csv");
		    	}
		    });
		    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			     	sportvereinControl.leseAusDatei("txt");
			    }
	    	});
		    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					sportvereinControl.schreibeSportvereineInCsvDatei();
				}	
		    });
	    }
	    void zeigeSportvereineAn(){
	    	if(this.sportvereinModel.getSportverein() != null){
	    		txtAnzeige.setText(
	    			this.sportvereinModel.getSportverein().gibSportvereinZurueck(' '));
	    	}
	    	else{
	    		zeigeInformationsfensterAn("Bisher wurde keine Sportverein aufgenommen!");
	    	}
	    	
	    } 
	    void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	    		"Information", meldung).zeigeMeldungsfensterAn();
	    }	
	    
	    void zeigeFehlermeldungsfensterAn(String meldung){
	       	new MeldungsfensterAnzeiger(AlertType.ERROR,
	        	"Fehler", meldung).zeigeMeldungsfensterAn();
	    }

		public Pane getPane() {
			return pane;
		}

		public void setPane(Pane pane) {
			this.pane = pane;
		}

		public Label getLblEingabe() {
			return lblEingabe;
		}

		public void setLblEingabe(Label lblEingabe) {
			this.lblEingabe = lblEingabe;
		}

		public Label getLblAnzeige() {
			return lblAnzeige;
		}

		public void setLblAnzeige(Label lblAnzeige) {
			this.lblAnzeige = lblAnzeige;
		}

		public Label getLblName() {
			return lblName;
		}

		public void setLblName(Label lblName) {
			this.lblName = lblName;
		}

		public Label getLblOrt() {
			return lblOrt;
		}

		public void setLblOrt(Label lblOrt) {
			this.lblOrt = lblOrt;
		}

		public Label getLblAnzahlMitglieder() {
			return lblAnzahlMitglieder;
		}

		public void setLblAnzahlMitglieder(Label lblAnzahlMitglieder) {
			this.lblAnzahlMitglieder = lblAnzahlMitglieder;
		}

		public Label getLblAnzahlEhemaligerMitglieder() {
			return lblAnzahlEhemaligerMitglieder;
		}

		public void setLblAnzahlEhemaligerMitglieder(Label lblAnzahlEhemaligerMitglieder) {
			this.lblAnzahlEhemaligerMitglieder = lblAnzahlEhemaligerMitglieder;
		}

		public Label getLblSportarten() {
			return lblSportarten;
		}

		public void setLblSportarten(Label lblSportarten) {
			this.lblSportarten = lblSportarten;
		}

		public TextField getTxtName() {
			return txtName;
		}

		public void setTxtName(TextField txtName) {
			this.txtName = txtName;
		}

		public TextField getTxtOrt() {
			return txtOrt;
		}

		public void setTxtOrt(TextField txtOrt) {
			this.txtOrt = txtOrt;
		}

		public TextField getTxtAnzahlMitglieder() {
			return txtAnzahlMitglieder;
		}

		public void setTxtAnzahlMitglieder(TextField txtAnzahlMitglieder) {
			this.txtAnzahlMitglieder = txtAnzahlMitglieder;
		}

		public TextField getTxtAnzahlEhemaligerMitglieder() {
			return txtAnzahlEhemaligerMitglieder;
		}

		public void setTxtAnzahlEhemaligerMitglieder(TextField txtAnzahlEhemaligerMitglieder) {
			this.txtAnzahlEhemaligerMitglieder = txtAnzahlEhemaligerMitglieder;
		}

		public TextField getTxtSportarten() {
			return txtSportarten;
		}

		public void setTxtSportarten(TextField txtSportarten) {
			this.txtSportarten = txtSportarten;
		}

		public TextArea getTxtAnzeige() {
			return txtAnzeige;
		}

		public void setTxtAnzeige(TextArea txtAnzeige) {
			this.txtAnzeige = txtAnzeige;
		}

		public Button getBtnEingabe() {
			return btnEingabe;
		}

		public void setBtnEingabe(Button btnEingabe) {
			this.btnEingabe = btnEingabe;
		}

		public Button getBtnAnzeige() {
			return btnAnzeige;
		}

		public void setBtnAnzeige(Button btnAnzeige) {
			this.btnAnzeige = btnAnzeige;
		}

		public MenuBar getMnbrMenuLeiste() {
			return mnbrMenuLeiste;
		}

		public void setMnbrMenuLeiste(MenuBar mnbrMenuLeiste) {
			this.mnbrMenuLeiste = mnbrMenuLeiste;
		}

		public Menu getMnDatei() {
			return mnDatei;
		}

		public void setMnDatei(Menu mnDatei) {
			this.mnDatei = mnDatei;
		}

		public MenuItem getMnItmCsvImport() {
			return mnItmCsvImport;
		}

		public void setMnItmCsvImport(MenuItem mnItmCsvImport) {
			this.mnItmCsvImport = mnItmCsvImport;
		}

		public MenuItem getMnItmTxtImport() {
			return mnItmTxtImport;
		}

		public void setMnItmTxtImport(MenuItem mnItmTxtImport) {
			this.mnItmTxtImport = mnItmTxtImport;
		}

		public MenuItem getMnItmCsvExport() {
			return mnItmCsvExport;
		}

		public void setMnItmCsvExport(MenuItem mnItmCsvExport) {
			this.mnItmCsvExport = mnItmCsvExport;
		}
	    
}
