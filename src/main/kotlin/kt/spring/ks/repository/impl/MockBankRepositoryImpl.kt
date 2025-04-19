package kt.spring.ks.repository.impl

import kt.spring.ks.model.AccountNumber
import kt.spring.ks.repository.BankRepository
import kt.spring.ks.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankRepositoryImpl : BankRepository {
    override fun getBanks(): Collection<Bank> {
        return listOf(Bank(
            accountNumber = AccountNumber("123", "123456789", "0100", "CZ2112301234567890100"),
            transactionFee = 2.3
        ),
            Bank(
                accountNumber = AccountNumber(null, "123456789", "0100", "CZ2112301234567890100"),
                transactionFee = 2.3
            ),Bank(
                accountNumber = AccountNumber("123", "123456789", "5500", "CZ2112301234567895500"),
                transactionFee = 3.2
            ))
    }
}