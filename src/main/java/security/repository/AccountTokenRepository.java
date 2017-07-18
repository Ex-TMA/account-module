package security.repository;

import org.springframework.data.repository.CrudRepository;
import security.model.AccountToken;

/**
 * Created by truongnguyen on 7/18/17.
 */
public interface AccountTokenRepository extends CrudRepository<AccountToken, Long>{
}
