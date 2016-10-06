package modele.quizz;

import java.io.Serializable;
import java.util.List;

public class Enigme implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String imagePath;
	private String videoPath;
	private String question;
	private List<Reponse> reponsesPossibles;
	private String infoReponse;
	private TypeEnigme typeEnigme;
	
	public Enigme(String imagePath, String videoPath, String question, List<Reponse> reponsesPossibles,
			String infoReponse, TypeEnigme typeEnigme) {
		super();
		this.imagePath = imagePath;
		this.videoPath = videoPath;
		this.question = question;
		this.reponsesPossibles = reponsesPossibles;
		this.infoReponse = infoReponse;
		this.typeEnigme = typeEnigme;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<Reponse> getReponsesPossibles() {
		return reponsesPossibles;
	}
	
	public void setReponsesPossibles(List<Reponse> reponsesPossibles) {
		this.reponsesPossibles = reponsesPossibles;
	}
	
	public String getInfoReponse() {
		return infoReponse;
	}
	
	public void setInfoReponse(String infoReponse) {
		this.infoReponse = infoReponse;
	}

	public TypeEnigme getTypeEnigme() {
		return typeEnigme;
	}

	public void setTypeEnigme(TypeEnigme typeEnigme) {
		this.typeEnigme = typeEnigme;
	}
	
}
