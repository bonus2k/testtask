package com.space.dao;

import com.space.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DAOController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DAOController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Ship> index(){
        return jdbcTemplate.query("SELECT * FROM ship", new BeanPropertyRowMapper<>(Ship.class));
    }


    public Ship show(Long id) {
        return jdbcTemplate.query("SELECT * FROM ship WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Ship.class)).get(0);
    }

    public Ship update(Ship ship, Long id) {
        jdbcTemplate.update("UPDATE ship SET " +
                "name=?, planet=?, shipType=?, prodDate=?, isUsed=?, speed=?, crewSize=?," +
                "rating=? WHERE id=?",
                ship.getName(), ship.getPlanet(), ship.getShipType().toString(), ship.getProdDate(), ship.getUsed(),
                ship.getSpeed(), ship.getCrewSize(), ship.countRating(), id);

        return jdbcTemplate.query("SELECT * FROM ship WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Ship.class)).get(0);
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM ship WHERE id=?", new Object[]{id});
    }
}
