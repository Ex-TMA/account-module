package account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import account.model.AccountAccess;

/**
 * Created by truongnguyen on 7/18/17.
 */
@Repository
public interface AccountAccessRepository extends JpaRepository<AccountAccess,Long> {
}