package kt.spring.ks.mapper

import kt.spring.ks.dto.AccountDto
import kt.spring.ks.dto.CustomerDto
import kt.spring.ks.model.Account
import kt.spring.ks.model.Customer
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface AccountServiceMapper {

    @Mapping(target = "accountOwner", source = "customer")
    fun toAccountDto(account : Account) : AccountDto

    @Mapping(target = "customerId", source = "id")
    fun toCustomerDto(customer: Customer) : CustomerDto

}