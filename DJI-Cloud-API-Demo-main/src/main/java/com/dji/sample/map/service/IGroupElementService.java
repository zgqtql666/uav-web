package com.dji.sample.map.service;

import com.dji.sample.map.model.dto.GroupElementDTO;
import com.dji.sdk.cloudapi.map.CreateMapElementRequest;
import com.dji.sdk.cloudapi.map.MapGroupElement;
import com.dji.sdk.cloudapi.map.UpdateMapElementRequest;

import java.util.List;
import java.util.Optional;

/**
 * @author sean
 * @version 0.2
 * @date 2021/11/29
 */
public interface IGroupElementService {

    /**
     * 根据组 ID 查询该组中的所有元素。
     * @param groupId
     * @return
     */
    List<MapGroupElement> getElementsByGroupId(String groupId);

    /**
     * 保存所有的元素
     * @param groupId
     * @param elementCreate
     * @return
     */
    Boolean saveElement(String groupId, CreateMapElementRequest elementCreate);

    /**
     * 根据元素id查询元素信息，更新元素。
     * @param elementId
     * @param elementUpdate
     * @param username
     * @return
     */
    Boolean updateElement(String elementId, UpdateMapElementRequest elementUpdate, String username);

    /**
     * 根据元素 ID 删除元素。
     * @param elementId
     * @return
     */
    Boolean deleteElement(String elementId);

    /**
     * 根据元素 ID 查询元素，包括元素中的坐标信息。
     * @param elementId
     * @return
     */
    Optional<GroupElementDTO> getElementByElementId(String elementId);
}
