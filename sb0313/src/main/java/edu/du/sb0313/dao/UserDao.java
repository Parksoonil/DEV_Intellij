package edu.du.sb0313.dao;

import edu.du.sb0313.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int addUser(Users user) {
        String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,user.getUsername(),user.getEmail(),user.getPassword());
    }
    public Users getUserById(Long id) {
        String sql = "SELECT id, username, email, password create_at, update_at FROM" +
                " users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, userRowMapper());
    }
    public Users getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper());
    }
    public List<Users> getAllUsers() {
        String sql = "SELECT id, username, email, password, created_at, updated_at FROM users";
        return jdbcTemplate.query(sql, userRowMapper());
    }
    public int deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
    public int updateUser(Users user) {
        String sql = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getId());
    }
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
    }
    private RowMapper<Users> userRowMapper() {
        return (rs, rowNum) -> {
            Users user = new Users();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setCreateAt(rs.getTimestamp("created_at").toLocalDateTime());
            user.setUpdateAt(rs.getTimestamp("updated_at").toLocalDateTime());
            return user;
        };
    }

}
