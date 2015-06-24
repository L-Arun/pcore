/**
 * 
 */
package com.lehecai.core.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件操作工具类
 * @author leiming
 * @author sunshow
 *
 */
public class CoreFileUtils {
	public static final Logger logger = LoggerFactory.getLogger(CoreFileUtils.class);
	
	/**
	 * 有编码方式的文件创建
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @param encoding
	 *            编码方式 例如 GBK 或者 UTF-8
	 * @return
	 */
	public static boolean createFile(String filePathAndName, String fileContent, String encoding) {
		if(filePathAndName == null){
			logger.error("创建指定编码文件参数filePathAndName为null,创建失败,请指定具体文件");
			return false;
		}
		if(encoding == null){
			logger.error("创建指定编码文件参数encoding为null,创建失败,请指定具体编码");
			return false;
		}
		try {
			File file = new File(filePathAndName);
			if (!file.exists()) {
				String dirPath = file.getParent();
				if(dirPath != null){
					File dirFolder = new File(dirPath);
					if(!dirFolder.exists()){
						dirFolder.mkdirs();
					}
				}
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file, encoding);
			String content = null;
			if(fileContent == null){
				content = "";
			}else{
				content = fileContent;
			}
			writer.println(content);
			writer.close();
			logger.info("创建并写入内容到文件(filePathAndName:"+filePathAndName+",绝对路径:{})成功,编码格式:{}",file.getAbsolutePath(),encoding);
		} catch (Exception e) {
			logger.error("创建文件(参数filePathAndName:"+filePathAndName+")操作出错,创建失败",e);
			return false;
		}
		return true;
	}
	
	/**
	 * 判断文件是否存在
	 * @param filePathAndName
	 * @return
	 */
	public static boolean isExist(String filePathAndName) {
		File file = new File(filePathAndName);
		return file.exists();
	}
	
	/**
	 * 读取文件内容
	 * @param filePathAndName 带有完整绝对路径的文件名
	 * @param encoding 文件打开的编码方式
	 * @return 返回文件的内容
	 */
	public static String readFile(String filePathAndName, String encoding) throws IOException{
		if (filePathAndName == null || filePathAndName.isEmpty()) {
			return null;
		}
		
		if (!isExist(filePathAndName)) {
			logger.info("文件不存在，路径：{}", filePathAndName);
			return null;
		}
		encoding = encoding.trim();
		StringBuffer sb = new StringBuffer("");
		String content = null;
		
		FileInputStream fs = new FileInputStream(filePathAndName);
		InputStreamReader isr;
		if (encoding.isEmpty()) {
			isr = new InputStreamReader(fs);
		} else {
			isr = new InputStreamReader(fs, encoding);
		}
		BufferedReader br = new BufferedReader(isr);
		
		String data = "";
		while ((data = br.readLine()) != null) {
			sb.append(data + " ");
		}
		content = sb.toString();
		
		br.close();
		isr.close();
		fs.close();
		
		return content;
	}
	
	public static String getFileContentByMappedBuffer(String filepath, String charset) throws FileNotFoundException, IOException {
		FileChannel fc = new FileInputStream(filepath).getChannel();
		
		ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		
		try {
			return CoreStringUtils.convertByteBuffer(bb, charset);
		} finally {
			fc.close();
		}
	}
	
	/**
	 * 按行读取文件内容
	 * @param filepath
	 * @param charset
	 * @param converter 字符串转换器,如有配置,进行相应转换
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<String> getFileContentByLine(String filepath, String charset, IStringConverter converter) throws FileNotFoundException, IOException {
		BufferedReader in = null;
		try {
			File file = new File(filepath);
			
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file), charset);
			
			in = new BufferedReader(reader);

			List<String> result = new ArrayList<String>();
			
			String temp = null;
			while ((temp = in.readLine()) != null) {
				if (converter == null) {
					// 如果未设置转换器
					result.add(temp);
					continue;
				}
				
				String converted = converter.convert(temp);
				// 如果转换结果返回null，不放入读取结果里
				if (converted != null) {
					result.add(temp);
					continue;
				}
			}
			return result;
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
	public static void uploadFile(File file, String filePathAndName, String encoding) throws Exception {
		File toFile = new File(filePathAndName);
		if (!toFile.exists()) {
			String dirPath = toFile.getParent();
			if(dirPath != null){
				File dirFolder = new File(dirPath);
				if(!dirFolder.exists()){
					dirFolder.mkdirs();
				}
			}
			toFile.createNewFile();
		}
		InputStream is = null;
		BufferedOutputStream os = null;
		try {
			is = new FileInputStream(file);
			os = new BufferedOutputStream(new FileOutputStream(filePathAndName));
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (os != null)
				os.close();
			if (is != null)
				is.close();
		}
	}
}
