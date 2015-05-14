package bluegrass.blues.config.definition.builder;

import bluegrass.blues.config.definition.Node;

/**
 *
 * @author gcaseres
 * @param <TConcreteBuilder>
 */
public abstract class NodeBuilder<TConcreteBuilder extends NodeBuilder> {

    
    protected String name;


    protected NodeBuilder() {
        this(null);
    }

    public NodeBuilder(String name) {
        this.name = name;
    }

    public abstract Node build();

 


}
