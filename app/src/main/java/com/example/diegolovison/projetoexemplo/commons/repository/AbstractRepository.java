package com.example.diegolovison.projetoexemplo.commons.repository;

import android.content.Context;
import android.database.Cursor;

import com.example.diegolovison.projetoexemplo.commons.mapper.RowMapper;
import com.example.diegolovison.projetoexemplo.commons.util.DataAccessUtils;
import com.example.diegolovison.projetoexemplo.commons.database.template.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public abstract class AbstractRepository<T> {

    private JdbcTemplate jdbcTemplate;

    public AbstractRepository(Context context) {

        this.jdbcTemplate = new JdbcTemplate(context);
    }

    protected JdbcTemplate getJdbcTemplate() {

        return jdbcTemplate;
    }

    public <T> List<T> query(String sql, Object[] selectionArgs, RowMapper<T> mapper) {

        List<T> result = new ArrayList<>();

        Cursor cursor = null;

        try {

            cursor = getJdbcTemplate().rawQuery(sql, convertArrayToString(selectionArgs));

            if (cursor.moveToFirst()) {

                do {

                    result.add(mapper.mapRow(cursor));

                } while (cursor.moveToNext());
            }
        } finally {

            if (cursor != null) {
                cursor.close();
            }
        }

        return result;
    }

    public <T> T queryForObject(String sql, Object[] selectionArgs, RowMapper<T> mapper) {

        List<T> result = query(sql, selectionArgs, mapper);

        return DataAccessUtils.requiredSingleResult(result);
    }

    private String[] convertArrayToString(Object[] args) {

        String[] selectionArgs = null;

        if (args != null) {

            selectionArgs = new String[args.length];

            for (int i=0; i<args.length; i++) {

                selectionArgs[i] = String.valueOf(args[i]);
            }
        }

        return selectionArgs;
    }
}
