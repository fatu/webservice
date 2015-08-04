package com.library.app.commontests.category;

import com.library.app.category.model.Category;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.List;

/**
 * @author boaztu
 */
@Ignore
public class CategoryForTestsRepository {

    public static Category java() {
        return new Category("java");
    }

    public static Category cleanCode() {
        return new Category("Clean Code");
    }

    public static Category architecture() {
        return new Category("Architecture");
    }

    public static Category network() {
        return new Category("network");
    }

    public static Category categoryWithId(Category category, Long id) {
        category.setId(id);
        return category;
    }

    public static List<Category> allCategories() {
        return Arrays.asList(java(), cleanCode(), architecture(), network());
    }

}
