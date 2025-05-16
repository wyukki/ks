package kt.spring.ks.controller.dto.v1

import kt.spring.ks.service.dto.AccountDto

data class GetAccountsV1Response(var accounts: Collection<AccountDto>)