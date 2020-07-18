package com.lab.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExpResultsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpResultsExample() {
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

        public Criteria andExpresultsIdIsNull() {
            addCriterion("expresults_id is null");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdIsNotNull() {
            addCriterion("expresults_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdEqualTo(Integer value) {
            addCriterion("expresults_id =", value, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdNotEqualTo(Integer value) {
            addCriterion("expresults_id <>", value, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdGreaterThan(Integer value) {
            addCriterion("expresults_id >", value, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expresults_id >=", value, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdLessThan(Integer value) {
            addCriterion("expresults_id <", value, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdLessThanOrEqualTo(Integer value) {
            addCriterion("expresults_id <=", value, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdIn(List<Integer> values) {
            addCriterion("expresults_id in", values, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdNotIn(List<Integer> values) {
            addCriterion("expresults_id not in", values, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdBetween(Integer value1, Integer value2) {
            addCriterion("expresults_id between", value1, value2, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expresults_id not between", value1, value2, "expresultsId");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameIsNull() {
            addCriterion("expresults_name is null");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameIsNotNull() {
            addCriterion("expresults_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameEqualTo(String value) {
            addCriterion("expresults_name =", value, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameNotEqualTo(String value) {
            addCriterion("expresults_name <>", value, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameGreaterThan(String value) {
            addCriterion("expresults_name >", value, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameGreaterThanOrEqualTo(String value) {
            addCriterion("expresults_name >=", value, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameLessThan(String value) {
            addCriterion("expresults_name <", value, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameLessThanOrEqualTo(String value) {
            addCriterion("expresults_name <=", value, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameLike(String value) {
            addCriterion("expresults_name like", value, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameNotLike(String value) {
            addCriterion("expresults_name not like", value, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameIn(List<String> values) {
            addCriterion("expresults_name in", values, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameNotIn(List<String> values) {
            addCriterion("expresults_name not in", values, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameBetween(String value1, String value2) {
            addCriterion("expresults_name between", value1, value2, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsNameNotBetween(String value1, String value2) {
            addCriterion("expresults_name not between", value1, value2, "expresultsName");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyIsNull() {
            addCriterion("expresults_fauclty is null");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyIsNotNull() {
            addCriterion("expresults_fauclty is not null");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyEqualTo(String value) {
            addCriterion("expresults_fauclty =", value, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyNotEqualTo(String value) {
            addCriterion("expresults_fauclty <>", value, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyGreaterThan(String value) {
            addCriterion("expresults_fauclty >", value, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyGreaterThanOrEqualTo(String value) {
            addCriterion("expresults_fauclty >=", value, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyLessThan(String value) {
            addCriterion("expresults_fauclty <", value, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyLessThanOrEqualTo(String value) {
            addCriterion("expresults_fauclty <=", value, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyLike(String value) {
            addCriterion("expresults_fauclty like", value, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyNotLike(String value) {
            addCriterion("expresults_fauclty not like", value, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyIn(List<String> values) {
            addCriterion("expresults_fauclty in", values, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyNotIn(List<String> values) {
            addCriterion("expresults_fauclty not in", values, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyBetween(String value1, String value2) {
            addCriterion("expresults_fauclty between", value1, value2, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsFaucltyNotBetween(String value1, String value2) {
            addCriterion("expresults_fauclty not between", value1, value2, "expresultsFauclty");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssIsNull() {
            addCriterion("expresults_calss is null");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssIsNotNull() {
            addCriterion("expresults_calss is not null");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssEqualTo(String value) {
            addCriterion("expresults_calss =", value, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssNotEqualTo(String value) {
            addCriterion("expresults_calss <>", value, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssGreaterThan(String value) {
            addCriterion("expresults_calss >", value, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssGreaterThanOrEqualTo(String value) {
            addCriterion("expresults_calss >=", value, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssLessThan(String value) {
            addCriterion("expresults_calss <", value, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssLessThanOrEqualTo(String value) {
            addCriterion("expresults_calss <=", value, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssLike(String value) {
            addCriterion("expresults_calss like", value, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssNotLike(String value) {
            addCriterion("expresults_calss not like", value, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssIn(List<String> values) {
            addCriterion("expresults_calss in", values, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssNotIn(List<String> values) {
            addCriterion("expresults_calss not in", values, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssBetween(String value1, String value2) {
            addCriterion("expresults_calss between", value1, value2, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsCalssNotBetween(String value1, String value2) {
            addCriterion("expresults_calss not between", value1, value2, "expresultsCalss");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisIsNull() {
            addCriterion("expresults_analysis is null");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisIsNotNull() {
            addCriterion("expresults_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisEqualTo(String value) {
            addCriterion("expresults_analysis =", value, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisNotEqualTo(String value) {
            addCriterion("expresults_analysis <>", value, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisGreaterThan(String value) {
            addCriterion("expresults_analysis >", value, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("expresults_analysis >=", value, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisLessThan(String value) {
            addCriterion("expresults_analysis <", value, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisLessThanOrEqualTo(String value) {
            addCriterion("expresults_analysis <=", value, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisLike(String value) {
            addCriterion("expresults_analysis like", value, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisNotLike(String value) {
            addCriterion("expresults_analysis not like", value, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisIn(List<String> values) {
            addCriterion("expresults_analysis in", values, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisNotIn(List<String> values) {
            addCriterion("expresults_analysis not in", values, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisBetween(String value1, String value2) {
            addCriterion("expresults_analysis between", value1, value2, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsAnalysisNotBetween(String value1, String value2) {
            addCriterion("expresults_analysis not between", value1, value2, "expresultsAnalysis");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishIsNull() {
            addCriterion("expresults_finish is null");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishIsNotNull() {
            addCriterion("expresults_finish is not null");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishEqualTo(String value) {
            addCriterion("expresults_finish =", value, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishNotEqualTo(String value) {
            addCriterion("expresults_finish <>", value, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishGreaterThan(String value) {
            addCriterion("expresults_finish >", value, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishGreaterThanOrEqualTo(String value) {
            addCriterion("expresults_finish >=", value, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishLessThan(String value) {
            addCriterion("expresults_finish <", value, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishLessThanOrEqualTo(String value) {
            addCriterion("expresults_finish <=", value, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishLike(String value) {
            addCriterion("expresults_finish like", value, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishNotLike(String value) {
            addCriterion("expresults_finish not like", value, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishIn(List<String> values) {
            addCriterion("expresults_finish in", values, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishNotIn(List<String> values) {
            addCriterion("expresults_finish not in", values, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishBetween(String value1, String value2) {
            addCriterion("expresults_finish between", value1, value2, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsFinishNotBetween(String value1, String value2) {
            addCriterion("expresults_finish not between", value1, value2, "expresultsFinish");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiIsNull() {
            addCriterion("expresults_riqi is null");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiIsNotNull() {
            addCriterion("expresults_riqi is not null");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiEqualTo(Date value) {
            addCriterionForJDBCDate("expresults_riqi =", value, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiNotEqualTo(Date value) {
            addCriterionForJDBCDate("expresults_riqi <>", value, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiGreaterThan(Date value) {
            addCriterionForJDBCDate("expresults_riqi >", value, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expresults_riqi >=", value, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiLessThan(Date value) {
            addCriterionForJDBCDate("expresults_riqi <", value, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expresults_riqi <=", value, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiIn(List<Date> values) {
            addCriterionForJDBCDate("expresults_riqi in", values, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiNotIn(List<Date> values) {
            addCriterionForJDBCDate("expresults_riqi not in", values, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expresults_riqi between", value1, value2, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andExpresultsRiqiNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expresults_riqi not between", value1, value2, "expresultsRiqi");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanIsNull() {
            addCriterion("erpresults_shijianduan is null");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanIsNotNull() {
            addCriterion("erpresults_shijianduan is not null");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanEqualTo(Integer value) {
            addCriterion("erpresults_shijianduan =", value, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanNotEqualTo(Integer value) {
            addCriterion("erpresults_shijianduan <>", value, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanGreaterThan(Integer value) {
            addCriterion("erpresults_shijianduan >", value, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanGreaterThanOrEqualTo(Integer value) {
            addCriterion("erpresults_shijianduan >=", value, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanLessThan(Integer value) {
            addCriterion("erpresults_shijianduan <", value, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanLessThanOrEqualTo(Integer value) {
            addCriterion("erpresults_shijianduan <=", value, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanIn(List<Integer> values) {
            addCriterion("erpresults_shijianduan in", values, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanNotIn(List<Integer> values) {
            addCriterion("erpresults_shijianduan not in", values, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanBetween(Integer value1, Integer value2) {
            addCriterion("erpresults_shijianduan between", value1, value2, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andErpresultsShijianduanNotBetween(Integer value1, Integer value2) {
            addCriterion("erpresults_shijianduan not between", value1, value2, "erpresultsShijianduan");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusIsNull() {
            addCriterion("expresults_status is null");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusIsNotNull() {
            addCriterion("expresults_status is not null");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusEqualTo(Integer value) {
            addCriterion("expresults_status =", value, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusNotEqualTo(Integer value) {
            addCriterion("expresults_status <>", value, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusGreaterThan(Integer value) {
            addCriterion("expresults_status >", value, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("expresults_status >=", value, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusLessThan(Integer value) {
            addCriterion("expresults_status <", value, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("expresults_status <=", value, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusIn(List<Integer> values) {
            addCriterion("expresults_status in", values, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusNotIn(List<Integer> values) {
            addCriterion("expresults_status not in", values, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusBetween(Integer value1, Integer value2) {
            addCriterion("expresults_status between", value1, value2, "expresultsStatus");
            return (Criteria) this;
        }

        public Criteria andExpresultsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("expresults_status not between", value1, value2, "expresultsStatus");
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