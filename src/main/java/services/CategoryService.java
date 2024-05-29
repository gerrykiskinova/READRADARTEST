package services;

import models.Category;
import repo.DBMainRepo;

import java.util.List;

public class CategoryService {
    public List<Category> load() {
        return DBMainRepo.getCategories();
    }
}
