package kt.spring.ks.service

import kt.spring.ks.controller.dto.v1.CreateAccountV1Request
import kt.spring.ks.controller.dto.v1.UpdateAccountV1Request
import kt.spring.ks.service.dto.AccountDto

interface AccountService {

    fun getAccounts(): Collection<AccountDto>
    fun getAccount(id: String): AccountDto
    fun createAccount(createAccountRequest: CreateAccountV1Request): String
    fun updateAccount(accountId: String, updateAccountRequest: UpdateAccountV1Request): AccountDto
    fun deleteAccount(accountId: String)
}