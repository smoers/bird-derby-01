package org.bird.derby.common.config;

import java.util.Hashtable;
import java.util.UUID;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.builder.fluent.XMLBuilderParameters;
import org.apache.commons.configuration2.ex.ConfigurationException;


/**
 * Classe utilisée pour la gestion des fichiers de configuration au format XML
 * @author a49974
 *
 */

@SuppressWarnings("serial")
public class XmlConfigurationProvider extends Hashtable<String , FileBasedConfigurationBuilder<XMLConfiguration>> {
	
	/*
	 * Table<ID, filePath>
	 */
	private Hashtable<String, String> linkIdtoPath;
	
	/**
	 * Contructeur
	 */
	private XmlConfigurationProvider(){
		linkIdtoPath = new Hashtable<String,String>();
	}
	
	/**
	 * Singleton
	 * @author a49974
	 *
	 */
	private static class SingletonHolder{
		private final static XmlConfigurationProvider instance = new XmlConfigurationProvider();
	}
	
	/**
	 * Get Instance Singleton
	 * @return {@link XmlConfigurationProvider}
	 */
	public static XmlConfigurationProvider getInstance(){
		return SingletonHolder.instance;
	}
	
	
	
	/**
	 * Cette méthode retourne la classe XMLConfiguration correspondant
	 * au fichier XML passé en paramètre
	 * @param filePath type String
	 * @return XMLConfiguration
	 * @throws ConfigurationException
	 */
	public XMLConfiguration getConfiguration(String filePath) throws ConfigurationException {
		
		XMLConfiguration config = null; //Init config
		
		if(containsKey(filePath)){
			//si l'objet XMLConfiguration existe on ne le recharge pas
			config = get(filePath).getConfiguration();
		}
		else{
			//si l'objet XMLConfiguration n'existe pas on le recharge
			Parameters params = new Parameters();
			XMLBuilderParameters xml = params.xml();
			xml.setFileName(filePath);
			xml.setEncoding("ISO-8859-1");
		
			FileBasedConfigurationBuilder<XMLConfiguration> builder = new FileBasedConfigurationBuilder<XMLConfiguration>(XmlConfigurationExtended.class);
			builder.configure(xml);
			//retourne l'objet XMLConfiguration
			config = builder.getConfiguration();
			//Charge l'objet dans le tableau
			if(config.getString("id") == null){
				config.addProperty("id", UUID.randomUUID());
				builder.save();
			}
			linkIdtoPath.put(config.getString("id"), filePath);
			put(filePath, builder);

		}
		return config;
		
		
	}
	
	public boolean save(XMLConfiguration config) throws ConfigurationException{
		
		boolean save = false;
		
		if(linkIdtoPath.containsKey(config.getString("id"))){
			get(linkIdtoPath.get(config.getString("id"))).save();
			save = true;
		}
		
		return save;
	}
	
}
