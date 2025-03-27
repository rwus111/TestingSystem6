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

    public static Specification<Account> buildWhere(AccountFilterForm form) {
        Specification<Account> whereUsername = new SpecificationImpl(SEARCH, form.getSearch());
        return Specification.where(whereUsername);
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
            }
            return null;
        }
    }
}
