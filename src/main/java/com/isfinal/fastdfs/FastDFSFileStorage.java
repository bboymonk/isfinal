/*
package com.isfinal.fastdfs;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

import com.isfinal.fastdfs.pool.FastdfsPool;
import com.isfinal.fastdfs.service.IFileStorage;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.StorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


*/
/**
 * 本地文件存取实现
 *
 *//*


public class FastDFSFileStorage implements IFileStorage {

	*/
/**
	 * Logger
	 *//*

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	*/
/**
	 * fastdfsPool
	 *//*

	@Autowired
	private FastdfsPool fastdfsPool;

	*/
/**
	 * 返回对应的文件ID,的字节流
	 *
	 * @param fileId
	 * @return
	 * @author yfcheng2@iflytek.com
	 * @created 2014年12月3日 下午8:18:13
	 * @lastModified
	 * @history
	 *//*

	@Override
	public InputStream readFile(String fileId) throws Exception {
		return new ByteArrayInputStream(getFileById(fileId));
	}

	*/
/**
	 * 上传文件
	 *
	 * @param file 文件 文件扩展名通过file.getName()获得
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(File file) throws Exception {
		if (file != null && file.exists()) {
			return saveFile(file.getAbsolutePath(), FilenameUtils.getExtension(file.getName()),
					new HashMap<String, String>());
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传文件
	 *
	 * @param file   文件
	 * @param suffix 文件扩展名，如 (jpg,txt)
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(File file, String suffix) throws Exception {
		if (file != null && file.exists()) {
			return saveFile(file.getAbsolutePath(), suffix, new HashMap<String, String>());
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传文件
	 *
	 * @param fileBuff 二进制数组
	 * @param suffix   文件扩展名 ，如(jpg,txt)
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(byte[] fileBuff, String suffix) throws Exception {
		if (fileBuff.length == 0) {
			return StringUtils.EMPTY;
		} else {
			return saveFile(null, fileBuff, suffix, new HashMap<String, String>());
		}
	}

	*/
/**
	 * 删除文件
	 *
	 * @param fileId 包含group及文件目录和名称信息
	 * @return true 删除成功，false删除失败
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

//	@Override
//	public boolean deleteFile(String fileId) throws Exception {
//		StorageClient storageClient;
//		try {
//			storageClient = fastdfsPool.getResource();
//		} catch (Exception e) {
//			logger.error(e.getMessage() + " saveFile localFileName fastdfs pools is wrong", e);
//			throw new Exception(e);
//		}
//		boolean flag;
//		try {
//			flag = storageClient.delete_file1(fileId) == 0;
//		} catch (Exception e) {
//			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
//			fastdfsPool.returnBrokenResource(storageClient);
//			throw new Exception(e);
//		}
//		fastdfsPool.returnResource(storageClient);
//		return flag;
//
//	}

	*/
/**
	 * 查找文件内容
	 *
	 * @param fileId
	 * @return 文件内容的二进制流
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	@Override
	public byte[] getFileById(String fileId) throws Exception {
		StorageClient storageClient = null;
		byte[] bytes = null;
		try {
			storageClient = fastdfsPool.getResource();
			bytes = storageClient.download_file1(fileId);
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			throw new Exception(e);
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return bytes;
	}

	*/
/**
	 * 上传文件
	 *
	 * @param groupName 文件
	 * @param file      文件
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(String groupName, File file) throws Exception {
		if (file != null && file.exists()) {
			return saveFile(groupName, file.getAbsolutePath(), FilenameUtils.getExtension(file.getName()),
					new HashMap<String, String>());
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传文件
	 *
	 * @param file    文件
	 * @param metaMap 文件属性
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(File file, HashMap<String, String> metaMap) throws Exception {
		if (file != null && file.exists()) {
			return saveFile(file.getAbsolutePath(), FilenameUtils.getExtension(file.getName()), metaMap);
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传文件
	 *
	 * @param filePath 文件路径
	 * @param suffix   文件扩展名，如 (jpg,txt)
	 * @param metaMap  文件属性
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(String filePath, String suffix, HashMap<String, String> metaMap) throws Exception {
		return saveFile(null, filePath, suffix, metaMap);
	}

	*/
/**
	 * 上传文件
	 *
	 * @param groupName 组名
	 * @param file      文件
	 * @param suffix    文件扩展名，如 (jpg,txt)
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(String groupName, File file, String suffix) throws Exception {
		if (file != null && file.exists()) {
			return saveFile(groupName, file.getAbsolutePath(), suffix, new HashMap<String, String>());
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传文件
	 *
	 * @param groupName 组名
	 * @param file      文件
	 * @param metaMap   文件属性
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(String groupName, File file, HashMap<String, String> metaMap) throws Exception {
		if (file != null && file.exists()) {
			return saveFile(groupName, file.getAbsolutePath(), FilenameUtils.getExtension(file.getName()), metaMap);
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传文件
	 *
	 * @param groupName 组名
	 * @param filePath  文件路径
	 * @param suffix    文件扩展名，如 (jpg,txt)
	 * @param metaMap   文件属性
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(String groupName, String filePath, String suffix, HashMap<String, String> metaMap)
			throws Exception {
		StorageClient storageClient = null;
		String fileId = StringUtils.EMPTY;
		try {
			storageClient = fastdfsPool.getResource();
			fileId = storageClient.upload_file1(groupName, filePath, suffix, MapUtil.mapToNameValues(metaMap));
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			throw new Exception(e);
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return fileId;
	}

	*/
/**
	 * 上传文件
	 *
	 * @param groupName 组名
	 * @param fileBuff  二进制数组
	 * @param suffix    文件扩展名 ，如(jpg,txt)
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	@Override
	public String saveFile(String groupName, byte[] fileBuff, String suffix) throws Exception {
		if (fileBuff.length > 0) {
			return saveFile(groupName, fileBuff, suffix, new HashMap<String, String>());
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传文件
	 *
	 * @param groupName 文件
	 * @param fileBuff  二进制数组
	 * @param suffix    文件扩展名 ，如(jpg,txt)
	 * @param metaMap   文件属性
	 * @return 文件存储路径
	 * @throws Exception
	 *//*

	*/
/*@Override
	public String saveFile(String groupName, byte[] fileBuff, String suffix, HashMap<String, String> metaMap)
			throws Exception {
		String fastDFSFileId = StringUtils.EMPTY;
		StorageClient storageClient = null;
		try {
			storageClient = fastdfsPool.getResource();
			fastDFSFileId = storageClient.upload_file1(fileBuff, suffix, MapUtil.mapToNameValues(metaMap));
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return fastDFSFileId;
	}*//*


	*/
/**
	 * 从fastdfs中从指定的offset下载downloadBytes长度的文件内容，并返回数据
	 *
	 * @param fileId        下载的文件Id
	 * @param fileOffset    下载时的偏移值
	 * @param downloadBytes 下载数据量
	 * @return
	 * @throws Exception
	 *//*

	@Override
	public byte[] downloadFile(String fileId, long fileOffset, long downloadBytes) throws Exception {
		StorageClient storageClient = null;
		byte[] bytes = null;
		try {
			storageClient = fastdfsPool.getResource();
			bytes = storageClient.download_file1(fileId, fileOffset, downloadBytes);
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			throw new Exception(e);
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return bytes;
	}

	*/
/**
	 * 上传可追加的文件
	 *
	 * @param file 文件数据
	 * @return 上传成功后的文件名
	 * @throws Exception
	 *//*

	@Override
	public String uploadAppendFile(File file) throws Exception {
		if (file != null && file.exists()) {
			return uploadAppendFile(file, new HashMap<String, String>());
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传可追加的文件
	 *
	 * @param file    文件数据
	 * @param metaMap 文件元数据
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	*/
/*@Override
	public String uploadAppendFile(File file, HashMap<String, String> metaMap) throws Exception {
		String fastDFSFileId = StringUtils.EMPTY;
		StorageClient storageClient = null;
		try {
			storageClient = fastdfsPool.getResource();
			fastDFSFileId = storageClient.upload_appender_file1(file.getAbsolutePath(),
					FilenameUtils.getExtension(file.getName()), MapUtil.mapToNameValues(metaMap));
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return fastDFSFileId;
	}*//*


	*/
/**
	 * 上传可追加的文件
	 *
	 * @param fileBuff 文件数据
	 * @param suffix   文件扩展名
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	@Override
	public String uploadAppendFile(byte[] fileBuff, String suffix) throws Exception {
		if (fileBuff.length > 0) {
			return uploadAppendFile(fileBuff, suffix, new HashMap<String, String>());
		} else {
			return StringUtils.EMPTY;
		}
	}

	*/
/**
	 * 上传可追加的文件
	 *
	 * @param fileBuff 文件数据
	 * @param suffix   文件扩展名
	 * @param metaMap  文件元数据
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	*/
/*@Override
	public String uploadAppendFile(byte[] fileBuff, String suffix, HashMap<String, String> metaMap) throws Exception {
		String fastDFSFileId = StringUtils.EMPTY;
		StorageClient storageClient = null;
		try {
			storageClient = fastdfsPool.getResource();
			fastDFSFileId = storageClient.upload_appender_file1(fileBuff, suffix, MapUtil.mapToNameValues(metaMap));
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return fastDFSFileId;
	}*//*


	*/
/**
	 * 向可追加文件中追加写入数据
	 *
	 * @param appenderFileId 可追加文件Id
	 * @param file           需要追加的文件数据
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	@Override
	public Boolean appendFile(String appenderFileId, File file) throws Exception {
		Boolean flag = false;
		StorageClient storageClient = null;
		try {
			storageClient = fastdfsPool.getResource();
			flag = storageClient.append_file1(appenderFileId, file.getAbsolutePath()) == 0;
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return flag;
	}

	*/
/**
	 * 向可追加文件中追加写入数据
	 *
	 * @param appenderFileId 可追加文件Id
	 * @param fileBuff       需要追加的文件数据
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	@Override
	public Boolean appendFile(String appenderFileId, byte[] fileBuff) throws Exception {
		Boolean flag = false;
		StorageClient storageClient = null;
		try {
			storageClient = fastdfsPool.getResource();
			flag = storageClient.append_file1(appenderFileId, fileBuff) == 0;
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return flag;
	}

	*/
/**
	 * 向可追加文件中追加写入数据
	 *
	 * @param appenderFileId 可追加文件Id
	 * @param fileBuff       需要追加的文件数据
	 * @param offset         追加数据的偏移值
	 * @param length         追加的数据长度
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	@Override
	public Boolean appendFile(String appenderFileId, byte[] fileBuff, int offset, int length) throws Exception {
		Boolean flag = false;
		StorageClient storageClient = null;
		try {
			storageClient = fastdfsPool.getResource();
			flag = storageClient.append_file1(appenderFileId, fileBuff, offset, length) == 0;
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return flag;
	}

	*/
/**
	 * 清除文件内容
	 *
	 * @param appenderFileId 可追加文件Id
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	@Override
	public Boolean truncateFile(String appenderFileId) throws Exception {
		Boolean flag = false;
		StorageClient storageClient = null;
		try {
			storageClient = fastdfsPool.getResource();
			flag = storageClient.truncate_file1(appenderFileId) == 0;
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return flag;
	}

	*/
/**
	 * 获取文件的元数据
	 *
	 * @param fileId 文件Id
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	@Override
	public HashMap<String, String> getMetadata(String fileId) throws Exception {
		NameValuePair[] nameValuePairs = null;
		StorageClient storageClient = null;
		try {
			storageClient = fastdfsPool.getResource();
			nameValuePairs = storageClient.get_metadata1(fileId);
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return MapUtil.nameValuesToMap(nameValuePairs);
	}

	*/
/**
	 * 设置文件的元数据
	 *
	 * @param fileId  文件Id
	 * @param metaMap 文件元数据
	 * @param flag  true 全部覆盖 false 合并
	 * @return
	 * @throws java.io.IOException
	 * @throws Exception
	 *//*

	@Override
	public Boolean setMetadata(String fileId, HashMap<String, String> metaMap, boolean flag) throws Exception {
		Boolean retrunFlag = false;
		StorageClient storageClient = null;
		try {
			byte opFlag = flag ? ProtoCommon.STORAGE_SET_METADATA_FLAG_OVERWRITE
					: ProtoCommon.STORAGE_SET_METADATA_FLAG_MERGE;
			storageClient = fastdfsPool.getResource();
			retrunFlag = storageClient.set_metadata1(fileId, MapUtil.mapToNameValues(metaMap), opFlag) == 0;
		} catch (Exception e) {
			logger.error(e.getMessage() + " fastdfs upload file is wrong", e);
			if (storageClient != null) {
				fastdfsPool.returnBrokenResource(storageClient);
			}
		} finally {
			if (storageClient != null) {
				fastdfsPool.returnResource(storageClient);
			}
		}
		return retrunFlag;
	}

}
*/
