package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author gcaseres
 */
public class PrototypeArrayNode extends Node {

    private List<Node> prototype;

    protected PrototypeArrayNode() {
        this.prototype = new ArrayList<>();
    }

    public PrototypeArrayNode(String name) {
        super(name);
        this.prototype = new ArrayList<>();
    }

    protected void setPrototype(List<Node> value) {
        this.prototype = value;
    }

    public List<Node> getPrototype() {
        return this.prototype;
    }

    public void addPrototypeItem(Node item) {
        item.setParent(this);
        this.prototype.add(item);
    }

    /*
     @Override
     public Object normalize(ConfigurationNode configNode) {

     HashMap<String, Object> result = new HashMap<>();

     for (Node node : this.children) {
     List<ConfigurationNode> configChildren = configNode.getChildren(node.getName());
     if (configChildren.size() == 1) {
     result.put(node.getName(), node.normalize(configChildren.get(0)));
     } else {
     List<Object> values = new ArrayList<>();
     for (ConfigurationNode configChild : configChildren) {
     values.add(node.normalize(configChild));
     }
     result.put(node.getName(), values);
     }

     }

     return result;
     }
     */
    @Override
    public void validate(List<ConfigurationNode> configNodes) throws NodeValidationException {
        super.validate(configNodes);
        this.validatePrototype(configNodes);
    }

    @Override
    protected void validateCardinals(List<ConfigurationNode> configNodes) throws NodeValidationException {

    }

    protected void validatePrototype(List<ConfigurationNode> configNodes) throws NodeValidationException {
        /*
         if (configData == null) {
         throw new NodeValidationException(this, String.format("Expected not null value."));
         }

         if (!(configData instanceof List<?>)) {
         throw new NodeValidationException(this, String.format("Expected value of type List<?>, but '%s' was provided.", configData.getClass().toString()));
         }
         */

        /*
         for (Map<Object, Object> configDataMap : configDataList) {
         for (Entry<Object, Object> entry : configDataMap.entrySet()) {

         boolean found = false;
         for (Node child : this.prototype) {
         if (child.getName().equals(entry.getKey())) {
         found = true;
         }
         }
         if (!found) {
         throw new NodeValidationException(this, String.format("The node didn't expect a child with name '%s'. Expected children are: '%s'. Current children are: '%s'", entry.getKey().toString(), this.getPrototypeNames(), configDataMap.keySet()));
         }
         }

         for (Node child : this.prototype) {
         if (!configDataMap.containsKey(child.getName())) {
         throw new NodeValidationException(this, String.format("A child named '%s' is expected.", child.getName()));
         }

         child.validate(configDataMap.get(child.getName()));
         }
         }
         */
        for (ConfigurationNode configNode : configNodes) {
            for (ConfigurationNode childNode : configNode.getChildren()) {
                boolean found = false;

                for (Node child : this.prototype) {
                    if (child.getName().equals(childNode.getName())) {
                        found = true;
                    }
                }

                if (!found) {
                    throw new NodeValidationException(this, String.format("The node didn't expect a child with name '%s'. Expected children are: '%s'. Current children are: '%s'", childNode.getName(), this.getPrototypeNames(), configNode.getChildrenNames()));
                }
            }
        }

        for (ConfigurationNode configNode : configNodes) {
            for (Node child : this.prototype) {
                List<ConfigurationNode> configChildren = configNode.getChildren(child.getName());

                if (configChildren.isEmpty()) {
                    throw new NodeValidationException(this, String.format("A child named '%s' is expected.", child.getName()));
                }

                child.validate(configChildren);
            }
        }

    }

    private List<String> getPrototypeNames() {
        List<String> result = new ArrayList<>();

        for (Node n : this.prototype) {
            result.add(n.getName());
        }

        return result;
    }
}
