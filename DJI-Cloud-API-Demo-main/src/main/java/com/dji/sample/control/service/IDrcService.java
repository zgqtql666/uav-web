package com.dji.sample.control.service;

import com.dji.sample.control.model.dto.JwtAclDTO;
import com.dji.sample.control.model.param.DrcConnectParam;
import com.dji.sample.control.model.param.DrcModeParam;
import com.dji.sdk.cloudapi.control.DrcModeMqttBroker;

/**
 * @author sean
 * @version 1.3
 * @date 2023/1/11
 */

/**
 * 定义了一个关于无人机机巢远程控制服务的接口。
 */
public interface IDrcService {

    /**
     * 在Redis中保存停靠站的DRC模式。
     * @param dockSn 停靠站的序列号
     * @param clientId 客户端ID
     */
    void setDrcModeInRedis(String dockSn, String clientId);

    /**
     * 查询控制停靠站的客户端。
     * @param dockSn 停靠站的序列号
     * @return 返回控制该停靠站的客户端ID
     */
    String getDrcModeInRedis(String dockSn);

    /**
     * 在Redis中删除停靠站的DRC模式。
     * @param dockSn 停靠站的序列号
     * @return 返回操作是否成功的布尔值
     */
    Boolean delDrcModeInRedis(String dockSn);

    /**
     * 为控制端提供MQTT选项。
     * @param workspaceId 工作空间ID
     * @param userId 用户ID
     * @param username 用户名
     * @param param 连接参数
     * @return 返回MQTT代理信息
     */
    DrcModeMqttBroker userDrcAuth(String workspaceId, String userId, String username, DrcConnectParam param);

    /**
     * 使停靠站进入DRC模式，并授予相关权限。
     * @param workspaceId 工作空间ID
     * @param param DRC模式参数
     * @return 返回JWT访问控制数据传输对象
     */
    JwtAclDTO deviceDrcEnter(String workspaceId, DrcModeParam param);

    /**
     * 使停靠站退出DRC模式。
     * @param workspaceId 工作空间ID
     * @param param DRC模式参数
     */
    void deviceDrcExit(String workspaceId, DrcModeParam param);
}
