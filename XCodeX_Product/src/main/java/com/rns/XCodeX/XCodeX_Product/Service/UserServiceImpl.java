package com.rns.XCodeX.XCodeX_Product.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rns.XCodeX.XCodeX_Product.Repositary.UserMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.model.UserMaster;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMasterRepositary userMasterRepositary;

	public List<UserMaster> getAllUsersByEmail(String email) {
		System.out.println("All Users Email!..");
		return userMasterRepositary.findAllByEmail(email);
	}

	@Override
	public UserMaster login(UserMaster userMaster) {

		List<UserMaster> result = userMasterRepositary.findAllByEmail(userMaster.getEmail());
		if (CollectionUtils.isEmpty(result)) {
			return null;
		} else {
			String pw = encryptPassword(userMaster.getPassword());
			UserMaster userProfile = result.get(0);
			if(StringUtils.equals(userProfile.getPassword(), pw)) {
				return userProfile;
			} else {
				return null;
			}
		}
	}

	private String encryptPassword(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

			// bytes to hex
			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}
			System.out.println(sb.toString());
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserMaster> getAllUsers() {
		System.out.println("All Users !..");
		return userMasterRepositary.findAllByOrderByUsernameAsc();
	}

	@Override
	public UserMaster loadProfile(UserMaster userMaster) {
		Optional<UserMaster> result = userMasterRepositary.findById(userMaster.getIdUser());
		if (result == null || !result.isPresent()) {
			return null;
		} else {
			return result.get();
		}
	}
}
