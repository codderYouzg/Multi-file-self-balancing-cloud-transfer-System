package edu.youzg.test;

/**
 * 注册中心 步骤：<br/>
 * 1、初始化 ResourceCenterServer<br/>
 * 2、启动 注册中心
 */
public class TestResourceCenter {

	public static void main(String[] args) {
		ResourceCenterServer rcs = new ResourceCenterServer();
		rcs.initCenter("/resource/ResourceRegistryCenter-RMI.xml");
		rcs.startup();
	}
	
}
