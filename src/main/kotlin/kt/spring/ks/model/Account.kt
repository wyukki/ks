package kt.spring.ks.model


data class Account (
    val id: String,
    val accountNumber: AccountNumber,
    val customer: Customer
)