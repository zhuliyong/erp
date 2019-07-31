package com.sys.common.tools;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * 有关编辑XML
 * 
 * @author yuson
 *
 */
public class EditorForXML<mian> {

	/**
	 *读取xml文件
	 * @param fileName 文件名
	 * @param key 标记
	 * @return 对应的内容
	 */
	public static String getValueForKey(String fileName, String key) {
		// 1：取出文件流
		// 2：读取文件里的xml里的内容
		// 3：取出key对应的value值
		String value = "";//
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(in); // 读取xml-并建立document
			Element rootElt = document.getRootElement();// 取出rootElt
			value = rootElt.elementText(key);// 取出updateTime 里的值
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println(EditorForXML.getValueForKey("excelExplain.xml", "BcEmployeeImportExplain"));
	}
 
}
