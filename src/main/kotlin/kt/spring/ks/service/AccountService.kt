package kt.spring.ks.service

import kt.spring.ks.dto.AccountDto

interface AccountService {

    fun getAccounts(): Collection<AccountDto>;
    fun getAccount(id: String): AccountDto
}