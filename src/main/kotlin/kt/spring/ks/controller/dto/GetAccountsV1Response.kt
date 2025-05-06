package kt.spring.ks.controller.dto

import kt.spring.ks.dto.AccountDto

data class GetAccountsV1Response(var accounts: Collection<AccountDto>)