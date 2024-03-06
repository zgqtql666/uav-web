package com.dji.sample.map.service;

import com.dji.sdk.cloudapi.map.GetMapElementsResponse;

import java.util.List;

/**
 * @author sean
 * @version 0.2
 * @date 2021/11/29
 */
public interface IGroupService {

    /**
     * 根据工作区的 ID 查询工作区中的所有组
     * If the group id does not exist, do not add this filter condition.
     * @param workspaceId
     * @param groupId
     * @param isDistributed Used to define if the group needs to be distributed. Default is true.
     * @return
     */
    List<GetMapElementsResponse> getAllGroupsByWorkspaceId(String workspaceId, String groupId, Boolean isDistributed);

}
