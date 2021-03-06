package account.model;

import account.Utils;
import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

/**
 * Created by truongnguyen on 7/18/17.
 */
@Entity
public class Account extends BaseEntity{

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotBlank
    private String userName;
    @NotBlank
    private String pass;
    @Enumerated(EnumType.STRING)
    private AccountState state;
    @NotBlank
    private String name;
    @Email
    private String email;

    @ManyToMany
    @JoinTable(name = "AccountAccess", joinColumns = { @JoinColumn(name = "accountId") }, inverseJoinColumns = { @JoinColumn(name = "accessId") })
    private List<Access> accesses;

    protected Account() {
    }

    public Account(String userName, String pass, AccountState state, String name, String email) {
        this.userName = userName;
        this.pass = Utils.encode(pass);
        this.state = state;
        this.name = name;
        this.email = email;
        this.accesses = Lists.newArrayList();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = Utils.encode(pass);
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAccess(Access access){
        this.accesses.add(access);
    }

    @Override
    public String toString(){
        return String.format("Account[id=%d, name=%s]",id, name);
    }
}
