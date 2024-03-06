package com.dji.sample.storage.service;

import com.dji.sdk.cloudapi.storage.StsCredentialsResponse;

/**
 * @author sean
 * @version 0.3
 * @date 2021/12/29
 */
public interface IStorageService {

    /**
     * 需要云存储集成、安全数据访问、配置管理以及与MQTT协议相关的消息处理的应用程序开发中
     * @return临时凭证对象
     */
    StsCredentialsResponse getSTSCredentials();

}
