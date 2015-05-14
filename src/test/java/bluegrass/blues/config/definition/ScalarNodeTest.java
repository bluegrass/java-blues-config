package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.ScalarNode;
import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.standard.LeafConfigurationNode;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author gcaseres
 */
public class ScalarNodeTest {
        
    @Test(expected = NodeValidationException.class)
    public void testValidateNullValueWithoutDefault() throws NodeValidationException {
        ScalarNode node = Mockito.mock(ScalarNode.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(node.getName()).thenReturn("test-node");        
                
        node.validate(new LeafConfigurationNode("test-node", null));
    }
    
    @Test
    public void testValidateNullValueWithDefault() throws NodeValidationException {
        ScalarNode node = Mockito.mock(ScalarNode.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(node.getName()).thenReturn("test-node");

        node.setDefaultValue("default");        
                
        node.validate(new LeafConfigurationNode("test-node", null));
    }    
    
    
}
