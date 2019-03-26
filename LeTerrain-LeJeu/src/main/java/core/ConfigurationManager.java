package core;

import java.io.Serializable;
import java.util.ResourceBundle;

public class ConfigurationManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static ResourceBundle properties;
	
	public void init() {
		setProperties(ResourceBundle.getBundle("conf.leTerrain"));
	}

	public static String getProperties(String nom) {
		if (properties == null) {
			properties = ResourceBundle.getBundle("conf.leTerrain");
		}
		return properties.getString(nom);
	}

	public void setProperties(ResourceBundle properties) {
		ConfigurationManager.properties = properties;
	}
	
}
