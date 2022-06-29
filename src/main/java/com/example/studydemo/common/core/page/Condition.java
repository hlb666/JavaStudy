package com.example.studydemo.common.core.page;

import java.util.List;

public class Condition {
    private String condition;
    private List<Object> values;

    public static ConditionBuilder builder() {
        return new ConditionBuilder();
    }

    public String getCondition() {
        return this.condition;
    }

    public List<Object> getValues() {
        return this.values;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Condition)) {
            return false;
        } else {
            Condition other = (Condition)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$condition = this.getCondition();
                Object other$condition = other.getCondition();
                if (this$condition == null) {
                    if (other$condition != null) {
                        return false;
                    }
                } else if (!this$condition.equals(other$condition)) {
                    return false;
                }

                Object this$values = this.getValues();
                Object other$values = other.getValues();
                if (this$values == null) {
                    if (other$values != null) {
                        return false;
                    }
                } else if (!this$values.equals(other$values)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Condition;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $condition = this.getCondition();
        result = result * 59 + ($condition == null ? 43 : $condition.hashCode());
        Object $values = this.getValues();
        result = result * 59 + ($values == null ? 43 : $values.hashCode());
        return result;
    }

    public String toString() {
        return "Condition(condition=" + this.getCondition() + ", values=" + this.getValues() + ")";
    }

    public Condition() {
    }

    public Condition(String condition, List<Object> values) {
        this.condition = condition;
        this.values = values;
    }

    public static class ConditionBuilder {
        private String condition;
        private List<Object> values;

        ConditionBuilder() {
        }

        public ConditionBuilder condition(String condition) {
            this.condition = condition;
            return this;
        }

        public ConditionBuilder values(List<Object> values) {
            this.values = values;
            return this;
        }

        public Condition build() {
            return new Condition(this.condition, this.values);
        }

        public String toString() {
            return "Condition.ConditionBuilder(condition=" + this.condition + ", values=" + this.values + ")";
        }
    }
}
