package request;

import java.util.Optional;
import java.util.Set;

/**
 * Created by kevin on 06/03/17.
 */
public abstract class IRequest {

    abstract String[] getStrings(String key);

    abstract Optional<String> getOptionalString(String key);

    abstract Optional<Integer> getOptionalInt(String key);

    abstract Optional<Long> getOptionalLong(String key);

    abstract Optional<Boolean> getOptionalBoolean(String key);

    abstract Optional<Double> getOptionalDouble(String key);

    abstract Set<String> getKeys();

    public boolean getBoolean(String key) {
        Optional<Boolean> result = getOptionalBoolean(key);

        return result.orElseThrow(() -> new IllegalStateException("The request requires parameter " + key));
    }

    public double getDouble(String key) {
        Optional<Double> result = getOptionalDouble(key);

        return result.orElseThrow(() -> new IllegalStateException("The request requires parameter " + key));
    }

    public String getString(String key) {
        Optional<String> result = getOptionalString(key);

        return result.orElseThrow(() -> new IllegalStateException("The request requires parameter " + key));
    }

    public int getInt(String key) {
        Optional<Integer> result = getOptionalInt(key);

        return result.orElseThrow(() -> new IllegalStateException("The request requires parameter " + key));
    }

    public long getLong(String key) {
        Optional<Long> result = getOptionalLong(key);

        return result.orElseThrow(() -> new IllegalStateException("The request requires parameter " + key));
    }
}

