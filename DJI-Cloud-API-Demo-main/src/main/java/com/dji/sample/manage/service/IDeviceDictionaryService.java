package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.DeviceDictionaryDTO;

import java.util.Optional;

/**
 * @author sean.zhou
 * @version 0.1
 * @date 2021/11/15
 */
public interface IDeviceDictionaryService {

    /**
     * 根据领域、设备类型和子类型查询设备的类型数据。
     *
     * @param domain 领域
     * @param deviceType 设备类型
     * @param subType 子类型
     * @return 返回设备字典数据传输对象的Optional
     */
    Optional<DeviceDictionaryDTO> getOneDictionaryInfoByTypeSubType(Integer domain, Integer deviceType, Integer subType);

}
