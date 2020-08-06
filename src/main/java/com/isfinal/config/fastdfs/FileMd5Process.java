/*
package com.isfinal.config.fastdfs;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.isfinal.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

class FileMd5Process extends FastDFSFileStorage {

	@Resource(name = "fastDfsJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	*/
/**
	 * 
	 * 根据文件检查是否已经存在在fastdfs库中， 通过MD5进行文件内容比对
	 * 
	 * @param file
	 * @return
	 *//*

	public String queryFileMd5(File file) {

		String md5Txt = null;
		try {
			md5Txt = MD5Util.getFileMD5String(file);

			List<Map<String, Object>> mapItemList = jdbcTemplate
					.queryForList("select  *  from   T_FASTDFS_FILES t where t.FILE_MD5 = ? ", md5Txt);
			for (int i = 0; i < mapItemList.size(); i++) {
				Map<String, Object> item = mapItemList.get(i);

				String filePath = (String) item.get("FILE_PATH");

				String suffix = (String) item.get("FILE_SUFFIX");
				BigDecimal decimal = (BigDecimal) item.get("FILE_SIZE");

				if (StringUtils.equals(md5Txt, (String) item.get("FILE_MD5"))) {
					return filePath;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	*/
/**
	 * 
	 * 根据文件检查是否已经存在在fastdfs库中， 通过MD5进行文件内容比对
	 * 
	 * @param file
	 * @return
	 *//*

	public String queryByteBufferMd5(byte[] data, String fileName) {

		try {
			String md5Txt = MD5Util.getFileMD5String(data);

			List<Map<String, Object>> mapItemList = jdbcTemplate
					.queryForList("select  *  from   T_FASTDFS_FILES t where t.FILE_MD5 = ? ", md5Txt);
			for (int i = 0; i < mapItemList.size(); i++) {
				Map<String, Object> item = mapItemList.get(i);

				String filePath = (String) item.get("FILE_PATH");

				String suffix = (String) item.get("FILE_SUFFIX");
				BigDecimal decimal = (BigDecimal) item.get("FILE_SIZE");

				if (StringUtils.equals(md5Txt, (String) item.get("FILE_MD5"))) {
					return filePath;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	*/
/**
	 * 
	 * 保存文件数据信息到数据库
	 * 
	 * @param file
	 *//*

	public void saveNewFileItem(File file, String fastDfsPath) {

		String fileName = file.getName();
		int suffixPosition = fileName.lastIndexOf('.');
		String suffix = "";
		if (suffixPosition != -1) {
			suffix = fileName.substring(suffixPosition);
		}
		String fileMd5Txt = null;
		try {
			fileMd5Txt = MD5Util.getFileMD5String(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbcTemplate.update(
				"insert  into  T_FASTDFS_FILES (id,FILE_NAME,CREATE_TIME," + "FILE_SIZE,"
						+ "FILE_SUFFIX,FILE_MD5,FILE_PATH," + "DEL_FLAG,SAVE_SYSTEM_FLAG) "
						+ "values(sys_guid(),?,to_char(now(),'yyyymmddhh24miss'),?,?,?,?,0,?)",
				new Object[] { file.getName(), file.length(), suffix, fileMd5Txt, fastDfsPath, "-" });

	}

	*/
/**
	 * 
	 * 保存文件数据信息到数据库
	 * 
	 * @param file
	 *//*

	public void saveNewFileItem(byte[] data, String fileName, String fastDfsPath) {

		int suffixPosition = fileName.lastIndexOf('.');
		String suffix = "";
		if (suffixPosition != -1) {
			suffix = fileName.substring(suffixPosition);
		}
		String fileMd5Txt = null;
		try {
			fileMd5Txt = MD5Util.getFileMD5String(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbcTemplate.update(
				"insert  into  T_FASTDFS_FILES (id,FILE_NAME,CREATE_TIME," + "FILE_SIZE,"
						+ "FILE_SUFFIX,FILE_MD5,FILE_PATH," + "DEL_FLAG,SAVE_SYSTEM_FLAG) "
						+ "values(sys_guid(),?,to_char(now(),'yyyymmddhh24miss'),?,?,?,?,0,?)",
				new Object[] { fileName, data.length, suffix, fileMd5Txt, fastDfsPath, "-" });

	}

	*/
/**
	 * 
	 * 保存文件数据信息到数据库
	 * 
	 * @param file
	 *//*

	public void deleteNewFileItem(String fastDfsPath) {

		jdbcTemplate.update("update  T_FASTDFS_FILES t  set  t.DEL_FLAG= 1  where  t.FILE_PATH = ? ", fastDfsPath);

	}

	@Override
	public String saveFile(String groupName, String filePath, String suffix, HashMap<String, String> metaMap)
			throws Exception {

		File file = new File(filePath);
		String fileFastDfsPath = queryFileMd5(file);
		// 返回对应的已经存在的文件路径
		if (fileFastDfsPath != null) {
			return fileFastDfsPath;
		}
		String fileId = super.saveFile(groupName, filePath, suffix, metaMap);

		saveNewFileItem(file, fileId);
		return fileId;
	}

	@Override
	public String saveFile(byte[] fileBuff, String suffix) throws Exception {

		String byteFileName = "_byte_file." + suffix;
		String fileFastDfsPath = queryByteBufferMd5(fileBuff, byteFileName);
		// 返回对应的已经存在的文件路径
		if (fileFastDfsPath != null) {
			return fileFastDfsPath;
		}
		String fileId = super.saveFile(fileBuff, suffix);
		saveNewFileItem(fileBuff, byteFileName, fileId);
		return fileId;
	}

	@Override
	public boolean deleteFile(String fileId) throws Exception {
		boolean return_flag = super.deleteFile(fileId);
		deleteNewFileItem(fileId);
		return return_flag;
	}

}
*/
