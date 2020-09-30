package com.net.onlinebookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


import com.net.onlinebookstore.entity.Book;


public interface BookRepository extends JpaRepository<Book,Long> {
	
	//รับค่าผ่าน url
	
	@RestResource(path = "categoryid")   //กำหนดชื่อ path ที่ใช้ค้นหา
	Page<Book> findByCategoryId(@Param("id") Long id, Pageable pageable);

	
	@RestResource(path = "searchbykeyword")   //กำหนดชื่อ path ที่ใช้ค้นหา
	Page<Book> findByNameContaining(@Param("name") String keyword, Pageable pageable);
}
