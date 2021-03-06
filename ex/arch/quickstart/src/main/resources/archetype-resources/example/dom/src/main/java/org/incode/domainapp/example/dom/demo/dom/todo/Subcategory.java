#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.incode.domainapp.example.dom.demo.dom.todo;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Predicate;

public enum Subcategory {
    // professional
    OpenSource, Consulting, Education, Marketing,
    // domestic
    Shopping, Housework, Garden, Chores,
    // other
    Other;

    public static List<Subcategory> listFor(final Category category) {
        return category != null ? category.subcategories() : Collections.<Subcategory>emptyList();
    }

    public static String validate(final Category category, final Subcategory subcategory) {
        if (category == null) {
            return "Enter category first";
        }
        return !category.subcategories().contains(subcategory)
                ? "Invalid subcategory for category '" + category + "'"
                : null;
    }

    public static Predicate<Subcategory> thoseFor(final Category category) {
        return new Predicate<Subcategory>() {

            @Override
            public boolean apply(final Subcategory subcategory) {
                return category.subcategories().contains(subcategory);
            }
        };
    }
}
