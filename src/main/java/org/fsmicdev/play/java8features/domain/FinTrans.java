package org.fsmicdev.play.java8features.domain;

/**
 * Financial transaction.
 *
 * @author mic
 */
public class FinTrans {

    private Integer id;

    private Double value;

    private FinTransType finTransType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public FinTransType getFinTransType() {
        return finTransType;
    }

    public void setFinTransType(FinTransType finTransType) {
        this.finTransType = finTransType;
    }

    public FinTrans getThis() {
        return this;
    }

    @Override
    public String toString() {
        return "FinTrans{" +
                "id=" + id +
                ", value=[$]" + value +
                ", finTransType=" + finTransType +
                '}';
    }
}
