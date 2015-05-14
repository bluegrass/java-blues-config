package bluegrass.blues.config.definition.builder;

import bluegrass.blues.config.definition.CompositeNode;
import bluegrass.blues.config.definition.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcaseres
 * @param <TParentBuilder>
 */
public class CompositeNodeBuilder<TParentBuilder extends NodeBuilder> extends ChildNodeBuilder<TParentBuilder, CompositeNodeBuilder> {

    protected List<NodeBuilder> childrenBuilders;
    
    protected CompositeNodeBuilder() {
        super();
        this.childrenBuilders = new ArrayList<>();
        
    }
    
    public CompositeNodeBuilder(String name, TParentBuilder parentBuilder) {
        super(name, parentBuilder);
        this.childrenBuilders = new ArrayList<>();
    }

    @Override
    public Node build() {
        CompositeNode node = new CompositeNode(this.name);
        for (NodeBuilder builder : this.childrenBuilders) {
            node.addChild(builder.build());
        }
        
        return node;
    }
    
    public StringNodeBuilder<CompositeNodeBuilder<TParentBuilder>> stringChild(String name) {
        StringNodeBuilder builder = new StringNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;
    }
    
    public IntegerNodeBuilder<CompositeNodeBuilder<TParentBuilder>> integerChild(String name) {
        IntegerNodeBuilder builder = new IntegerNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;
    }
    
    public CompositeNodeBuilder<CompositeNodeBuilder<TParentBuilder>> compositeChild(String name) {
        CompositeNodeBuilder builder = new CompositeNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;
    }
    
    public PrototypeArrayNodeBuilder<CompositeNodeBuilder<TParentBuilder>> prototypeArrayChild(String name) {
        PrototypeArrayNodeBuilder builder = new PrototypeArrayNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;        
    }
    
}
