package kt.spring.ks.controller.dto.v1

data class CreateAccountV1Request(val account: CreateAccountV1RequestAccount) {
    data class CreateAccountV1RequestAccount(val accountNumber: CreateAccountV1RequestAccountNumber, val customer: CreateAccountV1RequestCustomer) {
        data class CreateAccountV1RequestAccountNumber(val core: String, val bankCode: String, val prefix: String?, val iban: String)
        data class CreateAccountV1RequestCustomer(val name: String)
    }
}
