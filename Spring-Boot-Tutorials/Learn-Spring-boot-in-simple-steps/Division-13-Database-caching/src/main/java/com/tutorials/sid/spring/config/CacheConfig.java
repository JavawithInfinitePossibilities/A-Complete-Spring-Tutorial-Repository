/**
 * 
 */
package com.tutorials.sid.spring.config;

import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.MapConfig;

/**
 * @author Lenovo
 *
 */
@Configuration
public class CacheConfig {

	public Config cacheConfig() {
		return new Config().setInstanceName("hazal-instance")
				.addMapConfig(new MapConfig().setName("student-cache").setTimeToLiveSeconds(3000));

	}
}
