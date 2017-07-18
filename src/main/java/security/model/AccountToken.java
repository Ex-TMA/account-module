package security.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by truongnguyen on 7/18/17.
 */
@Entity
public class AccountToken implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String token;
    private String ip;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiresAt;
    @ManyToOne
    private Account account;

    protected AccountToken() {
    }

    public AccountToken(String token, String ip, Date expiresAt, Account account) {
        this.token = token;
        this.ip = ip;
        this.expiresAt = expiresAt;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public String toString(){
        return String.format("AccountToken[id=%d, token=%s]",id, token);
    }
}