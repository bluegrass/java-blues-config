package bluegrass.blues.config.definition.builder;

import bluegrass.blues.config.definition.Node;
import bluegrass.blues.config.definition.StringNode;

/**
 *
 * @author gcaseres
 * @param <TParentBuilder>
 */
public class StringNodeBuilder<TParentBuilder extends NodeBuilder> extends ChildNodeBuilder<TParentBuilder, StringNodeBuilder<TParentBuilder>> {
    private String defaultValue = null;
    
    public StringNodeBuilder(String name, TParentBuilder parentBuilder) {
        super(name, parentBuilder);
    }

    @Override
    public Node build() {
        StringNode node = new StringNode(this.name);
        node.setDefaultValue(this.defaultValue);
        return node;        
    }

    public StringNodeBuilder defaultValue(String value) {
        this.defaultValue = value;
        return this;
    }

}
