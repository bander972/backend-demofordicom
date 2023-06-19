package com.example.dicomdemo.exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.projectdicom.demo.api.*;

/**
 * 处理spring相关异常
 *
 * @author thomas
 * @version 1.0
 * @date 2021/7/1 11:29
 **/
@Slf4j
@Component
@RestControllerAdvice
@Order(0)
public class SpringExceptionHandler {

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) throws Throwable {
        log.warn("出现请求异常：" + e.getClass().getName());
        log.warn(e.getMessage());
        return CommonResult.fail(ResultCode.MissingRequestParameter);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e.getClass());
        return CommonResult.fail(ResultCode.BadRequest).setError_message(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder message = new StringBuilder();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message.append(fieldError.getField()).append(fieldError.getDefaultMessage());
            }
        }
        return CommonResult.fail(message.toString());
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleValidException(BindException e) {
        log.error(e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder message = new StringBuilder();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message.append(fieldError.getField()).append(fieldError.getDefaultMessage());
            }
        }
        return CommonResult.fail(message.toString());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleAccessDeniedException(AccessDeniedException e) {
        log.error(e.getClass().getName());
        log.error(e.getMessage());
        return CommonResult.fail(ResultCode.Forbidden);
    }

    @ExceptionHandler(value = BadSqlGrammarException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleBadSqlGrammarException(BadSqlGrammarException e) throws Throwable {
        log.error(e.getClass().getName());
        log.error(e.getMessage());
        return CommonResult.fail(ResultCode.InternalServerError);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) throws Throwable {
        log.debug(e.getClass().getName());
        log.debug(e.getMessage());
        return CommonResult.fail(ResultCode.RequestMethodNotSupported);
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleDuplicateKeyException(DuplicateKeyException e) throws Throwable {
        log.debug(e.getClass().getName());
        log.debug(e.getMessage());
        return CommonResult.fail(ResultCode.DuplicateKeyError);
    }

}
