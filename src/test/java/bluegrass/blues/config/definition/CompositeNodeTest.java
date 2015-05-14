package bluegrass.blues.config.definition;

/**
 *
 * @author gcaseres
 */
public class CompositeNodeTest {
    /*
    @Test
    public void testValidateOptionalChildren() throws NodeValidationException {
        CompositeNode parent = new CompositeNode("parent");
        Node optionalChild = Mockito.mock(Node.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(optionalChild.getName()).thenReturn("optional-child");
        optionalChild.setMinOccurences(0);
        
        parent.addChild(optionalChild);
        
        ConfigurationNodeMock parentConfigNode = new ConfigurationNodeMock("parent", null);
        
        parent.validate(parentConfigNode);        
    }
    
    
    @Test(expected = NodeValidationException.class)
    public void testValidateChildrenMinOcurrencesFail() throws NodeValidationException {
        CompositeNode parent = new CompositeNode("parent");
        Node optionalChild = Mockito.mock(Node.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(optionalChild.getName()).thenReturn("min-occurences-child");
        optionalChild.setMinOccurences(2);
        
        parent.addChild(optionalChild);
        
        ConfigurationNodeMock parentConfigNode = new ConfigurationNodeMock("parent", null);
        parentConfigNode.addChild(new ConfigurationNodeMock("min-occurences-child", 1));
                
        parent.validate(parentConfigNode);        
    }        
    
    @Test
    public void testValidateChildrenMinOcurrencesSuccess() throws NodeValidationException {
        CompositeNode parent = new CompositeNode("parent");
        Node optionalChild = Mockito.mock(Node.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(optionalChild.getName()).thenReturn("min-occurences-child");
        optionalChild.setMinOccurences(2);
        
        parent.addChild(optionalChild);
        
        ConfigurationNodeMock parentConfigNode = new ConfigurationNodeMock("parent", null);
        parentConfigNode.addChild(new ConfigurationNodeMock("min-occurences-child", 1));
        parentConfigNode.addChild(new ConfigurationNodeMock("min-occurences-child", 2));
        
        parent.validate(parentConfigNode);        
        
        parentConfigNode.addChild(new ConfigurationNodeMock("min-occurences-child", 3));
        
        parent.validate(parentConfigNode);        
                
        
    }            
    
    @Test
    public void testValidateChildrenMaxOcurrencesSuccess() throws NodeValidationException {
        CompositeNode parent = new CompositeNode("parent");
        Node optionalChild = Mockito.mock(Node.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(optionalChild.getName()).thenReturn("max-occurences-child");
        optionalChild.setMaxOccurences(3);
        
        parent.addChild(optionalChild);
        
        ConfigurationNodeMock parentConfigNode = new ConfigurationNodeMock("parent", null);
        parentConfigNode.addChild(new ConfigurationNodeMock("max-occurences-child", 1));
        parentConfigNode.addChild(new ConfigurationNodeMock("max-occurences-child", 2));
        
        parent.validate(parentConfigNode);        
        
        parentConfigNode.addChild(new ConfigurationNodeMock("max-occurences-child", 3));
        
        parent.validate(parentConfigNode);        
        
    }            
    
    @Test(expected = NodeValidationException.class)
    public void testValidateChildrenMaxOcurrencesFail() throws NodeValidationException {
        CompositeNode parent = new CompositeNode("parent");
        Node optionalChild = Mockito.mock(Node.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(optionalChild.getName()).thenReturn("max-occurences-child");
        optionalChild.setMaxOccurences(2);
        
        parent.addChild(optionalChild);
        
        ConfigurationNodeMock parentConfigNode = new ConfigurationNodeMock("parent", null);
        parentConfigNode.addChild(new ConfigurationNodeMock("max-occurences-child", 1));
        parentConfigNode.addChild(new ConfigurationNodeMock("max-occurences-child", 2));
        parentConfigNode.addChild(new ConfigurationNodeMock("max-occurences-child", 3));
                
        parent.validate(parentConfigNode);        
    }        
    
    */
}
