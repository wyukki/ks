package kt.spring.ks.controller.advice

import kt.spring.ks.controller.dto.UserError
import kt.spring.ks.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AccountControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception): ResponseEntity<UserError> = ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(e.message?.let { UserError(it, HttpStatus.BAD_REQUEST.value()) })

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<UserError> =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(e.message?.let { UserError(it, HttpStatus.NOT_FOUND.value()) }
                ?: UserError("Required entity was not found", HttpStatus.NOT_FOUND.value()))
}