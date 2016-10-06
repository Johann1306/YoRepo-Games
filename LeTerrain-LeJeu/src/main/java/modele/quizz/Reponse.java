package modele.quizz;

import java.io.Serializable;

public class Reponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String reponse;
	private boolean bonneReponse;
	
	public Reponse(String reponse, boolean bonneReponse) {
		super();
		this.reponse = reponse;
		this.bonneReponse = bonneReponse;
	}

	public String getReponse() {
		return reponse;
	}
	
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	public boolean isBonneReponse() {
		return bonneReponse;
	}
	
	public void setBonneReponse(boolean bonneReponse) {
		this.bonneReponse = bonneReponse;
	}
}
