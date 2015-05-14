package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public class ArrayNode extends Node {
    
    public ArrayNode(String name) {
        super(name);
    }

    @Override
    public void validate(List<ConfigurationNode> configNodes) throws NodeValidationException {
        super.validate(configNodes);
    }
    
}
