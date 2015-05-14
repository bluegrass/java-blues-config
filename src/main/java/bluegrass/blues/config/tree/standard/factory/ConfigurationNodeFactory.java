package bluegrass.blues.config.tree.standard.factory;

import bluegrass.blues.config.tree.ConfigurationNode;
import bluegrass.blues.config.tree.standard.LeafConfigurationNode;
import bluegrass.blues.config.tree.standard.MapConfigurationNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gcaseres
 */
public class ConfigurationNodeFactory {
    
    public static List<ConfigurationNode> create(String name, Object configData) {
        List<ConfigurationNode> result = new ArrayList<>();
        if (configData instanceof Map<?, ?>) {
            result.add(new MapConfigurationNode(name, (Map<Object, Object>)configData));            
            
            return result;
        }
        if (configData instanceof List<?>) {
            for (Object itemConfigData : (List<?>)configData) {
                result.addAll(ConfigurationNodeFactory.create(name, itemConfigData));
            }
            
            return result;
        }        
        
        result.add(new LeafConfigurationNode(name, configData));
        
        return result;
    }
}
