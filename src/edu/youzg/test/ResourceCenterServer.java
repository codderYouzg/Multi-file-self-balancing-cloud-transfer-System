package edu.youzg.test;

import edu.youzg.resource_founder.core.IResourceListener;
import edu.youzg.resource_founder.core.ResourceRegistryCenter;
import org.apache.log4j.Logger;

public class ResourceCenterServer implements IResourceListener {
	private static final String DEFAULT_CONFIG_PATH = "/resource/ResourceRegistryCenter-RMI.xml";
	public static final int RCSPort = 6666;
	private ResourceRegistryCenter center;

	private Logger log = Logger.getLogger(ResourceCenterServer.class);

	public ResourceCenterServer() {
		this.center = new ResourceRegistryCenter(RCSPort);
		this.center.addListener(this);
	}

	public void initCenter() {
		initCenter(DEFAULT_CONFIG_PATH);
	}

	public void initCenter(String configFilePath) {
		this.center.initRegistryCenter(configFilePath);
	}

	public void startup() {
		this.center.startup();
	}

	public void shutdown() {
		this.center.shutdown();
	}

	@Override
	public void dealMessage(String message) {
		log.info(message);
	}
	
}
