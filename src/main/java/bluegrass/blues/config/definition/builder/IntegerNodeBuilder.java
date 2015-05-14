package bluegrass.blues.config.definition.builder;

import bluegrass.blues.config.definition.IntegerNode;
import bluegrass.blues.config.definition.Node;

/**
 *
 * @author gcaseres
 * @param <TParentBuilder>
 */
public class IntegerNodeBuilder<TParentBuilder extends NodeBuilder> extends ChildNodeBuilder<TParentBuilder, IntegerNodeBuilder<TParentBuilder>> {
    private Integer defaultValue = null;
        
    public IntegerNodeBuilder(String name, TParentBuilder parentBuilder) {
        super(name, parentBuilder);
    }

    @Override
    public Node build() {
        IntegerNode node = new IntegerNode(this.name);
        node.setDefaultValue(this.defaultValue);
        return node;        
    }

    public IntegerNodeBuilder defaultValue(Integer value) {
        this.defaultValue = value;
        return this;
    }

}
