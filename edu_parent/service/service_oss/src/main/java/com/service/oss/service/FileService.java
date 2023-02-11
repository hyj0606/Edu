package com.service.oss.service;

import java.io.InputStream;

/**
 * 文件上传服务接口
 */
public interface FileService {

    /**
     * 阿里云oss文件上传
     * @param inputStream 上传文件的输入流
     * @param module      上传到oss的文件目录
     * @param originalFileName 原始文件名
     * @return                  返回上传上去之后的url地址
     */
    String upload(InputStream inputStream, String module, String originalFileName);

}
