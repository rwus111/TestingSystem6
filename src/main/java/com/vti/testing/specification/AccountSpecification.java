package com.vti.testing.specification;

import com.vti.testing.entity.Account;
import com.vti.testing.form.AccountFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {
    private static final String SEARCH = "SEARCH";
    private static final String MIN_ID = "MIN_ID";
    private static final String MAX_ID = "MAX_ID";

    public static Specification<Account> buildWhere(AccountFilterForm form) {
        Specification<Account> whereUsername = new SpecificationImpl(SEARCH, form.getSearch());
        Specification<Account> whereMinId = new SpecificationImpl(MIN_ID, form.getMinId());
        Specification<Account> whereMaxId = new SpecificationImpl(MAX_ID, form.getMaxId());
        return Specification.where(whereUsername).and(whereMinId).and(whereMaxId);
    }

    private static class SpecificationImpl implements Specification<Account> {
        private String key;
        private Object value;

        public SpecificationImpl(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null) {
                return null;
            }
            switch (key) {
                case SEARCH:
                    // username LIKE "%value%"
                    return criteriaBuilder.like(root.get("username"), "%" + value + "%");
                case MIN_ID:
                    // id >= value
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
                case MAX_ID:
                    // id <= value
                    return criteriaBuilder.lessThanOrEqualTo(root.get("id"), value.toString());
            }
            return null;
        }
    }
}
