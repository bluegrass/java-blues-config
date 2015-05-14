package bluegrass.blues.config.definition.builder;

import bluegrass.blues.config.definition.Node;
import bluegrass.blues.config.definition.RootNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcaseres
 */
public class RootNodeBuilder extends NodeBuilder<RootNodeBuilder> {

    protected List<NodeBuilder> childrenBuilders;

    public RootNodeBuilder() {
        super();
        this.childrenBuilders = new ArrayList<>();
    }

    @Override
    public Node build() {
        RootNode node = new RootNode();

        for (NodeBuilder builder : this.childrenBuilders) {
            node.addChild(builder.build());
        }

        return node;

    }

    public StringNodeBuilder<RootNodeBuilder> stringChild(String name) {
        StringNodeBuilder builder = new StringNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;
    }

    public IntegerNodeBuilder<RootNodeBuilder> integerChild(String name) {
        IntegerNodeBuilder builder = new IntegerNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;

    }

    public CompositeNodeBuilder<RootNodeBuilder> compositeChild(String name) {
        CompositeNodeBuilder builder = new CompositeNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;
    }

    public PrototypeArrayNodeBuilder<RootNodeBuilder> prototypeArrayChild(String name) {
        PrototypeArrayNodeBuilder builder = new PrototypeArrayNodeBuilder(name, this);
        this.childrenBuilders.add(builder);
        
        return builder;        
    }
    
}
