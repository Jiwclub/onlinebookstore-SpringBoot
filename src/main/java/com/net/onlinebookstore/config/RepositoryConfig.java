package com.net.onlinebookstore.config;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

//import com.net.onlinebookstore.entity.Book;
//import com.net.onlinebookstore.entity.BookCategory;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
	//ผูกให้
	@Autowired
	private EntityManager entityManager; //EntityManager เป็น object ที่ใช้แทนการ เพิ่มลบแก้ไข
	
	//สร้าง id ให้json
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//		config.exposeIdsFor(Book.class);
//		config.exposeIdsFor(BookCategory.class);
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
				.map(Type::getJavaType)
				.toArray(Class[]::new));
		config.getCorsRegistry().addMapping("/**").allowedOrigins("http://localhost:4200");
		
	}
}
