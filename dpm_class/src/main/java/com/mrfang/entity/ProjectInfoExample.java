package com.mrfang.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectInfoExample() {
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

        public Criteria andPiIdIsNull() {
            addCriterion("pi_id is null");
            return (Criteria) this;
        }

        public Criteria andPiIdIsNotNull() {
            addCriterion("pi_id is not null");
            return (Criteria) this;
        }

        public Criteria andPiIdEqualTo(Integer value) {
            addCriterion("pi_id =", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotEqualTo(Integer value) {
            addCriterion("pi_id <>", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThan(Integer value) {
            addCriterion("pi_id >", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi_id >=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThan(Integer value) {
            addCriterion("pi_id <", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThanOrEqualTo(Integer value) {
            addCriterion("pi_id <=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdIn(List<Integer> values) {
            addCriterion("pi_id in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotIn(List<Integer> values) {
            addCriterion("pi_id not in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdBetween(Integer value1, Integer value2) {
            addCriterion("pi_id between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pi_id not between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameIsNull() {
            addCriterion("pi_projectName is null");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameIsNotNull() {
            addCriterion("pi_projectName is not null");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameEqualTo(String value) {
            addCriterion("pi_projectName =", value, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameNotEqualTo(String value) {
            addCriterion("pi_projectName <>", value, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameGreaterThan(String value) {
            addCriterion("pi_projectName >", value, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("pi_projectName >=", value, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameLessThan(String value) {
            addCriterion("pi_projectName <", value, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameLessThanOrEqualTo(String value) {
            addCriterion("pi_projectName <=", value, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameLike(String value) {
            addCriterion("pi_projectName like", value, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameNotLike(String value) {
            addCriterion("pi_projectName not like", value, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameIn(List<String> values) {
            addCriterion("pi_projectName in", values, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameNotIn(List<String> values) {
            addCriterion("pi_projectName not in", values, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameBetween(String value1, String value2) {
            addCriterion("pi_projectName between", value1, value2, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiProjectnameNotBetween(String value1, String value2) {
            addCriterion("pi_projectName not between", value1, value2, "piProjectname");
            return (Criteria) this;
        }

        public Criteria andPiStartdateIsNull() {
            addCriterion("pi_startDate is null");
            return (Criteria) this;
        }

        public Criteria andPiStartdateIsNotNull() {
            addCriterion("pi_startDate is not null");
            return (Criteria) this;
        }

        public Criteria andPiStartdateEqualTo(Date value) {
            addCriterion("pi_startDate =", value, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateNotEqualTo(Date value) {
            addCriterion("pi_startDate <>", value, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateGreaterThan(Date value) {
            addCriterion("pi_startDate >", value, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("pi_startDate >=", value, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateLessThan(Date value) {
            addCriterion("pi_startDate <", value, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateLessThanOrEqualTo(Date value) {
            addCriterion("pi_startDate <=", value, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateIn(List<Date> values) {
            addCriterion("pi_startDate in", values, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateNotIn(List<Date> values) {
            addCriterion("pi_startDate not in", values, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateBetween(Date value1, Date value2) {
            addCriterion("pi_startDate between", value1, value2, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiStartdateNotBetween(Date value1, Date value2) {
            addCriterion("pi_startDate not between", value1, value2, "piStartdate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateIsNull() {
            addCriterion("pi_endDate is null");
            return (Criteria) this;
        }

        public Criteria andPiEnddateIsNotNull() {
            addCriterion("pi_endDate is not null");
            return (Criteria) this;
        }

        public Criteria andPiEnddateEqualTo(Date value) {
            addCriterion("pi_endDate =", value, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateNotEqualTo(Date value) {
            addCriterion("pi_endDate <>", value, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateGreaterThan(Date value) {
            addCriterion("pi_endDate >", value, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("pi_endDate >=", value, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateLessThan(Date value) {
            addCriterion("pi_endDate <", value, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateLessThanOrEqualTo(Date value) {
            addCriterion("pi_endDate <=", value, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateIn(List<Date> values) {
            addCriterion("pi_endDate in", values, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateNotIn(List<Date> values) {
            addCriterion("pi_endDate not in", values, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateBetween(Date value1, Date value2) {
            addCriterion("pi_endDate between", value1, value2, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiEnddateNotBetween(Date value1, Date value2) {
            addCriterion("pi_endDate not between", value1, value2, "piEnddate");
            return (Criteria) this;
        }

        public Criteria andPiStatusIsNull() {
            addCriterion("pi_status is null");
            return (Criteria) this;
        }

        public Criteria andPiStatusIsNotNull() {
            addCriterion("pi_status is not null");
            return (Criteria) this;
        }

        public Criteria andPiStatusEqualTo(Integer value) {
            addCriterion("pi_status =", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusNotEqualTo(Integer value) {
            addCriterion("pi_status <>", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusGreaterThan(Integer value) {
            addCriterion("pi_status >", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi_status >=", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusLessThan(Integer value) {
            addCriterion("pi_status <", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pi_status <=", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusIn(List<Integer> values) {
            addCriterion("pi_status in", values, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusNotIn(List<Integer> values) {
            addCriterion("pi_status not in", values, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusBetween(Integer value1, Integer value2) {
            addCriterion("pi_status between", value1, value2, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pi_status not between", value1, value2, "piStatus");
            return (Criteria) this;
        }

        public Criteria andAcidIsNull() {
            addCriterion("acId is null");
            return (Criteria) this;
        }

        public Criteria andAcidIsNotNull() {
            addCriterion("acId is not null");
            return (Criteria) this;
        }

        public Criteria andAcidEqualTo(Integer value) {
            addCriterion("acId =", value, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidNotEqualTo(Integer value) {
            addCriterion("acId <>", value, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidGreaterThan(Integer value) {
            addCriterion("acId >", value, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("acId >=", value, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidLessThan(Integer value) {
            addCriterion("acId <", value, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidLessThanOrEqualTo(Integer value) {
            addCriterion("acId <=", value, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidIn(List<Integer> values) {
            addCriterion("acId in", values, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidNotIn(List<Integer> values) {
            addCriterion("acId not in", values, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidBetween(Integer value1, Integer value2) {
            addCriterion("acId between", value1, value2, "acid");
            return (Criteria) this;
        }

        public Criteria andAcidNotBetween(Integer value1, Integer value2) {
            addCriterion("acId not between", value1, value2, "acid");
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