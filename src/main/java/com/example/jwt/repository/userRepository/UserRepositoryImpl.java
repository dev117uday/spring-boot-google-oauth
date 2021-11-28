package com.example.jwt.repository.userRepository;

import com.example.jwt.model.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO public.oauthuser(sub, email) VALUES (?, ?) on conflict do nothing;";
        jdbcTemplate.update(sql, user.getSub(), user.getEmail());
    }

}
