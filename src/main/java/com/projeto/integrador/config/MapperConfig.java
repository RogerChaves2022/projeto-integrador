package com.projeto.integrador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.projeto.integrador.mapper.EstoqueMapper;

@Component
public class MapperConfig {

	
	@Bean
	public EstoqueMapper EstoqueMapper() {
		return EstoqueMapper.INSTANCE;
	}
}
