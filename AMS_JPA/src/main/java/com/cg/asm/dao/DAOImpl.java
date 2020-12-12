package com.cg.asm.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.asm.beans.Asset;
import com.cg.asm.beans.AssetAllocation;
import com.cg.asm.beans.AssetStatus;
import com.cg.asm.beans.Employee;
import com.cg.asm.beans.UserMaster;
import com.cg.asm.exceptions.AddEmployeeException;
import com.cg.asm.exceptions.AddingAssetException;
import com.cg.asm.exceptions.AssetAllocationException;
import com.cg.asm.exceptions.GettingAssetException;
import com.cg.asm.exceptions.RaiseAllocationException;
import com.cg.asm.exceptions.RemovingAssetException;
import com.cg.asm.exceptions.StatusException;
import com.cg.asm.exceptions.UpdatingAssetException;

public class DAOImpl implements DAO {

	EntityManagerFactory entityManagerFactory = null;

	public UserMaster login(Integer userid, String password) {
		UserMaster um = new UserMaster();
//em to access data from  db
		EntityManager entityManager = null;
		//persistence is class
		entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select usertype from UserMaster where userid=:uid and userpassword=:upwd";
		//used to create entity class name as table name and members as columns name
		Query query = entityManager.createQuery(jpql);
		//it will store the uid and upwd values
		query.setParameter("uid", userid);
		query.setParameter("upwd", password);
		//if we have multiple values it results the single result from that  values
		String user = (String) query.getSingleResult();
		um.setUsertype(user);
		//clase all the objects
		entityManager.close();
		return um;
	}

	public Asset addingAsset(Asset asset) {
		
		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();

			Asset asset1 = entityManager.find(Asset.class, asset.getAssetid());
			if (asset1 == null) {
				//to transfer the data from model to database and from database to model
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(asset);
				entityTransaction.commit();
				return asset;
			}

			else {
				
				throw new AddingAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return null;
	}

	public Asset removingAsset(Integer aid) {
		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "Delete from Asset where assetid=:assid";
			Asset asset = entityManager.find(Asset.class, aid);
			Query query = entityManager.createQuery(jpql);
			query.setParameter("assid", aid);
			Integer i = query.executeUpdate();
			if (i > 0) {
				entityTransaction.commit();
				return asset;
			} else {

				throw new RemovingAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Asset> getAllAsset() {
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from Asset";
			TypedQuery<Asset> query = entityManager.createQuery(jpql, Asset.class);
			List<Asset> list = query.getResultList();
			if (!list.isEmpty()) {

				return list;
			} else {

				throw new GettingAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return null;

	}

	public Employee addEmployee(Employee employee) {
		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			Employee employee1 = entityManager.find(Employee.class, employee.getEmpno());
			if (employee1 == null) {
				String query1 = "select deptid from Department ";

				Query query = entityManager.createQuery(query1);
				List<Integer> list = (List<Integer>) query.getResultList();
				for (Integer emp : list) {

					if (employee.getDeptid() == emp) {
						entityTransaction = entityManager.getTransaction();
						entityTransaction.begin();

						entityManager.persist(employee);
						entityTransaction.commit();
						return employee;

					}
				}

				throw new AddEmployeeException();

			} else {

				throw new AddEmployeeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public AssetAllocation raiseAllocation(AssetAllocation assetallocation) {
		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			AssetStatus as = new AssetStatus();
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			AssetAllocation assetallocation1 = entityManager.find(AssetAllocation.class,
					assetallocation.getAllocationid());
			if (assetallocation1 == null) {
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(assetallocation);
				as.setAllocationid(assetallocation.getAllocationid());
				as.setStatus("null");
				entityManager.persist(as);

				entityTransaction.commit();
				return assetallocation;

			}

			else {

				throw new RaiseAllocationException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return null;
	}

	public List<AssetAllocation> getAllAssetAllocation() {
		EntityManager entityManager = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from AssetAllocation";
			Query query = entityManager.createQuery(jpql);
			List<AssetAllocation> list = query.getResultList();
			if (!list.isEmpty()) {
				return list;

			} else {

				throw new AssetAllocationException();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return null;
	}

	public Boolean setStatus(Integer allocationid, String status) {

		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "UPDATE AssetStatus SET status=:asname WHERE allocationid=:allocid";

			Query query = entityManager.createQuery(jpql);
			query.setParameter("asname", status);
			query.setParameter("allocid", allocationid);
			Integer i = query.executeUpdate();
			if (i > 0) {
				entityTransaction.commit();
				return true;
			} else {

				throw new StatusException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String viewStatus(Integer allocationid) {
		EntityManager entityManager = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from AssetStatus where allocationid=:allocid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("allocid", allocationid);
			List<AssetStatus> list = query.getResultList();
			for (AssetStatus astatus : list) {
				System.out.println(astatus.getAllocationid());
				if (astatus.getStatus().equals("null")) {
					return "Status not updated till now";
				} else {
					return astatus.getStatus();
				}
			}

			throw new StatusException();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "enter valid allocation id";
	}

	public Asset updatingAssetName(Integer aid, String assetname) {
		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			Asset asset = entityManager.find(Asset.class, aid);
			entityTransaction.begin();
			String jpql = "UPDATE Asset SET assetname=:asname WHERE assetid=:aid";

			Query query = entityManager.createQuery(jpql);
			query.setParameter("asname", assetname);
			query.setParameter("aid", aid);
			Integer i = query.executeUpdate();
			if (i > 0) {
				asset.setAssetname(assetname);
				entityTransaction.commit();
				return asset;
			} else {
				throw new UpdatingAssetException();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	public Asset updatingAssetDesription(Integer aid, String assetdes) {
		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			Asset asset1 = entityManager.find(Asset.class, aid);
			entityTransaction.begin();
			String jpql = "UPDATE Asset SET assetdes=:asdes WHERE assetid=:aid";

			Query query = entityManager.createQuery(jpql);
			query.setParameter("asdes", assetdes);
			query.setParameter("aid", aid);
			Integer i = query.executeUpdate();
			if (i > 0) {
				asset1.setAssetdes(assetdes);
				entityTransaction.commit();
				return asset1;
			} else {
				throw new UpdatingAssetException();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public Asset updatingAssetQuantity(Integer aid, Integer assetquan) {
		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			Asset asset2 = entityManager.find(Asset.class, aid);
			entityTransaction.begin();
			String jpql2 = "UPDATE Asset SET quantity=:aquan WHERE assetid=:aid";

			Query query2 = entityManager.createQuery(jpql2);
			query2.setParameter("aquan", assetquan);
			query2.setParameter("aid", aid);
			Integer i2 = query2.executeUpdate();
			if (i2 > 0) {
				asset2.setQuantity(assetquan);
				entityTransaction.commit();
				return asset2;
			} else {
				throw new UpdatingAssetException();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public Asset updatingAssetStatus(Integer aid, String assetstatus) {
		EntityManager entityManager = null;

		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management_JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			Asset asset3 = entityManager.find(Asset.class, aid);
			entityTransaction.begin();
			String jpql3 = "UPDATE Asset SET status=:assetstatus WHERE assetid=:aid";

			Query query3 = entityManager.createQuery(jpql3);
			query3.setParameter("assetstatus", assetstatus);
			query3.setParameter("aid", aid);
			Integer i3 = query3.executeUpdate();
			if (i3 > 0) {
				asset3.setStatus(assetstatus);
				entityTransaction.commit();
				return asset3;
			} else {
				throw new UpdatingAssetException();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
