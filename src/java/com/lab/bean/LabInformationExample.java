package com.lab.bean;

import java.util.ArrayList;
import java.util.List;

public class LabInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LabInformationExample() {
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

        public Criteria andLabinformationIdIsNull() {
            addCriterion("labinformation_id is null");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdIsNotNull() {
            addCriterion("labinformation_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdEqualTo(Integer value) {
            addCriterion("labinformation_id =", value, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdNotEqualTo(Integer value) {
            addCriterion("labinformation_id <>", value, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdGreaterThan(Integer value) {
            addCriterion("labinformation_id >", value, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("labinformation_id >=", value, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdLessThan(Integer value) {
            addCriterion("labinformation_id <", value, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdLessThanOrEqualTo(Integer value) {
            addCriterion("labinformation_id <=", value, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdIn(List<Integer> values) {
            addCriterion("labinformation_id in", values, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdNotIn(List<Integer> values) {
            addCriterion("labinformation_id not in", values, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdBetween(Integer value1, Integer value2) {
            addCriterion("labinformation_id between", value1, value2, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("labinformation_id not between", value1, value2, "labinformationId");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorIsNull() {
            addCriterion("labinformation_floor is null");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorIsNotNull() {
            addCriterion("labinformation_floor is not null");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorEqualTo(String value) {
            addCriterion("labinformation_floor =", value, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorNotEqualTo(String value) {
            addCriterion("labinformation_floor <>", value, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorGreaterThan(String value) {
            addCriterion("labinformation_floor >", value, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorGreaterThanOrEqualTo(String value) {
            addCriterion("labinformation_floor >=", value, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorLessThan(String value) {
            addCriterion("labinformation_floor <", value, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorLessThanOrEqualTo(String value) {
            addCriterion("labinformation_floor <=", value, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorLike(String value) {
            addCriterion("labinformation_floor like", value, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorNotLike(String value) {
            addCriterion("labinformation_floor not like", value, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorIn(List<String> values) {
            addCriterion("labinformation_floor in", values, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorNotIn(List<String> values) {
            addCriterion("labinformation_floor not in", values, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorBetween(String value1, String value2) {
            addCriterion("labinformation_floor between", value1, value2, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationFloorNotBetween(String value1, String value2) {
            addCriterion("labinformation_floor not between", value1, value2, "labinformationFloor");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumIsNull() {
            addCriterion("labinformation_num is null");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumIsNotNull() {
            addCriterion("labinformation_num is not null");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumEqualTo(Integer value) {
            addCriterion("labinformation_num =", value, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumNotEqualTo(Integer value) {
            addCriterion("labinformation_num <>", value, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumGreaterThan(Integer value) {
            addCriterion("labinformation_num >", value, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("labinformation_num >=", value, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumLessThan(Integer value) {
            addCriterion("labinformation_num <", value, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumLessThanOrEqualTo(Integer value) {
            addCriterion("labinformation_num <=", value, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumIn(List<Integer> values) {
            addCriterion("labinformation_num in", values, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumNotIn(List<Integer> values) {
            addCriterion("labinformation_num not in", values, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumBetween(Integer value1, Integer value2) {
            addCriterion("labinformation_num between", value1, value2, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationNumNotBetween(Integer value1, Integer value2) {
            addCriterion("labinformation_num not between", value1, value2, "labinformationNum");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjIsNull() {
            addCriterion("labinformation_sykj is null");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjIsNotNull() {
            addCriterion("labinformation_sykj is not null");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjEqualTo(Integer value) {
            addCriterion("labinformation_sykj =", value, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjNotEqualTo(Integer value) {
            addCriterion("labinformation_sykj <>", value, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjGreaterThan(Integer value) {
            addCriterion("labinformation_sykj >", value, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjGreaterThanOrEqualTo(Integer value) {
            addCriterion("labinformation_sykj >=", value, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjLessThan(Integer value) {
            addCriterion("labinformation_sykj <", value, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjLessThanOrEqualTo(Integer value) {
            addCriterion("labinformation_sykj <=", value, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjIn(List<Integer> values) {
            addCriterion("labinformation_sykj in", values, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjNotIn(List<Integer> values) {
            addCriterion("labinformation_sykj not in", values, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjBetween(Integer value1, Integer value2) {
            addCriterion("labinformation_sykj between", value1, value2, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationSykjNotBetween(Integer value1, Integer value2) {
            addCriterion("labinformation_sykj not between", value1, value2, "labinformationSykj");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameIsNull() {
            addCriterion("labinformation_name is null");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameIsNotNull() {
            addCriterion("labinformation_name is not null");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameEqualTo(String value) {
            addCriterion("labinformation_name =", value, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameNotEqualTo(String value) {
            addCriterion("labinformation_name <>", value, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameGreaterThan(String value) {
            addCriterion("labinformation_name >", value, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameGreaterThanOrEqualTo(String value) {
            addCriterion("labinformation_name >=", value, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameLessThan(String value) {
            addCriterion("labinformation_name <", value, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameLessThanOrEqualTo(String value) {
            addCriterion("labinformation_name <=", value, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameLike(String value) {
            addCriterion("labinformation_name like", value, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameNotLike(String value) {
            addCriterion("labinformation_name not like", value, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameIn(List<String> values) {
            addCriterion("labinformation_name in", values, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameNotIn(List<String> values) {
            addCriterion("labinformation_name not in", values, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameBetween(String value1, String value2) {
            addCriterion("labinformation_name between", value1, value2, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationNameNotBetween(String value1, String value2) {
            addCriterion("labinformation_name not between", value1, value2, "labinformationName");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionIsNull() {
            addCriterion("labinformation_description is null");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionIsNotNull() {
            addCriterion("labinformation_description is not null");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionEqualTo(String value) {
            addCriterion("labinformation_description =", value, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionNotEqualTo(String value) {
            addCriterion("labinformation_description <>", value, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionGreaterThan(String value) {
            addCriterion("labinformation_description >", value, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("labinformation_description >=", value, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionLessThan(String value) {
            addCriterion("labinformation_description <", value, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionLessThanOrEqualTo(String value) {
            addCriterion("labinformation_description <=", value, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionLike(String value) {
            addCriterion("labinformation_description like", value, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionNotLike(String value) {
            addCriterion("labinformation_description not like", value, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionIn(List<String> values) {
            addCriterion("labinformation_description in", values, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionNotIn(List<String> values) {
            addCriterion("labinformation_description not in", values, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionBetween(String value1, String value2) {
            addCriterion("labinformation_description between", value1, value2, "labinformationDescription");
            return (Criteria) this;
        }

        public Criteria andLabinformationDescriptionNotBetween(String value1, String value2) {
            addCriterion("labinformation_description not between", value1, value2, "labinformationDescription");
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