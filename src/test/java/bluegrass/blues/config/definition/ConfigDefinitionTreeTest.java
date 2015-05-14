package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.CompositeNode;
import bluegrass.blues.config.definition.ConfigDefinitionTree;
import bluegrass.blues.config.definition.IntegerNode;
import bluegrass.blues.config.definition.RootNode;
import bluegrass.blues.config.definition.StringNode;
import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import bluegrass.blues.config.tree.standard.MapConfigurationNode;
import bluegrass.blues.config.tree.standard.factory.ConfigurationNodeFactory;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 *
 * @author gcaseres
 */
public class ConfigDefinitionTreeTest {
    
    protected ConfigurationNode createConfigurationData() {
        Map<String, Object> root = new HashMap<>();
        Map<String, Object> node_2 = new HashMap<>();
        
        root.put("1", "value-1");
        root.put("2", node_2);
        
        node_2.put("2-1", 10);
        node_2.put("2-2", "text");
                                        
        return ConfigurationNodeFactory.create("root", root).get(0);
    }
    
    @Test(expected = NodeValidationException.class)
    public void testValidateFail() throws NodeValidationException {
        Map<Object, Object> configData = new HashMap<>();
        configData.put("node-1", 10);
        
        ConfigDefinitionTree tree = new ConfigDefinitionTree(new RootNode());
        
        tree.validate(new MapConfigurationNode("node-1", configData));
    }
    
    
    @Test
    public void testValidateSuccess() throws NodeValidationException {
        ConfigDefinitionTree tree = new ConfigDefinitionTree(new RootNode());
        StringNode node_1 = new StringNode("1");
        
        CompositeNode node_2 = new CompositeNode("2");
        
        IntegerNode node_2_1 = new IntegerNode("2-1");

        StringNode node_2_2 = new StringNode("2-2");
        
        node_2.addChild(node_2_1);
        node_2.addChild(node_2_2);
        
        
        tree.getRoot().addChild(node_1);
        tree.getRoot().addChild(node_2);
                
        
        tree.validate(this.createConfigurationData());        
    }    
    
}
