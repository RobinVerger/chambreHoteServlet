package reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;



public class Reservation {

	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String nbrePersonne;
	private Date nuitee;
	private String arrivee;
	private String depart;
	private final List<Reservation> listeResa = new ArrayList<>();
	private final Map<String, Reservation> Resas = new HashMap<String, Reservation>();

	public Map<String, Reservation> getResas() {
		return Resas;
	}
	private final static Reservation INSTANCE = new Reservation();
	
	public void addReservation(Reservation reservation) throws Exception{
		if(Resas.containsKey(reservation.getNom()))
			throw new Exception("Ce billet a déjà été enregistré !");
		
		Resas.put(reservation.getNom(), reservation);
	}
	
	public List<Reservation> getListeResa() {
		return listeResa;
	}
	public static Reservation getInstance() {
		return INSTANCE;
	}
	public void addResa(Reservation resa)throws Exception{
		listeResa.add(resa);
	}
	public List<Reservation> getResa() {
		return listeResa;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNbrePersonne() {
		return nbrePersonne;
	}
	public void setNbrePersonne(String nbrePersonne) {
		this.nbrePersonne = nbrePersonne;
	}
	public Date getNuitee() {
		return nuitee;
	}
	public void setNuitee(Date nuitee) {
		this.nuitee = nuitee;
	}
	public String getArrivee() {
		return arrivee;
	}
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}}
	
	
	

