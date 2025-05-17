package kt.spring.ks.service.dto


data class AccountDto(var id: String, var accountNumber: AccountNumber, var accountOwner: CustomerDto, val accountName: String)
