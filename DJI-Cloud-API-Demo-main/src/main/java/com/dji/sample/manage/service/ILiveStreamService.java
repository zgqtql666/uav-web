package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.CapacityDeviceDTO;
import com.dji.sample.manage.model.dto.LiveTypeDTO;
import com.dji.sdk.common.HttpResultResponse;

import java.util.List;

/**
 * @author sean.zhou
 * @date 2021/11/19
 * @version 0.1
 */
//实时直播功能
public interface ILiveStreamService {

    /**
     * 获取可在此工作区中实时广播的所有无人机数据。
     * @param workspaceId
     * @return
     */
    List<CapacityDeviceDTO> getLiveCapacity(String workspaceId);

    /**
     * 通过发布 mqtt 消息发起直播。
     * @param liveParam Parameters needed for on-demand.
     * @return
     */
    HttpResultResponse liveStart(LiveTypeDTO liveParam);

    /**
     * 通过发布 mqtt 消息停止直播。
     * @param videoId
     * @return
     */
    HttpResultResponse liveStop(String videoId);

    /**
     * 通过发布 mqtt 消息来重新调整直播的清晰度。
     * @param liveParam
     * @return
     */
    HttpResultResponse liveSetQuality(LiveTypeDTO liveParam);

    /**
     * 在直播过程中切换设备的镜头。
     * @param liveParam
     * @return
     */
    HttpResultResponse liveLensChange(LiveTypeDTO liveParam);
}
