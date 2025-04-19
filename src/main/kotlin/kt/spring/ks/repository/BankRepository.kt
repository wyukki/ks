package kt.spring.ks.repository

import kt.spring.ks.model.Bank

interface BankRepository {
    fun getBanks() : Collection<Bank>
}