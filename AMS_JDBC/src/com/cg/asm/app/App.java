package com.cg.asm.app;

import java.util.Iterator;
import java.util.List;
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

		
		Services service = new ServicesImpl();
		Scanner sc = new Scanner(System.in);
		Validate validate = new Validate();

		jump2: while (true) {
			System.out.println("**********AMS*********************");
			System.out.println("Enter Your Choice ");
			System.out.println("1. Admin");
			System.out.println("2. manager");
			System.out.println("3. exit program");
			System.out.println("*******************************");
			Integer id = sc.nextInt();

			if (id == 2)

			{
				System.out.println("Enter The User Id");
				Integer userid = sc.nextInt();
				System.out.println("Enter Password");
				String password = sc.next();

				UserMaster um = service.loginService(userid, password);
				if (um.getUsertype().equalsIgnoreCase("manager"))
					System.out.println("manager");

				jump1: while (true) {
					System.out.println("**********MANAGER OPERATIONS*********************");
					System.out.println("Enter Your Choice");
					System.out.println("1.Add employee");
					System.out.println("2.Raise Allocation ");
					System.out.println("3.View Status");
					System.out.println("4. Exit");
					System.out.println("*******************************");
					Integer choice1 = sc.nextInt();
					switch (choice1) {
					case 1:
						Employee employee = new Employee();
						System.out.println("Enter Employee Id");
						String empid = sc.next();

						Boolean b = validate.numberValidation(empid);
						jump: while (!b) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println(" Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								empid = sc.next();
								if (validate.numberValidation(empid)) {
									break jump;
								}
							}
						}
						employee.setEmpno(Integer.parseInt(empid));
						System.out.println("Enter Employee Name");

						String name = sc.next();
						Boolean b1 = validate.numberValidation(name);
						jumpvalidate: while (b1) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								name = sc.next();
								if (!validate.numberValidation(name)) {
									break jumpvalidate;
								}
							}
						}
						employee.setEname(name);
						System.out.println("Enter Deptartmentid Of The Employee");

						String deptid = sc.next();

						Boolean b2 = validate.numberValidation(deptid);
						jump: while (!b2) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								deptid = sc.next();
								if (validate.numberValidation(deptid)) {
									break jump;
								}
							}
						}
						employee.setDeptid(Integer.parseInt(deptid));
						System.out.println("Enter Hiredate Of The Employee");
						String hiredate = sc.next();
						Boolean b3 = validate.dateValidation(hiredate);
						jump: while (!b3) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Please Enter In YYYY/MM/DD Format");
								System.out.println("Please Enter Again");
								hiredate = sc.next();
								if (validate.dateValidation(hiredate)) {
									break jump;
								}
							}
						}
						employee.setHiredate(hiredate);

						System.out.println("Enter Job Of Employee");

						String job = sc.next();
						Boolean b4 = validate.numberValidation(job);
						jumpvalidate: while (b4) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								job = sc.next();
								if (!validate.numberValidation(job)) {
									break jumpvalidate;
								}
							}
						}
						employee.setJob(job);
						System.out.println("Enter MGR Number");

						String mgr = sc.next();

						Boolean b5 = validate.numberValidation(mgr);
						jump: while (!b5) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								mgr = sc.next();
								if (validate.numberValidation(mgr)) {
									break jump;
								}
							}
						}
						employee.setMgrno(Integer.parseInt(mgr));
						System.out.println("Added Employee :" + service.addingEmployeeService(employee));
						break;
					case 2:
						AssetAllocation assetallocation = new AssetAllocation();
						Integer min = 1;
						Integer max = 300;
						Integer rand = (int) ((Math.random() * ((max - min) + 1)) + min);

						assetallocation.setAllocationid(rand);

						System.out.println("Enter Asset Id ");

						String assetid = sc.next();

						Boolean b6 = validate.numberValidation(assetid);
						jump: while (!b6) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetid = sc.next();
								if (validate.numberValidation(assetid)) {
									break jump;
								}
							}
						}
						assetallocation.setAssetid(Integer.parseInt(assetid));

						System.out.println("Enter Employee Number");
						String empno = sc.next();

						Boolean b7 = validate.numberValidation(empno);
						jump: while (!b7) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								empno = sc.next();
								if (validate.numberValidation(empno)) {
									break jump;
								}
							}
						}
						assetallocation.setEmpno(Integer.parseInt(empno));
						System.out.println("Enter Allocation Date");

						String date = sc.next();
						Boolean b8 = validate.dateValidation(date);
						jump: while (!b8) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Please Enter In YYYY/MM/DD Format");
								System.out.println("Enter Again");
								date = sc.next();
								if (validate.dateValidation(date)) {
									break jump;
								}
							}
						}
						assetallocation.setAllocationdate(date);
						System.out.println("Enter Release Date ");

						String releasedate = sc.next();
						Boolean b9 = validate.dateValidation(releasedate);
						jump: while (!b9) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Please Enter In YYYY/MM/DD Format");
								System.out.println("Enter Again");
								releasedate = sc.next();
								if (validate.dateValidation(releasedate)) {
									break jump;
								}
							}
						}
						assetallocation.setReleasedate(releasedate);
						System.out.println("Enter Quantity");
						String quantity = sc.next();

						Boolean b10 = validate.numberValidation(quantity);
						jump: while (!b10) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								quantity = sc.next();
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
						String allocationid = sc.next();

						Boolean b11 = validate.numberValidation(allocationid);
						jump: while (!b11) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								allocationid = sc.next();
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
				Integer userid = sc.nextInt();
				System.out.println("Enter Password");
				String password = sc.next();

				UserMaster um = service.loginService(userid, password);
				if (um.getUsertype().equalsIgnoreCase("admin"))

					System.out.println("admin");
				jump: while (true) {
					System.out.println("************ADMIN OPERATIONS*******************");
					System.out.println("Enter Your Choice");
					System.out.println("1.Add asset");
					System.out.println("2.Remove asset");
					System.out.println("3. Update asset");
					System.out.println("4. View all asset");
					System.out.println("5. View all allocation request");
					System.out.println("6. Set allocation status");
					System.out.println("7. Exit");
					System.out.println("*******************************");
					Integer choice = sc.nextInt();
					switch (choice) {
					case 1:
						Asset a = new Asset();
						System.out.println("Enter Asset Id");
						String assetid = sc.next();

						Boolean b = validate.numberValidation(assetid);
						jumpadmin: while (!b) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetid = sc.next();
								if (validate.numberValidation(assetid)) {
									break jumpadmin;
								}
							}
						}
						a.setAssetid(Integer.parseInt(assetid));
						System.out.println(" Enter Asset Name ");
						String assetname = sc.next();
						Boolean b1 = validate.numberValidation(assetname);
						jumpadmin: while (b1) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetname = sc.next();
								if (!validate.numberValidation(assetname)) {
									break jumpadmin;
								}
							}
						}

						a.setAssetname(assetname);
						System.out.println("Enter Asset Description");
						a.setAssetdes(sc.next());
						System.out.println("Enter Asset Quantity");
						String assetquantity = sc.next();

						Boolean b2 = validate.numberValidation(assetquantity);
						jumpadmin: while (!b2) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetquantity = sc.next();
								if (validate.numberValidation(assetquantity)) {
									break jumpadmin;
								}
							}
						}
						a.setQuantity(Integer.parseInt(assetquantity));
						System.out.println(" Enter Asset Status ");
						String status = sc.next();
						Boolean b3 = validate.numberValidation(status);
						jumpadmin: while (b3) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								status = sc.next();
								if (!validate.numberValidation(status)) {
									break jumpadmin;
								}
							}
						}
						a.setStatus(status);

						System.out.println("Added asset :" + service.addingAssetService(a));
						break;
					case 2:
						System.out.println("Enter The Asset Id That You Want To Remove");
						Asset a1 = new Asset();
						String assetid1 = sc.next();

						Boolean b4 = validate.numberValidation(assetid1);
						jumpadmin: while (!b4) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetid1 = sc.next();
								if (validate.numberValidation(assetid1)) {
									break jumpadmin;
								}
							}
						}
						a1 = service.removingAssetService(Integer.parseInt(assetid1));
						System.out.println("removed asset is :" + a1);
						break;

					case 3:
						System.out.println("Enter The Asset Id That You Want To Update");
						String assetid2 = sc.next();

						Boolean b5 = validate.numberValidation(assetid2);
						jumpadmin: while (!b5) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetid2 = sc.next();
								if (validate.numberValidation(assetid2)) {
									break jumpadmin;
								}
							}
						}
						System.out.println("to update asset");
						System.out.println("enter the choice");
						System.out.println("1.update asset name");
						System.out.println("2.update asset des ");
						System.out.println("3. update asset quantity");
						System.out.println("4.update asset status");
						String assetchoice = sc.next();

						Boolean b10 = validate.numberValidation(assetchoice);
						jumpadmin: while (!b10) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetchoice = sc.next();
								if (validate.numberValidation(assetchoice)) {
									break jumpadmin;
								}
							}
						}
						switch (Integer.parseInt(assetchoice)) {
						case 1:
							System.out.println("enter updated asset name");
							String updatedassetname = sc.next();
							System.out.println("updated asset name :"
									+ service.updatingAssetNameService(Integer.parseInt(assetid2), updatedassetname));
							break;

						case 2:
							System.out.println("Enter Updated Asset DesCRIPTION");
							String updatedassetdes = sc.next();
							System.out.println("updated asset des :"
									+ service.updatingAssetDesService(Integer.parseInt(assetid2), updatedassetdes));
							break;

						case 3:
							System.out.println("Enter Updated Asset Quantity");
							Integer updatedassetquantity = sc.nextInt();
							System.out.println("updated asset quantity :" + service
									.updatingAssetQuantityService(Integer.parseInt(assetid2), updatedassetquantity));
							break;

						case 4:
							System.out.println("Enter Updated Asset Status");
							String updatedassetstatus = sc.next();
							System.out.println("updated asset status :"
									+ service.updatingAssetStatusService(Integer.parseInt(assetid2), updatedassetstatus));
							break;

						}
						break;
					case 4:
						System.out.println("Assets Are");
						List list=service.getAllAssetService();
						Iterator it=list.iterator();
						while(it.hasNext())
						{
							System.out.println(it.next());
						}
						break;
					case 5:
						List list1=service.getAllAssetAllocationService();
						Iterator it1=list1.iterator();
						while(it1.hasNext())
						{
							System.out.println(it1.next());
						}
						break;
					case 6:
						System.out.println("Enter Allocation Id To Set Status");

						String allocationid = sc.next();

						Boolean b6 = validate.numberValidation(allocationid);
						jumpadmin: while (!b6) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								allocationid = sc.next();
								if (validate.numberValidation(allocationid)) {
									break jumpadmin;
								}
							}
						}
						Integer allocation_id = Integer.parseInt(allocationid);
						System.out.println("Enter Status");
						String assetstatus = sc.next();
						Boolean b11 = validate.numberValidation(assetstatus);
						jumpadmin: while (b11) {
							try {
								throw new ValidationException();
							} catch (ValidationException e1) {
								System.out.println("Your Format is Wrong, Enter In String Format");
								System.out.println("Please Enter Again");
								assetstatus = sc.next();
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
				sc.close();
				break jump2;
			}

		}

	}

}
