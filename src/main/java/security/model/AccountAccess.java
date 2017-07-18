package security.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by truongnguyen on 7/18/17.
 */
@Entity
public class AccountAccess implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String access;

    public AccountAccess() {
    }

    public AccountAccess(String access) {
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
    @Override
    public String toString(){
        return String.format("AccountAccess[id=%d, access=%s]",id, access);
    }
}
