package bluegrass.blues.config.definition.exception;

import bluegrass.blues.config.definition.Node;

/**
 *
 * @author gcaseres
 */
public class NodeValidationException extends Exception {

    public NodeValidationException(Node node, String message) {
        super(String.format("[%s] - %s", node.getPath(), message));
    }

}
