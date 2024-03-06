package com.dji.sample.media.service;

import com.dji.sample.media.model.MediaFileDTO;
import com.dji.sdk.cloudapi.media.MediaUploadCallbackRequest;
import com.dji.sdk.common.PaginationData;

import java.net.URL;
import java.util.List;

/**
 * @author sean
 * @version 0.2
 * @date 2021/12/9
 */
public interface IFileService {

    /**
     * 数据库查询操作的一个封装，用于根据特定的标识符（在这里是工作空间ID和文件指纹）检索媒体文件实体。
     * @param workspaceId
     * @param fingerprint
     * @return
     */
    Boolean checkExist(String workspaceId, String fingerprint);

    /**
     * 将文件的基本信息保存到数据库中。
     * @param workspaceId
     * @param file
     * @return
     */
    Integer saveFile(String workspaceId, MediaUploadCallbackRequest file);

    /**
     * 根据工作区 ID 查询该工作区下所有文件的信息。
     * @param workspaceId
     * @return
     */
    List<MediaFileDTO> getAllFilesByWorkspaceId(String workspaceId);

    /**
     * 在此工作区中的所有媒体文件之间进行分页。
     * @param workspaceId
     * @param page
     * @param pageSize
     * @return
     */
    PaginationData<MediaFileDTO> getMediaFilesPaginationByWorkspaceId(String workspaceId, long page, long pageSize);

    /**
     * 获取文件的下载地址。
     * @param workspaceId
     * @param fileId
     * @return
     */
    URL getObjectUrl(String workspaceId, String fileId);

    /**
     * 查询作业的所有媒体文件。
     * @param workspaceId
     * @param jobId
     * @return
     */
    List<MediaFileDTO> getFilesByWorkspaceAndJobId(String workspaceId, String jobId);
}
