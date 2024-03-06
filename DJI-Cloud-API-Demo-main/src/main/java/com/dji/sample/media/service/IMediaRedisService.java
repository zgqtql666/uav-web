package com.dji.sample.media.service;

import com.dji.sample.media.model.MediaFileCountDTO;

/**
 * @author sean
 * @version 0.2
 * @date 2021/12/9
 */
/*
定义了一组用于管理和跟踪媒体文件计数和优先级的操作。
这些操作可能在处理大量媒体文件上传、下载或同步的场景中特别有用，
 */
public interface IMediaRedisService {
    //为特定的网关序列号（gatewaySn）和作业ID（jobId）设置媒体文件计数。
    void setMediaCount(String gatewaySn, String jobId, MediaFileCountDTO mediaFile);
    //获取指定网关序列号和作业ID的媒体文件计数。
    MediaFileCountDTO getMediaCount(String gatewaySn, String jobId);
    //删除特定网关序列号和作业ID的媒体文件计数。
    boolean delMediaCount(String gatewaySn, String jobId);
    //删除指定网关序列号的媒体文件计数。
    boolean detMediaCountByDeviceSn(String gatewaySn);
    //为指定网关序列号设置具有最高优先级的媒体文件。
    void setMediaHighestPriority(String gatewaySn, MediaFileCountDTO mediaFile);
    //获取指定网关序列号的最高优先级媒体文件。
    MediaFileCountDTO getMediaHighestPriority(String gatewaySn);
    //删除指定网关序列号的最高优先级媒体文件记录。
    boolean delMediaHighestPriority(String gatewaySn);

}
