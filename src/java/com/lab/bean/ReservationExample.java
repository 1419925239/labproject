package com.lab.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReservationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReservationExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(Integer value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(Integer value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(Integer value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(Integer value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<Integer> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<Integer> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(Integer value1, Integer value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_id not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andReserLabidIsNull() {
            addCriterion("reser_labid is null");
            return (Criteria) this;
        }

        public Criteria andReserLabidIsNotNull() {
            addCriterion("reser_labid is not null");
            return (Criteria) this;
        }

        public Criteria andReserLabidEqualTo(Integer value) {
            addCriterion("reser_labid =", value, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidNotEqualTo(Integer value) {
            addCriterion("reser_labid <>", value, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidGreaterThan(Integer value) {
            addCriterion("reser_labid >", value, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidGreaterThanOrEqualTo(Integer value) {
            addCriterion("reser_labid >=", value, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidLessThan(Integer value) {
            addCriterion("reser_labid <", value, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidLessThanOrEqualTo(Integer value) {
            addCriterion("reser_labid <=", value, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidIn(List<Integer> values) {
            addCriterion("reser_labid in", values, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidNotIn(List<Integer> values) {
            addCriterion("reser_labid not in", values, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidBetween(Integer value1, Integer value2) {
            addCriterion("reser_labid between", value1, value2, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserLabidNotBetween(Integer value1, Integer value2) {
            addCriterion("reser_labid not between", value1, value2, "reserLabid");
            return (Criteria) this;
        }

        public Criteria andReserUserIdIsNull() {
            addCriterion("reser_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReserUserIdIsNotNull() {
            addCriterion("reser_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReserUserIdEqualTo(Integer value) {
            addCriterion("reser_user_id =", value, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdNotEqualTo(Integer value) {
            addCriterion("reser_user_id <>", value, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdGreaterThan(Integer value) {
            addCriterion("reser_user_id >", value, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reser_user_id >=", value, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdLessThan(Integer value) {
            addCriterion("reser_user_id <", value, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("reser_user_id <=", value, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdIn(List<Integer> values) {
            addCriterion("reser_user_id in", values, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdNotIn(List<Integer> values) {
            addCriterion("reser_user_id not in", values, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdBetween(Integer value1, Integer value2) {
            addCriterion("reser_user_id between", value1, value2, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reser_user_id not between", value1, value2, "reserUserId");
            return (Criteria) this;
        }

        public Criteria andReserExpidIsNull() {
            addCriterion("reser_expid is null");
            return (Criteria) this;
        }

        public Criteria andReserExpidIsNotNull() {
            addCriterion("reser_expid is not null");
            return (Criteria) this;
        }

        public Criteria andReserExpidEqualTo(Integer value) {
            addCriterion("reser_expid =", value, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidNotEqualTo(Integer value) {
            addCriterion("reser_expid <>", value, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidGreaterThan(Integer value) {
            addCriterion("reser_expid >", value, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("reser_expid >=", value, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidLessThan(Integer value) {
            addCriterion("reser_expid <", value, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidLessThanOrEqualTo(Integer value) {
            addCriterion("reser_expid <=", value, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidIn(List<Integer> values) {
            addCriterion("reser_expid in", values, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidNotIn(List<Integer> values) {
            addCriterion("reser_expid not in", values, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidBetween(Integer value1, Integer value2) {
            addCriterion("reser_expid between", value1, value2, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserExpidNotBetween(Integer value1, Integer value2) {
            addCriterion("reser_expid not between", value1, value2, "reserExpid");
            return (Criteria) this;
        }

        public Criteria andReserTypeIsNull() {
            addCriterion("reser_type is null");
            return (Criteria) this;
        }

        public Criteria andReserTypeIsNotNull() {
            addCriterion("reser_type is not null");
            return (Criteria) this;
        }

        public Criteria andReserTypeEqualTo(Integer value) {
            addCriterion("reser_type =", value, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeNotEqualTo(Integer value) {
            addCriterion("reser_type <>", value, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeGreaterThan(Integer value) {
            addCriterion("reser_type >", value, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reser_type >=", value, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeLessThan(Integer value) {
            addCriterion("reser_type <", value, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reser_type <=", value, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeIn(List<Integer> values) {
            addCriterion("reser_type in", values, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeNotIn(List<Integer> values) {
            addCriterion("reser_type not in", values, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeBetween(Integer value1, Integer value2) {
            addCriterion("reser_type between", value1, value2, "reserType");
            return (Criteria) this;
        }

        public Criteria andReserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reser_type not between", value1, value2, "reserType");
            return (Criteria) this;
        }

        public Criteria andWeekdayIsNull() {
            addCriterion("weekday is null");
            return (Criteria) this;
        }

        public Criteria andWeekdayIsNotNull() {
            addCriterion("weekday is not null");
            return (Criteria) this;
        }

        public Criteria andWeekdayEqualTo(Integer value) {
            addCriterion("weekday =", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotEqualTo(Integer value) {
            addCriterion("weekday <>", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayGreaterThan(Integer value) {
            addCriterion("weekday >", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekday >=", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLessThan(Integer value) {
            addCriterion("weekday <", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLessThanOrEqualTo(Integer value) {
            addCriterion("weekday <=", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayIn(List<Integer> values) {
            addCriterion("weekday in", values, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotIn(List<Integer> values) {
            addCriterion("weekday not in", values, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayBetween(Integer value1, Integer value2) {
            addCriterion("weekday between", value1, value2, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotBetween(Integer value1, Integer value2) {
            addCriterion("weekday not between", value1, value2, "weekday");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeIsNull() {
            addCriterion("reser_datatime is null");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeIsNotNull() {
            addCriterion("reser_datatime is not null");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeEqualTo(Integer value) {
            addCriterion("reser_datatime =", value, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeNotEqualTo(Integer value) {
            addCriterion("reser_datatime <>", value, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeGreaterThan(Integer value) {
            addCriterion("reser_datatime >", value, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reser_datatime >=", value, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeLessThan(Integer value) {
            addCriterion("reser_datatime <", value, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeLessThanOrEqualTo(Integer value) {
            addCriterion("reser_datatime <=", value, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeIn(List<Integer> values) {
            addCriterion("reser_datatime in", values, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeNotIn(List<Integer> values) {
            addCriterion("reser_datatime not in", values, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeBetween(Integer value1, Integer value2) {
            addCriterion("reser_datatime between", value1, value2, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDatatimeNotBetween(Integer value1, Integer value2) {
            addCriterion("reser_datatime not between", value1, value2, "reserDatatime");
            return (Criteria) this;
        }

        public Criteria andReserDataIsNull() {
            addCriterion("reser_data is null");
            return (Criteria) this;
        }

        public Criteria andReserDataIsNotNull() {
            addCriterion("reser_data is not null");
            return (Criteria) this;
        }

        public Criteria andReserDataEqualTo(Date value) {
            addCriterionForJDBCDate("reser_data =", value, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("reser_data <>", value, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataGreaterThan(Date value) {
            addCriterionForJDBCDate("reser_data >", value, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("reser_data >=", value, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataLessThan(Date value) {
            addCriterionForJDBCDate("reser_data <", value, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("reser_data <=", value, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataIn(List<Date> values) {
            addCriterionForJDBCDate("reser_data in", values, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("reser_data not in", values, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("reser_data between", value1, value2, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("reser_data not between", value1, value2, "reserData");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeIsNull() {
            addCriterion("reser_creattime is null");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeIsNotNull() {
            addCriterion("reser_creattime is not null");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeEqualTo(Date value) {
            addCriterion("reser_creattime =", value, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeNotEqualTo(Date value) {
            addCriterion("reser_creattime <>", value, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeGreaterThan(Date value) {
            addCriterion("reser_creattime >", value, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reser_creattime >=", value, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeLessThan(Date value) {
            addCriterion("reser_creattime <", value, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("reser_creattime <=", value, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeIn(List<Date> values) {
            addCriterion("reser_creattime in", values, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeNotIn(List<Date> values) {
            addCriterion("reser_creattime not in", values, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeBetween(Date value1, Date value2) {
            addCriterion("reser_creattime between", value1, value2, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("reser_creattime not between", value1, value2, "reserCreattime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeIsNull() {
            addCriterion("reser_modifytime is null");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeIsNotNull() {
            addCriterion("reser_modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeEqualTo(Date value) {
            addCriterion("reser_modifytime =", value, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeNotEqualTo(Date value) {
            addCriterion("reser_modifytime <>", value, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeGreaterThan(Date value) {
            addCriterion("reser_modifytime >", value, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reser_modifytime >=", value, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeLessThan(Date value) {
            addCriterion("reser_modifytime <", value, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("reser_modifytime <=", value, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeIn(List<Date> values) {
            addCriterion("reser_modifytime in", values, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeNotIn(List<Date> values) {
            addCriterion("reser_modifytime not in", values, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeBetween(Date value1, Date value2) {
            addCriterion("reser_modifytime between", value1, value2, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("reser_modifytime not between", value1, value2, "reserModifytime");
            return (Criteria) this;
        }

        public Criteria andReserStatusIsNull() {
            addCriterion("reser_status is null");
            return (Criteria) this;
        }

        public Criteria andReserStatusIsNotNull() {
            addCriterion("reser_status is not null");
            return (Criteria) this;
        }

        public Criteria andReserStatusEqualTo(Integer value) {
            addCriterion("reser_status =", value, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusNotEqualTo(Integer value) {
            addCriterion("reser_status <>", value, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusGreaterThan(Integer value) {
            addCriterion("reser_status >", value, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("reser_status >=", value, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusLessThan(Integer value) {
            addCriterion("reser_status <", value, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusLessThanOrEqualTo(Integer value) {
            addCriterion("reser_status <=", value, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusIn(List<Integer> values) {
            addCriterion("reser_status in", values, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusNotIn(List<Integer> values) {
            addCriterion("reser_status not in", values, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusBetween(Integer value1, Integer value2) {
            addCriterion("reser_status between", value1, value2, "reserStatus");
            return (Criteria) this;
        }

        public Criteria andReserStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("reser_status not between", value1, value2, "reserStatus");
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