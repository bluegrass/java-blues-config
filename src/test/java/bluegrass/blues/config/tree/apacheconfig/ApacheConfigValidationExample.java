package bluegrass.blues.config.tree.apacheconfig;

import bluegrass.blues.config.tree.apacheconfig.ApacheConfigConfigurationNode;
import bluegrass.blues.config.definition.ConfigDefinitionTree;
import bluegrass.blues.config.definition.builder.TreeBuilder;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Test;

/**
 *
 * @author gcaseres
 */
public class ApacheConfigValidationExample {

    protected ConfigDefinitionTree createConfigDefinitionTree() {
        TreeBuilder builder = new TreeBuilder();
        builder.root()
                .integerChild("integer-node").end()
                .compositeChild("composite-node")
                    .stringChild("string-node").end()  
                    .compositeChild("composite-node")
                        .integerChild("integer-node").end()
                        .stringChild("string-node").end()
                    .end()
                .end()
                .prototypeArrayChild("prototype-node")
                    .integerChild("integer-node").end()
                    .stringChild("string-node").end()
                .end();
        
                
        return builder.build();
    }
    
    @Test
    public void testPropertiesFileValidation() throws ConfigurationException, Exception {
        PropertiesConfiguration propsConfig = new PropertiesConfiguration("sample-config-1.properties");

        HierarchicalConfiguration config = ConfigurationUtils.convertToHierarchical(propsConfig);             
                        
        this.createConfigDefinitionTree().validate(new ApacheConfigConfigurationNode(config.getRootNode()));                
    }
    
    @Test
    public void testXmlFileValidation() throws ConfigurationException, Exception {
        XMLConfiguration xmlConfig = new XMLConfiguration("sample-config-1.xml");       
                        
        this.createConfigDefinitionTree().validate(new ApacheConfigConfigurationNode(xmlConfig.getRootNode()));                        
    }    

}
