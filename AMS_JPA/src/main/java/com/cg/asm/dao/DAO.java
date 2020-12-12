package com.cg.asm.dao;

import java.util.List;

import com.cg.asm.beans.Asset;
import com.cg.asm.beans.AssetAllocation;
import com.cg.asm.beans.Employee;
import com.cg.asm.beans.UserMaster;

public interface DAO {
	UserMaster login(Integer userid, String password);

	Asset addingAsset(Asset asset);

	Asset removingAsset(Integer aid);

	Asset updatingAssetName(Integer aid, String assetname);

	Asset updatingAssetDesription(Integer aid, String assetdes);

	Asset updatingAssetQuantity(Integer aid, Integer assetquan);

	Asset updatingAssetStatus(Integer aid, String assetstatus);

	List<Asset> getAllAsset();

	Employee addEmployee(Employee employee);

	AssetAllocation raiseAllocation(AssetAllocation assetallocation);

	List<AssetAllocation> getAllAssetAllocation();

	Boolean setStatus(Integer allocationid, String status);

	String viewStatus(Integer allocationid);

}
