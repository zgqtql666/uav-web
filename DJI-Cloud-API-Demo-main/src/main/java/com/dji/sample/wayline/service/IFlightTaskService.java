package com.dji.sample.wayline.service;

import com.dji.sample.common.model.CustomClaim;
import com.dji.sample.wayline.model.dto.ConditionalWaylineJobKey;
import com.dji.sample.wayline.model.dto.WaylineJobDTO;
import com.dji.sample.wayline.model.param.CreateJobParam;
import com.dji.sample.wayline.model.param.UpdateJobParam;
import com.dji.sdk.common.HttpResultResponse;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * @author sean
 * @version 1.1
 * @date 2022/6/9
 */
public interface IFlightTaskService {


    /**
     * 发送航线任务给机巢
     * @param param
     * @param customClaim   user info
     * @return
     */
    HttpResultResponse publishFlightTask(CreateJobParam param, CustomClaim customClaim) throws SQLException;

    /**
     * 发送一个航线任务给机巢
     * @param waylineJob
     * @return
     * @throws SQLException
     */
    HttpResultResponse publishOneFlightTask(WaylineJobDTO waylineJob) throws SQLException;

    /**
     * 立即执行任务。
     * @param jobId
     * @throws SQLException
     * @return
     */
    Boolean executeFlightTask(String workspaceId, String jobId);

    /**
     * 取消任务“基于作业 ID”。
     * @param workspaceId
     * @param jobIds
     * @throws SQLException
     */
    void cancelFlightTask(String workspaceId, Collection<String> jobIds);

    /**
     * 取消已下达但尚未执行的 Dock 任务。
     * @param workspaceId
     * @param dockSn
     * @param jobIds
     */
    void publishCancelTask(String workspaceId, String dockSn, List<String> jobIds);

    /**
     * 将此作业的媒体文件设置为立即上传。
     * @param workspaceId
     * @param jobId
     */
    void uploadMediaHighestPriority(String workspaceId, String jobId);

    /**
     * 手动控制 wayline 作业的执行状态。
     * @param workspaceId
     * @param jobId
     * @param param
     */
    void updateJobStatus(String workspaceId, String jobId, UpdateJobParam param);


    void retryPrepareJob(ConditionalWaylineJobKey jobKey, WaylineJobDTO waylineJob);
}
