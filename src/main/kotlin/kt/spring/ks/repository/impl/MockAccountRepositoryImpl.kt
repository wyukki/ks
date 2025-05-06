package kt.spring.ks.repository.impl

import kt.spring.ks.model.AccountNumber
import kt.spring.ks.repository.AccountRepository
import kt.spring.ks.model.Account
import kt.spring.ks.model.Customer
import org.springframework.stereotype.Repository

@Repository
class MockAccountRepositoryImpl : AccountRepository {
    override fun getAccounts(): Collection<Account> {
        return listOf(
            Account(
                accountNumber = AccountNumber("123", "123456789", "0100", "CZ2112301234567890100"),
                customer = Customer("1", "John Doe"),
                id = "1"
            ),
            Account(
                accountNumber = AccountNumber(null, "123456789", "0100", "CZ2112301234567890100"),
                customer = Customer("2", "Hanna Montana"),
                id = "2"

            ), Account(
                accountNumber = AccountNumber("123", "123456789", "5500", "CZ2112301234567895500"),
                customer = Customer("3", "Johnny Cash"),
                id = "1"
            )
        )

    }

    override fun getAccount(id: String): Account? {
        return if (id == "1") {
            Account(
                accountNumber = AccountNumber("123", "123456789", "0100", "CZ2112301234567890100"),
                customer = Customer("1", "John Doe"),
                id = "1"
            )
        } else {
            null
        }
    }
}