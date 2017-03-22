package com.kitbass.mastersynthetizer;

import java.util.List;


public class Helpers {
    public static Integer[] convertIntegerArrayListToArray(List<Integer> integerList) {
        Integer[] ret = new Integer[integerList.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integerList.get(i).intValue();
        }
        return ret;
    }
}
