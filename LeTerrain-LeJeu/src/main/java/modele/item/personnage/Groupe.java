package modele.item.personnage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Groupe implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PersonnagePrincipal> leGroupe;

	public Groupe() {
		this.leGroupe = new ArrayList<PersonnagePrincipal>();
	}
	
	public List<PersonnagePrincipal> getPersos() {
		return leGroupe;
	}

	public List<Personnage> getPersosVivants() {
		List<Personnage> persosDejaPresentes = new ArrayList<Personnage>();
		for (PersonnagePrincipal personnagePrincipal : leGroupe) {
			if (personnagePrincipal.isDejaPresente() && !personnagePrincipal.isMort()) {
				persosDejaPresentes.add(personnagePrincipal);
			}
		}
		return persosDejaPresentes;
	}
	
	public List<PersonnagePrincipal> getPersosPrincipauxVivants() {
		List<PersonnagePrincipal> persosDejaPresentes = new ArrayList<PersonnagePrincipal>();
		for (PersonnagePrincipal personnagePrincipal : leGroupe) {
			if (personnagePrincipal.isDejaPresente() && !personnagePrincipal.isMort()) {
				persosDejaPresentes.add(personnagePrincipal);
			}
		}
		return persosDejaPresentes;
	}

	public PersonnagePrincipal getPersoByNom(PersoPrenom nom) {
		for (PersonnagePrincipal perso : leGroupe)
			if (nom.equals(perso.getPrenom())) {
				return perso;
			}
		return null;
	}
	
	public PersonnagePrincipal getPersoByNom(String nom) {
		for (PersonnagePrincipal perso : leGroupe)
			if (nom.equals(perso.getPrenom().name())) {
				return perso;
			}
		return null;
	}
	
	public void ajoutePerso(PersonnagePrincipal perso) {
		leGroupe.add(perso);
	}

	public PersonnagePrincipal supprimePerso(PersonnagePrincipal perso) {
		leGroupe.remove(perso);
		return perso;
	}



}
