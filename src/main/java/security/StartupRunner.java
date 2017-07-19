package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import security.model.Access;
import security.model.Account;
import security.model.AccountAccess;
import security.model.AccountState;
import security.repository.AccountAccessRepository;
import security.repository.AccountRepository;
import security.repository.AccountTokenRepository;

/**
 * Created by truongnguyen on 7/18/17.
 */
public class StartupRunner implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountAccessRepository accountAccessRepository;
    @Autowired
    private AccountTokenRepository accountToken;

    @Override
    public void run(String... args) throws Exception {

        AccountAccess admin = accountAccessRepository.save(new AccountAccess(Access.ADMIN));
        AccountAccess user = accountAccessRepository.save(new AccountAccess(Access.USER));

        Account acc1 = new Account("truong1","password", AccountState.ACTIVE,"truong nguyen admin", "truongnguyen1610@gmail.com");
        acc1.addAccess(admin);
        accountRepository.save(acc1);

        Account acc2 = new Account("truong2","password", AccountState.ACTIVE,"truong nguyen user", "truongnguyen1610@gmail.com");
        acc2.addAccess(user);
        accountRepository.save(acc2);
    }
}
