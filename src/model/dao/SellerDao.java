package model.dao;

import model.entities.Department;

public interface SellerDao {

	void insert(Department obj);

	void update(Department obj);

	void deleteById(int id);

	Department findById(int id);

	Department findAll(int id);
}
