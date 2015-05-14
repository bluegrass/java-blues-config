package bluegrass.blues.config.tree.standard;

import bluegrass.blues.config.tree.ConfigurationNode;
import bluegrass.blues.config.tree.ConfigurationNodeValueHolder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public class LeafConfigurationNode implements ConfigurationNode {

    private Object value;
    private String name;
    
    public LeafConfigurationNode(String name, Object value) {
        this.name = name;
        this.value = value;
    }
            
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ConfigurationNodeValueHolder getValue() {
        return new ConfigurationNodeValueHolder(this.value);
    }

    @Override
    public List<ConfigurationNode> getChildren() {
        return new ArrayList<>();
    }
    
@Override
    public List<ConfigurationNode> getChildren(String name) {
        return new ArrayList<>();
    }    

    @Override
    public List<String> getChildrenNames() {
        return new ArrayList<>();
    }
    
}
