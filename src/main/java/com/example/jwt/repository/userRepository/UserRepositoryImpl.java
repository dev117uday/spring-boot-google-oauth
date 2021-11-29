package com.example.jwt.repository.userRepository;

import com.example.jwt.model.User;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insertUser(User user, String userName) {

        String sql = "INSERT INTO public.oauthuser(sub, email, name) VALUES (?, ?, ?) on conflict do nothing;";

        try {
            jdbcTemplate.update(sql, user.getSub(), user.getEmail(), userName);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

}
