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
		// TODO Auto-generated method stub
		return dao.addingAsset(asset);
	}

	public Asset removingAssetService(Integer aid) {

		return dao.removingAsset(aid);
	}

	// public Asset updateAssetService(Integer aid) {
	//
	// return d.updateAsset(aid);
	// }

	public List<Asset> getAllAssetService() {
		// TODO Auto-generated method stub
		return dao.getAllAsset();
	}

	public Employee addingEmployeeService(Employee employee) {

		return dao.addingEmployee(employee);
	}

	public AssetAllocation raiseAllocationService(AssetAllocation assetallocation) {
		return dao.raiseAllocation(assetallocation);
	}

	public List<AssetAllocation> getAllAssetAllocationService() {

		return dao.getAllAssetAllocation();
	}

	public String viewStatusService(Integer allocationid) {
		// TODO Auto-generated method stub
		return dao.viewStatus(allocationid);
	}

	public Asset updatingAssetNameService(Integer aid, String assetname) {

		return dao.updatingAssetName(aid, assetname);
	}

	public Asset updatingAssetDesService(Integer aid, String assetdes) {

		return dao.updatingAssetDescription(aid, assetdes);
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
