package org.fsmicdev.play.java8features.domain;

import java.util.List;

/**
 *
 *
 * @author mic
 */
public class ListFinTrans  {

    // @Param
    private List<FinTrans> finTransList;

    public ListFinTrans() {
    }

    public ListFinTrans(List<FinTrans> finTransList) {
        this.finTransList = finTransList;
    }

    public List<FinTrans> getFinTransList() {
        return finTransList;
    }
}
