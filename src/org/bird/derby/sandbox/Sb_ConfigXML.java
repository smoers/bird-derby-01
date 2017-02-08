package org.bird.derby.sandbox;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.bird.derby.common.config.XmlConfigurationProvider;

public class Sb_ConfigXML {

	public static void main(String[] args) throws ConfigurationException {
		
		XmlConfigurationProvider xmlProvider = XmlConfigurationProvider.getInstance();
		
		XMLConfiguration config = xmlProvider.getConfiguration("dbconfig.xml");
		
		System.out.println(config.getString("jdbc.derby.user"));
		
		config.setProperty("jdbc.derby.user", "zut !");
		
		
		xmlProvider.save(config);

	}

}
