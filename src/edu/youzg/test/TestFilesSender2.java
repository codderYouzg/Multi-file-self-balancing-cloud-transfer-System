package edu.youzg.test;

import edu.youzg.multifile_cloud_transfer.exception.RegistryIpIsNullException;
import edu.youzg.multifile_cloud_transfer.resourcer.SourceFileList;
import edu.youzg.resource_founder.core.ResourceBaseInfo;
import edu.youzg.resource_founder.resourcer.ResourceHolder;

/**
 * 发送端 步骤：<br/>
 * 1、准备 资源
 * 2、准备 发送端
 * 3、注册资源
 */
public class TestFilesSender2 {

	public static void main(String[] args) throws RegistryIpIsNullException {
		FilesSender.initConfig("/resource/holder2.properties");
		ResourceHolder.scanRMIMapping("/resource/ResourceHolder-RMI.xml");

		ResourceBaseInfo ri = new ResourceBaseInfo("app", "20170526212853", "1");
		SourceFileList sfl = new SourceFileList();
		sfl.setAbsoluteRoot("E:\\Multi-file self-balancing cloud transfer\\testArea\\source");
		sfl.collectFiles();

		FilesSender sender = new FilesSender();
		sender.registryResource(ri, sfl);
	}

}