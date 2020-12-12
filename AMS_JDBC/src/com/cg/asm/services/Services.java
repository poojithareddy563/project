package com.cg.asm.services;

import java.util.List;

import com.cg.asm.beans.Asset;
import com.cg.asm.beans.AssetAllocation;
import com.cg.asm.beans.Employee;
import com.cg.asm.beans.UserMaster;

public interface Services {
	UserMaster loginService(Integer userid,String password);
	Asset addingAssetService(Asset asset);
	Asset removingAssetService(Integer aid);
	Asset updatingAssetNameService(Integer aid,String assetname);
	Asset updatingAssetDesService(Integer aid,String assetdes);
	Asset updatingAssetQuantityService(Integer aid,Integer assetquan);
	Asset updatingAssetStatusService(Integer aid,String assetstatus);
	List<Asset> getAllAssetService();
	Employee addingEmployeeService(Employee employee);
	AssetAllocation raiseAllocationService(AssetAllocation assetallocation);
	List<AssetAllocation> getAllAssetAllocationService();
	Boolean setStatusService(Integer allocationid,String status);
	String viewStatusService(Integer allocationid);
	
}
