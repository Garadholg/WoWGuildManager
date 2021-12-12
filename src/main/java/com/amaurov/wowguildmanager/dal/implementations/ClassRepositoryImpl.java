package com.amaurov.wowguildmanager.dal.implementations;

import com.amaurov.wowguildmanager.dal.interfaces.ClassRepository;
import com.amaurov.wowguildmanager.models.Class;
import com.amaurov.wowguildmanager.models.Specialization;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Repository
public class ClassRepositoryImpl implements ClassRepository {

    private static final String TABLE_NAME = "Class";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM Class ";

    private final JdbcTemplate jdbc;

    public ClassRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Set<Class> getAll() {
        return Set.copyOf(jdbc.query(SELECT_ALL_QUERY, this::mapRowToClass));
    }

    @Override
    public Class getByID(int id) {
        return jdbc.queryForObject(SELECT_ALL_QUERY + "WHERE IDClass = ?", this::mapRowToClass, id);

    }

    private Class mapRowToClass(ResultSet rs, int index) throws SQLException {
        return new Class(
          rs.getInt("IDClass"),
          rs.getString("ClassName")
        );
    }
}
