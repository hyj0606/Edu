package com.service.oss.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName OssProperties
 * @Description 从配置文件读取变量
 * @Author hyj98
 * @Date 2023-02-07 20:50
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {

    private String endpoint;
    private String KeyId;
    private String KeySecret;
    private String buketName;


}
