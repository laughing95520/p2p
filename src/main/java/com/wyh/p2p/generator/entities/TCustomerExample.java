package com.wyh.p2p.generator.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCustomerExample() {
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

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("FNAME is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("FNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("FNAME =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("FNAME <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("FNAME >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("FNAME >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("FNAME <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("FNAME <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("FNAME like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("FNAME not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("FNAME in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("FNAME not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("FNAME between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("FNAME not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFbirthdayIsNull() {
            addCriterion("FBIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andFbirthdayIsNotNull() {
            addCriterion("FBIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andFbirthdayEqualTo(Date value) {
            addCriterion("FBIRTHDAY =", value, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayNotEqualTo(Date value) {
            addCriterion("FBIRTHDAY <>", value, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayGreaterThan(Date value) {
            addCriterion("FBIRTHDAY >", value, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("FBIRTHDAY >=", value, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayLessThan(Date value) {
            addCriterion("FBIRTHDAY <", value, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayLessThanOrEqualTo(Date value) {
            addCriterion("FBIRTHDAY <=", value, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayIn(List<Date> values) {
            addCriterion("FBIRTHDAY in", values, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayNotIn(List<Date> values) {
            addCriterion("FBIRTHDAY not in", values, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayBetween(Date value1, Date value2) {
            addCriterion("FBIRTHDAY between", value1, value2, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFbirthdayNotBetween(Date value1, Date value2) {
            addCriterion("FBIRTHDAY not between", value1, value2, "fbirthday");
            return (Criteria) this;
        }

        public Criteria andFsexIsNull() {
            addCriterion("FSEX is null");
            return (Criteria) this;
        }

        public Criteria andFsexIsNotNull() {
            addCriterion("FSEX is not null");
            return (Criteria) this;
        }

        public Criteria andFsexEqualTo(String value) {
            addCriterion("FSEX =", value, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexNotEqualTo(String value) {
            addCriterion("FSEX <>", value, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexGreaterThan(String value) {
            addCriterion("FSEX >", value, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexGreaterThanOrEqualTo(String value) {
            addCriterion("FSEX >=", value, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexLessThan(String value) {
            addCriterion("FSEX <", value, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexLessThanOrEqualTo(String value) {
            addCriterion("FSEX <=", value, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexLike(String value) {
            addCriterion("FSEX like", value, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexNotLike(String value) {
            addCriterion("FSEX not like", value, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexIn(List<String> values) {
            addCriterion("FSEX in", values, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexNotIn(List<String> values) {
            addCriterion("FSEX not in", values, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexBetween(String value1, String value2) {
            addCriterion("FSEX between", value1, value2, "fsex");
            return (Criteria) this;
        }

        public Criteria andFsexNotBetween(String value1, String value2) {
            addCriterion("FSEX not between", value1, value2, "fsex");
            return (Criteria) this;
        }

        public Criteria andFidNumIsNull() {
            addCriterion("FID_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFidNumIsNotNull() {
            addCriterion("FID_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFidNumEqualTo(Long value) {
            addCriterion("FID_NUM =", value, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumNotEqualTo(Long value) {
            addCriterion("FID_NUM <>", value, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumGreaterThan(Long value) {
            addCriterion("FID_NUM >", value, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumGreaterThanOrEqualTo(Long value) {
            addCriterion("FID_NUM >=", value, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumLessThan(Long value) {
            addCriterion("FID_NUM <", value, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumLessThanOrEqualTo(Long value) {
            addCriterion("FID_NUM <=", value, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumIn(List<Long> values) {
            addCriterion("FID_NUM in", values, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumNotIn(List<Long> values) {
            addCriterion("FID_NUM not in", values, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumBetween(Long value1, Long value2) {
            addCriterion("FID_NUM between", value1, value2, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFidNumNotBetween(Long value1, Long value2) {
            addCriterion("FID_NUM not between", value1, value2, "fidNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumIsNull() {
            addCriterion("FPHONE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFphoneNumIsNotNull() {
            addCriterion("FPHONE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFphoneNumEqualTo(Long value) {
            addCriterion("FPHONE_NUM =", value, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumNotEqualTo(Long value) {
            addCriterion("FPHONE_NUM <>", value, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumGreaterThan(Long value) {
            addCriterion("FPHONE_NUM >", value, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumGreaterThanOrEqualTo(Long value) {
            addCriterion("FPHONE_NUM >=", value, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumLessThan(Long value) {
            addCriterion("FPHONE_NUM <", value, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumLessThanOrEqualTo(Long value) {
            addCriterion("FPHONE_NUM <=", value, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumIn(List<Long> values) {
            addCriterion("FPHONE_NUM in", values, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumNotIn(List<Long> values) {
            addCriterion("FPHONE_NUM not in", values, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumBetween(Long value1, Long value2) {
            addCriterion("FPHONE_NUM between", value1, value2, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFphoneNumNotBetween(Long value1, Long value2) {
            addCriterion("FPHONE_NUM not between", value1, value2, "fphoneNum");
            return (Criteria) this;
        }

        public Criteria andFaddressIsNull() {
            addCriterion("FADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andFaddressIsNotNull() {
            addCriterion("FADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andFaddressEqualTo(String value) {
            addCriterion("FADDRESS =", value, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressNotEqualTo(String value) {
            addCriterion("FADDRESS <>", value, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressGreaterThan(String value) {
            addCriterion("FADDRESS >", value, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressGreaterThanOrEqualTo(String value) {
            addCriterion("FADDRESS >=", value, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressLessThan(String value) {
            addCriterion("FADDRESS <", value, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressLessThanOrEqualTo(String value) {
            addCriterion("FADDRESS <=", value, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressLike(String value) {
            addCriterion("FADDRESS like", value, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressNotLike(String value) {
            addCriterion("FADDRESS not like", value, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressIn(List<String> values) {
            addCriterion("FADDRESS in", values, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressNotIn(List<String> values) {
            addCriterion("FADDRESS not in", values, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressBetween(String value1, String value2) {
            addCriterion("FADDRESS between", value1, value2, "faddress");
            return (Criteria) this;
        }

        public Criteria andFaddressNotBetween(String value1, String value2) {
            addCriterion("FADDRESS not between", value1, value2, "faddress");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonIsNull() {
            addCriterion("FURGENT_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonIsNotNull() {
            addCriterion("FURGENT_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonEqualTo(String value) {
            addCriterion("FURGENT_PERSON =", value, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonNotEqualTo(String value) {
            addCriterion("FURGENT_PERSON <>", value, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonGreaterThan(String value) {
            addCriterion("FURGENT_PERSON >", value, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonGreaterThanOrEqualTo(String value) {
            addCriterion("FURGENT_PERSON >=", value, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonLessThan(String value) {
            addCriterion("FURGENT_PERSON <", value, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonLessThanOrEqualTo(String value) {
            addCriterion("FURGENT_PERSON <=", value, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonLike(String value) {
            addCriterion("FURGENT_PERSON like", value, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonNotLike(String value) {
            addCriterion("FURGENT_PERSON not like", value, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonIn(List<String> values) {
            addCriterion("FURGENT_PERSON in", values, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonNotIn(List<String> values) {
            addCriterion("FURGENT_PERSON not in", values, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonBetween(String value1, String value2) {
            addCriterion("FURGENT_PERSON between", value1, value2, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonNotBetween(String value1, String value2) {
            addCriterion("FURGENT_PERSON not between", value1, value2, "furgentPerson");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneIsNull() {
            addCriterion("FURGENT_PERSON_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneIsNotNull() {
            addCriterion("FURGENT_PERSON_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneEqualTo(Long value) {
            addCriterion("FURGENT_PERSON_PHONE =", value, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneNotEqualTo(Long value) {
            addCriterion("FURGENT_PERSON_PHONE <>", value, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneGreaterThan(Long value) {
            addCriterion("FURGENT_PERSON_PHONE >", value, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneGreaterThanOrEqualTo(Long value) {
            addCriterion("FURGENT_PERSON_PHONE >=", value, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneLessThan(Long value) {
            addCriterion("FURGENT_PERSON_PHONE <", value, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneLessThanOrEqualTo(Long value) {
            addCriterion("FURGENT_PERSON_PHONE <=", value, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneIn(List<Long> values) {
            addCriterion("FURGENT_PERSON_PHONE in", values, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneNotIn(List<Long> values) {
            addCriterion("FURGENT_PERSON_PHONE not in", values, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneBetween(Long value1, Long value2) {
            addCriterion("FURGENT_PERSON_PHONE between", value1, value2, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFurgentPersonPhoneNotBetween(Long value1, Long value2) {
            addCriterion("FURGENT_PERSON_PHONE not between", value1, value2, "furgentPersonPhone");
            return (Criteria) this;
        }

        public Criteria andFpasswordIsNull() {
            addCriterion("FPASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andFpasswordIsNotNull() {
            addCriterion("FPASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andFpasswordEqualTo(String value) {
            addCriterion("FPASSWORD =", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotEqualTo(String value) {
            addCriterion("FPASSWORD <>", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordGreaterThan(String value) {
            addCriterion("FPASSWORD >", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("FPASSWORD >=", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordLessThan(String value) {
            addCriterion("FPASSWORD <", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordLessThanOrEqualTo(String value) {
            addCriterion("FPASSWORD <=", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordLike(String value) {
            addCriterion("FPASSWORD like", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotLike(String value) {
            addCriterion("FPASSWORD not like", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordIn(List<String> values) {
            addCriterion("FPASSWORD in", values, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotIn(List<String> values) {
            addCriterion("FPASSWORD not in", values, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordBetween(String value1, String value2) {
            addCriterion("FPASSWORD between", value1, value2, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotBetween(String value1, String value2) {
            addCriterion("FPASSWORD not between", value1, value2, "fpassword");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Double value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Double value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Double value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Double value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Double value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Double> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Double> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Double value1, Double value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Double value1, Double value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Double value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Double value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Double value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Double value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Double value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Double> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Double> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Double value1, Double value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Double value1, Double value2) {
            addCriterion("income not between", value1, value2, "income");
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