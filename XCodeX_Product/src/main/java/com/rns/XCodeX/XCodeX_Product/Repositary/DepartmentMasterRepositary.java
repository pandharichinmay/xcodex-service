package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.DepartmentMaster;

@Repository
public interface DepartmentMasterRepositary extends CrudRepository<DepartmentMaster, Long> {
	List<DepartmentMaster> findAll();
}
