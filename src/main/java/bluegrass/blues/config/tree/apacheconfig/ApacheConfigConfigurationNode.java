package bluegrass.blues.config.tree.apacheconfig;

import bluegrass.blues.config.tree.ConfigurationNode;
import bluegrass.blues.config.tree.ConfigurationNodeValueHolder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public class ApacheConfigConfigurationNode implements ConfigurationNode {

    private org.apache.commons.configuration.tree.ConfigurationNode apacheConfigNode;

    public ApacheConfigConfigurationNode(org.apache.commons.configuration.tree.ConfigurationNode apacheConfigNode) {
        this.apacheConfigNode = apacheConfigNode;
    }

    @Override
    public String getName() {
        return this.apacheConfigNode.getName();
    }

    @Override
    public ConfigurationNodeValueHolder getValue() {
        return new ConfigurationNodeValueHolder(this.apacheConfigNode.getValue());
    }

    @Override
    public List<ConfigurationNode> getChildren() {
        List<ConfigurationNode> result = new ArrayList<>();
        for (Object apacheChild : this.apacheConfigNode.getChildren()) {
            result.add(new ApacheConfigConfigurationNode((org.apache.commons.configuration.tree.ConfigurationNode) apacheChild));
        }

        return result;
    }

    @Override
    public List<ConfigurationNode> getChildren(String name) {
        List<ConfigurationNode> result = new ArrayList<>();
        for (Object apacheChild : this.apacheConfigNode.getChildren(name)) {
            result.add(new ApacheConfigConfigurationNode((org.apache.commons.configuration.tree.ConfigurationNode) apacheChild));
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
