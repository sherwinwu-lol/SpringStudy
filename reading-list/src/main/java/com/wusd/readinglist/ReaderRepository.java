package com.wusd.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 通过JPA持久化读者
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {
}
