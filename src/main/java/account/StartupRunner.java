package account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import account.model.Access;
import account.model.Account;
import account.model.AccountAccess;
import account.model.AccountState;
import account.repository.AccountAccessRepository;
import account.repository.AccountRepository;
import account.repository.AccountTokenRepository;

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

        Account acc1 = new Account("truong","password", AccountState.ACTIVE,"truong nguyen admin", "truongnguyen1610@gmail.com");
        acc1.addAccess(admin);
        accountRepository.save(acc1);

        Account acc2 = new Account("son","password", AccountState.ACTIVE,"son nguyen user", "anhsonandynguyen@gmail.com");
        acc2.addAccess(user);
        accountRepository.save(acc2);
    }
}
