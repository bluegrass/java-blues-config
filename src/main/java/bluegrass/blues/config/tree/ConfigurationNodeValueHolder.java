package bluegrass.blues.config.tree;

import com.toddfast.util.convert.TypeConverter;

/**
 *
 * @author gcaseres
 */
public class ConfigurationNodeValueHolder {

    private Object value;

    public ConfigurationNodeValueHolder(Object value) {
        this.value = value;
    }

    public Object asObject() {
        return this.value;
    }

    public String asString() {
        return TypeConverter.asString(this.value);
    }

    public Integer asInteger() {
        return TypeConverter.asInt(this.value);
    }

    public Long asLong() {
        return TypeConverter.asLong(this.value);
    }        
    
}
