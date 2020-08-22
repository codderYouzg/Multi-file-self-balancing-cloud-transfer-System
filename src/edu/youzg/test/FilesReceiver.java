package edu.youzg.test;

import edu.youzg.multifile_cloud_transfer.exception.ResourceNotExistException;
import edu.youzg.multifile_cloud_transfer.receive.ResourceReceiver;
import edu.youzg.multifile_cloud_transfer.resourcer.SourceFileList;
import edu.youzg.multifile_cloud_transfer.sender.SourceHolderNode;
import edu.youzg.resource_founder.core.ResourceBaseInfo;
import edu.youzg.resource_founder.core.ResourceSpecificInfo;
import edu.youzg.util.PropertiesParser;

import java.util.List;

/**
 * 文件接收端
 */
public class FilesReceiver {
	private ResourceReceiver videoReceiver;
	
	public FilesReceiver() {
		this.videoReceiver = new ResourceReceiver();
	}

	/**
	 * 根据 指定路径，初始化 接收端信息
	 * @param configFile 配置文件 所在路径
	 */
	public void initConfig(String configFile) {
		SourceHolderNode.initConfig(configFile);

		PropertiesParser.loadProperties(configFile);
		int port = Integer.valueOf(PropertiesParser.value("port"));
		
		String registryIp = PropertiesParser.value("registry_ip");
		int registryPort = Integer.valueOf(PropertiesParser.value("registry_port"));

		this.videoReceiver.setCenterIp(registryIp);
		this.videoReceiver.setCenterPort(registryPort);
		this.videoReceiver.setReceiveServerPort(port);
	}

	public void setBaseInfo(ResourceBaseInfo ri) {
		this.videoReceiver.setBaseInfo(ri);
	}
	
	public void setSourceFileList(SourceFileList fileList) {
		this.videoReceiver.setFileList(fileList);
	}

	/**
	 * 获取 注册中心 的资源基本信息列表
	 * @return 注册中心 的资源基本信息列表
	 */
	public List<ResourceBaseInfo> getResourceList() {
		return this.videoReceiver.getResourceList();
	}

	/**
	 * 根据 资源基本信息，获取资源详细信息列表
	 * @param ri 资源基本信息
	 * @return 资源详细信息列表
	 */
	public List<ResourceSpecificInfo> getFileInfoListByResourceInfo(ResourceBaseInfo ri) {
		return this.videoReceiver.getFileInfoListByResourceInfo(ri);
	}

	/**
	 * 请求资源
	 */
	public void requestFiles() {
		try {
			this.videoReceiver.getResourceFiles();
		} catch (ResourceNotExistException e) {
			e.printStackTrace();
		}
	}

}
