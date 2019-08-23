package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rns.XCodeX.XCodeX_Product.model.DeviceMaster;

public interface DeviceMasterRepository extends CrudRepository<DeviceMaster, Long>{
	
	Optional<DeviceMaster> findByDeviceId(String deviceId);
	List<DeviceMaster> findByIdUser_idUserIn(List<Long> userIds);

}
