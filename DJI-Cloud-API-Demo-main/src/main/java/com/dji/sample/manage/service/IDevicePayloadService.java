package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.DeviceDTO;
import com.dji.sample.manage.model.dto.DevicePayloadDTO;
import com.dji.sample.manage.model.dto.DevicePayloadReceiver;
import com.dji.sdk.cloudapi.device.PayloadFirmwareVersion;

import java.util.Collection;
import java.util.List;

/**
 * @author sean.zhou
 * @date 2021/11/19
 * @version 0.1
 */
public interface IDevicePayloadService {

    /**
     * 根据负载的序列号查询负载是否已保存。
     * @param payloadSn
     * @return
     */
    Integer checkPayloadExist(String payloadSn);

    /**
     * 保存所有有效负载数据。
     * @param payloadReceiverList
     * @return
     */
    Boolean savePayloadDTOs(DeviceDTO drone, List<DevicePayloadReceiver> payloadReceiverList);

    /**
     * 保存一个有效负载数据。
     * @param payloadReceiver
     * @return
     */
    Integer saveOnePayloadDTO(DevicePayloadReceiver payloadReceiver);

    /**
     * 根据无人机序列号查询该无人机上的所有负载数据。
     * @param deviceSn
     * @return
     */
    List<DevicePayloadDTO> getDevicePayloadEntitiesByDeviceSn(String deviceSn);

    /**
     * 根据一些无人机的序列号的集合删除这些无人机上的所有有效负载数据。
     * @param deviceSns
     */
    void deletePayloadsByDeviceSn(List<String> deviceSns);

    /**
     * 更新负载的固件版本信息。
     * @param receiver
     */
    Boolean updateFirmwareVersion(String droneSn, PayloadFirmwareVersion receiver);

    /**
     * 根据负载序列号删除负载数据。
     * @param payloadSns
     */
    void deletePayloadsByPayloadsSn(Collection<String> payloadSns);

    /**
     * 检查无人机是否有权限控制特定索引的有效载荷
     * @param deviceSn
     * @param payloadIndex
     * @return
     */
    Boolean checkAuthorityPayload(String deviceSn, String payloadIndex);

    //更新无人机的有效载荷配置，确保数据库中的有效载荷信息与实际情况相符
    void updatePayloadControl(DeviceDTO drone, List<DevicePayloadReceiver> payloads);
}