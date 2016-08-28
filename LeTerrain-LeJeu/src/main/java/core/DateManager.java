package core;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;

public class DateManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Date dateCourante = null;
	private static DateFormat format = null;
	
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
	
	public static void passeUneHeure(JLabel labelDate) {
		dateCourante.setHours(dateCourante.getHours()+1);
		labelDate.setText(getDateCouranteFormateeUpperCase());
	}
	
	public static void passeUneJournee(JLabel labelDate) {
		dateCourante.setDate(dateCourante.getDate()+1);
		labelDate.setText(getDateCouranteFormateeUpperCase());
	}
	
	public static void passeUnMois(JLabel labelDate) {
		dateCourante.setMonth(dateCourante.getMonth()+1);
		labelDate.setText(getDateCouranteFormateeUpperCase());
	}

	public static void passeUneAnnee(JLabel labelDate) {
		dateCourante.setYear(dateCourante.getYear()+1);
		labelDate.setText(getDateCouranteFormateeUpperCase());
	}
	
	public static boolean estApresLaDateCourrante(Date date) {
		return dateCourante.before(date);
	}
	
	public static boolean estAvantLaDateCourrante(Date date) {
		return dateCourante.after(date);
	}

	public static boolean estEgaleALaDateCourante(Date date) {
		if ((dateCourante.getYear() == date.getYear())
				&& (dateCourante.getMonth() == date.getMonth())
				&& (dateCourante.getDay() == date.getDay())
				&& (dateCourante.getHours() == date.getHours())) {
			return true;
		}
		return false;
	}
	
	public static void afficheDateCourrante() {
		System.out.println(format.format(dateCourante));
	}
	
	public static String getDateCouranteFormatee() {
		return format.format(dateCourante);
	}
	
	public static String getDateCouranteFormateeLowerCase() {
		return format.format(dateCourante).toLowerCase();
	}
	
	public static String getDateCouranteFormateeUpperCase() {
		return format.format(dateCourante).toUpperCase();
	}

	public static Date getDateCourante() {
		return dateCourante;
	}

	public static void setDateCourante(Date dateCourante) {
		DateManager.dateCourante = dateCourante;
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
	
	public static void main(String[] args) {
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
		
	}

}
