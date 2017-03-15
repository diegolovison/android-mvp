package com.example.diegolovison.projetoexemplo.commons.util;

import java.util.List;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public abstract class DataAccessUtils {

    public static <T> T requiredSingleResult(List<T> results) {
        int size = (results != null ? results.size() : 0);
        if (size == 0) {
            return null;
        }
        if (results.size() > 1) {
            // TODO i18n
            //throw new IncorrectResultSizeDataAccessException(1, size);
            throw new IllegalArgumentException("Incorrect result size: " + size);
        }
        return results.get(0);
    }
}
