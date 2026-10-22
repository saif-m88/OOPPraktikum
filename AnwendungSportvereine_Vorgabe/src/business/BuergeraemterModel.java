package business;

public class BuergeraemterModel {
	public Sportverein sportverein;

	public void nehmeSportvereinAuf(String name, String ort, 
			int anzahlMitglieder, int anzahlehmaligerMitglieder,
			String[] sportarten) {

		this.sportverein = new Sportverein(
				name, 
				ort, 
				anzahlMitglieder, 
				anzahlehmaligerMitglieder, 
				sportarten);

	}

	public Sportverein getSportverein() {
		return sportverein;
	}

	public char[] gibSportvereinZurueck(char c) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
