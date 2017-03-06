package request;

/**
 * Created by kevin on 06/03/17.
 */
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import play.mvc.Http.Request;

import java.util.*;
import java.util.stream.Collectors;


public class BaseBodyRequest extends IRequest{

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    private Map<String, String[]> body;

    public BaseBodyRequest(Request httpRequest) {
        Preconditions.checkNotNull(httpRequest);

        this.body = httpRequest.body().asFormUrlEncoded();
    }

    public BaseBodyRequest(Map<String, String[]> body) {
        Preconditions.checkNotNull(body);

        this.body = body;
    }

    public BaseBodyRequest() {
    }

    public String[] getStrings(String key) {
        Preconditions.checkNotNull(key);

        String[] values = body.get(key);
        return values != null ? values : EMPTY_STRING_ARRAY;
    }

    public Optional<String> getOptionalString(String key) {
        Preconditions.checkNotNull(key);

        String[] values = body.get(key);

        if (values == null || values.length != 1) {
            return Optional.empty();
        }

        return Optional.of(values[0]);
    }

    public int getInt(String key) {
        return Integer.parseInt(getString(key));
    }

    public long getLong(String key) {
        return Long.parseLong(getString(key));
    }

    public Optional<Integer> getOptionalInt(String key) {
        Optional<String> result = getOptionalString(key);

        try {
            return result.map(s1 -> Integer.parseInt(s1));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public <T extends Number> List<T> getNumberList(String key, Class<T> type) {
        List<String> strings = Arrays.asList(getStrings(key));
        List<T> result = new ArrayList<>();

        for (String s: strings) {
            if (type == Integer.class) {
                result.add(type.cast(Integer.parseInt(s)));
            } else if (type == Long.class) {
                result.add(type.cast(Long.parseLong(s)));
            } else if (type == Byte.class) {
                result.add(type.cast(Byte.parseByte(s)));
            } else if (type == Short.class) {
                result.add(type.cast(Short.parseShort(s)));
            } else if (type == Float.class) {
                result.add(type.cast(Float.parseFloat(s)));
            } else if (type == Double.class) {
                result.add(type.cast(Double.parseDouble(s)));
            } else {
                throw new ClassCastException(type.toString() + " is not valid. Might need to be added to the if statement");
            }
        }
        return result;
    }

    public Optional<Long> getOptionalLong(String key) {
        Optional<String> result = getOptionalString(key);

        try {
            return result.map(s1 -> Long.parseLong(s1));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override
    Optional<Boolean> getOptionalBoolean(String key) {
        Optional<String> result = getOptionalString(key);

        return result.map(s1 -> Boolean.parseBoolean(s1));
    }

    @Override
    Optional<Double> getOptionalDouble(String key) {
        Optional<String> result = getOptionalString(key);

        try {
            return result.map(s1 -> Double.parseDouble(s1));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override
    public Set<String> getKeys() {
        return this.body.keySet();
    }

    @Override
    public double getDouble(String key) {
        return Double.parseDouble(getString(key));
    }

    @Override
    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(getString(key));
    }

}

