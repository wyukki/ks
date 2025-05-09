package kt.spring.ks.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

private const val ACCOUNTS_URL = "/api/v1/accounts"

@SpringBootTest
@AutoConfigureMockMvc
internal class AccountDtoControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun testGetAccounts() {
        mockMvc.get(ACCOUNTS_URL)
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("accounts[0].id") { value("1") }
            }
    }

    @Test
    fun testGetAccount() {
        mockMvc.get("$ACCOUNTS_URL/1")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("accountDto.accountNumber.core") { value("123456789") }
            }
    }

    @Test
    fun testGetAccount_NotExists() {
        val accountId = "does_not_exists"
        mockMvc.get("$ACCOUNTS_URL/$accountId")
            .andDo { print() }
            .andExpect {
                status { isNotFound()}
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("message") { value("Account with id $accountId doesn't exist") }
            }
    }
}