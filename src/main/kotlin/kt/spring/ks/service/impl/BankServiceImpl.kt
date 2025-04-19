package kt.spring.ks.service.impl

import kt.spring.ks.model.Bank
import kt.spring.ks.repository.BankRepository
import kt.spring.ks.service.BankService
import org.springframework.stereotype.Service

@Service
class BankServiceImpl(private val repository: BankRepository): BankService {

    override fun getBanks(): Collection<Bank> = repository.getBanks()
}