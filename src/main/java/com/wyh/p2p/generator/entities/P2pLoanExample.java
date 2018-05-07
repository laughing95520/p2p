package com.wyh.p2p.generator.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2pLoanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2pLoanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(Float value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(Float value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(Float value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(Float value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(Float value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(Float value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<Float> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<Float> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(Float value1, Float value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(Float value1, Float value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andLoanMonthIsNull() {
            addCriterion("loan_month is null");
            return (Criteria) this;
        }

        public Criteria andLoanMonthIsNotNull() {
            addCriterion("loan_month is not null");
            return (Criteria) this;
        }

        public Criteria andLoanMonthEqualTo(Integer value) {
            addCriterion("loan_month =", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthNotEqualTo(Integer value) {
            addCriterion("loan_month <>", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthGreaterThan(Integer value) {
            addCriterion("loan_month >", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_month >=", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthLessThan(Integer value) {
            addCriterion("loan_month <", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthLessThanOrEqualTo(Integer value) {
            addCriterion("loan_month <=", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthIn(List<Integer> values) {
            addCriterion("loan_month in", values, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthNotIn(List<Integer> values) {
            addCriterion("loan_month not in", values, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthBetween(Integer value1, Integer value2) {
            addCriterion("loan_month between", value1, value2, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_month not between", value1, value2, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdIsNull() {
            addCriterion("guarantee_id is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdIsNotNull() {
            addCriterion("guarantee_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdEqualTo(Integer value) {
            addCriterion("guarantee_id =", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdNotEqualTo(Integer value) {
            addCriterion("guarantee_id <>", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdGreaterThan(Integer value) {
            addCriterion("guarantee_id >", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guarantee_id >=", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdLessThan(Integer value) {
            addCriterion("guarantee_id <", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdLessThanOrEqualTo(Integer value) {
            addCriterion("guarantee_id <=", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdIn(List<Integer> values) {
            addCriterion("guarantee_id in", values, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdNotIn(List<Integer> values) {
            addCriterion("guarantee_id not in", values, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdBetween(Integer value1, Integer value2) {
            addCriterion("guarantee_id between", value1, value2, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guarantee_id not between", value1, value2, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRepayWayIsNull() {
            addCriterion("repay_way is null");
            return (Criteria) this;
        }

        public Criteria andRepayWayIsNotNull() {
            addCriterion("repay_way is not null");
            return (Criteria) this;
        }

        public Criteria andRepayWayEqualTo(Byte value) {
            addCriterion("repay_way =", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotEqualTo(Byte value) {
            addCriterion("repay_way <>", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayGreaterThan(Byte value) {
            addCriterion("repay_way >", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayGreaterThanOrEqualTo(Byte value) {
            addCriterion("repay_way >=", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayLessThan(Byte value) {
            addCriterion("repay_way <", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayLessThanOrEqualTo(Byte value) {
            addCriterion("repay_way <=", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayIn(List<Byte> values) {
            addCriterion("repay_way in", values, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotIn(List<Byte> values) {
            addCriterion("repay_way not in", values, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayBetween(Byte value1, Byte value2) {
            addCriterion("repay_way between", value1, value2, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotBetween(Byte value1, Byte value2) {
            addCriterion("repay_way not between", value1, value2, "repayWay");
            return (Criteria) this;
        }

        public Criteria andWordsIsNull() {
            addCriterion("words is null");
            return (Criteria) this;
        }

        public Criteria andWordsIsNotNull() {
            addCriterion("words is not null");
            return (Criteria) this;
        }

        public Criteria andWordsEqualTo(String value) {
            addCriterion("words =", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotEqualTo(String value) {
            addCriterion("words <>", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsGreaterThan(String value) {
            addCriterion("words >", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsGreaterThanOrEqualTo(String value) {
            addCriterion("words >=", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLessThan(String value) {
            addCriterion("words <", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLessThanOrEqualTo(String value) {
            addCriterion("words <=", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLike(String value) {
            addCriterion("words like", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotLike(String value) {
            addCriterion("words not like", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsIn(List<String> values) {
            addCriterion("words in", values, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotIn(List<String> values) {
            addCriterion("words not in", values, "words");
            return (Criteria) this;
        }

        public Criteria andWordsBetween(String value1, String value2) {
            addCriterion("words between", value1, value2, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotBetween(String value1, String value2) {
            addCriterion("words not between", value1, value2, "words");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(Double value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(Double value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(Double value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(Double value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(Double value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(Double value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<Double> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<Double> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(Double value1, Double value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(Double value1, Double value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andLoanTimeIsNull() {
            addCriterion("loan_time is null");
            return (Criteria) this;
        }

        public Criteria andLoanTimeIsNotNull() {
            addCriterion("loan_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTimeEqualTo(Date value) {
            addCriterion("loan_time =", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeNotEqualTo(Date value) {
            addCriterion("loan_time <>", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeGreaterThan(Date value) {
            addCriterion("loan_time >", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loan_time >=", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeLessThan(Date value) {
            addCriterion("loan_time <", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeLessThanOrEqualTo(Date value) {
            addCriterion("loan_time <=", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeIn(List<Date> values) {
            addCriterion("loan_time in", values, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeNotIn(List<Date> values) {
            addCriterion("loan_time not in", values, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeBetween(Date value1, Date value2) {
            addCriterion("loan_time between", value1, value2, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeNotBetween(Date value1, Date value2) {
            addCriterion("loan_time not between", value1, value2, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeIsNull() {
            addCriterion("lending_time is null");
            return (Criteria) this;
        }

        public Criteria andLendingTimeIsNotNull() {
            addCriterion("lending_time is not null");
            return (Criteria) this;
        }

        public Criteria andLendingTimeEqualTo(Date value) {
            addCriterion("lending_time =", value, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeNotEqualTo(Date value) {
            addCriterion("lending_time <>", value, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeGreaterThan(Date value) {
            addCriterion("lending_time >", value, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lending_time >=", value, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeLessThan(Date value) {
            addCriterion("lending_time <", value, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeLessThanOrEqualTo(Date value) {
            addCriterion("lending_time <=", value, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeIn(List<Date> values) {
            addCriterion("lending_time in", values, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeNotIn(List<Date> values) {
            addCriterion("lending_time not in", values, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeBetween(Date value1, Date value2) {
            addCriterion("lending_time between", value1, value2, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andLendingTimeNotBetween(Date value1, Date value2) {
            addCriterion("lending_time not between", value1, value2, "lendingTime");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNull() {
            addCriterion("process_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNotNull() {
            addCriterion("process_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdEqualTo(String value) {
            addCriterion("process_instance_id =", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotEqualTo(String value) {
            addCriterion("process_instance_id <>", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThan(String value) {
            addCriterion("process_instance_id >", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_instance_id >=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThan(String value) {
            addCriterion("process_instance_id <", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("process_instance_id <=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLike(String value) {
            addCriterion("process_instance_id like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotLike(String value) {
            addCriterion("process_instance_id not like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIn(List<String> values) {
            addCriterion("process_instance_id in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotIn(List<String> values) {
            addCriterion("process_instance_id not in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdBetween(String value1, String value2) {
            addCriterion("process_instance_id between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotBetween(String value1, String value2) {
            addCriterion("process_instance_id not between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}