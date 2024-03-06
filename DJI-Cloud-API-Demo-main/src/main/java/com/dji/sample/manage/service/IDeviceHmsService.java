package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.DeviceHmsDTO;
import com.dji.sample.manage.model.param.DeviceHmsQueryParam;
import com.dji.sdk.common.PaginationData;

/**
 * @author sean
 * @version 1.1
 * @date 2022/7/6
 */
public interface IDeviceHmsService {

    /**
     * 根据查询参数进行分页查询HMS数据。
     * @param param
     * @return
     */
    PaginationData<DeviceHmsDTO> getDeviceHmsByParam(DeviceHmsQueryParam param);

    /**
     * 标记指定设备的所有未读HMS消息为已读。
     * @param deviceSn
     */
    void updateUnreadHms(String deviceSn);
}
