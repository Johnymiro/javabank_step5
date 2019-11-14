package org.academiadecodigo.javabank.model.account;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * A checking account with no restrictions
 * @see Account
 * @see AccountType#CHECKING
 */
@Entity(name = "checkingaccount_single_account")
@DiscriminatorValue("checkingaccount")
public class CheckingAccount extends AbstractAccount {

    /**
     * @see Account#getAccountType()
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
