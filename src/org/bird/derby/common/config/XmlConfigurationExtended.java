package org.bird.derby.common.config;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;

import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;

public class XmlConfigurationExtended extends XMLConfiguration {
	
	public XmlConfigurationExtended(){
		super();
	}
	
	public XmlConfigurationExtended(HierarchicalConfiguration<ImmutableNode> file) throws ConfigurationException
    {
        super(file);
    }

    @Override
    protected Transformer createTransformer() throws ConfigurationException {
        Transformer transformer = super.createTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        return transformer;
    }	

}
