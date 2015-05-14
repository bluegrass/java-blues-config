package bluegrass.blues.config.definition.builder;

/**
 * Builder for every node that has a parent (all non root nodes).
 * 
 * This kind of builder has an {@link end()} method that returns the parent
 * builder.
 * 
 * @author gcaseres
 * @param <TParentBuilder> Type of the parent builder that created this builder.
 * @param <TConcreteBuilder> Type of the concrete builder returned by builder methods.
 */
public abstract class ChildNodeBuilder<TParentBuilder extends NodeBuilder, TConcreteBuilder extends ChildNodeBuilder> extends NodeBuilder<TConcreteBuilder> {

    protected TParentBuilder parentBuilder;

    protected ChildNodeBuilder() {
        super();
    }

    public ChildNodeBuilder(String name, TParentBuilder parentBuilder) {
        super(name);
        this.parentBuilder = parentBuilder;
    }

    public TParentBuilder end() {
        return this.parentBuilder;
    }

}
