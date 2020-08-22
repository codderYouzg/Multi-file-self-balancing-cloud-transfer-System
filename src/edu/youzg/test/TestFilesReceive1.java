package edu.youzg.test;

import edu.youzg.multifile_cloud_transfer.resourcer.SourceFileList;
import edu.youzg.resource_founder.core.ResourceBaseInfo;
import edu.youzg.resource_founder.core.ResourceSpecificInfo;

import java.util.List;

/**
 * 接收端 步骤：<br/>
 * 1、读取配置文件，初始化 SourceHolderNode 和 FilesReceiver
 * 2、请求 资源列表
 * 3、请求 指定的资源
 */
public class TestFilesReceive1 {

	public static void main(String[] args) {
		FilesReceiver filesReceiver = new FilesReceiver();
		filesReceiver.initConfig("/resource/receive1.properties");
		List<ResourceBaseInfo> resourceList = filesReceiver.getResourceList();
		if (resourceList == null || resourceList.size() <= 0) {
			System.out.println("注册中心 当前不存在 资源");
			return;
		}

		ResourceBaseInfo resourceInfo = resourceList.get(0);

		SourceFileList sfl = new SourceFileList();
		List<ResourceSpecificInfo> fileInfoList = filesReceiver.getFileInfoListByResourceInfo(resourceInfo);

		sfl.setFileList(fileInfoList);
		sfl.setAbsoluteRoot("E:\\Multi-file self-balancing cloud transfer\\testArea\\target1\\");

		filesReceiver.setBaseInfo(resourceInfo);
		filesReceiver.setSourceFileList(sfl);

		filesReceiver.requestFiles();
	}

}