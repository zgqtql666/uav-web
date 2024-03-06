package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.FirmwareModelDTO;

/**
 * @author sean
 * @version 1.3
 * @date 2022/12/21
 */
public interface IFirmwareModelService {

    /**
     * 接收一个包含固件ID和设备名称列表的 DTO（数据传输对象），将这些信息转换成实体对象，并将每个实体对象插入到数据库中
     * @param firmwareModel
     */
    void saveFirmwareDeviceName(FirmwareModelDTO firmwareModel);

}
