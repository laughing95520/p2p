package com.wyh.p2p.generator.entities;

import java.util.ArrayList;
import java.util.List;

public class P2pProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2pProductExample() {
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

        public Criteria andLowestMoneyIsNull() {
            addCriterion("lowest_money is null");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyIsNotNull() {
            addCriterion("lowest_money is not null");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyEqualTo(Double value) {
            addCriterion("lowest_money =", value, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyNotEqualTo(Double value) {
            addCriterion("lowest_money <>", value, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyGreaterThan(Double value) {
            addCriterion("lowest_money >", value, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("lowest_money >=", value, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyLessThan(Double value) {
            addCriterion("lowest_money <", value, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyLessThanOrEqualTo(Double value) {
            addCriterion("lowest_money <=", value, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyIn(List<Double> values) {
            addCriterion("lowest_money in", values, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyNotIn(List<Double> values) {
            addCriterion("lowest_money not in", values, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyBetween(Double value1, Double value2) {
            addCriterion("lowest_money between", value1, value2, "lowestMoney");
            return (Criteria) this;
        }

        public Criteria andLowestMoneyNotBetween(Double value1, Double value2) {
            addCriterion("lowest_money not between", value1, value2, "lowestMoney");
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

        public Criteria andTimelineIsNull() {
            addCriterion("timeline is null");
            return (Criteria) this;
        }

        public Criteria andTimelineIsNotNull() {
            addCriterion("timeline is not null");
            return (Criteria) this;
        }

        public Criteria andTimelineEqualTo(Integer value) {
            addCriterion("timeline =", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineNotEqualTo(Integer value) {
            addCriterion("timeline <>", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineGreaterThan(Integer value) {
            addCriterion("timeline >", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeline >=", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineLessThan(Integer value) {
            addCriterion("timeline <", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineLessThanOrEqualTo(Integer value) {
            addCriterion("timeline <=", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineIn(List<Integer> values) {
            addCriterion("timeline in", values, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineNotIn(List<Integer> values) {
            addCriterion("timeline not in", values, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineBetween(Integer value1, Integer value2) {
            addCriterion("timeline between", value1, value2, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineNotBetween(Integer value1, Integer value2) {
            addCriterion("timeline not between", value1, value2, "timeline");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIsNull() {
            addCriterion("all_money is null");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIsNotNull() {
            addCriterion("all_money is not null");
            return (Criteria) this;
        }

        public Criteria andAllMoneyEqualTo(Double value) {
            addCriterion("all_money =", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotEqualTo(Double value) {
            addCriterion("all_money <>", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyGreaterThan(Double value) {
            addCriterion("all_money >", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("all_money >=", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyLessThan(Double value) {
            addCriterion("all_money <", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyLessThanOrEqualTo(Double value) {
            addCriterion("all_money <=", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIn(List<Double> values) {
            addCriterion("all_money in", values, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotIn(List<Double> values) {
            addCriterion("all_money not in", values, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyBetween(Double value1, Double value2) {
            addCriterion("all_money between", value1, value2, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotBetween(Double value1, Double value2) {
            addCriterion("all_money not between", value1, value2, "allMoney");
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