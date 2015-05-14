package bluegrass.blues.config.definition.builder;

import bluegrass.blues.config.definition.ConfigDefinitionTree;
import bluegrass.blues.config.definition.RootNode;

/**
 *
 * @author gcaseres
 */
public class TreeBuilder {

    private RootNodeBuilder rootNodeBuilder;

    public ConfigDefinitionTree build() {
        return new ConfigDefinitionTree((RootNode)this.rootNodeBuilder.build());
    }

    public RootNodeBuilder root() {        
        this.rootNodeBuilder = new RootNodeBuilder();
        return this.rootNodeBuilder;
    }
    
}
