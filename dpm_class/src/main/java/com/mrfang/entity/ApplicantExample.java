package com.mrfang.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicantExample() {
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

        public Criteria andAcIdIsNull() {
            addCriterion("ac_id is null");
            return (Criteria) this;
        }

        public Criteria andAcIdIsNotNull() {
            addCriterion("ac_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcIdEqualTo(Integer value) {
            addCriterion("ac_id =", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotEqualTo(Integer value) {
            addCriterion("ac_id <>", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdGreaterThan(Integer value) {
            addCriterion("ac_id >", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ac_id >=", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdLessThan(Integer value) {
            addCriterion("ac_id <", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdLessThanOrEqualTo(Integer value) {
            addCriterion("ac_id <=", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdIn(List<Integer> values) {
            addCriterion("ac_id in", values, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotIn(List<Integer> values) {
            addCriterion("ac_id not in", values, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdBetween(Integer value1, Integer value2) {
            addCriterion("ac_id between", value1, value2, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ac_id not between", value1, value2, "acId");
            return (Criteria) this;
        }

        public Criteria andAcNameIsNull() {
            addCriterion("ac_name is null");
            return (Criteria) this;
        }

        public Criteria andAcNameIsNotNull() {
            addCriterion("ac_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcNameEqualTo(String value) {
            addCriterion("ac_name =", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameNotEqualTo(String value) {
            addCriterion("ac_name <>", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameGreaterThan(String value) {
            addCriterion("ac_name >", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameGreaterThanOrEqualTo(String value) {
            addCriterion("ac_name >=", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameLessThan(String value) {
            addCriterion("ac_name <", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameLessThanOrEqualTo(String value) {
            addCriterion("ac_name <=", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameLike(String value) {
            addCriterion("ac_name like", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameNotLike(String value) {
            addCriterion("ac_name not like", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameIn(List<String> values) {
            addCriterion("ac_name in", values, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameNotIn(List<String> values) {
            addCriterion("ac_name not in", values, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameBetween(String value1, String value2) {
            addCriterion("ac_name between", value1, value2, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameNotBetween(String value1, String value2) {
            addCriterion("ac_name not between", value1, value2, "acName");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayIsNull() {
            addCriterion("ac_birthday is null");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayIsNotNull() {
            addCriterion("ac_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayEqualTo(Date value) {
            addCriterion("ac_birthday =", value, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayNotEqualTo(Date value) {
            addCriterion("ac_birthday <>", value, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayGreaterThan(Date value) {
            addCriterion("ac_birthday >", value, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("ac_birthday >=", value, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayLessThan(Date value) {
            addCriterion("ac_birthday <", value, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("ac_birthday <=", value, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayIn(List<Date> values) {
            addCriterion("ac_birthday in", values, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayNotIn(List<Date> values) {
            addCriterion("ac_birthday not in", values, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayBetween(Date value1, Date value2) {
            addCriterion("ac_birthday between", value1, value2, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("ac_birthday not between", value1, value2, "acBirthday");
            return (Criteria) this;
        }

        public Criteria andAcSexIsNull() {
            addCriterion("ac_sex is null");
            return (Criteria) this;
        }

        public Criteria andAcSexIsNotNull() {
            addCriterion("ac_sex is not null");
            return (Criteria) this;
        }

        public Criteria andAcSexEqualTo(Integer value) {
            addCriterion("ac_sex =", value, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexNotEqualTo(Integer value) {
            addCriterion("ac_sex <>", value, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexGreaterThan(Integer value) {
            addCriterion("ac_sex >", value, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("ac_sex >=", value, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexLessThan(Integer value) {
            addCriterion("ac_sex <", value, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexLessThanOrEqualTo(Integer value) {
            addCriterion("ac_sex <=", value, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexIn(List<Integer> values) {
            addCriterion("ac_sex in", values, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexNotIn(List<Integer> values) {
            addCriterion("ac_sex not in", values, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexBetween(Integer value1, Integer value2) {
            addCriterion("ac_sex between", value1, value2, "acSex");
            return (Criteria) this;
        }

        public Criteria andAcSexNotBetween(Integer value1, Integer value2) {
            addCriterion("ac_sex not between", value1, value2, "acSex");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeIsNull() {
            addCriterion("workingLife is null");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeIsNotNull() {
            addCriterion("workingLife is not null");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeEqualTo(Integer value) {
            addCriterion("workingLife =", value, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeNotEqualTo(Integer value) {
            addCriterion("workingLife <>", value, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeGreaterThan(Integer value) {
            addCriterion("workingLife >", value, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeGreaterThanOrEqualTo(Integer value) {
            addCriterion("workingLife >=", value, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeLessThan(Integer value) {
            addCriterion("workingLife <", value, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeLessThanOrEqualTo(Integer value) {
            addCriterion("workingLife <=", value, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeIn(List<Integer> values) {
            addCriterion("workingLife in", values, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeNotIn(List<Integer> values) {
            addCriterion("workingLife not in", values, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeBetween(Integer value1, Integer value2) {
            addCriterion("workingLife between", value1, value2, "workinglife");
            return (Criteria) this;
        }

        public Criteria andWorkinglifeNotBetween(Integer value1, Integer value2) {
            addCriterion("workingLife not between", value1, value2, "workinglife");
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