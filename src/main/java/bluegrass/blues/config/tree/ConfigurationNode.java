package bluegrass.blues.config.tree;

import java.util.List;

/**
 *
 * @author gcaseres
 */
public interface ConfigurationNode {
    String getName();
    ConfigurationNodeValueHolder getValue();
    List<ConfigurationNode> getChildren();
    List<ConfigurationNode> getChildren(String name);
    List<String> getChildrenNames();
}
