package kt.spring.ks.model

data class AccountNumber (
    val prefix: String?,
    val core: String,
    val bankCode: String,
    val iban: String
)