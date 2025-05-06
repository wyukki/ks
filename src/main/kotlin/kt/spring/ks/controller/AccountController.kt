package kt.spring.ks.controller

import kt.spring.ks.controller.dto.GetAccountV1Response
import kt.spring.ks.controller.dto.GetAccountsV1Response
import kt.spring.ks.service.AccountService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/accounts")
class AccountController(private val accountService: AccountService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAccounts(): GetAccountsV1Response {
        val accounts = accountService.getAccounts()
        return GetAccountsV1Response(accounts)
    }

    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: String): GetAccountV1Response {
        val account = accountService.getAccount(id)
        return GetAccountV1Response(account)
    }
}