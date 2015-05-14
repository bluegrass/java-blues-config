package bluegrass.blues.config.definition;

import bluegrass.blues.config.definition.exception.NodeValidationException;
import bluegrass.blues.config.tree.ConfigurationNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public class ConfigDefinitionTree {

    private RootNode root;

    public ConfigDefinitionTree(RootNode root) {
        this.root = root;
    }

    public RootNode getRoot() {
        return this.root;
    }

    public void validate(ConfigurationNode configNode) throws NodeValidationException {
        List<ConfigurationNode> configNodes = new ArrayList<>();
        configNodes.add(configNode);
        this.root.validate(configNodes);
    }
}
