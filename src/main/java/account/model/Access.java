package account.model;

import java.util.Arrays;

/**
 * Created by truongnguyen on 7/19/17.
 */
public enum Access {
    ADMIN("admin"),
    USER("user");

    private String value;

    private Access(String value)
    {
        this.value = value;
    }

    public Access fromValue(String value)
    {
        for (Access access : Access.values()) {
            if (access.value.equalsIgnoreCase(value)) {
                return access;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum value type " + value + ", Allowed values are" + Arrays.toString(values()));
    }
}
