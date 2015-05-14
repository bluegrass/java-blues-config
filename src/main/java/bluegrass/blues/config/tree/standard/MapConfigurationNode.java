package bluegrass.blues.config.tree.standard;

import bluegrass.blues.config.tree.ConfigurationNode;
import bluegrass.blues.config.tree.ConfigurationNodeValueHolder;
import bluegrass.blues.config.tree.standard.factory.ConfigurationNodeFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author gcaseres
 */
public class MapConfigurationNode implements ConfigurationNode {

    private Map<Object, Object> configData;
    private String name;

    public MapConfigurationNode(String name, Map<Object, Object> configData) {
        this.name = name;
        this.configData = configData;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ConfigurationNodeValueHolder getValue() {
        return new ConfigurationNodeValueHolder(null);
    }

    @Override
    public List<ConfigurationNode> getChildren() {
        List<ConfigurationNode> result = new ArrayList<>();

        for (Entry<Object, Object> entry : this.configData.entrySet()) {
            result.addAll(ConfigurationNodeFactory.create(entry.getKey().toString(), entry.getValue()));
        }

        return result;
    }

    @Override
    public List<ConfigurationNode> getChildren(String name) {
        List<ConfigurationNode> result = new ArrayList<>();
        if (this.configData.containsKey(name)) {
            result.addAll(ConfigurationNodeFactory.create(name, this.configData.get(name)));            
        }

        return result;
    }

    @Override
    public List<String> getChildrenNames() {
        List<String> result = new ArrayList<>();
        for (ConfigurationNode child : this.getChildren()) {
            result.add(child.getName());
        }
        
        return result;
    }

}
