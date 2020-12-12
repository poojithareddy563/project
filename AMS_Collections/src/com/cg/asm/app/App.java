package com.cg.asm.app;

import java.util.Scanner;

import com.cg.asm.beans.Asset;
import com.cg.asm.beans.AssetAllocation;
import com.cg.asm.beans.Employee;
import com.cg.asm.beans.UserMaster;
import com.cg.asm.exceptions.ValidationException;
import com.cg.asm.services.Services;
import com.cg.asm.services.ServicesImpl;
import com.cg.asm.validations.Validate;

public class App {

	public static void main(String[] args) {
		/** service ogj creation **/
		Services service = new ServicesImpl();
		Scanner scr = new Scanner(System.in);
		Validate validate = new Validate();

		jump2: while (true) {
			System.out.println("***********AMS********************");
			System.out.println("Enter Your Choice ");
			System.out.println("1. Admin");
			System.out.println("2. manager");
			System.out.println("3. Exit Program");
			System.out.println("*******************************");
			Integer id = scr.nextInt();
			/** if id==2 the it goes to manager **/
			if (id == 2)

			{
				System.out.println("Enter The User Id");
				Integer userid = scr.nextInt();
				System.out.println("Enter Password");
				String password = scr.next();
				/** using service obj invoking loginservice() **/
				UserMaster usermaster = service.loginService(userid, password);
				if (usermaster.getUsertype().equalsIgnoreCase("manager"))
					System.out.println("manager");

				jump1: while (true) {
					System.out.println("***********MANAGER OPERATIONS********************");
					System.out.println("Enter Your Choice");
					System.out.println("1.Add Employee");
					System.out.println("2.Raise Allocation ");
					System.out.println("3.View Status");
					System.out.println("4. Exit");
					System.out.println("*******************************");
					Integer choice1 = scr.nextInt();
					switch (choice1) {
					case 1:
						Employee emp = new Employee();
						System.out.println("Enter Employee Id");
						String empid = scr.next();

						Boolean b = validate.numberValidation(empid);
						jump: while (!b) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								empid = scr.next();
								if (validate.numberValidation(empid)) {
									break jump;
								}
							}
						}
						emp.setEmpno(Integer.parseInt(empid));
						System.out.println("Enter Employee Name");

						String name = scr.next();
						Boolean b1 = validate.numberValidation(name);
						jumpvalidate: while (b1) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								name = scr.next();
								if (!validate.numberValidation(name)) {
									break jumpvalidate;
								}
							}
						}
						emp.setEname(name);
						System.out.println("Enter Deptid Of The Employee");

						String deptid = scr.next();

						Boolean b2 = validate.numberValidation(deptid);
						jump: while (!b2) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter again");
								deptid = scr.next();
								if (validate.numberValidation(deptid)) {
									break jump;
								}
							}
						}
						emp.setDeptid(Integer.parseInt(deptid));
						System.out.println("Enter Hiredate Of The Employee");
						String hiredate = scr.next();
						Boolean b3 = validate.dateValidation(hiredate);
						jump: while (!b3) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Please Enter In YYYY/MM/DD Format");
								System.out.println("Enter Again");
								hiredate = scr.next();
								if (validate.dateValidation(hiredate)) {
									break jump;
								}
							}
						}
						emp.setHiredate(hiredate);

						System.out.println("Enter Job Of Employee");

						String job = scr.next();
						Boolean b4 = validate.numberValidation(job);
						jumpvalidate: while (b4) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								job = scr.next();
								if (!validate.numberValidation(job)) {
									break jumpvalidate;
								}
							}
						}
						emp.setJob(job);
						System.out.println("Enter MGR Number");

						String mgr = scr.next();

						Boolean b5 = validate.numberValidation(mgr);
						jump: while (!b5) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								mgr = scr.next();
								if (validate.numberValidation(mgr)) {
									break jump;
								}
							}
						}
						emp.setMgrno(Integer.parseInt(mgr));
						System.out.println("Added Employee :" + service.addingEmployeeService(emp));
						break;
					case 2:
						AssetAllocation assetallocation = new AssetAllocation();
						Integer min = 1;
						Integer max = 400;
						Integer rand = (int) ((Math.random() * ((max - min) + 1)) + min);

						assetallocation.setAllocationid(rand);

						System.out.println("Enter Asset Id ");

						String assetid = scr.next();

						Boolean b6 = validate.numberValidation(assetid);
						jump: while (!b6) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetid = scr.next();
								if (validate.numberValidation(assetid)) {
									break jump;
								}
							}
						}
						assetallocation.setAssetid(Integer.parseInt(assetid));

						System.out.println("Enter Employee Number");
						String empno = scr.next();

						Boolean b7 = validate.numberValidation(empno);
						jump: while (!b7) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Formatr");
								System.out.println("Please Enter Again");
								empno = scr.next();
								if (validate.numberValidation(empno)) {
									break jump;
								}
							}
						}
						assetallocation.setEmpno(Integer.parseInt(empno));
						System.out.println("Enter Allocation Date");

						String date = scr.next();
						Boolean b8 = validate.dateValidation(date);
						jump: while (!b8) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Please Enter In YYYY/MM/DD Format");
								System.out.println("Enter Again");
								date = scr.next();
								if (validate.dateValidation(date)) {
									break jump;
								}
							}
						}
						assetallocation.setAllocationdate(date);
						System.out.println("Enter Release Date ");

						String releasedate = scr.next();
						Boolean b9 = validate.dateValidation(releasedate);
						jump: while (!b9) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Please Enter In YYYY/MM/DD Format");
								System.out.println("Enter Again");
								releasedate = scr.next();
								if (validate.dateValidation(releasedate)) {
									break jump;
								}
							}
						}
						assetallocation.setReleasedate(releasedate);
						System.out.println("Enter Quantity");
						String quantity = scr.next();

						Boolean b10 = validate.numberValidation(quantity);
						jump: while (!b10) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								quantity = scr.next();
								if (validate.numberValidation(quantity)) {
									break jump;
								}
							}
						}
						assetallocation.setQuantity(Integer.parseInt(quantity));
						System.out.println(
								"Raised allocation request :" + service.raiseAllocationService(assetallocation));
						System.out.println("Randomly generated allocation id :" + assetallocation.getAllocationid());

						break;
					case 3:
						System.out.println("Enter The Allocation Id");
						String allocationid = scr.next();

						Boolean b11 = validate.numberValidation(allocationid);
						jump: while (!b11) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								allocationid = scr.next();
								if (validate.numberValidation(allocationid)) {
									break jump;
								}
							}
						}
						System.out.println(service.viewStatusService(Integer.parseInt(allocationid)));
						break;
					case 4:
						System.out.println("Manager Logged Out Successfully");
						break jump1;
					default:
						System.out.println("Enter Valid Number");
						break;

					}

				}
			}

			else if (id == 1) {
				System.out.println("Enter The User Id");
				Integer userid = scr.nextInt();
				System.out.println("Enter Password");
				String password = scr.next();

				UserMaster usermaster = service.loginService(userid, password);
				if (usermaster.getUsertype().equalsIgnoreCase("admin"))

					System.out.println("admin");
				jump: while (true) {
					System.out.println("***********ADMIN OPERATIONS********************");
					System.out.println("Enter Your Choice");
					System.out.println("1.Add asset");
					System.out.println("2.Remove asset");
					System.out.println("3. Update asset");
					System.out.println("4. View all asset");
					System.out.println("5. View all allocation request");
					System.out.println("6. Set allocation status");
					System.out.println("7. Exit");
					System.out.println("*******************************");
					Integer choice = scr.nextInt();
					switch (choice) {
					case 1:
						Asset asset = new Asset();
						System.out.println("Enter Asset Id");
						String assetid = scr.next();

						Boolean b = validate.numberValidation(assetid);
						jumpadmin: while (!b) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetid = scr.next();
								if (validate.numberValidation(assetid)) {
									break jumpadmin;
								}
							}
						}
						asset.setAssetid(Integer.parseInt(assetid));
						System.out.println(" Enter Asset Name ");
						String assetname = scr.next();
						Boolean b1 = validate.numberValidation(assetname);
						jumpadmin: while (b1) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetname = scr.next();
								if (!validate.numberValidation(assetname)) {
									break jumpadmin;
								}
							}
						}

						asset.setAssetname(assetname);
						System.out.println("Enter Asset Description");
						asset.setAssetdes(scr.next());
						System.out.println("Enter Asset Quantity");
						String assetquantity = scr.next();

						Boolean b2 = validate.numberValidation(assetquantity);
						jumpadmin: while (!b2) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetquantity = scr.next();
								if (validate.numberValidation(assetquantity)) {
									break jumpadmin;
								}
							}
						}
						asset.setQuantity(Integer.parseInt(assetquantity));
						System.out.println(" Enter Asset Status ");
						String status = scr.next();
						Boolean b3 = validate.numberValidation(status);
						jumpadmin: while (b3) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								status = scr.next();
								if (!validate.numberValidation(status)) {
									break jumpadmin;
								}
							}
						}
						asset.setStatus(status);

						System.out.println("Added asset :" + service.addingAssetService(asset));
						break;
					case 2:
						System.out.println("Enter The Asset Id You Want To Remove");
						Asset asset1 = new Asset();
						String assetid1 = scr.next();

						Boolean b4 = validate.numberValidation(assetid1);
						jumpadmin: while (!b4) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetid1 = scr.next();
								if (validate.numberValidation(assetid1)) {
									break jumpadmin;
								}
							}
						}
						asset1 = service.removingAssetService(Integer.parseInt(assetid1));
						System.out.println("removed asset is :" + asset1);
						break;

					case 3:
						System.out.println("Enter The Asset Id You Want To Update");
						String assetid2 = scr.next();

						Boolean b5 = validate.numberValidation(assetid2);
						jumpadmin: while (!b5) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetid2 = scr.next();
								if (validate.numberValidation(assetid2)) {
									break jumpadmin;
								}
							}
						}
						System.out.println("To Update Asset");
						System.out.println("Enter The Choice");
						System.out.println("1.update asset name");
						System.out.println("2.update asset des ");
						System.out.println("3. update asset quantity");
						System.out.println("4.update asset status");
						String assetchoice = scr.next();

						Boolean b10 = validate.numberValidation(assetchoice);
						jumpadmin: while (!b10) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetchoice = scr.next();
								if (validate.numberValidation(assetchoice)) {
									break jumpadmin;
								}
							}
						}
						switch (Integer.parseInt(assetchoice)) {
						case 1:
							System.out.println("Enter Updated Asset Name");
							String updatedassetname = scr.next();
							System.out.println("updated asset name :"
									+ service.updatingAssetNameService(Integer.parseInt(assetid2), updatedassetname));
							break;

						case 2:
							System.out.println("Enter Updated Asset Description");
							String updatedassetdes = scr.next();
							System.out.println("updated asset des :"
									+ service.updatingAssetDesService(Integer.parseInt(assetid2), updatedassetdes));
							break;

						case 3:
							System.out.println("Enter Updated Asset Quantity");
							Integer updatedassetquantity = scr.nextInt();
							System.out.println("updated asset quantity :" + service
									.updatingAssetQuantityService(Integer.parseInt(assetid2), updatedassetquantity));
							break;

						case 4:
							System.out.println("Enter Updated Asset Status");
							String updatedassetstatus = scr.next();
							System.out.println("updated asset status :" + service
									.updatingAssetStatusService(Integer.parseInt(assetid2), updatedassetstatus));
							break;

						}
						break;
					case 4:
						System.out.println("Assets Are");
						service.getAllAssetService();
						break;
					case 5:
						service.getAllAssetAllocationService();
						break;
					case 6:
						System.out.println("Enter Allocation Id To Set Status");

						String allocationid = scr.next();

						Boolean b6 = validate.numberValidation(allocationid);
						jumpadmin: while (!b6) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								allocationid = scr.next();
								if (validate.numberValidation(allocationid)) {
									break jumpadmin;
								}
							}
						}
						Integer allocation_id = Integer.parseInt(allocationid);
						System.out.println("Enter Status");
						String assetstatus = scr.next();
						Boolean b11 = validate.numberValidation(assetstatus);
						jumpadmin: while (b11) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetstatus = scr.next();
								if (!validate.numberValidation(assetstatus)) {
									break jumpadmin;
								}
							}
						}

						if (service.setStatusService(allocation_id, assetstatus)) {
							System.out.println("Status Changed");
						} else {
							System.out.println("Status Not Changed");
						}
						break;

					case 7:
						System.out.println("Admin Logged Out Successfully");
						break jump;
					default:
						System.out.println("Enter Valid Number");
						break;
					}
				}
			} else if (id == 3) {
				System.out.println("Thank You...Visit Again");
				scr.close();
				break jump2;
			}

		}

	}

}
