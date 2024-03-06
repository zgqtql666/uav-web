package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.UserDTO;
import com.dji.sample.manage.model.dto.UserListDTO;
import com.dji.sdk.common.HttpResultResponse;
import com.dji.sdk.common.PaginationData;

import java.util.Optional;

public interface IUserService {

    /**
     * 根据用户名查询用户的详细信息。
     * @param username
     * @param workspaceId
     * @return
     */
    HttpResultResponse getUserByUsername(String username, String workspaceId);

    /**
     * 验证用户名和密码以登录。
     * @param username
     * @param password
     * @param flag
     * @return
     */
    HttpResultResponse userLogin(String username, String password, Integer flag);

    /**
     * 改用户的密码
     * @param token
     * @return
     */
    Optional<UserDTO> refreshToken(String token);

    /**
     * 查询工作区中所有用户的信息。
     * @param workspaceId   uuid
     * @return
     */
    PaginationData<UserListDTO> getUsersByWorkspaceId(long page, long pageSize, String workspaceId);

    //在特定工作区中更新特定用户的 MQTT 用户名和密码，以及更新时间。
    Boolean updateUser(String workspaceId, String userId, UserListDTO user);
}
