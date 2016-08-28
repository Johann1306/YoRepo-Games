package core;

import modele.item.personnage.PersonnagePrincipal;

public class MainCACA {

	public static void main(String[] args) {
		PersonnagePrincipal item1 = new PersonnagePrincipal();
		System.out.println(item1.isAvailable());
		item1.setAvailable(true);
		System.out.println(item1.isAvailable());
	}
	
	
}
