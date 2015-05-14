package bluegrass.blues.config.definition;

/**
 *
 * @author gcaseres
 */
public class RootNode extends CompositeNode {

    public RootNode() {

    }
    
    @Override
    public String getPath() {
        return "root";
    }
/*
    @Override
    protected void validateName(ConfigurationNode configNode) throws NodeValidationException {
        
            Root nodes have not name validation.
        
    }
*/
}
