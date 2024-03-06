package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.DeviceLogsDTO;
import com.dji.sample.manage.model.param.DeviceLogsCreateParam;
import com.dji.sample.manage.model.param.DeviceLogsQueryParam;
import com.dji.sdk.cloudapi.log.FileUploadUpdateRequest;
import com.dji.sdk.cloudapi.log.LogModuleEnum;
import com.dji.sdk.common.HttpResultResponse;
import com.dji.sdk.common.PaginationData;

import java.net.URL;
import java.util.List;

/**
 * @author sean
 * @version 1.2
 * @date 2022/9/7
 */
public interface IDeviceLogsService {

    /**
     * 根据查询参数进行分页，获取设备上传日志列表。
     * @param deviceSn
     * @param param
     * @return
     */
    PaginationData<DeviceLogsDTO> getUploadedLogs(String deviceSn, DeviceLogsQueryParam param);

    /**
     * 获取可实时上传的日志文件列表。
     * @param deviceSn
     * @param domainList
     * @return
     */
    HttpResultResponse getRealTimeLogs(String deviceSn, List<LogModuleEnum> domainList);

    /**
     * 添加设备日志。
     *
     * @param bid
     * @param username
     * @param deviceSn
     * @param param
     * @return logs id
     */
    String insertDeviceLogs(String bid, String username, String deviceSn, DeviceLogsCreateParam param);

    /**
     * 向网关发起日志上传请求。
     * @param username
     * @param deviceSn
     * @param param
     * @return
     */
    HttpResultResponse pushFileUpload(String username, String deviceSn, DeviceLogsCreateParam param);

    /**
     * 推送修改日志文件状态的请求。
     * @param deviceSn
     * @param param
     * @return
     */
    HttpResultResponse pushUpdateFile(String deviceSn, FileUploadUpdateRequest param);

    /**
     * Delete log records.
     * @param deviceSn
     * @param logsId
     */
    void deleteLogs(String deviceSn, String logsId);

    /**
     * 更新日志状态, which is updated when the logs upload succeeds or fails.
     * @param logsId
     * @param value
     */
    void updateLogsStatus(String logsId, Integer value);

    /**
     * 获取日志文件的网址
     * @param logsId
     * @param fileId
     * @return
     */
    URL getLogsFileUrl(String logsId, String fileId);
}
