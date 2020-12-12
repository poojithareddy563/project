package com.cg.asm.services;

import java.util.List;

import com.cg.asm.beans.Asset;
import com.cg.asm.beans.AssetAllocation;
import com.cg.asm.beans.Employee;
import com.cg.asm.beans.UserMaster;
import com.cg.asm.dao.DAO;
import com.cg.asm.dao.DAOImpl;

public class ServicesImpl implements Services {
	DAO dao = new DAOImpl();

	public UserMaster loginService(Integer userid, String password) {

		return dao.login(userid, password);
	}

	public Asset addingAssetService(Asset asset) {

		return dao.addingAsset(asset);
	}

	public Asset removingAssetService(Integer aid) {

		return dao.removingAsset(aid);
	}

	

	public List<Asset> getAllAssetService() {
		
		return dao.getAllAsset();
	}

	public Employee addEmployeeService(Employee employee) {

		return dao.addEmployee(employee);
	}

	public AssetAllocation raiseAllocationService(AssetAllocation assetallocation) {
		return dao.raiseAllocation(assetallocation);
	}

	public List<AssetAllocation> getAllAssetAllocationService() {

		return dao.getAllAssetAllocation();
	}

	public String viewStatusService(Integer allocationid) {

		return dao.viewStatus(allocationid);
	}

	public Asset updatingAssetNameService(Integer aid, String assetname) {

		return dao.updatingAssetName(aid, assetname);
	}

	public Asset updatingAssetDesService(Integer aid, String assetdes) {

		return dao.updatingAssetDesription(aid, assetdes);
	}

	public Asset updatingAssetQuantityService(Integer aid, Integer assetquan) {

		return dao.updatingAssetQuantity(aid, assetquan);
	}

	public Asset updatingAssetStatusService(Integer aid, String assetstatus) {

		return dao.updatingAssetStatus(aid, assetstatus);
	}

	public Boolean setStatusService(Integer allocationid, String status) {

		return dao.setStatus(allocationid, status);
	}

}
