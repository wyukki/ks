package kt.spring.ks.mapper

import kt.spring.ks.controller.dto.v1.CreateAccountV1Request
import kt.spring.ks.service.dto.AccountDto
import kt.spring.ks.service.dto.CustomerDto
import kt.spring.ks.model.Account
import kt.spring.ks.model.AccountNumber
import kt.spring.ks.model.Customer
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface AccountServiceMapper {

    @Mapping(target = "accountOwner", source = "customer")
    fun toAccountDto(account: Account): AccountDto

    @Mapping(target = "customerId", source = "id")
    fun toCustomerDto(customer: Customer): CustomerDto

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountNumber", source = "account.accountNumber")
    @Mapping(target = "customer", source = "account.customer")
    fun toAccount(createAccountV1Request: CreateAccountV1Request): Account

    @Mapping(target = "core", source = "core")
    @Mapping(target = "prefix", source = "prefix")
    @Mapping(target = "bankCode", source = "bankCode")
    @Mapping(target = "iban", source = "iban")
    fun toAccountNumber(accountNumber: CreateAccountV1Request.CreateAccountV1RequestAccount.CreateAccountV1RequestAccountNumber): AccountNumber

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    fun toCustomer(customer: CreateAccountV1Request.CreateAccountV1RequestAccount.CreateAccountV1RequestCustomer) : Customer
}