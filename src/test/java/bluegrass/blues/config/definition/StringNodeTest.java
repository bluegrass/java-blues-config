package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.StringNode;
import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import bluegrass.blues.config.tree.ConfigurationNodeValueHolder;
import bluegrass.blues.config.tree.standard.LeafConfigurationNode;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author gcaseres
 */
public class StringNodeTest {
    
    @Test
    public void testValidateSuccess() throws NodeValidationException {
        StringNode node = new StringNode("test-node");        
                
        node.validate(new LeafConfigurationNode("test-node", "text"));       
    }
    
    
    /*
    @Test(expected = NodeValidationException.class)
    public void testValidateWrongType() throws NodeValidationException {
        StringNode node = new StringNode("test-node");        
        
        node.validate(10);
    } 
    */
}
