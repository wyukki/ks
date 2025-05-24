package kt.spring.ks.repository

import kt.spring.ks.model.Account

interface AccountRepository {
    fun getAccounts() : Collection<Account>
    fun getAccount(id: String): Account?
    fun createAccount(account: Account): String
    fun updateAccount(accountId: String, newAccountName: String): Account?
    fun deleteAccount(accountId: String): Account?
}