package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.DeviceMaster;
import com.rns.XCodeX.XCodeX_Product.model.UserMaster;

@Repository
public interface UserMasterRepositary extends CrudRepository<UserMaster, Long> {
	List<UserMaster> findAllByEmail(String email);
	List<UserMaster> findAllByOrderByUsernameAsc();
	void save(DeviceMaster deviceMaster);

}
