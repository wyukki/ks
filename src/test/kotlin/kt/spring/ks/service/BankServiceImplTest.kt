package kt.spring.ks.service

import io.mockk.mockk
import io.mockk.verify
import kt.spring.ks.repository.BankRepository
import kt.spring.ks.service.impl.BankServiceImpl
import kotlin.test.Test


internal class BankServiceImplTest {

    private var repository: BankRepository = mockk(relaxed = true)
    private var service : BankService = BankServiceImpl(repository)


    @Test
    fun testGetBanks() {

        var actual = service.getBanks()
        verify(exactly = 1) { repository.getBanks() }
    }
}