package com.cg.asm.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.asm.beans.Asset;
import com.cg.asm.beans.AssetAllocation;
import com.cg.asm.beans.AssetStatus;
import com.cg.asm.beans.Department;
import com.cg.asm.beans.Employee;
import com.cg.asm.beans.UserMaster;

public class Database {
	public Map<Integer, UserMaster> map;
	public Map<Integer, Employee> mapemp;
	public Map<Integer, Department> mapdept;
	public Map<Integer, Asset> mapasset;
	public Map<Integer, AssetAllocation> mapaa;
	public Map<Integer, String> mapas;

	public Database() {
		map = new HashMap<Integer, UserMaster>();
		UserMaster um = new UserMaster();
		um.setUserid(101);
		um.setUsername("poojitha");
		um.setUserpassword("pooji");
		um.setUsertype("manager");
		map.put(um.getUserid(), um);

		UserMaster um1 = new UserMaster();
		um1.setUserid(102);
		um1.setUsername("nikitha");
		um1.setUserpassword("niki");
		um1.setUsertype("admin");
		map.put(um1.getUserid(), um1);

		mapemp = new HashMap<Integer, Employee>();
		Employee e = new Employee();
		e.setEmpno(10);
		e.setEname("yash");
		e.setDeptid(1);
		e.setHiredate("12-10-2019");
		e.setJob("Software Deveploper");
		e.setMgrno(20);
		mapemp.put(e.getEmpno(), e);

		mapdept = new HashMap<Integer, Department>();
		Department d = new Department();
		d.setDeptid(1);
		d.setDeptname("Software Department");
		mapdept.put(d.getDeptid(), d);

		mapasset = new HashMap<Integer, Asset>();
		Asset a = new Asset();
		a.setAssetid(60);
		a.setAssetname("lappy");
		a.setAssetdes("desk");
		a.setQuantity(12);
		a.setStatus("process");
		mapasset.put(a.getAssetid(), a);

		mapaa = new HashMap<Integer, AssetAllocation>();
		AssetAllocation all = new AssetAllocation();
		all.setAllocationid(1000);
		all.setAssetid(60);
		all.setEmpno(10);
		all.setAllocationdate("13-10-2019");
		all.setReleasedate("21-10-2019");
		all.setQuantity(56);
		mapaa.put(all.getAllocationid(), all);

		mapas = new HashMap<Integer, String>();
		AssetStatus as = new AssetStatus();
		as.setAllocationid(1000);
		as.setStatus("");
		mapas.put(as.getAllocationid(), as.getStatus());
	}
}
