package account;

import account.model.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import account.model.Role;
import account.model.Account;
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

        System.out.println(accountRepository.findAll());

    }
}
