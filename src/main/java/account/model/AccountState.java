package account.model;

import java.util.Arrays;

/**
 * Created by truongnguyen on 7/19/17.
 */
public enum AccountState {
    ACTIVE("active"),
    INACTIVE("inactive");

    private String value;

    private AccountState(String value)
    {
        this.value = value;
    }

    public AccountState fromValue(String value)
    {
        for (AccountState accountState : AccountState.values()) {
            if (accountState.value.equalsIgnoreCase(value)) {
                return accountState;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum value type " + value + ", Allowed values are" + Arrays.toString(values()));
    }

}
