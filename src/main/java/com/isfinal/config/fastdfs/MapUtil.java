package com.isfinal.config.fastdfs;
import org.csource.common.NameValuePair;

import java.util.HashMap;


/**
 * <p>
 * MapUtils作用
 * </p>
 *
 */
public class MapUtil {

	/**
	 * mapToNameValues
	 *
	 * @param hashMap
	 *            hashMap
	 * @return NameValuePair
	 */
	public static NameValuePair[] mapToNameValues(HashMap<String, String> hashMap) {
		if (hashMap == null || hashMap.isEmpty()) {
			return new NameValuePair[0];
		}
		NameValuePair[] nameValuePairs = new NameValuePair[hashMap.size()];
		int i = 0;
		for (String key : hashMap.keySet()) {
			NameValuePair nameValuePair = new NameValuePair(key, hashMap.get(key));
			nameValuePairs[i] = nameValuePair;
			i++;
		}
		return nameValuePairs;
	}

	/**
	 * nameValuesToMap
	 *
	 * @param nameValuePairs
	 *            nameValuePairs
	 * @return HashMap
	 */
	public static HashMap<String, String> nameValuesToMap(NameValuePair[] nameValuePairs) {
		if (nameValuePairs == null || nameValuePairs.length == 0) {
			return new HashMap<String, String>();
		}
		int num = nameValuePairs.length;
		HashMap<String, String> hashMap = new HashMap<String, String>(num);
		for (int i = 0; i < num; i++) {
			NameValuePair nameValuePair = nameValuePairs[i];
			hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
		}
		return hashMap;
	}
}
