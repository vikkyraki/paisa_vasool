package com.fun.paisa.model;

import com.fun.paisa.common.BalanceCalculatorUtil;
import com.fun.paisa.common.PriceSplitType;
import com.fun.paisa.common.SplitValidatorUtil;
import com.fun.paisa.model.split.PriceSplit;

import javax.xml.ws.WebServiceException;
import java.util.Date;
import java.util.List;

public class Expense {

    private static Integer UID = 0;

    private Integer Id;
    private String name;
    private Date date;
    private User addedBy;
    private User paidBy;
    private Double totalAmount;

    private List<PriceSplit> splits;
    private String category;
    private PriceSplitType priceSplitType;

    static class ExpenseBuilder{
        private Integer Id;
        private String name;
        private Date date;
        private User addedBy;
        private User paidBy;
        private List<PriceSplit> splits;
        private String category;
        private PriceSplitType priceSplitType;
        private Double totalAmount;


        public ExpenseBuilder setId() {
            this.Id = UID++;
            return this;
        }

        public ExpenseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ExpenseBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public ExpenseBuilder setAddedBy(User addedBy) {
            this.addedBy = addedBy;
            return this;
        }

        public ExpenseBuilder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }

        public ExpenseBuilder setSplits(List<PriceSplit> splits) {
            this.splits = splits;
            return this;
        }

        public Expense build() {
            Expense expense = new Expense(this);
            return expense;
        }

        public Integer getId() {
            return Id;
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return date;
        }

        public User getAddedBy() {
            return addedBy;
        }

        public User getPaidBy() {
            return paidBy;
        }

        public List<PriceSplit> getSplits() {
            return splits;
        }

        public String getCategory() {
            return category;
        }

        public ExpenseBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public PriceSplitType getPriceSplitType() {
            return priceSplitType;
        }

        public ExpenseBuilder setPriceSplitType(PriceSplitType priceSplitType) {
            this.priceSplitType = priceSplitType;
            return this;
        }

        public Double getTotalAmount() {
            return totalAmount;
        }

        public ExpenseBuilder setTotalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }
    }

    boolean validate() {
        // sum of amounts should be eqaul to Total sum;

        if (!SplitValidatorUtil.baseValidate(this))
            return false;

        switch (priceSplitType) {
            case EQUAL:
                return SplitValidatorUtil.equalSplitValidate(this);
            case PERCENTAGE:
                return SplitValidatorUtil.percentageSplitValidate(this);
            case AMOUNT:
                return SplitValidatorUtil.amountSplitValidate(this);
            default:
                throw new WebServiceException("No price Type");

        }
    }

    public Expense(ExpenseBuilder expenseBuilder) {
        setId(expenseBuilder.getId());
        setName(expenseBuilder.getName());
        setDate(expenseBuilder.getDate());
        setAddedBy(expenseBuilder.getAddedBy());
        setPaidBy(expenseBuilder.getPaidBy());
        setCategory(expenseBuilder.getCategory());
        setSplits(expenseBuilder.getSplits());
        setPriceSplitType(expenseBuilder.getPriceSplitType());
        setTotalAmount(expenseBuilder.getTotalAmount());
        setSplits(expenseBuilder.getSplits());

        if (validate()) {
            throw new WebServiceException(" validator eror");
        }

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<PriceSplit> getSplits() {
        return splits;
    }

    public void setSplits(List<PriceSplit> splits) {
        this.splits = splits;
    }

    public void removeSplits(PriceSplit split) {
        splits.remove(split);

        switch (priceSplitType) {
            case EQUAL:
                 BalanceCalculatorUtil.equalBalanceCalculator(this);
            case PERCENTAGE:
                    BalanceCalculatorUtil.percentageBalanceCalculator(this);
            case AMOUNT:
                    BalanceCalculatorUtil.amountBalanceCalculator(this);
            default:
                throw new WebServiceException("No price Type");

        }
    }

    public PriceSplitType getPriceSplitType() {
        return priceSplitType;
    }

    public void setPriceSplitType(PriceSplitType priceSplitType) {
        this.priceSplitType = priceSplitType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
