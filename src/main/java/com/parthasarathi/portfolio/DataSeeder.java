package com.parthasarathi.portfolio;

import com.parthasarathi.portfolio.Models.*;
import com.parthasarathi.portfolio.Repos.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/** Runs on startup: creates the admin login and starter content if the database is empty. */
@Component
public class DataSeeder implements CommandLineRunner {
    private final UserRepo users;
    private final AboutRepo about;
    private final SkillRepo skills;
    private final PasswordEncoder encoder;
    @Value("${app.admin.username}") private String adminUser;
    @Value("${app.admin.password}") private String adminPass;

    public DataSeeder(UserRepo users, AboutRepo about, SkillRepo skills, PasswordEncoder encoder) {
        this.users = users; this.about = about; this.skills = skills; this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        if (users.count() == 0) {
            User u = new User();
            u.username = adminUser;
            u.passwordHash = encoder.encode(adminPass);
            users.save(u);
            System.out.println(">>> Admin created. Username: " + adminUser + "  (change the password before deploying!)");
        }
        if (about.count() == 0) {
            About a = new About();
            a.fullName = "Parthasarathi Bala";
            a.title = "BTech Student at SOA University";
            a.cgpa = 7.6;
            a.bio = "I'm a BTech student at Siksha 'O' Anusandhan University in Bhubaneswar. I enjoy solving problems with code and maths and building practical web applications.";
            about.save(a);
        }
        if (skills.count() == 0) {
            addSkill("Java", "Backend", 85, 1);
            addSkill("Spring Boot", "Backend", 80, 2);
            addSkill("PostgreSQL", "Database", 75, 3);
            addSkill("React", "Frontend", 75, 4);
            addSkill("REST APIs", "Backend", 80, 5);
        }
    }

    private void addSkill(String name, String category, int level, int order) {
        Skill s = new Skill();
        s.name = name; s.category = category; s.proficiency = level; s.displayOrder = order;
        skills.save(s);
    }
}
