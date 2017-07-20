package account.model;

import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
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
    private int timeToLiveInMinutes;

    @ManyToMany
    private List<AccountAccess> accesses;

    protected Account() {
    }

    public Account(String userName, String pass, AccountState state, String name, String email) {
        this.userName = userName;
        this.pass = pass;
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
        this.pass = pass;
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

    public int getTimeToLiveInMinutes() {
        return timeToLiveInMinutes;
    }

    public void setTimeToLiveInMinutes(int timeToLiveInMinutes) {
        this.timeToLiveInMinutes = timeToLiveInMinutes;
    }
    public void addAccess(AccountAccess access){
        this.accesses.add(access);
    }

    @Override
    public String toString(){
        return String.format("Account[id=%d, name=%s]",id, name);
    }
}