package core;

import java.util.ResourceBundle;

public class ConfigurationManager {

	private static ResourceBundle properties;
	
	public void init() {
		setProperties(ResourceBundle.getBundle("conf.leTerrain"));
	}

	public static String getProperties(String nom) {
		return properties.getString(nom);
	}

	public void setProperties(ResourceBundle properties) {
		ConfigurationManager.properties = properties;
	}
	
}
