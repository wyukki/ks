package kt.spring.ks.service

import kt.spring.ks.model.Bank

interface BankService {

    fun getBanks(): Collection<Bank>;
}