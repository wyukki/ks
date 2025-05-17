package kt.spring.ks.controller.dto.v1

data class UpdateAccountV1Response(val account: UpdateAccountV1ResponseAccount) {
    data class UpdateAccountV1ResponseAccount(
        val accountName: String,
        val accountNumber: UpdateAccountV1ResponseAccountNumber,
        val customer: UpdateAccountV1ResponseCustomer
    ) {
        data class UpdateAccountV1ResponseAccountNumber(
            val core: String,
            val bankCode: String,
            val prefix: String?,
            val iban: String
        )

        data class UpdateAccountV1ResponseCustomer(val name: String)
    }
}
