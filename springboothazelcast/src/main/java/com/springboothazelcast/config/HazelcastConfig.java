package com.springboothazelcast.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@EnableJpaRepositories(basePackages = "com.springboothazelcast.repository")
@EnableCaching
public class HazelcastConfig {
	
	public HazelcastInstance hazelcastInstance() {
		Config config = new Config();
		//MapConfig configuration
		MapConfig mapConfig = new MapConfig();
		mapConfig.setName("book");
		mapConfig.setMaxSizeConfig(new MaxSizeConfig(100, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE));
		mapConfig.setEvictionPolicy(EvictionPolicy.LRU);
		mapConfig.setTimeToLiveSeconds(60);
		
		config.setInstanceName("satish_hazelcast");
		config.addMapConfig(mapConfig);
		return Hazelcast.newHazelcastInstance(config);
		
	}
}
