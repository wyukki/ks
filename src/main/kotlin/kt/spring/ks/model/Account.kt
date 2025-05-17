package kt.spring.ks.model


data class Account (
    var id: String?,
    val accountNumber: AccountNumber,
    val customer: Customer,
    var accountName: String
)