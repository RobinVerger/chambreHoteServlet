package chambreHote;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enregistrement.Reponse;
import reservation.Reservation;
/**
 * Servlet implementation class Chambre
 */
@WebServlet("/Chambre")
public class ChambreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChambreServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	request.setAttribute("listeResa", Reservation.getInstance().getListeResa());
	
	getServletContext().getRequestDispatcher("/listeresa.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String arrivee = request.getParameter("arrivee");
		String depart = request.getParameter("depart");
		String nbrePersonne = request.getParameter("nbrePersonne");
		String myradio = request.getParameter("myradio");

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format
																				// jour
																				// /
																				// mois
																				// /
																				// année
		LocalDate date1 = LocalDate.parse(arrivee, format);
		LocalDate date2 = LocalDate.parse(depart, format);
		Period period = Period.ofDays((int) ChronoUnit.DAYS.between(date1, date2));

		int nuitee = period.getDays();
		request.setAttribute("nuitee", nuitee);
		
		

		// Vérification des informations saisies
		if ((nom == null) || (nom.isEmpty())) {
			String message = "Le nom n'est pas renseigné !";
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		} else if ((prenom == null) || (prenom.isEmpty())) {
			String message = "Le prénom n'est pas renseigné !";
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		} else if ((arrivee == null) || (arrivee.isEmpty())) {
			String message = "La date d'arrivée n'est pas renseignée !";
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		} else if ((depart == null) || (depart.isEmpty())) {
			String message = "La date de départ n'est pas renseignée !";
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		} else {
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email);
			request.setAttribute("telephone", telephone);
			request.setAttribute("arrivee", arrivee);
			request.setAttribute("depart", depart);
			request.setAttribute("nbrePersonne", nbrePersonne);
			
			Reservation newReservation = new Reservation();
			newReservation.setNom(nom);
			newReservation.setPrenom(prenom);
			newReservation.setEmail(email);
			newReservation.setTelephone(telephone);
			newReservation.setArrivee(arrivee);
			newReservation.setDepart(depart);
			newReservation.setNbrePersonne(nbrePersonne);
			
			try {
				Reservation.getInstance().addResa(newReservation);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("reservation", newReservation);
			this.getServletContext().getRequestDispatcher("/reservation.jsp").forward(request, response);
		}
	}
}
