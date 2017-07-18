package security.repository;

import org.springframework.data.repository.CrudRepository;
import security.model.AccountAccess;

/**
 * Created by truongnguyen on 7/18/17.
 */
public interface AccountAccessRepository extends CrudRepository<AccountAccess,Long> {
}
