package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.IntegerNode;
import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.standard.LeafConfigurationNode;
import org.junit.Test;

/**
 *
 * @author gcaseres
 */
public class IntegerNodeTest {
    
    @Test
    public void testValidateSuccess() throws NodeValidationException {
        IntegerNode node = new IntegerNode("test-node");        
               
        node.validate(new LeafConfigurationNode("test-node", 10));
                
    }
    
    @Test(expected = NodeValidationException.class)
    public void testValidateWrongType() throws NodeValidationException {
        IntegerNode node = new IntegerNode("test-node");        
                
        node.validate(new LeafConfigurationNode("test-node", "a"));
    }    
}
