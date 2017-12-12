package enregistrement;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Reponse {

	private String nom;
	private String prenom;
	private String depart;
	private String arrivee;
	private final static Map<String, Reponse> reponses = new HashMap<String, Reponse>();
	
	public Map<String, Reponse> getReponse(){
		return reponses;
	}
	
	public static void addReponse(Reponse reponse) throws Exception{
		if(reponses.containsKey(reponse.getNom()))
			throw new Exception("Ce nom a déjà été enregistré !");
	
		reponses.put(reponse.getNom(), reponse);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrivee() {
		return arrivee;
	}
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
}
	