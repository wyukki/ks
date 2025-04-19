package kt.spring.ks.model


data class Bank (
    val accountNumber: AccountNumber,
    private val transactionFee: Double
)