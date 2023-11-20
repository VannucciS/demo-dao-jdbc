package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("+++ TEST 1: Seller find by id +++");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n+++ TEST 2 : Seller find by department +++");

		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n+++ TEST 3 : Seller findAll +++");

		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n+++ TEST 4 : Seller insert +++");

		Seller newSeller = new Seller(0, "Greg Blue", "greg@gmail.com", new Date(), 3000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("New seller ID " + newSeller.getId());
		
		System.out.println("\n+++ TEST 5 : Seller update +++");
		
		seller = sellerDao.findById(1);
		seller.setName("Aldus Black");
		sellerDao.update(seller);
		System.out.println("System updated!");
	}

}
