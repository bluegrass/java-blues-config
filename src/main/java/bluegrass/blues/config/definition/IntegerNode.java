package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public class IntegerNode extends ScalarNode {

    public IntegerNode(String name) {
        this(name, null);
    }

    public IntegerNode(String name, String defaultValue) {
        super(name, defaultValue);
    }
   
    @Override
    public void validate(List<ConfigurationNode> configNodes) throws NodeValidationException {
        super.validate(configNodes);

        this.validateConfigValueType(configNodes.get(0));
    }

    protected void validateConfigValueType(ConfigurationNode configNode) throws NodeValidationException {
        try {
            configNode.getValue().asInteger();
        } catch (Exception e) {
            throw new NodeValidationException(this, String.format("Expected integer value, but '%s' was provided.", configNode.getValue().asObject().toString()));
        }
    }

}
