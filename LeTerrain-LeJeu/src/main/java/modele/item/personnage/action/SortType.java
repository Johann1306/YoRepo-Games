package modele.item.personnage.action;

public enum SortType {
	// DEGATS
	DEGATS_MONO, 
	DEGATS_MULTI, 
	DEGATS_ALL,
	
	// REGEN VIE
	REGEN_VIE_PERSO, 
	REGEN_VIE_MONO, 
	REGEN_VIE_MULTI, 

	// REGEN VIE + DEGATS
	ABSORPTION_VIE_MONO, 
	ABSORPTION_VIE_MULTI, 
	
	// REGEN MANA
	REGEN_MANA_PERSO, 
	REGEN_MANA_MONO, 
	REGEN_MANA_MULTI, 
	
	// DEGATS MANA 
	BRULURE_MANA_MONO, 
	BRULURE_MANA_MULTI, 
	
	// REGEN MANA + DEGATS MANA 
	ABSORPTION_MANA_MONO, 
	ABSORPTION_MANA_MULTI, 
	
	// BOUCLIER
	BOUCLIER_PERSO, 
	BOUCLIER_MONO, 
	BOUCLIER_MULTI, 
	
	// AURA
	AURA_PERSO, 
	AURA_MONO, 
	AURA_MULTI, 
	
	// REZ
	RESURRECTION_MONO, 
	RESURRECTION_MULTI,
	
	// STUN
	STUN_MONO,
	STUN_MULTI,
	
	// TAUNT
	TAUNT_MONO,
	TAUNT_MULTI,

	// ESQUIVE
	ESQUIVE,
	
	// RENVOI DEGATS
	RENVOI_DEGATS_PERSO; 
}
