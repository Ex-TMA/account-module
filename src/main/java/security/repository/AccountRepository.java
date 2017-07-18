package security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import security.model.Account;

/**
 * Created by truongnguyen on 7/18/17.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
}
