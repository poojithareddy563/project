package com.cg.asm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.asm.beans.Asset;
import com.cg.asm.beans.AssetAllocation;
import com.cg.asm.beans.Employee;
import com.cg.asm.beans.UserMaster;
import com.cg.asm.exceptions.AddingAssetException;
import com.cg.asm.exceptions.AddingEmployeeException;
import com.cg.asm.exceptions.GetAssetException;
import com.cg.asm.exceptions.LoginException;
import com.cg.asm.exceptions.RaisingAllocationException;
import com.cg.asm.exceptions.RemovingAssetException;
import com.cg.asm.exceptions.StatusException;
import com.cg.asm.exceptions.UpdatingAssetException;
import com.cg.asm.exceptions.ValidationException;
import com.cg.asm.repo.Database;
import com.cg.asm.validations.Validate;

/**
 * this class implementations for all abstract methods that are in dao interface
 **/

public class DAOImpl implements DAO {
	/** database obj is created in order to access db **/
	Database database = new Database();

	/** login method implemetation **/
	@Override
	public UserMaster login(Integer userid, String password) {

		if (database.map.containsKey(userid)) {
			UserMaster usermaster = database.map.get(userid);
			if (usermaster.getUserpassword().equals(password)) {
				return usermaster;
			}
		}
		/** custom exception which is thrown to jvm by using throw keyword **/
		throw new LoginException();
	}

	@Override
	public Asset addingAsset(Asset asset) {
		/**
		 * once admin login he can add asset if gives same asset id it throw exception
		 **/
		try {
			if (!database.mapasset.containsKey(asset.getAssetid())) {
				database.mapasset.put(asset.getAssetid(), asset);
				return asset;
			} else {
				throw new AddingAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/** removing asset by passing correct asset id **/
	@Override
	public Asset removingAsset(Integer aid) {
		try {
			Asset asset = new Asset();
			if (database.mapasset.containsKey(aid)) {
				asset = database.mapasset.remove(aid);
				return asset;
			} else {

				throw new RemovingAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/** getAllAsset() is performed by admin to get all list of assets **/
	@Override
	public List<Asset> getAllAsset() {
		/**
		 * try block contains all the getAllAsset method implementation and it will
		 * throw exception when the database has no assets
		 */
		try {
			if (!database.mapasset.isEmpty()) {
				List<Asset> list = new ArrayList(database.mapasset.values());
				Iterator<Asset> it = list.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}

				return list;
			} else {
				throw new GetAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * adding employee is done by manager if same number is given it will throw
	 * exception
	 **/
	@Override
	public Employee addingEmployee(Employee employee) {
		try {
			if (!database.mapemp.containsKey(employee.getEmpno())) {
				if (database.mapdept.containsKey(employee.getDeptid())) {
					database.mapemp.put(employee.getEmpno(), employee);
					return employee;
				}

				throw new AddingEmployeeException();
			} else {

				throw new AddingEmployeeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** raise alocation is performed by manager by giving asset id **/
	@Override
	public AssetAllocation raiseAllocation(AssetAllocation assetallocation) {

		try {
			if (!database.mapas.containsKey(assetallocation.getAllocationid())) {
				database.mapas.put(assetallocation.getAllocationid(), "null");
				if (!database.mapaa.containsKey(assetallocation.getAllocationid())) {
					database.mapaa.put(assetallocation.getAllocationid(), assetallocation);
					return assetallocation;
				}
			} else {
				throw new RaisingAllocationException();
			}
			throw new RaisingAllocationException();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** getAllAssetallocation() is performed by admin to get all list of assets **/
	@Override
	public List<AssetAllocation> getAllAssetAllocation() {
		/**
		 * try block contains all the getAllAsset method implementation and it will
		 * throw exception when the database has no assets
		 */
		try {
			if (!database.mapaa.isEmpty()) {
				List<AssetAllocation> list = new ArrayList(database.mapaa.values());
				Iterator<AssetAllocation> it = list.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				return list;

			} else {
				System.out.println("raise list is not available");
				throw new RaisingAllocationException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** setstatus is done by admin gy giving generation allocation id **/
	@Override
	public Boolean setStatus(Integer allocationid, String status) {
		try {
			if (database.mapaa.containsKey(allocationid)) {
				database.mapas.put(allocationid, status);
				return true;

			} else {
				throw new StatusException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * view status is present in manager and he can view the status by passing
	 * alllocation id
	 **/
	@Override
	public String viewStatus(Integer allocationid) {
		try {
			if (database.mapas.containsKey(allocationid)) {

				String s = database.mapas.get(allocationid);

				if (!s.isEmpty()) {
					return s;
				} else {

					throw new StatusException();
				}

			}
			throw new StatusException();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "status not available";
	}

	/** asset update can be done by admin by passing assetid and assetname **/
	@Override
	public Asset updatingAssetName(Integer aid, String assetname) {
		try {
			if (database.mapasset.containsKey(aid)) {
				Asset s = database.mapasset.get(aid);
				s.setAssetname(assetname);
				return s;
			} else {
				throw new UpdatingAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * assetdescription update can be done by admin by passing assetid and assetdesc
	 **/
	@Override
	public Asset updatingAssetDescription(Integer aid, String assetdes) {
		try {
			if (database.mapasset.containsKey(aid)) {
				Asset s = database.mapasset.get(aid);
				s.setAssetdes(assetdes);
				return s;
			} else {
				throw new UpdatingAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * assetquantiyt update can be done by admin by passing assetid and assetquan
	 **/
	@Override
	public Asset updatingAssetQuantity(Integer aid, Integer assetquan) {
		try {
			if (database.mapasset.containsKey(aid)) {
				Asset s2 = database.mapasset.get(aid);
				s2.setQuantity(assetquan);
				return s2;
			} else {
				throw new UpdatingAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * assetstatus update can be done by admin by passing assetid and set
	 * assetstatus
	 **/
	@Override
	public Asset updatingAssetStatus(Integer aid, String assetstatus) {
		try {
			if (database.mapasset.containsKey(aid)) {
				Asset s = database.mapasset.get(aid);
				s.setStatus(assetstatus);
				return s;
			} else {
				throw new UpdatingAssetException();
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
