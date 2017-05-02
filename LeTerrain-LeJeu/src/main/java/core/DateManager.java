package core;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;

import front.MenuPrincipal;
import modele.evenement.Evenement;

public class DateManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date dateCourante;
	private DateFormat format;
	
	public void initialise() {
		genereDateDepart();
	}

	public void genereDateDepart() {
		// le lundi 3 septembre 1990
		dateCourante = genereUneDate(1990, Calendar.SEPTEMBER, 3, 8, 0, 0);
		format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.FRANCE);
	}
	
	public static Date genereUneDate(int year, int mois, int jour, int heure, int minute, int seconde) {
		Calendar instance = Calendar.getInstance();
		instance.set(year, mois, jour, heure, minute, seconde);
		Date date = new Date();
		date.setTime(instance.getTime().getTime());
		return date;
	}
	
	public void passeUneHeure() {
		dateCourante.setHours(dateCourante.getHours()+1);
		MenuPrincipal.getMainFrame().getPanelHaut().getLabelDate().setText(getDateCouranteFormateeUpperCase());
	}
	
	public void passeUneJournee(JLabel labelDate) {
		dateCourante.setDate(dateCourante.getDate()+1);
		labelDate.setText(getDateCouranteFormateeUpperCase());
	}
	
	public void passeUnMois(JLabel labelDate) {
		dateCourante.setMonth(dateCourante.getMonth()+1);
		labelDate.setText(getDateCouranteFormateeUpperCase());
	}

	public void passeUneAnnee(JLabel labelDate) {
		dateCourante.setYear(dateCourante.getYear()+1);
		labelDate.setText(getDateCouranteFormateeUpperCase());
	}
	
//	public boolean estApresLaDateCourrante(Date date) {
//		return dateCourante.before(date);
//	}
//	
//	public boolean estAvantLaDateCourrante(Date date) {
//		return dateCourante.after(date);
//	}
//
//	public boolean estEgaleALaDateCourante(Date date) {
//		if ((dateCourante.getYear() == date.getYear())
//				&& (dateCourante.getMonth() == date.getMonth())
//				&& (dateCourante.getDay() == date.getDay())
//				&& (dateCourante.getHours() == date.getHours())) {
//			return true;
//		}
//		return false;
//	}
	
	public long compare(Date date) {
		long dateCourante = this.dateCourante.getTime();
		long dateCompare = date.getTime();
		return dateCompare-dateCourante;
	}
	
	public void afficheDateCourrante() {
		System.out.println(format.format(dateCourante));
	}
	
	public String getDateCouranteFormatee() {
		return format.format(dateCourante);
	}
	
	public String getDateCouranteFormateeLowerCase() {
		return format.format(dateCourante).toLowerCase();
	}
	
	public String getDateCouranteFormateeUpperCase() {
		return format.format(dateCourante).toUpperCase();
	}

	public Date getDateCourante() {
		return dateCourante;
	}

	public void setDateCourante(Date dateCourante) {
		this.dateCourante = dateCourante;
	}

	public static String getDateFormatee(Date dateNaissance) {
		String dateJour = "0";
		String dateMois = "0";
		int jour = dateNaissance.getDate();
		int mois = dateNaissance.getMonth()+1;
		if (jour<10) {
			dateJour = dateJour.concat(String.valueOf(jour));
		} else {
			dateJour = String.valueOf(jour);
		}
		if (mois<10) {
			dateMois = dateMois.concat(String.valueOf(mois));
		} else {
			dateMois = String.valueOf(mois);
		}
		
		String dateFormatee = dateJour + "/" + dateMois + "/19" + dateNaissance.getYear();
		
		return dateFormatee;
	}

	
//	public static void calculeMaxCaractere() {
//		DateManager manager = new DateManager();
//		manager.initialise();
//		JLabel labelDate = new JLabel(DateManager.getDateCouranteFormatee());
//		Date fin = DateManager.genereUneDate(2020, Calendar.JANUARY, 1, 0, 0, 0);
////		Date fin = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 8, 0, 0);
//		int tailleMax = 0;
//		while (!DateManager.estEgaleALaDateCourante(fin)) {
//			DateManager.passeUneHeure(labelDate);
////			DateManager.afficheDateCourrante();
//			if (DateManager.getDateCouranteFormatee().length() > tailleMax) {
//				tailleMax = DateManager.getDateCouranteFormatee().length();
//				DateManager.afficheDateCourrante();
//			}
//		}
//		System.out.println("Taille Max = " + tailleMax);
//	}
	
//	public static void main(String[] args) {
//		DateManager.genereDateDepart();
//		JLabel labelDate = new JLabel(DateManager.getDateCouranteFormatee());
//		DateManager.afficheDateCourrante();
//		DateManager.passeUnMois(labelDate);
//		DateManager.afficheDateCourrante();
//		DateManager.passeUnMois(labelDate);
//		DateManager.afficheDateCourrante();
//		DateManager.passeUnMois(labelDate);
//		DateManager.afficheDateCourrante();
//		DateManager.passeUnMois(labelDate);
//		DateManager.afficheDateCourrante();
//		DateManager.passeUnMois(labelDate);
//		DateManager.afficheDateCourrante();
//		DateManager.passeUnMois(labelDate);
//		DateManager.afficheDateCourrante();
//		calculeMaxCaractere();
//	}

}
