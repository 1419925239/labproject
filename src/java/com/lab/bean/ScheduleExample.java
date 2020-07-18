package com.lab.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScheduleExample() {
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

        public Criteria andScheduleIdIsNull() {
            addCriterion("Schedule_id is null");
            return (Criteria) this;
        }

        public Criteria andScheduleIdIsNotNull() {
            addCriterion("Schedule_id is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleIdEqualTo(Integer value) {
            addCriterion("Schedule_id =", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdNotEqualTo(Integer value) {
            addCriterion("Schedule_id <>", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdGreaterThan(Integer value) {
            addCriterion("Schedule_id >", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Schedule_id >=", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdLessThan(Integer value) {
            addCriterion("Schedule_id <", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdLessThanOrEqualTo(Integer value) {
            addCriterion("Schedule_id <=", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdIn(List<Integer> values) {
            addCriterion("Schedule_id in", values, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdNotIn(List<Integer> values) {
            addCriterion("Schedule_id not in", values, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdBetween(Integer value1, Integer value2) {
            addCriterion("Schedule_id between", value1, value2, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Schedule_id not between", value1, value2, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andLabIdIsNull() {
            addCriterion("lab_id is null");
            return (Criteria) this;
        }

        public Criteria andLabIdIsNotNull() {
            addCriterion("lab_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabIdEqualTo(Integer value) {
            addCriterion("lab_id =", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotEqualTo(Integer value) {
            addCriterion("lab_id <>", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdGreaterThan(Integer value) {
            addCriterion("lab_id >", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lab_id >=", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdLessThan(Integer value) {
            addCriterion("lab_id <", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdLessThanOrEqualTo(Integer value) {
            addCriterion("lab_id <=", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdIn(List<Integer> values) {
            addCriterion("lab_id in", values, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotIn(List<Integer> values) {
            addCriterion("lab_id not in", values, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdBetween(Integer value1, Integer value2) {
            addCriterion("lab_id between", value1, value2, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lab_id not between", value1, value2, "labId");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIsNull() {
            addCriterion("Schedule_date is null");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIsNotNull() {
            addCriterion("Schedule_date is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleDateEqualTo(Date value) {
            addCriterionForJDBCDate("Schedule_date =", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("Schedule_date <>", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateGreaterThan(Date value) {
            addCriterionForJDBCDate("Schedule_date >", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Schedule_date >=", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateLessThan(Date value) {
            addCriterionForJDBCDate("Schedule_date <", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Schedule_date <=", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIn(List<Date> values) {
            addCriterionForJDBCDate("Schedule_date in", values, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("Schedule_date not in", values, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Schedule_date between", value1, value2, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Schedule_date not between", value1, value2, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andT1IsNull() {
            addCriterion("T1 is null");
            return (Criteria) this;
        }

        public Criteria andT1IsNotNull() {
            addCriterion("T1 is not null");
            return (Criteria) this;
        }

        public Criteria andT1EqualTo(Integer value) {
            addCriterion("T1 =", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotEqualTo(Integer value) {
            addCriterion("T1 <>", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1GreaterThan(Integer value) {
            addCriterion("T1 >", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1GreaterThanOrEqualTo(Integer value) {
            addCriterion("T1 >=", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1LessThan(Integer value) {
            addCriterion("T1 <", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1LessThanOrEqualTo(Integer value) {
            addCriterion("T1 <=", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1In(List<Integer> values) {
            addCriterion("T1 in", values, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotIn(List<Integer> values) {
            addCriterion("T1 not in", values, "t1");
            return (Criteria) this;
        }

        public Criteria andT1Between(Integer value1, Integer value2) {
            addCriterion("T1 between", value1, value2, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotBetween(Integer value1, Integer value2) {
            addCriterion("T1 not between", value1, value2, "t1");
            return (Criteria) this;
        }

        public Criteria andT2IsNull() {
            addCriterion("T2 is null");
            return (Criteria) this;
        }

        public Criteria andT2IsNotNull() {
            addCriterion("T2 is not null");
            return (Criteria) this;
        }

        public Criteria andT2EqualTo(Integer value) {
            addCriterion("T2 =", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotEqualTo(Integer value) {
            addCriterion("T2 <>", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2GreaterThan(Integer value) {
            addCriterion("T2 >", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2GreaterThanOrEqualTo(Integer value) {
            addCriterion("T2 >=", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2LessThan(Integer value) {
            addCriterion("T2 <", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2LessThanOrEqualTo(Integer value) {
            addCriterion("T2 <=", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2In(List<Integer> values) {
            addCriterion("T2 in", values, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotIn(List<Integer> values) {
            addCriterion("T2 not in", values, "t2");
            return (Criteria) this;
        }

        public Criteria andT2Between(Integer value1, Integer value2) {
            addCriterion("T2 between", value1, value2, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotBetween(Integer value1, Integer value2) {
            addCriterion("T2 not between", value1, value2, "t2");
            return (Criteria) this;
        }

        public Criteria andT3IsNull() {
            addCriterion("T3 is null");
            return (Criteria) this;
        }

        public Criteria andT3IsNotNull() {
            addCriterion("T3 is not null");
            return (Criteria) this;
        }

        public Criteria andT3EqualTo(Integer value) {
            addCriterion("T3 =", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotEqualTo(Integer value) {
            addCriterion("T3 <>", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3GreaterThan(Integer value) {
            addCriterion("T3 >", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3GreaterThanOrEqualTo(Integer value) {
            addCriterion("T3 >=", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3LessThan(Integer value) {
            addCriterion("T3 <", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3LessThanOrEqualTo(Integer value) {
            addCriterion("T3 <=", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3In(List<Integer> values) {
            addCriterion("T3 in", values, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotIn(List<Integer> values) {
            addCriterion("T3 not in", values, "t3");
            return (Criteria) this;
        }

        public Criteria andT3Between(Integer value1, Integer value2) {
            addCriterion("T3 between", value1, value2, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotBetween(Integer value1, Integer value2) {
            addCriterion("T3 not between", value1, value2, "t3");
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