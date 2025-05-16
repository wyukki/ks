package kt.spring.ks.controller

import com.fasterxml.jackson.databind.ObjectMapper
import kt.spring.ks.controller.dto.v1.CreateAccountV1Request
import org.hamcrest.Matchers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.util.regex.Pattern

private const val ACCOUNTS_URL = "/api/v1/accounts"
private val ACCOUNT_ID_PATTERN = Pattern.compile("[0-9]+")

@SpringBootTest
@AutoConfigureMockMvc
internal class AccountDtoControllerTest @Autowired constructor(val mockMvc: MockMvc, val objectMapper: ObjectMapper) {


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

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("GET /api/v1/accounts/{}")
    inner class GetAccountTests {
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
                    status { isNotFound() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("message") { value("Account with id $accountId doesn't exist") }
                }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("POST /api/v1/accounts/{}")
    inner class CreateAccountTests {
        @Test
        fun testCreateAccountOk() {

            val requestBody = CreateAccountV1Request(
                CreateAccountV1Request.CreateAccountV1RequestAccount(
                    customer = CreateAccountV1Request.CreateAccountV1RequestAccount.CreateAccountV1RequestCustomer(
                        name = "John"
                    ),
                    accountNumber = CreateAccountV1Request.CreateAccountV1RequestAccount.CreateAccountV1RequestAccountNumber(
                        "123", "0100", null, "CZ0000001230100"
                    )
                )
            )

            mockMvc.post(ACCOUNTS_URL) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(requestBody)
            }
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("id") {value(Matchers.matchesPattern(ACCOUNT_ID_PATTERN))}
                }
        }
    }

}