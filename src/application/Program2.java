package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("**********Test 1: insert implementation *************");
		
		Department newDep = new Department(null, "Oldies");
		departmentDao.insert(newDep);
		System.out.println("New department id: " + newDep.getId());
		
		System.out.println("**********Test 2: update implementation *************");
		newDep = new Department(5, "dvds");
		departmentDao.update(newDep);
		System.out.println("Department updated!");
		
		/*System.out.println("**********Test 3: deletion implementation *************");
		departmentDao.deleteById(8);
		System.out.println("Department Deleted!");*/

		System.out.println("**********Test 4: findById implementation *************");
		Department dep = departmentDao.findById(4);
		System.out.println(dep.getId() + " - " + dep.getName());
		
		System.out.println("**********Test 4: findByAll implementation *************");
		List<Department> list = departmentDao.findAll();
		for(Department d: list) {
			System.out.println(d.getId() + " - " + d.getName());
		}
	}

}
