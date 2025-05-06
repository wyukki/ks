package kt.spring.ks.service.impl

import kt.spring.ks.dto.AccountDto
import kt.spring.ks.mapper.AccountServiceMapper
import kt.spring.ks.repository.AccountRepository
import kt.spring.ks.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(private val repository: AccountRepository, private val mapper: AccountServiceMapper) : AccountService {

    override fun getAccounts(): Collection<AccountDto> {
        val accounts = repository.getAccounts()
        return accounts.map { mapper.toAccountDto(it) }
    }

    override fun getAccount(id: String): AccountDto {
        val account = repository.getAccount(id)
        account?.let { return mapper.toAccountDto(it) }
        throw RuntimeException("Account with id $id not found")
    }
}