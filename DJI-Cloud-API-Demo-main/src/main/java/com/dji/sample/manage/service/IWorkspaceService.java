package com.dji.sample.manage.service;


import com.dji.sample.manage.model.dto.WorkspaceDTO;

import java.util.Optional;

public interface IWorkspaceService {

    /**
     * 根据工作空间ID查询工作空间信息。
     * @param workspaceId
     * @return
     */
    Optional<WorkspaceDTO> getWorkspaceByWorkspaceId(String workspaceId);

    /**
     * Query the workspace of a workspace based on bind code.
     * @param bindCode
     * @return
     */
    Optional<WorkspaceDTO> getWorkspaceNameByBindCode(String bindCode);

}
