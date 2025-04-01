package com.vti.testing.specification;

import com.vti.testing.entity.Department;
import com.vti.testing.form.DepartmentFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Date;

public class DepartmentSpecification {
    private static final String MIN_DATE = "MIN_DATE";
    private static final String MIN_YEAR = "MIN_YEAR";

    public static Specification<Department> buildWhere(DepartmentFilterForm form) {
        Specification<Department> whereMinDate = new SpecificationImpl(MIN_DATE, form.getMinDate());
        Specification<Department> whereMinYear = new SpecificationImpl(MIN_YEAR, form.getMinYear());
        return Specification.where(whereMinDate).and(whereMinYear);
    }

    private static class SpecificationImpl implements Specification<Department> {
        private String key;
        private Object value;

        public SpecificationImpl(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null) {
                return null;
            }
            switch (key) {
                case MIN_DATE:
                    // createdDate >= value
                    return criteriaBuilder.greaterThanOrEqualTo(
                            root.get("createdDate").as(Date.class),
                            (java.util.Date) value
                    );
                case MIN_YEAR:
                    // year(createdDate) >= value
                    return criteriaBuilder.greaterThanOrEqualTo(
                            criteriaBuilder.function("year", Integer.class, root.get("createdDate")),
                            (Integer) value
                    );
            }
            return null;
        }
    }
}
