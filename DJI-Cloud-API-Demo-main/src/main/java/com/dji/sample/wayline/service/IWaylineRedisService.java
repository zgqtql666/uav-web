package com.dji.sample.wayline.service;

import com.dji.sample.component.mqtt.model.EventsReceiver;
import com.dji.sample.wayline.model.dto.ConditionalWaylineJobKey;
import com.dji.sample.wayline.model.dto.WaylineJobDTO;
import com.dji.sdk.cloudapi.wayline.FlighttaskProgress;

import java.util.Optional;

/**
 * @author sean
 * @version 1.4
 * @date 2023/3/24
 */
public interface IWaylineRedisService {

    /**
     * 将机巢执行的 wayline 作业的状态保存到 redis 中。
     * @param dockSn
     * @param data
     */
    void setRunningWaylineJob(String dockSn, EventsReceiver<FlighttaskProgress> data);

    /**
     * 在 redis 中查询 dock 执行的 wayline 作业的状态。
     * @param dockSn
     * @return
     */
    Optional<EventsReceiver<FlighttaskProgress>> getRunningWaylineJob(String dockSn);

    /**
     * Delete the wayline job status of the dock operation in redis.
     * @param dockSn
     * @return
     */
    Boolean delRunningWaylineJob(String dockSn);

    /**
     * 将 dock 挂起的 wayline 作业保存到 redis。
     * @param dockSn
     * @param jobId
     */
    void setPausedWaylineJob(String dockSn, String jobId);

    /**
     * 在 redis 中查询 dock 挂起的 wayline 作业 id。
     * @param dockSn
     * @return
     */
    String getPausedWaylineJobId(String dockSn);

    /**
     * Delete the wayline job suspended by the dock in redis.
     * @param dockSn
     * @return
     */
    Boolean delPausedWaylineJob(String dockSn);

    /**
     * 将被 dock 阻塞的 wayline 作业保存到 redis。
     * @param dockSn
     * @param jobId
     */
    void setBlockedWaylineJob(String dockSn, String jobId);

    /**
     * Query the wayline job id blocked by the dock in redis.
     * @param dockSn
     * @return
     */
    String getBlockedWaylineJobId(String dockSn);

    /**
     * Save the conditional wayline job by the dock to redis.
     * @param waylineJob
     */
    void setConditionalWaylineJob(WaylineJobDTO waylineJob);

    /**
     * Query the conditional wayline job id by the dock in redis.
     * @param jobId
     * @return
     */
    Optional<WaylineJobDTO> getConditionalWaylineJob(String jobId);

    /**
     * Delete the conditional wayline job by the dock in redis.
     * @param jobId
     * @return
     */
    Boolean delConditionalWaylineJob(String jobId);

    Boolean addPrepareConditionalWaylineJob(WaylineJobDTO waylineJob);

    Optional<ConditionalWaylineJobKey> getNearestConditionalWaylineJob();

    Double getConditionalWaylineJobTime(ConditionalWaylineJobKey jobKey);

    Boolean removePrepareConditionalWaylineJob(ConditionalWaylineJobKey jobKey);
}
