package model.dao.impl;

import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao{


    @Override
    public void insert(Department dp) {

    }

    @Override
    public void update(Department dp) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
