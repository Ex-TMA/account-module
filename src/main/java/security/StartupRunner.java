package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import security.model.Account;
import security.model.AccountAccess;
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

        AccountAccess access = accountAccessRepository.save(new AccountAccess("ADMIN"));

        Account acc = new Account("truong","password","active","truong nguyen", "truongnguyen1610@gmail.com");
        acc.addAccess(access);
        accountRepository.save(acc);
    }
}
