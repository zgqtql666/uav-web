package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.DeviceFirmwareDTO;
import com.dji.sample.manage.model.dto.DeviceFirmwareNoteDTO;
import com.dji.sample.manage.model.dto.DeviceFirmwareUpgradeDTO;
import com.dji.sample.manage.model.param.DeviceFirmwareQueryParam;
import com.dji.sample.manage.model.param.DeviceFirmwareUploadParam;
import com.dji.sdk.cloudapi.firmware.OtaCreateDevice;
import com.dji.sdk.common.PaginationData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * @author sean
 * @version 1.2
 * @date 2022/8/16
 */
public interface IDeviceFirmwareService {

    /**
     * 根据设备型号和固件版本查询具体固件信息。
     *
     * @param workspaceId
     * @param deviceName
     * @param version
     * @return
     */
    Optional<DeviceFirmwareDTO> getFirmware(String workspaceId, String deviceName, String version);

    /**
     * 获取此设备型号的最新固件版本说明。
     * @param deviceName
     * @return
     */
    Optional<DeviceFirmwareNoteDTO> getLatestFirmwareReleaseNote(String deviceName);

    /**
     * 获取设备需要更新的固件信息。
     *
     * @param workspaceId
     * @param upgradeDTOS
     * @return
     */
    List<OtaCreateDevice> getDeviceOtaFirmware(String workspaceId, List<DeviceFirmwareUpgradeDTO> upgradeDTOS);

    /**
     * 按页面查询固件版本信息。
     *
     * @param workspaceId
     * @param param
     * @return
     */
    PaginationData<DeviceFirmwareDTO> getAllFirmwarePagination(String workspaceId, DeviceFirmwareQueryParam param);

    /**
     * 根据 md5 检查文件是否存在。
     *
     * @param workspaceId
     * @param fileMd5
     * @return
     */
    Boolean checkFileExist(String workspaceId, String fileMd5);

    /**
     * 导入固件文件以进行设备升级。
     * @param workspaceId
     * @param creator
     * @param param
     * @param file
     */
    void importFirmwareFile(String workspaceId, String creator, DeviceFirmwareUploadParam param, MultipartFile file);

    /**
     * 保存固件的文件信息。
     * @param firmware
     * @param deviceNames
     */
    void saveFirmwareInfo(DeviceFirmwareDTO firmware, List<String> deviceNames);

    /**
     * 更新固件的文件信息。
     * @param firmware
     */
    void updateFirmwareInfo(DeviceFirmwareDTO firmware);
}
