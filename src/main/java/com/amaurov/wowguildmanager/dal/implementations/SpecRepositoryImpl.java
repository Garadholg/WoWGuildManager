package com.amaurov.wowguildmanager.dal.implementations;

import com.amaurov.wowguildmanager.dal.interfaces.ClassRepository;
import com.amaurov.wowguildmanager.dal.interfaces.SpecRepository;
import com.amaurov.wowguildmanager.models.Class;
import com.amaurov.wowguildmanager.models.Specialization;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Repository
public class SpecRepositoryImpl implements SpecRepository {

    private static final String TABLE_NAME = "Specialization";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM Specialization ";

    private final JdbcTemplate jdbc;
    private final ClassRepository classRepository;

    public SpecRepositoryImpl(JdbcTemplate jdbc, ClassRepository classRepository) {
        this.jdbc = jdbc;
        this.classRepository = classRepository;
    }

    @Override
    public Set<Specialization> getAll() {
        return Set.copyOf(jdbc.query(SELECT_ALL_QUERY, this::mapRowToSpec));
    }

    @Override
    public Specialization getByID(int id) {
        return jdbc.queryForObject(SELECT_ALL_QUERY + "WHERE IDSpecialization = ?", this::mapRowToSpec, id);
    }

    private Specialization mapRowToSpec(ResultSet rs, int index) throws SQLException {
        return new Specialization(
                rs.getInt("IDSpecialization"),
                classRepository.getByID(rs.getInt("ClassID")),
                rs.getString("SpecName")
        );
    }
}
