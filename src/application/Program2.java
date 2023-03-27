package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST : department findById");
		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("=== TEST 1: department Insert");
		Department newDepartment = new Department(null, "Mônica");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("=== TEST 2: department Update");
		department = departmentDao.findById(1);
		department.setName("Xadrez");
		departmentDao.update(department);
		System.out.println("Update Completed");

		System.out.println("=== TEST 3: department Delete");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		System.out.println("=== TEST 4: department findAll");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
	}

}
