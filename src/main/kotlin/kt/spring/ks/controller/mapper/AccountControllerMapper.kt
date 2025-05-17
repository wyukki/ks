package kt.spring.ks.controller.mapper

import kt.spring.ks.controller.dto.v1.UpdateAccountV1Response
import kt.spring.ks.service.dto.AccountDto
import kt.spring.ks.service.dto.AccountNumber
import kt.spring.ks.service.dto.CustomerDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface AccountControllerMapper {

    @Mapping(target = "account", source = "account")
    @Mapping(target = "copy", ignore = true)
    fun toUpdateAccountV1Response(account: AccountDto): UpdateAccountV1Response


    @Mapping(target = "accountName", source = "accountName")
    @Mapping(target = "accountNumber", source = "accountNumber")
    @Mapping(target = "customer", source = "accountOwner")
    fun toUpdateAccountV1ResponseAccount(account: AccountDto): UpdateAccountV1Response.UpdateAccountV1ResponseAccount

    @Mapping(target = "core", source = "core")
    @Mapping(target = "bankCode", source = "bankCode")
    @Mapping(target = "prefix", source = "prefix")
    @Mapping(target = "iban", source = "iban")
    fun toUpdateAccountV1ResponseAccountNumber(accountNumber: AccountNumber): UpdateAccountV1Response.UpdateAccountV1ResponseAccount.UpdateAccountV1ResponseAccountNumber


    @Mapping(target = "name", source = "name")
    @Mapping(target = "copy", ignore = true)
    fun toUpdateAccountV1ResponseCustomer(accountOwner: CustomerDto): UpdateAccountV1Response.UpdateAccountV1ResponseAccount.UpdateAccountV1ResponseCustomer
}