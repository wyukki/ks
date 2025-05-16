package kt.spring.ks.service.impl

import kt.spring.ks.controller.dto.v1.CreateAccountV1Request
import kt.spring.ks.service.dto.AccountDto
import kt.spring.ks.exception.NotFoundException
import kt.spring.ks.mapper.AccountServiceMapper
import kt.spring.ks.repository.AccountRepository
import kt.spring.ks.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(private val repository: AccountRepository, private val mapper: AccountServiceMapper) :
    AccountService {

    override fun getAccounts(): Collection<AccountDto> = repository.getAccounts().map { mapper.toAccountDto(it) }

    override fun getAccount(id: String): AccountDto = repository.getAccount(id)?.let { mapper.toAccountDto(it) }
        ?: throw NotFoundException("Account with id $id doesn't exist")

    override fun createAccount(createAccountRequest: CreateAccountV1Request): String =
        repository.createAccount(mapper.toAccount(createAccountRequest))
}