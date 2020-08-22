package edu.youzg.test;

import edu.youzg.multifile_cloud_transfer.exception.RegistryIpIsNullException;
import edu.youzg.multifile_cloud_transfer.resourcer.SourceFileList;
import edu.youzg.multifile_cloud_transfer.sender.SourceHolderNode;
import edu.youzg.resource_founder.core.ResourceBaseInfo;

/**
 * 文件发送端
 */
public class FilesSender {
	private SourceHolderNode holderNode;
	
	public FilesSender() throws RegistryIpIsNullException {
		this.holderNode = SourceHolderNode.newInstance();
	}
	
	public static void initConfig(String configFile) {
		SourceHolderNode.initConfig(configFile);
	}
	
	public void registryResource(ResourceBaseInfo baseInfo, SourceFileList fileList) {
		this.holderNode.reportResource(baseInfo, fileList);
	}

	public void logoutResource(ResourceBaseInfo baseInfo) {
		this.holderNode.logoutResource(baseInfo);
	}

}
