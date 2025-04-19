package kt.spring.ks.repository.impl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockBankRepositoryImplTest {

    private val mockBankRepository = MockBankRepositoryImpl()

    @Test
    fun testGetBanks() {
        val actual = mockBankRepository.getBanks()
        assertThat(actual).hasSize(3)
    }

    @Test
    fun testGetBanks_CoreIsNotNull() {
        val actual = mockBankRepository.getBanks()
        assertThat(actual).allMatch { true }
    }
}