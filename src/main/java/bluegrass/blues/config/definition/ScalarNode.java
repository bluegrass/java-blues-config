package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public abstract class ScalarNode extends Node {

    private Object defaultValue = null;

    public ScalarNode(String name) {
        this(name, null);
    }

    public ScalarNode(String name, Object defaultValue) {
        super(name);
        this.defaultValue = defaultValue;
    }

    public void setDefaultValue(Object value) {
        this.defaultValue = value;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public boolean hasDefaultValue() {
        return this.defaultValue != null;
    }

    @Override
    public void validate(List<ConfigurationNode> configNodes) throws NodeValidationException {
        super.validate(configNodes);

        this.validateDefaultValue(configNodes.get(0));        
    }

    @Override
    protected void validateCardinals(List<ConfigurationNode> configNodes) throws NodeValidationException {
        super.validateCardinals(configNodes);
        
        if (configNodes.size() > 1) {
            throw new NodeValidationException(this, String.format("Only one node named '%s' was expected.", this.getName()));
        }
    }
    
    protected void validateDefaultValue(ConfigurationNode configNode) throws NodeValidationException {
        if (!this.hasDefaultValue() && (configNode.getValue().asObject() == null)) {
            throw new NodeValidationException(this, "The node value cannot be null. Use a default value to allow null values.");
        }
    }
}
