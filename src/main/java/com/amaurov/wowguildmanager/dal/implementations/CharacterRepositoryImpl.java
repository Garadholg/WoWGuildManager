package com.amaurov.wowguildmanager.dal.implementations;

import com.amaurov.wowguildmanager.dal.interfaces.CharacterRepository;
import com.amaurov.wowguildmanager.dal.interfaces.SpecRepository;
import com.amaurov.wowguildmanager.models.Character;
import com.amaurov.wowguildmanager.models.Class;
import com.amaurov.wowguildmanager.models.Specialization;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    private static final String TABLE_NAME = "userchar";
    private static final String PK_COLUMN = "IDUserCharacter";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM userchar ";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert jdbcInsert;
    private final SpecRepository specRepository;

    public CharacterRepositoryImpl(JdbcTemplate jdbc, SpecRepository specRepository) {
        this.jdbc = jdbc;
        this.jdbcInsert = new SimpleJdbcInsert(jdbc)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(PK_COLUMN);
        this.specRepository = specRepository;
    }

    @Override
    public Optional<List<Character>> getAllForUser(String username) {
        try {
            return Optional.ofNullable(
              jdbc.query(SELECT_ALL_QUERY + "WHERE username = ?", this::mapRowToCharacter, username)
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public int create(Character character) {
        try {
            Map<String, Object> values = new HashMap<>();

            values.put("Username", character.getUser());
            values.put("CharacterName", character.getName());
            values.put("RaceID", character.getRace());
            values.put("SpecID", character.getSpec().getId());
            values.put("isMainChar", character.isMainChar());

            int new_key = jdbcInsert.executeAndReturnKey(values).intValue();
            return new_key;
        } catch (Exception e) {
            // error
            return 0;
        }
    }

    private Character mapRowToCharacter(ResultSet rs, int index) throws SQLException {
        return new Character(
                rs.getInt("IDUserCharacter"),
                rs.getString("Username"),
                rs.getString("CharacterName"),
                specRepository.getByID(rs.getInt("SpecID")),
                rs.getBoolean("isMainChar")
        );
    }
}
