package com.dji.sample.wayline.service;

import com.dji.sample.wayline.model.dto.WaylineJobDTO;
import com.dji.sample.wayline.model.enums.WaylineJobStatusEnum;
import com.dji.sample.wayline.model.param.CreateJobParam;
import com.dji.sdk.common.PaginationData;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author sean
 * @version 1.1
 * @date 2022/6/1
 */
public interface IWaylineJobService {

    /**
     * 在数据库中创建 wayline 作业。
     * @param param
     * @param workspaceId   user info
     * @param username      user info
     * @param beginTime     The time the job started.
     * @param endTime       The time the job ended.
     * @return
     */
    Optional<WaylineJobDTO> createWaylineJob(CreateJobParam param, String workspaceId, String username, Long beginTime, Long endTime);

    /**
     * 根据父任务的信息创建子任务。
     * @param workspaceId
     * @param parentId
     * @return
     */
    Optional<WaylineJobDTO> createWaylineJobByParent(String workspaceId, String parentId);

    /**
     * 根据条件查询航路线作业。
     * @param workspaceId
     * @param jobIds
     * @param status
     * @return
     */
    List<WaylineJobDTO> getJobsByConditions(String workspaceId, Collection<String> jobIds, WaylineJobStatusEnum status);

    /**
     * 根据作业ID查询作业信息。
     * @param workspaceId
     * @param jobId
     * @return job information
     */
    Optional<WaylineJobDTO> getJobByJobId(String workspaceId, String jobId);

    /**
     * Update job data.
     * @param dto
     * @return
     */
    Boolean updateJob(WaylineJobDTO dto);

    /**
     * 在此工作区中的所有作业中分页。
     * @param workspaceId
     * @param page
     * @param pageSize
     * @return
     */
    PaginationData<WaylineJobDTO> getJobsByWorkspaceId(String workspaceId, long page, long pageSize);

    /**
     * 查询机巢的航线执行状态。
     * @param dockSn
     * @return
     */
    WaylineJobStatusEnum getWaylineState(String dockSn);
}
