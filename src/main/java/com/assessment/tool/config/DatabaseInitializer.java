package com.assessment.tool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            jdbcTemplate.execute("ALTER TABLE notes MODIFY COLUMN file_url LONGTEXT");
            System.out.println("✅ ALTER TABLE notes file_url to LONGTEXT executed successfully.");
        } catch (Exception e) {
            System.out.println("Note file_url column alter notice: " + e.getMessage());
        }

        try {
            jdbcTemplate.execute("ALTER TABLE notes MODIFY COLUMN content LONGTEXT");
            System.out.println("✅ ALTER TABLE notes content to LONGTEXT executed successfully.");
        } catch (Exception e) {
            System.out.println("Note content column alter notice: " + e.getMessage());
        }

        try {
            jdbcTemplate.execute("ALTER TABLE notes MODIFY COLUMN file_name VARCHAR(500)");
            System.out.println("✅ ALTER TABLE notes file_name to VARCHAR(500) executed successfully.");
        } catch (Exception e) {
            System.out.println("Note file_name column alter notice: " + e.getMessage());
        }
    }
}
