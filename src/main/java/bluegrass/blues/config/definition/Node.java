package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public abstract class Node {

    private Node parent;
    private String name;
    private int maxOccurences;
    private int minOccurences;

    protected Node() {

    }

    public Node(String name) {
        this();   
        this.name = name;
    }

    public int getMaxOccurences() {
        return this.maxOccurences;
    }

    public int getMinOccurences() {
        return this.minOccurences;
    }

    public boolean isRequired() {
        return this.minOccurences > 0;
    }

    public void setMinOccurences(int value) {
        this.minOccurences = value;
    }

    public void setMaxOccurences(int value) {
        this.maxOccurences = value;
    }

    public String getPath() {
        if (this.hasParent()) {
            return String.format("%s.%s", this.getParent().getPath(), this.getName());
        } else {
            return this.name;
        }
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public void setParent(Node value) {
        this.parent = value;
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    //public abstract Object normalize(ConfigurationNode configNode);

    public void validate(ConfigurationNode configNode) throws NodeValidationException {
        List<ConfigurationNode> configNodes = new ArrayList<>();
        configNodes.add(configNode);
        
        this.validate(configNodes);        
    }
    
    public void validate(List<ConfigurationNode> configNodes) throws NodeValidationException {
        this.validateCardinals(configNodes);
    }
    
    protected void validateCardinals(List<ConfigurationNode> configNodes) throws NodeValidationException {
        if (configNodes.isEmpty()) {
            throw new NodeValidationException(this, String.format("A node named '%s' was expected.", this.getName()));
        }
    }

    @Override
    public String toString() {
        return String.format("Node: {name: '%s', class: %s}", this.getName(), this.getClass().toString());
    }
    
    /*
    protected void validateName(Object configData) throws NodeValidationException {
        if (configData == null) {
            throw new NodeValidationException(this, String.format("Expected '%s' node but found a configuration node with null name.", this.getName()));
        }
        if (!configNode.getName().equals(this.getName())) {
            throw new NodeValidationException(this, String.format("Expected '%s' node but found '%s'.", this.getName(), configNode.getName()));
        }
    }
    */
}
