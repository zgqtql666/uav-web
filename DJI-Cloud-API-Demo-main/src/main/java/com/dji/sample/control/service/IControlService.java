package com.dji.sample.control.service;

import com.dji.sample.control.model.enums.DroneAuthorityEnum;
import com.dji.sample.control.model.enums.RemoteDebugMethodEnum;
import com.dji.sample.control.model.param.*;
import com.dji.sdk.common.HttpResultResponse;

/**
 * @author sean
 * @version 1.2
 * @date 2022/7/29
 */

/**
 * 定义了一个无人机控制服务接口。
 */
public interface IControlService {

    /**
     * 通过命令远程调试无人机机巢。
     * @param sn 无人机的序列号
     * @param serviceIdentifier 调试服务的标识符
     * @param param 调试参数
     * @return 返回调试结果
     */
    HttpResultResponse controlDockDebug(String sn, RemoteDebugMethodEnum serviceIdentifier, RemoteDebugParam param);

    /**
     * 控制无人机飞往目标点。
     * @param sn 无人机的序列号
     * @param param 飞行参数
     * @return 返回飞行结果
     */
    HttpResultResponse flyToPoint(String sn, FlyToPointParam param);

    /**
     * 结束无人机飞往目标点的任务。
     * @param sn 无人机的序列号
     * @return 返回操作结果
     */
    HttpResultResponse flyToPointStop(String sn);

    /**
     * 处理飞往目标点过程中的进度结果通知。
     * @param receiver 消息接收器
     * @param headers 消息头
     * @return 返回处理结果
     */
    // CommonTopicReceiver handleFlyToPointProgress(CommonTopicReceiver receiver, MessageHeaders headers);


    /**
     * 控制无人机起飞。
     * @param sn 无人机的序列号
     * @param param 起飞参数
     * @return 返回起飞结果
     */
    HttpResultResponse takeoffToPoint(String sn, TakeoffToPointParam param);

    /**
     * 抢占无人机的控制权或有效载荷控制权。
     * @param sn 无人机的序列号
     * @param authority 控制权类型
     * @param param 相关参数
     * @return 返回操作结果
     */
    HttpResultResponse seizeAuthority(String sn, DroneAuthorityEnum authority, DronePayloadParam param);

    /**
     * 操作无人机的有效载荷。
     * @param param 载荷命令参数
     * @return 返回操作结果
     */
    HttpResultResponse payloadCommands(PayloadCommandsParam param) throws Exception;
}
