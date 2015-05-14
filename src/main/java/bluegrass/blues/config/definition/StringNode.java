package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public class StringNode extends ScalarNode {

    public StringNode(String name) {
        this(name, null);
    }

    public StringNode(String name, String defaultValue) {
        super(name, defaultValue);
    }

    /*
     @Override
     public Object normalize(ConfigurationNode configNode) {
     return configNode.getValue().toString();

     }
     */
    @Override
    public void validate(List<ConfigurationNode> configNodes) throws NodeValidationException {
        super.validate(configNodes);

        this.validateConfigValueType(configNodes.get(0));
    }

    protected void validateConfigValueType(ConfigurationNode configNode) throws NodeValidationException {
        try {
            configNode.getValue().asString();
        } catch (Exception e) {
            throw new NodeValidationException(this, String.format("Expected string value, but '%s' was provided.", configNode.getValue().asObject().toString()));
        }
    }

}
