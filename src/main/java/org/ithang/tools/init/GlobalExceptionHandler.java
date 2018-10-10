package org.ithang.tools.init;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常处理
 * @author zyt
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
	  /** 内部错误：空指针错误，其他一切未捕获错误 */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleUnKnownException(RuntimeException ex, WebRequest request) {
        ex.printStackTrace();
        //LOG.error("请求 {},发生异常:{}", request.getDescription(true), ex.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, ex.getMessage(), headers, HttpStatus.OK, request);
    }
	
}
