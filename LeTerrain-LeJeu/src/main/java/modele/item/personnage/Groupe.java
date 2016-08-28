package modele.item.personnage;

import java.util.ArrayList;
import java.util.List;

public class Groupe {

	private List<PersonnagePrincipal> leGroupe;

	public Groupe() {
		this.leGroupe = new ArrayList<PersonnagePrincipal>();
	}
	
	public List<PersonnagePrincipal> getPersos() {
		return leGroupe;
	}
	
	public PersonnagePrincipal getPersoByNom(PersoPrenom nom) {
		for (PersonnagePrincipal perso : leGroupe)
			if (nom.equals(perso.getPrenom())) {
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
