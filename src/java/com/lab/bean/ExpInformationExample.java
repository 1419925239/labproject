package com.lab.bean;

import java.util.ArrayList;
import java.util.List;

public class ExpInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpInformationExample() {
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

        public Criteria andExpinformationIdIsNull() {
            addCriterion("expinformation_id is null");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdIsNotNull() {
            addCriterion("expinformation_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdEqualTo(Integer value) {
            addCriterion("expinformation_id =", value, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdNotEqualTo(Integer value) {
            addCriterion("expinformation_id <>", value, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdGreaterThan(Integer value) {
            addCriterion("expinformation_id >", value, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expinformation_id >=", value, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdLessThan(Integer value) {
            addCriterion("expinformation_id <", value, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdLessThanOrEqualTo(Integer value) {
            addCriterion("expinformation_id <=", value, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdIn(List<Integer> values) {
            addCriterion("expinformation_id in", values, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdNotIn(List<Integer> values) {
            addCriterion("expinformation_id not in", values, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdBetween(Integer value1, Integer value2) {
            addCriterion("expinformation_id between", value1, value2, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expinformation_id not between", value1, value2, "expinformationId");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyIsNull() {
            addCriterion("expinformation_faculty is null");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyIsNotNull() {
            addCriterion("expinformation_faculty is not null");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyEqualTo(String value) {
            addCriterion("expinformation_faculty =", value, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyNotEqualTo(String value) {
            addCriterion("expinformation_faculty <>", value, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyGreaterThan(String value) {
            addCriterion("expinformation_faculty >", value, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyGreaterThanOrEqualTo(String value) {
            addCriterion("expinformation_faculty >=", value, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyLessThan(String value) {
            addCriterion("expinformation_faculty <", value, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyLessThanOrEqualTo(String value) {
            addCriterion("expinformation_faculty <=", value, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyLike(String value) {
            addCriterion("expinformation_faculty like", value, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyNotLike(String value) {
            addCriterion("expinformation_faculty not like", value, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyIn(List<String> values) {
            addCriterion("expinformation_faculty in", values, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyNotIn(List<String> values) {
            addCriterion("expinformation_faculty not in", values, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyBetween(String value1, String value2) {
            addCriterion("expinformation_faculty between", value1, value2, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationFacultyNotBetween(String value1, String value2) {
            addCriterion("expinformation_faculty not between", value1, value2, "expinformationFaculty");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeIsNull() {
            addCriterion("expinformation_type is null");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeIsNotNull() {
            addCriterion("expinformation_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeEqualTo(String value) {
            addCriterion("expinformation_type =", value, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeNotEqualTo(String value) {
            addCriterion("expinformation_type <>", value, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeGreaterThan(String value) {
            addCriterion("expinformation_type >", value, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("expinformation_type >=", value, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeLessThan(String value) {
            addCriterion("expinformation_type <", value, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeLessThanOrEqualTo(String value) {
            addCriterion("expinformation_type <=", value, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeLike(String value) {
            addCriterion("expinformation_type like", value, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeNotLike(String value) {
            addCriterion("expinformation_type not like", value, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeIn(List<String> values) {
            addCriterion("expinformation_type in", values, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeNotIn(List<String> values) {
            addCriterion("expinformation_type not in", values, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeBetween(String value1, String value2) {
            addCriterion("expinformation_type between", value1, value2, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationTypeNotBetween(String value1, String value2) {
            addCriterion("expinformation_type not between", value1, value2, "expinformationType");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameIsNull() {
            addCriterion("expinformation_name is null");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameIsNotNull() {
            addCriterion("expinformation_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameEqualTo(String value) {
            addCriterion("expinformation_name =", value, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameNotEqualTo(String value) {
            addCriterion("expinformation_name <>", value, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameGreaterThan(String value) {
            addCriterion("expinformation_name >", value, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameGreaterThanOrEqualTo(String value) {
            addCriterion("expinformation_name >=", value, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameLessThan(String value) {
            addCriterion("expinformation_name <", value, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameLessThanOrEqualTo(String value) {
            addCriterion("expinformation_name <=", value, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameLike(String value) {
            addCriterion("expinformation_name like", value, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameNotLike(String value) {
            addCriterion("expinformation_name not like", value, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameIn(List<String> values) {
            addCriterion("expinformation_name in", values, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameNotIn(List<String> values) {
            addCriterion("expinformation_name not in", values, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameBetween(String value1, String value2) {
            addCriterion("expinformation_name between", value1, value2, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationNameNotBetween(String value1, String value2) {
            addCriterion("expinformation_name not between", value1, value2, "expinformationName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameIsNull() {
            addCriterion("expinformation_teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameIsNotNull() {
            addCriterion("expinformation_teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameEqualTo(String value) {
            addCriterion("expinformation_teacher_name =", value, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameNotEqualTo(String value) {
            addCriterion("expinformation_teacher_name <>", value, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameGreaterThan(String value) {
            addCriterion("expinformation_teacher_name >", value, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("expinformation_teacher_name >=", value, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameLessThan(String value) {
            addCriterion("expinformation_teacher_name <", value, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("expinformation_teacher_name <=", value, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameLike(String value) {
            addCriterion("expinformation_teacher_name like", value, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameNotLike(String value) {
            addCriterion("expinformation_teacher_name not like", value, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameIn(List<String> values) {
            addCriterion("expinformation_teacher_name in", values, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameNotIn(List<String> values) {
            addCriterion("expinformation_teacher_name not in", values, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameBetween(String value1, String value2) {
            addCriterion("expinformation_teacher_name between", value1, value2, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationTeacherNameNotBetween(String value1, String value2) {
            addCriterion("expinformation_teacher_name not between", value1, value2, "expinformationTeacherName");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusIsNull() {
            addCriterion("expinformation_status is null");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusIsNotNull() {
            addCriterion("expinformation_status is not null");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusEqualTo(Integer value) {
            addCriterion("expinformation_status =", value, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusNotEqualTo(Integer value) {
            addCriterion("expinformation_status <>", value, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusGreaterThan(Integer value) {
            addCriterion("expinformation_status >", value, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("expinformation_status >=", value, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusLessThan(Integer value) {
            addCriterion("expinformation_status <", value, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusLessThanOrEqualTo(Integer value) {
            addCriterion("expinformation_status <=", value, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusIn(List<Integer> values) {
            addCriterion("expinformation_status in", values, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusNotIn(List<Integer> values) {
            addCriterion("expinformation_status not in", values, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusBetween(Integer value1, Integer value2) {
            addCriterion("expinformation_status between", value1, value2, "expinformationStatus");
            return (Criteria) this;
        }

        public Criteria andExpinformationStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("expinformation_status not between", value1, value2, "expinformationStatus");
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