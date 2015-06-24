/**
 * 
 */
package com.lehecai.core.service.impl.upload;

import com.lehecai.core.bean.config.FileUploadConfig;
import com.lehecai.core.service.upload.FileUploadService;

/**
 * @author sunshow
 *
 */
public class FileUploadServiceImpl implements FileUploadService {
	
	private FileUploadConfig fileUploadConfig;

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.upload.FileUploadService#getFilePath(long)
	 */
	@Override
	public String getFilePath(long uploadId) {
		
		if (uploadId == 0) {
			return null;
		}

		if (fileUploadConfig == null) {
			return null;
		}
		
		String filePath = null;
		
		switch (fileUploadConfig.getVersion()) {
		case 0:
			filePath = getFilePathDefault(uploadId);
			break;

		default:
			filePath = getFilePathDefault(uploadId);
			break;
		}
		
		return filePath;
	}
	
	/**
	 * 默认方式获取存储路径
	 * 存储目录的算法：按照ID对256取模
	 * @param uploadId
	 * @return
	 */
	protected String getFilePathDefault(long uploadId) {
		int dir = (int) (uploadId % 256);
		
		StringBuffer sb = new StringBuffer(fileUploadConfig.getSavePath());
		sb.append("/").append(dir).append("/").append(uploadId).append(".").append(fileUploadConfig.getExtName());
		
		return sb.toString();
	}

	public FileUploadConfig getFileUploadConfig() {
		return fileUploadConfig;
	}

	public void setFileUploadConfig(FileUploadConfig fileUploadConfig) {
		this.fileUploadConfig = fileUploadConfig;
	}

}
