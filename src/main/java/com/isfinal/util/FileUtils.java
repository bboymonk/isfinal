package com.isfinal.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具包
 * 
 * @lastModified
 * @history
 */

public class FileUtils {

	/**
	 * 写入文件
	 * 
	 * @param path
	 * @param sqlStream
	 * @lastModified
	 * @history
	 */
	public static void writeFileDic(String path, InputStream sqlStream, String fileName, String fileType) {
		FileOutputStream o = null;
		try {
			String sqlFileName = path + "/" + fileName + fileType;
			o = new FileOutputStream(sqlFileName);
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = sqlStream.read(buffer)) != -1) {
				o.write(buffer, 0, len);
			}
			o.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != o) {
				try {
					o.close();
					o = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 文件转byte[]
	 * 
	 * @param path
	 *            文件路径
	 * @return
	 * @lastModified
	 * @history
	 */
	public static byte[] fileToBytes(String path) {
		File file = new File(path);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			file.delete();
			return bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 * 
	 * @param dir
	 *            将要删除的文件目录
	 * @return boolean Returns "true" if all deletions were successful. If a
	 *         deletion fails, the method stops attempting to delete and returns
	 *         "false".
	 */
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

	/**
	 * 读取文件内容
	 * 
	 * @param path
	 * @return
	 * @lastModified
	 * @history
	 */
	public static String readFile(String path) {
		File file = new File(path);
		StringBuilder result = new StringBuilder();
		try {
			FileInputStream fin = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(fin, "utf-8");
			char[] buffer = new char[1024];
			int len = 0;
			while ((len = reader.read(buffer)) != -1) {
				result.append(buffer, 0, len);
			}
			reader.close();
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * 读取文件内容
	 * 
	 * @param path
	 * @return
	 * @lastModified
	 * @history
	 */
	public static String readFile(String path, String charset) {
		File file = new File(path);
		StringBuilder result = new StringBuilder();
		try {
			FileInputStream fin = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(fin, charset);
			char[] buffer = new char[1024];
			int len = 0;
			while ((len = reader.read(buffer)) != -1) {
				result.append(buffer, 0, len);
			}
			reader.close();
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * <p>
	 * 方法名称：字节流写入文件
	 * </p>
	 * <p>
	 * 方法说明：
	 * </p>
	 * 
	 * @param data
	 *            字节流
	 * @param filePath
	 *            文件名
	 */
	public static void bytesToFile(byte[] data, String filePath) {
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		FileOutputStream o = null;
		try {
			o = new FileOutputStream(filePath);
			o.write(data, 0, data.length);
			o.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != o) {
				try {
					o.close();
					o = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * <p>
	 * 方法名称：删除特定目录下pattern所对应的文件
	 * </p>
	 * <p>
	 * 方法说明：
	 * </p>
	 * 
	 * @param dirPath
	 * @param pattern
	 */
	public static void deleteFile(File dirPath, String pattern) {
		if (dirPath.isDirectory()) {
			String[] children = dirPath.list();
			for (int i = 0; i < children.length; i++) {
				if (children[i].matches(pattern)) {
					new File(dirPath + File.separator + children[i]).delete();
				}
			}
		}
	}

	/**
	 * <p>
	 * 方法名称：如果文件夹不存在在创建
	 * </p>
	 * <p>
	 * 方法说明：
	 * </p>
	 * 
	 * @param dirPath
	 */
	public static void mkDirIfNotExsits(String dirPath) {
		File file = new File(dirPath);
		if (!file.exists()) {
			file.mkdirs();
		}

	}

	/**
	 * 获取路径下的所有文件
	 * 
	 * @param directoryPath
	 *            需要遍历的文件夹路径
	 * @param isAddDirectory
	 *            是否将子文件夹的路径也添加到list集合中 true 添加 false 不添加
	 * @return
	 */
	public static List<String> getAllFilePath(String directoryPath, boolean isAddDirectory) {
		List<String> list = new ArrayList<String>();
		File baseFile = new File(directoryPath);
		if (baseFile.isFile() || !baseFile.exists()) {
			return list;
		}
		File[] files = baseFile.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if (isAddDirectory) {
					list.add(file.getAbsolutePath());
				}
				list.addAll(getAllFilePath(file.getAbsolutePath(), isAddDirectory));
			} else {
				list.add(file.getAbsolutePath());
			}
		}
		return list;
	}

}
