package com.task.betpawa_server.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "serverprop")
@Configuration("environmentProperties")
public class EnvironmentProperties {
	  private String port;

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}
}
