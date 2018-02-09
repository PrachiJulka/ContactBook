package com.ttn.contactbook.dao;

import com.ttn.contactbook.domain.Categories;
import com.ttn.contactbook.domain.User;

public interface CategoriesOperations {
    String addCategory(Categories categories,User user);
    void editCategory(Categories categories,User user);
    void deleteCategory(Categories categories,User user);


}
