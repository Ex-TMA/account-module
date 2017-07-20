package account.repository;

import account.model.Account;
import account.model.AccountAccess;
import account.model.AccountState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by truongnguyen on 7/18/17.
 */
@RepositoryRestResource(collectionResourceRel = "account", path = "account")
public interface AccountRepository extends JpaRepository<Account,Long> {

    @RestResource(path = "user")
    Account findByUserName(@Param("userName") String userName);

    @RestResource(path = "state")
    Page<Account> findByState(@Param("state") AccountState state, Pageable p);

    @RestResource(path = "name")
    Page<Account> findByName(@Param("name") String name, Pageable p);

    @RestResource(path = "email")
    Account findByEmail(@Param("email") String email);

    @RestResource(path = "accesses")
    Page<Account> findByAccesses(@Param("accesses") Collection<AccountAccess> accesses, Pageable p);
}
