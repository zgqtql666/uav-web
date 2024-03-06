package com.dji.sample.manage.service;

import com.dji.sample.component.websocket.model.BizCodeEnum;
import com.dji.sample.manage.model.dto.DeviceDTO;
import com.dji.sample.manage.model.dto.DeviceFirmwareUpgradeDTO;
import com.dji.sample.manage.model.dto.TopologyDeviceDTO;
import com.dji.sample.manage.model.param.DeviceQueryParam;
import com.dji.sdk.cloudapi.device.ControlSourceEnum;
import com.dji.sdk.cloudapi.device.DeviceOsdHost;
import com.dji.sdk.cloudapi.device.DockModeCodeEnum;
import com.dji.sdk.cloudapi.device.DroneModeCodeEnum;
import com.dji.sdk.config.version.GatewayManager;
import com.dji.sdk.common.HttpResultResponse;
import com.dji.sdk.common.PaginationData;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Optional;

/**
 * @author sean.zhou
 * @date 2021/11/10
 * @version 0.1
 */
public interface IDeviceService {

    /**
     * 无人机离线
     * @param deviceSn aircraft's SN
     */
    void subDeviceOffline(String deviceSn);

    /**
     * 网关离线
     * @param gatewaySn gateway's SN
     */
    void gatewayOffline(String gatewaySn);

    /**
     * 在网关设备上线时订阅网关的 Topic，取消订阅子设备的 Topic。
     * @param gateway
     */
    void gatewayOnlineSubscribeTopic(GatewayManager gateway);

    /**
     * 在无人机上线时订阅网关和子设备的主题。
     * @param gateway
     */
    void subDeviceOnlineSubscribeTopic(GatewayManager gateway);

    /**
     * 当网关设备下线时，取消订阅网关和子设备的 Topic。
     * @param gateway
     */
    void offlineUnsubscribeTopic(GatewayManager gateway);

    /**
     * 根据不同的查询条件获取设备数据。
     * @param param query parameters
     * @return
     */
    List<DeviceDTO> getDevicesByParams(DeviceQueryParam param);

    /**
     * Web 端的业务界面。获取有关此工作区中所有设备的所有信息。
     * @param workspaceId
     * @return
     */
    List<DeviceDTO> getDevicesTopoForWeb(String workspaceId);

    /**
     * 设置无人机的遥控器和有效载荷信息。
     * @param device
     */
    void spliceDeviceTopo(DeviceDTO device);

    /**
     * 根据设备的sn查询设备的信息。
     * @param sn device sn
     * @return
     */
    Optional<TopologyDeviceDTO> getDeviceTopoForPilot(String sn);

    /**
     * 将单个设备信息转换为拓扑对象。
     * @param device
     * @return
     */
    TopologyDeviceDTO deviceConvertToTopologyDTO(DeviceDTO device);

    /**
     * 当服务器收到同一工作区中任何设备在线、离线和拓扑更新的请求时，
     * 它还通过 websocket 向 PILOT 广播设备在线、离线和拓扑更新的推送，
     * 并且 PILOT 在收到推送后会再次获取设备拓扑列表。
     * @param workspaceId
     * @param deviceSn
     */
    void pushDeviceOfflineTopo(String workspaceId, String deviceSn);

    /**
     * 当服务器收到同一工作区中任何设备在线、离线和拓扑更新的请求时，
     * 它还通过 websocket 向 PILOT 广播设备在线、离线和拓扑更新的推送，
     * 并且 PILOT 在收到推送后会再次获取设备拓扑列表。
     * @param workspaceId
     * @param gatewaySn
     * @param deviceSn
     */
    void pushDeviceOnlineTopo(String workspaceId, String gatewaySn, String deviceSn);

    /**
     * 更新设备信息。
     * @param deviceDTO
     * @return
     */
    Boolean updateDevice(DeviceDTO deviceDTO);

    /**
     * 将设备绑定到组织和人员。
     * @param device
     */
    Boolean bindDevice(DeviceDTO device);

    /**
     * 在一个工作区中获取绑定设备列表。
     * @param workspaceId
     * @param page
     * @param pageSize
     * @param domain
     * @return
     */
    PaginationData<DeviceDTO> getBoundDevicesWithDomain(String workspaceId, Long page, Long pageSize, Integer domain);

    /**
     * 根据设备的序列号解绑设备。
     * @param deviceSn
     */
    void unbindDevice(String deviceSn);

    /**
     * 根据设备的序列号获取设备信息。
     * @param sn device's sn
     * @return device
     */
    Optional<DeviceDTO> getDeviceBySn(String sn);

    /**
     * 为设备固件更新创建作业。
     * @param workspaceId
     * @param upgradeDTOS
     * @return
     */
    HttpResultResponse createDeviceOtaJob(String workspaceId, List<DeviceFirmwareUpgradeDTO> upgradeDTOS);

    /**
     * 设置无人机的属性参数。
     * @param workspaceId
     * @param dockSn
     * @param param
     * @return
     */
    int devicePropertySet(String workspaceId, String dockSn, JsonNode param);

    /**
     * 检查扩展坞的工作状态。
     * @param dockSn
     * @return
     */
    DockModeCodeEnum getDockMode(String dockSn);

    /**
     * 查询无人机的工作状态。
     * @param deviceSn
     * @return
     */
    DroneModeCodeEnum getDeviceMode(String deviceSn);

    /**
     * 检查扩展坞是否处于 drc 模式。
     * @param dockSn
     * @return
     */
    Boolean checkDockDrcMode(String dockSn);

    /**
     * 检查设备是否具有飞行控制功能。
     * @param gatewaySn
     * @return
     */
    Boolean checkAuthorityFlight(String gatewaySn);

    /*
    此函数负责将 DeviceDTO 对象转换为 DeviceEntity 对象，并通过调用 mapper.insert(entity) 将其保存到数据库中。
    如果插入操作成功（插入记录数大于0），它将返回新插入实体的ID；
    如果失败，则返回 -1。
     */
    Integer saveDevice(DeviceDTO device);

    /*
    此函数首先检查数据库中是否存在具有相同序列号的设备记录。
    如果存在，则调用 updateDevice(device) 函数来更新设备；
    如果不存在，则调用 saveDevice(device) 函数来保存新设备。
    如果设备被成功更新或保存，它返回 true。
     */
    Boolean saveOrUpdateDevice(DeviceDTO device);

    /*
    此函数通过WebSocket服务将OSD（On-Screen Display）数据推送给Pilot端。
    它使用 webSocketMessageService.sendBatch 方法发送消息，包括工作空间ID、用户类型、业务代码和OSD数据。
     */
    void pushOsdDataToPilot(String workspaceId, String sn, DeviceOsdHost data);

    /*
    此函数负责将OSD数据或其他相关信息推送到Web端用户。
    这可能包括实时数据流、设备状态更新等信息，也是通过WebSocket服务实现的。
     */
    void pushOsdDataToWeb(String workspaceId, BizCodeEnum codeEnum, String sn, Object data);

    /*
    此函数用于更新设备（在这种情况下是网关设备）的飞行控制来源。
    如果控制来源发生变化，它会更新设备信息以反映这一变化，并通过WebSocket服务通知Web端用户控制来源的变更。
     */
    void updateFlightControl(DeviceDTO gateway, ControlSourceEnum controlSource);
}