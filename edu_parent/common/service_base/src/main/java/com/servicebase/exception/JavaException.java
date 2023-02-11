package com.servicebase.exception;

import com.service.base.result.ResultCodeEnum;
import lombok.Data;

/**
 * @ClassName JavaException
 * @Description 自定义异常
 *              用户自己主动抛出的异常
 * @Author hyj98
 * @Date 2023-01-12 22:34
 * @Version 1.0
 */
@Data
public class JavaException extends RuntimeException{

    private Integer code;

    public JavaException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
