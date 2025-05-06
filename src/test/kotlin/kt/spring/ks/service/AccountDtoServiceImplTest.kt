package kt.spring.ks.service

import io.mockk.mockk
import io.mockk.verify
import kt.spring.ks.mapper.AccountServiceMapper
import kt.spring.ks.repository.AccountRepository
import kt.spring.ks.service.impl.AccountServiceImpl
import org.mapstruct.factory.Mappers
import kotlin.test.Test


internal class AccountDtoServiceImplTest {

    private var repository: AccountRepository = mockk(relaxed = true)
    private var mapper: AccountServiceMapper = Mappers.getMapper(AccountServiceMapper::class.java)
    private var service : AccountService = AccountServiceImpl(repository, mapper)


    @Test
    fun testGetAccounts() {

        var actual = service.getAccounts()
        verify(exactly = 1) { repository.getAccounts() }
    }
}