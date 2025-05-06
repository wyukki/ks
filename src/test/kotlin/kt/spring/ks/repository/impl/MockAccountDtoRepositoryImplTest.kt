package kt.spring.ks.repository.impl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockAccountDtoRepositoryImplTest {

    private val mockBankRepository = MockAccountRepositoryImpl()

    @Test
    fun testGetAccounts() {
        val actual = mockBankRepository.getAccounts()
        assertThat(actual).hasSize(3)
    }

    @Test
    fun testGetAccounts_CoreIsNotNull() {
        val actual = mockBankRepository.getAccounts()
        assertThat(actual).allMatch { true }
    }
}