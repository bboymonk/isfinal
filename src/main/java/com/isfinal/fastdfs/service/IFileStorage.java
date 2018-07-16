package com.isfinal.fastdfs.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by wjb on 2018/7/16.
 */
public interface IFileStorage {
    /**
     * 上传文件
     *
     * @param file 文件
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(File file) throws Exception;

    /**
     * 上传文件
     *
     * @param file   文件
     * @param suffix 文件扩展名，如 (jpg,txt)
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(File file, String suffix) throws Exception;

    /**
     * 上传文件
     *
     * @param file    文件
     * @param metaMap 文件属性
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(File file, HashMap<String, String> metaMap) throws Exception;

    /**
     * 上传文件
     *
     * @param filePath 文件路径
     * @param suffix   文件扩展名，如 (jpg,txt)
     * @param metaMap  文件属性
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(String filePath, String suffix, HashMap<String, String> metaMap) throws Exception;

    /**
     * 上传文件
     *
     * @param groupName 组名
     * @param file      文件
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(String groupName, File file) throws Exception;

    /**
     * 上传文件
     *
     * @param groupName 组名
     * @param file      文件
     * @param suffix    文件扩展名，如 (jpg,txt)
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(String groupName, File file, String suffix) throws Exception;

    /**
     * 上传文件
     *
     * @param groupName 组名
     * @param file      文件
     * @param metaMap   文件属性
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(String groupName, File file, HashMap<String, String> metaMap) throws Exception;

    /**
     * 上传文件
     *
     * @param groupName 组名
     * @param filePath  文件路径
     * @param suffix    文件扩展名，如 (jpg,txt)
     * @param metaMap   文件属性
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(String groupName, String filePath, String suffix, HashMap<String, String> metaMap)
            throws Exception;

    /**
     * 上传文件
     *
     * @param fileBuff 二进制数组
     * @param suffix   文件扩展名 ，如(jpg,txt)
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(byte[] fileBuff, String suffix) throws Exception;

    /**
     * 上传文件
     *
     * @param groupName 组名
     * @param fileBuff  二进制数组
     * @param suffix    文件扩展名 ，如(jpg,txt)
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(String groupName, byte[] fileBuff, String suffix) throws Exception;

    /**
     * 上传文件
     *
     * @param groupName 文件
     * @param fileBuff  二进制数组
     * @param suffix    文件扩展名 ，如(jpg,txt)
     * @param metaMap   文件属性
     * @return 文件存储路径
     * @throws Exception
     */
    public String saveFile(String groupName, byte[] fileBuff, String suffix, HashMap<String, String> metaMap)
            throws Exception;

    /**
     * 删除文件
     *
     * @param fileId 包含group及文件目录和名称信息
     * @return true 删除成功，false删除失败
     * @throws Exception
     */
    public boolean deleteFile(String fileId) throws Exception;

    /**
     * 查找文件内容
     *
     * @param fileId
     * @return 文件内容的二进制流
     * @throws Exception
     */
    public byte[] getFileById(String fileId) throws Exception;

    /**
     * 返回对应的文件ID,的字节流
     *
     * @param fileId
     * @return
     * @author yfcheng2@iflytek.com
     * @created 2014年12月3日 下午8:18:13
     * @lastModified
     * @history
     */
    public InputStream readFile(String fileId) throws Exception;

    /**
     * 从fastdfs中从指定的offset下载downloadBytes长度的文件内容，并返回数据
     *
     * @param fileId        下载的文件Id
     * @param fileOffset    下载时的偏移值
     * @param downloadBytes 下载数据量
     * @return
     * @throws Exception
     */
    public byte[] downloadFile(String fileId, long fileOffset, long downloadBytes) throws Exception;

    /**
     * 上传可追加的文件
     *
     * @param file 文件数据
     * @return 上传成功后的文件名
     * @throws Exception
     */
    public String uploadAppendFile(File file) throws Exception;

    /**
     * 上传可追加的文件
     *
     * @param file    文件数据
     * @param metaMap 文件元数据
     * @return
     * @throws IOException
     * @throws Exception
     */
    public String uploadAppendFile(File file, HashMap<String, String> metaMap) throws Exception;

    /**
     * 上传可追加的文件
     *
     * @param fileBuff 文件数据
     * @param suffix   文件扩展名
     * @return
     * @throws IOException
     * @throws Exception
     */
    public String uploadAppendFile(byte[] fileBuff, String suffix) throws Exception;

    /**
     * 上传可追加的文件
     *
     * @param fileBuff 文件数据
     * @param suffix   文件扩展名
     * @param metaMap  文件元数据
     * @return
     * @throws IOException
     * @throws Exception
     */
    public String uploadAppendFile(byte[] fileBuff, String suffix, HashMap<String, String> metaMap) throws Exception;

    /**
     * 向可追加文件中追加写入数据
     *
     * @param appenderFileId 可追加文件Id
     * @param file           需要追加的文件数据
     * @return
     * @throws IOException
     * @throws Exception
     */
    public Boolean appendFile(String appenderFileId, File file) throws Exception;

    /**
     * 向可追加文件中追加写入数据
     *
     * @param appenderFileId 可追加文件Id
     * @param fileBuff       需要追加的文件数据
     * @return
     * @throws IOException
     * @throws Exception
     */
    public Boolean appendFile(String appenderFileId, byte[] fileBuff) throws Exception;

    /**
     * 向可追加文件中追加写入数据
     *
     * @param appenderFileId 可追加文件Id
     * @param fileBuff       需要追加的文件数据
     * @param offset         追加数据的偏移值
     * @param length         追加的数据长度
     * @return
     * @throws IOException
     * @throws Exception
     */
    public Boolean appendFile(String appenderFileId, byte[] fileBuff, int offset, int length) throws Exception;

    /**
     * 清除文件内容
     *
     * @param appenderFileId 可追加文件Id
     * @return
     * @throws IOException
     * @throws Exception
     */
    public Boolean truncateFile(String appenderFileId) throws Exception;

    /**
     * 获取文件的元数据
     *
     * @param fileId 文件Id
     * @return
     * @throws IOException
     * @throws Exception
     */
    public HashMap<String, String> getMetadata(String fileId) throws Exception;

    /**
     * 设置文件的元数据
     *
     * @param fileId  文件Id
     * @param metaMap 文件元数据
     * @param flag    true 全部覆盖 false 合并
     * @return
     * @throws IOException
     * @throws Exception
     */
    public Boolean setMetadata(String fileId, HashMap<String, String> metaMap, boolean flag) throws Exception;

}
