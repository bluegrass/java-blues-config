package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public class CompositeNode extends Node {

    private List<Node> children;

    protected CompositeNode() {
        this.children = new ArrayList<>();
    }

    public CompositeNode(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    protected void setChildren(List<Node> value) {
        this.children = value;
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    @Override
    public void validate(List<ConfigurationNode> configNodes) throws NodeValidationException {
        super.validate(configNodes);
        this.validateChildren(configNodes.get(0));        
    }
    
    @Override
    protected void validateCardinals(List<ConfigurationNode> configNodes) throws NodeValidationException {
        if (configNodes.isEmpty()) {
            throw new NodeValidationException(this, String.format("A node named '%s' was expected.", this.getName()));
        }
        
        if (configNodes.size() > 1) {
            throw new NodeValidationException(this, String.format("Only one node named '%s' was expected.", this.getName()));
        }
    }

    protected void validateChildren(ConfigurationNode configNode) throws NodeValidationException {
        /*
         if (configNode == null) {
         throw new NodeValidationException(this, String.format("Expected not null value."));
         }

         if (!(configData instanceof Map<?, ?>)) {
         throw new NodeValidationException(this, String.format("[%s] - Expected value of type Map<?,?> type, but '%s' was provided. %s",this.getName(), configData.getClass().toString(), configData.toString()));
         }
         */

        //Map<Object, Object> configDataMap = (Map<Object, Object>) configData;
        //for (Entry<Object, Object> entry : configDataMap.entrySet()) {
        for (ConfigurationNode childNode : configNode.getChildren()) {
            boolean found = false;

            for (Node child : this.children) {
                //if (child.getName().equals(entry.getKey())) {
                if (child.getName().equals(childNode.getName())) {
                    found = true;
                }
            }

            if (!found) {
                //throw new NodeValidationException(this, String.format("The node didn't expect a child with name '%s'. Expected children are: '%s'. Current children are: '%s'", entry.getKey().toString(), this.getChildrenNames(), configDataMap.keySet()));
                throw new NodeValidationException(this, String.format("The node didn't expect a child with name '%s'. Expected children are: '%s'. Current children are: '%s'", childNode.getName(), this.getChildrenNames(), configNode.getChildrenNames()));
            }
        }

        for (Node child : this.children) {
            List<ConfigurationNode> configChildren = configNode.getChildren(child.getName());

            if (configChildren.isEmpty()) {
                throw new NodeValidationException(this, String.format("A child named '%s' is expected.", child.getName()));
            }

            child.validate(configChildren);
        }

    }

    private List<String> getChildrenNames() {
        List<String> result = new ArrayList<>();

        for (Node n : this.children) {
            result.add(n.getName());
        }

        return result;
    }
}
