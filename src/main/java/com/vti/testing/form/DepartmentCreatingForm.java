package com.vti.testing.form;

import com.vti.testing.validation.DepartmentNameNotExists;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public class DepartmentCreatingForm {
    @NotBlank(message = "Department name must not blank")
    @Length(max = 50, message = "Department name's length is max 50 characters")
    @DepartmentNameNotExists
    private String name;
    @PositiveOrZero(message = "Total member must be greater than or equal 0")
    private int totalMember;
    @Pattern(regexp = "Dev|Test|ScrumMaster|PM", message = "Type must be Dev, Test, ScrumMaster, PM")
    private String type;
    private List<@Valid Account> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public static class Account{
        @NotBlank(message = "Username must not blank")
        @Length(max = 50, message = "Username's length is max 50 characters")
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
