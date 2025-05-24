package kt.spring.ks.controller

import kt.spring.ks.controller.dto.v1.*
import kt.spring.ks.controller.mapper.AccountControllerMapper
import kt.spring.ks.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
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
    fun getAccounts(): ResponseEntity<GetAccountsV1Response> =
        ResponseEntity.ok().body(GetAccountsV1Response(accountService.getAccounts()))


    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: String): ResponseEntity<GetAccountV1Response> =
        ResponseEntity.ok().body(GetAccountV1Response(accountService.getAccount(id)))


    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createAccount(@RequestBody createAccountRequest: CreateAccountV1Request): ResponseEntity<CreateAccountV1Response> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(CreateAccountV1Response(accountService.createAccount(createAccountRequest)))

    @PatchMapping(
        "/{accountId}", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateAccount(
        @RequestBody updateAccountRequest: UpdateAccountV1Request, @PathVariable accountId: String
    ): ResponseEntity<UpdateAccountV1Response> = ResponseEntity.ok().body(
        mapper.toUpdateAccountV1Response(
            accountService.updateAccount(
                accountId, updateAccountRequest
            )
        )
    )

    @DeleteMapping("/{accountId}")
    fun deleteAccount(@PathVariable accountId: String) : ResponseEntity<Unit> {
        accountService.deleteAccount(accountId)
        return ResponseEntity.noContent().build()
    }
}