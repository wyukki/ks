package kt.spring.ks.repository.impl

import kt.spring.ks.model.Account
import kt.spring.ks.model.AccountNumber
import kt.spring.ks.model.Customer
import kt.spring.ks.repository.AccountRepository
import org.springframework.stereotype.Repository

@Repository
class MockAccountRepositoryImpl : AccountRepository {

    val accounts: MutableList<Account> = mutableListOf(
        Account(
            accountNumber = AccountNumber("123", "123456789", "0100", "CZ2112301234567890100"),
            customer = Customer("1", "John Doe"),
            id = "1",
            accountName = "My account 1"
        ),
        Account(
            accountNumber = AccountNumber(null, "123456789", "0100", "CZ2112301234567890100"),
            customer = Customer("2", "Hanna Montana"),
            id = "2",
            accountName = "My account 2"

        ), Account(
            accountNumber = AccountNumber("123", "123456789", "5500", "CZ2112301234567895500"),
            customer = Customer("3", "Johnny Cash"),
            id = "3",
            accountName = "My account 3"
        )
    )

    companion object {
        @JvmStatic
        var idSequence: Int = 4;
    }

    override fun getAccounts(): Collection<Account> {
        return accounts

    }

    override fun getAccount(id: String): Account? {
        return accounts.find { it.id == id }
    }

    override fun createAccount(account: Account): String {
        val savedId = idSequence.toString()
        account.id = idSequence.toString()
        idSequence++
        accounts.add(account)
        return savedId
    }

    override fun updateAccount(accountId: String, newAccountName: String): Account? =
        accounts.find { it.id == accountId }?.let { it.accountName = newAccountName; it }

}