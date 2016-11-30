package chapter5.data.impl;

import chapter5.base.Spitter;
import chapter5.data.ISpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/24.
 */
@Repository
public class SpitterRepositoryImpl implements ISpitterRepository {


    private JdbcOperations jdbcOperations;


    @Autowired
    public SpitterRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public Spitter save(Spitter spitter) {
        jdbcOperations.update("insert into Spitter (username, password, first_name, last_name, email)" +
                                " values (?, ?, ?, ?, ?)",
                                spitter.getUsername(),
                                spitter.getPassword(),
                                spitter.getFirstName(),
                                spitter.getLastName(),
                                spitter.getEmail());
        return spitter;
    }

    public Spitter findByUsername(String username) {
        return jdbcOperations.queryForObject(
                "select id, username, null, first_name, last_name, email from Spitter where username=?",
                new SpitterRowMapper(),
                username);
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    null,
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"));
        }
    }
}
