package com.dji.sample.map.service;

import com.dji.sample.map.model.dto.GroupElementDTO;
import com.dji.sdk.cloudapi.map.*;
import com.dji.sdk.common.HttpResultResponse;

import java.util.List;
import java.util.Optional;

/**
 * @author sean
 * @version 0.2
 * @date 2021/11/30
 */
public interface IWorkspaceElementService {

    /**
     * 根据工作区的 ID 查询工作区中的所有组，
     * 包括组中元素的信息，以及元素中的坐标信息。
     * @param workspaceId
     * @param groupId
     * @param isDistributed
     * @return
     */
    List<GetMapElementsResponse> getAllGroupsByWorkspaceId(String workspaceId, String groupId, Boolean isDistributed);

    /**
     * 保存所有元素，包括组中元素的信息，
     * 和元素中的坐标信息。
     *
     * @param workspaceId
     * @param groupId
     * @param elementCreate
     * @return
     */
    HttpResultResponse saveElement(String workspaceId, String groupId, CreateMapElementRequest elementCreate);

    /**
     * 根据元素 ID 更新元素信息，
     * 包括组中元素的信息，以及元素中的坐标信息。
     *
     * @param workspaceId
     * @param elementId
     * @param elementUpdate
     * @param username
     * @return
     */
    HttpResultResponse updateElement(String workspaceId, String elementId, UpdateMapElementRequest elementUpdate, String username);

    /**
     * 根据元素 id 删除元素信息，
     * 包括组中元素的信息，以及元素中的坐标信息。
     *
     * @param workspaceId
     * @param elementId
     * @return
     */
    HttpResultResponse deleteElement(String workspaceId, String elementId);

    /**
     * 根据元素 id 查询元素，
     * 包括组中元素的信息，以及元素中的坐标信息。
     * @param elementId
     * @return
     */
    Optional<GroupElementDTO> getElementByElementId(String elementId);

    /**
     * 根据组 ID 删除所有元素信息，
     * 包括组中元素的信息，以及元素中的坐标信息。
     *
     * @param workspaceId
     * @param groupId
     * @return
     */
    HttpResultResponse deleteAllElementByGroupId(String workspaceId, String groupId);

    MapElementCreateWsResponse element2CreateWsElement(GroupElementDTO element);

    MapElementUpdateWsResponse element2UpdateWsElement(GroupElementDTO element);
}