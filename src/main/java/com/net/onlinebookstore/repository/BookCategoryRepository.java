package com.net.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.net.onlinebookstore.entity.BookCategory;


//สร้าง path
@RepositoryRestResource(collectionResourceRel = "bookCategory", path="book-category")
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
