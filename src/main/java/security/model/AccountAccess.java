package security.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by truongnguyen on 7/18/17.
 */
@Entity
public class AccountAccess extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Access access;

    public AccountAccess() {
    }

    public AccountAccess(Access access) {
        this.access = access;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }
    @Override
    public String toString(){
        return String.format("AccountAccess[id=%d, access=%s]",id, access);
    }
}
