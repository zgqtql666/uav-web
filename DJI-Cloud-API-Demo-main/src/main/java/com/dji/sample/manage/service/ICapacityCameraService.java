package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.CapacityCameraDTO;
import com.dji.sample.manage.model.receiver.CapacityCameraReceiver;

import java.util.List;

/**
 * @author sean.zhou
 * @date 2021/11/19
 * @version 0.1
 */
public interface ICapacityCameraService {

    /**
     * 根据设备序列号查询可从此设备实时直播的所有相机数据。
     * @param deviceSn 设备序列号
     * @return 返回相机能力的数据传输对象列表
     */
    List<CapacityCameraDTO> getCapacityCameraByDeviceSn(String deviceSn);

    /**
     * 根据设备序列号删除此设备的所有实时能力数据。
     * @param deviceSn 设备序列号
     * @return 返回操作是否成功的布尔值
     */
    Boolean deleteCapacityCameraByDeviceSn(String deviceSn);

    /**
     * 保存设备的实时能力数据。
     * @param capacityCameraReceivers 相机能力接收对象列表
     * @param deviceSn 设备序列号
     */
    void saveCapacityCameraReceiverList(List<CapacityCameraReceiver> capacityCameraReceivers, String deviceSn);

    /**
     * 将接收到的相机能力对象转换为相机数据传输对象。
     * @param receiver 相机能力接收对象
     * @return 返回相机数据传输对象
     */
    CapacityCameraDTO receiver2Dto(CapacityCameraReceiver receiver);
}
