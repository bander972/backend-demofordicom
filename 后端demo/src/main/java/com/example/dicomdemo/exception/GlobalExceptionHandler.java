package com.example.dicomdemo.exception;

import com.projectdicom.demo.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.projectdicom.demo.api.CommonResult;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@Component
@RestControllerAdvice
@Order
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleRuntimeException(RuntimeException e){
        log.error(e.getMessage());
        return CommonResult.fail(e.getMessage());
    }

    /**
     * NoHandlerFoundException 404 异常处理
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleNotFoundException(NoHandlerFoundException e) {
        log.error(e.getMessage(), e.getClass());
        // 404不需要处理 直接返回就行
        return CommonResult.fail(ResultCode.NotFound);
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleNullPointerException(NullPointerException e) {
        log.error( "发生空指针异常！");
        if (log.isDebugEnabled()) {
            e.printStackTrace();
        }
        return CommonResult.fail(ResultCode.NullPointerError);
    }

    private static final String START = "\n---------------发生未经处理的异常---------------\n";
    private static final String END = "---------------------------------------------";

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> handleException(Exception e) {
        log.error(START + "异常类：" + e.getClass().getName() + "\n" + "异常消息：" + e.getMessage() + "\n" + END);
        if (log.isDebugEnabled()) {
            e.printStackTrace();
        }
        return CommonResult.fail(ResultCode.InternalServerError);
}
}
