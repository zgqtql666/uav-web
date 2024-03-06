package com.dji.sample.manage.service;

import com.dji.sample.manage.model.dto.LogsFileDTO;
import com.dji.sample.manage.model.dto.LogsFileUploadDTO;
import com.dji.sdk.cloudapi.log.LogFileIndex;

import java.util.List;
import java.util.Optional;

/**
 * @author sean
 * @version 1.2
 * @date 2022/9/8
 */
//定义了与日志文件索引相关的数据库操作，如插入、查询和删除文件索引信息。
public interface ILogsFileIndexService {

    /**
     * 将日志文件的索引信息插入到数据库中。
     * @param file
     * @param deviceSn
     * @param domain
     * @param fileId
     * @return
     */
    Boolean insertFileIndex(LogFileIndex file, String deviceSn, Integer domain, String fileId);

    /**
     * 根据文件ID查询日志文件的上传的索引信息。
     * @param fileId
     * @return
     */
    Optional<LogsFileUploadDTO> getFileIndexByFileId(String fileId);

    /**
     *  批量查询日志文件的索引信息。
     * @param fileIds
     * @return
     */
    List<LogsFileUploadDTO> getFileIndexByFileIds(List<LogsFileDTO> fileIds);

    /**
     * 根据文件ID批量删除日志索引数据。
     * @param fileIds
     */
    void deleteFileIndexByFileIds(List<String> fileIds);
}
