package com.ahm.jx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BsJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	
	Page<T> getSearchPageable(String fieldString, String filter, String fieldSort, String order, Pageable pageable);
	
	List<T> getPagingData(String fieldSearch, int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
	
	Integer getPagingCount(String fieldSearch, Map<String, Object> filters);

}
