package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.PriorityMaster;


@Repository
public interface PriorityMasterRepositary extends CrudRepository<PriorityMaster, Long> {
	List<PriorityMaster> findAll();
}
