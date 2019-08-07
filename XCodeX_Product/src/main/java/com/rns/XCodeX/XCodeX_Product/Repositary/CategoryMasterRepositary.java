package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.CategoryMaster;

@Repository
public interface CategoryMasterRepositary extends CrudRepository<CategoryMaster, Long> {
	List<CategoryMaster> findAll();
}
