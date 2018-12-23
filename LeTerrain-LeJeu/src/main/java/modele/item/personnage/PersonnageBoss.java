package modele.item.personnage;

import java.util.List;

import javax.swing.ImageIcon;

import modele.competence.Competence;
import modele.item.personnage.action.ActionCombat;

public class PersonnageBoss extends PersonnageEnnemi {

	private static final long serialVersionUID = 1L;

	public PersonnageBoss(String nom, String prenom, int vieMax, int manaMax, int chargeMax, List<String> particularitesPhysique,
			List<String> particularitesSocial, List<String> phrasesPerso, ImageIcon photoPrincipal,
			List<ImageIcon> photos, List<ActionCombat> actionsCombat, Competence competence) {
		super(nom, prenom, vieMax, manaMax, chargeMax, particularitesPhysique, particularitesSocial, phrasesPerso, photoPrincipal,
				photos, actionsCombat, EnnemiType.BOSS, competence);
	}
	
	@Override
	public String getPrenom() {
		return super.getPrenom();
	}

	
}
