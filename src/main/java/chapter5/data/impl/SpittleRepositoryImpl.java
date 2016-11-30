package chapter5.data.impl;

import chapter5.base.Spittle;
import chapter5.data.ISpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/24.
 */
@Repository
public class SpittleRepositoryImpl implements ISpittleRepository {

    private JdbcOperations jdbcOperations;

    @Autowired
    public SpittleRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Spittle> findRecentSpittles() {
        return jdbcOperations.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper());
    }

    public List<Spittle> findSpittles(long max, int count) {
        return jdbcOperations.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where id < ?" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper(), max);
    }

    public Spittle findOne(long id) {
        return jdbcOperations.queryForObject(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where id = ?",
                new SpittleRowMapper(), id);
    }

    public void save(Spittle spittle) {
        jdbcOperations.update(
                "insert into Spittle (message, created_at, latitude, longitude)" +
                        " values (?, ?, ?, ?)",
                spittle.getMessage(),
                spittle.getTime(),
                spittle.getLatitude(),
                spittle.getLongitude());
    }

    private static class SpittleRowMapper implements RowMapper<Spittle>{
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException{
            return new Spittle(
                    rs.getLong("id"),
                    rs.getString("message"),
                    rs.getDate("created_at"),
                    rs.getDouble("longitude"),
                    rs.getDouble("latitude"));
        }
    }
}
