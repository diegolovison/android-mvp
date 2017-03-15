package com.example.diegolovison.projetoexemplo.visit.repository;

import android.content.ContentValues;
import android.content.Context;

import com.example.diegolovison.projetoexemplo.commons.repository.AbstractRepository;
import static com.example.diegolovison.projetoexemplo.commons.util.CursorUtils.*;
import com.example.diegolovison.projetoexemplo.visit.domain.Visit;
import com.example.diegolovison.projetoexemplo.visit.mapper.VisitRowMapper;
import com.example.diegolovison.projetoexemplo.visit.repository.entry.VisitEntry;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public class VisitRepositoryImpl extends AbstractRepository<Visit> implements VisitRepository {

    public VisitRepositoryImpl(Context context) {
        super(context);
    }

    @Override
    public Visit findLastByContactId(Long contactId) {

        String sql =
                "SELECT " +
                    VisitEntry._ID + ", " +
                    VisitEntry.COLUMN_NAME_CONTACT_ID + ", " +
                    VisitEntry.COLUMN_NAME_VISIT_DATE + " " +
                "FROM " + VisitEntry.TABLE_NAME + " " +
                "WHERE " +
                    VisitEntry.COLUMN_NAME_CONTACT_ID + " = ? " +
                "ORDER BY " +
                    VisitEntry.COLUMN_NAME_VISIT_DATE + " DESC " +
                "LIMIT 1";

        Visit visit = queryForObject(
                sql,
                new Object[] {
                    contactId
                },
                new VisitRowMapper());

        return visit;

    }

    @Override
    public Visit insert(Visit visit) {

        ContentValues values = new ContentValues();
        values.put(VisitEntry.COLUMN_NAME_CONTACT_ID, visit.getContact().getContactId());
        values.put(VisitEntry.COLUMN_NAME_VISIT_DATE, getDateTime(visit.getVisitDate()));

        long id = getJdbcTemplate().insert(
                VisitEntry.TABLE_NAME,
                null,
                values);

        visit.setVisitId(id);

        return visit;
    }
}
