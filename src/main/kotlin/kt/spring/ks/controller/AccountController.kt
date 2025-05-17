package kt.spring.ks.controller

import kt.spring.ks.controller.dto.v1.*
import kt.spring.ks.controller.mapper.AccountControllerMapper
import kt.spring.ks.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/accounts")
class AccountController(private val accountService: AccountService, private val mapper: AccountControllerMapper) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAccounts(): ResponseEntity<GetAccountsV1Response> {
        val accounts = accountService.getAccounts()
        return ResponseEntity.ok()
            .body(GetAccountsV1Response(accounts))
    }

    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: String): ResponseEntity<GetAccountV1Response> {
        val account = accountService.getAccount(id)
        return ResponseEntity.ok()
            .body(GetAccountV1Response(account))
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createAccount(@RequestBody createAccountRequest: CreateAccountV1Request): ResponseEntity<CreateAccountV1Response> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CreateAccountV1Response(accountService.createAccount(createAccountRequest)))
    }

    @PatchMapping("/{accountId}", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateAccount(
        @RequestBody updateAccountRequest: UpdateAccountV1Request,
        @PathVariable accountId: String
    ): ResponseEntity<UpdateAccountV1Response> {
        return ResponseEntity.ok()
            .body(
                mapper.toUpdateAccountV1Response(
                    accountService.updateAccount(
                        accountId,
                        updateAccountRequest
                    )
                )
            )

    }
}