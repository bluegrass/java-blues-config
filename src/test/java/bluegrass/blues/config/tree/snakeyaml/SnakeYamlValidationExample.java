package bluegrass.blues.config.tree.snakeyaml;

import bluegrass.blues.config.definition.builder.TreeBuilder;
import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import bluegrass.blues.config.tree.standard.factory.ConfigurationNodeFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author gcaseres
 */
public class SnakeYamlValidationExample {
    
    @Test
    public void testExample() throws ConfigurationException, FileNotFoundException, NodeValidationException, Exception {        
        Yaml yaml = new Yaml();
        
        Object yamlResult = yaml.load(new FileInputStream("src/test/resources/sample-config-1.yml"));                
                
        ConfigurationNode n = ConfigurationNodeFactory.create("root", yamlResult).get(0);
        
        
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
        
        builder.build().validate(n);
        
        //throw new Exception(String.format("%s", yamlResult.toString()));
    }
}
