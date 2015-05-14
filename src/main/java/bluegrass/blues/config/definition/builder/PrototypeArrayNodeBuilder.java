package bluegrass.blues.config.definition.builder;

import bluegrass.blues.config.definition.Node;
import bluegrass.blues.config.definition.PrototypeArrayNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcaseres
 * @param <TParentBuilder>
 */
public class PrototypeArrayNodeBuilder<TParentBuilder extends NodeBuilder> extends ChildNodeBuilder<TParentBuilder, IntegerNodeBuilder> {

    protected List<NodeBuilder> childrenBuilders;
    
    protected PrototypeArrayNodeBuilder() {
        super();
        this.childrenBuilders = new ArrayList<>();
        
    }
    
    public PrototypeArrayNodeBuilder(String name, TParentBuilder parentBuilder) {
        super(name, parentBuilder);
        this.childrenBuilders = new ArrayList<>();
    }

    @Override
    public Node build() {
        PrototypeArrayNode node = new PrototypeArrayNode(this.name);
        for (NodeBuilder builder : this.childrenBuilders) {
            node.addPrototypeItem(builder.build());
        }
        
        return node;
    }
    
    public StringNodeBuilder<PrototypeArrayNodeBuilder<TParentBuilder>> stringChild(String name) {
        StringNodeBuilder builder = new StringNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;
    }
    
    public IntegerNodeBuilder<PrototypeArrayNodeBuilder<TParentBuilder>> integerChild(String name) {
        IntegerNodeBuilder builder = new IntegerNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;
    }
    
    public CompositeNodeBuilder<PrototypeArrayNodeBuilder<TParentBuilder>> compositeChild(String name) {
        CompositeNodeBuilder builder = new CompositeNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;
    }
    
    
}
