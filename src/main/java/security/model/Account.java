package security.model;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by truongnguyen on 7/18/17.
 */
@Entity
public class Account implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String userName;
    private String pass;
    private String state;
    private String name;
    private String email;
    private int timeToLiveInMinutes;

    @ManyToMany
    private List<AccountAccess> accesses;

    protected Account() {
    }

    public Account(String userName, String pass, String state, String name, String email) {
        this.userName = userName;
        this.pass = pass;
        this.state = state;
        this.name = name;
        this.email = email;
        this.accesses = Lists.newArrayList();
    }

    public Long getId() {
        return id;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
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
