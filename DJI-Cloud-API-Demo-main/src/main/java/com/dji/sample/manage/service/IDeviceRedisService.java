package com.dji.sample.manage.service;

import com.dji.sample.component.mqtt.model.EventsReceiver;
import com.dji.sample.manage.model.dto.DeviceDTO;
import com.dji.sdk.cloudapi.firmware.OtaProgress;

import java.util.Optional;
import java.util.Set;

/**
 * @author sean
 * @version 1.4
 * @date 2023/3/21
 */
public interface IDeviceRedisService {

    /**
     * 确定设备是否上云。
     * @param sn
     * @return
     */
    Boolean checkDeviceOnline(String sn);

    /**
     * 在redis中查询设备的基本信息。
     * @param sn
     * @return
     */
    Optional<DeviceDTO> getDeviceOnline(String sn);

    /**
     * 将设备的基本信息保存在 redis 中。
     * @param device
     */
    void setDeviceOnline(DeviceDTO device);

    /**
     * 删除保存在 redis 中的设备基本信息。
     * @param sn
     * @return
     */
    Boolean delDeviceOnline(String sn);

    /**
     * Save the device's osd real-time data.
     * @param sn
     * @param data
     * @return
     */
    void setDeviceOsd(String sn, Object data);

    /**
     * Get the device's osd real-time data.
     * @param sn
     * @param clazz
     * @param <T>
     * @return
     */
    <T> Optional<T> getDeviceOsd(String sn, Class<T> clazz);
    /**
     * Delete the device's osd real-time data.
     * @param sn
     * @return
     */
    Boolean delDeviceOsd(String sn);

    /**
     * 将设备的固件更新进度保存在 redis 中。
     * @param sn
     * @param events
     */
    void setFirmwareUpgrading(String sn, EventsReceiver<OtaProgress> events);

    /**
     * 在redis中查询设备的固件更新进度。
     * @param sn
     * @return
     */
    Optional<EventsReceiver<OtaProgress>> getFirmwareUpgradingProgress(String sn);

    /**
     * 在 redis 中删除设备的固件更新进度。
     * @param sn
     * @return
     */
    Boolean delFirmwareUpgrading(String sn);

    /**
     * 将设备的 hms 密钥保存在 redis 中。
     * @param sn
     * @param keys
     */
    void addEndHmsKeys(String sn, String... keys);

    /**
     * 在 redis 中查询设备的所有 hms key。
     * @param sn
     * @return
     */
    Set<String> getAllHmsKeys(String sn);

    /**
     * 删除 redis 中设备的所有 hms key。
     * @param sn
     * @return
     */
    Boolean delHmsKeysBySn(String sn);

    //清除离线设备的所有信息
    void gatewayOffline(String gatewaySn);

    //用于当设备子设备离线时清除所有相关的状态和信息记录
    void subDeviceOffline(String deviceSn);
}
