package com.example.crowdfunding.config;

import com.example.crowdfunding.model.Project;
import com.example.crowdfunding.model.Role;
import com.example.crowdfunding.model.User;
import com.example.crowdfunding.repository.ProjectRepository;
import com.example.crowdfunding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByEmail("admin@example.com")) {
            User admin = new User(
                "Admin User",
                "admin@example.com",
                passwordEncoder.encode("password"),
                Role.ROLE_ADMIN
            );
            userRepository.save(admin);

            Project project1 = new Project(
                "Smart Water Bottle",
                "A revolutionary water bottle that tracks your hydration levels and reminds you to drink water.",
                "https://images.unsplash.com/photo-1523362628745-0c100150b504?w=400",
                new BigDecimal("50000"),
                LocalDate.now().plusDays(30),
                admin
            );

            Project project2 = new Project(
                "Eco-Friendly Packaging",
                "Biodegradable packaging solution to reduce plastic waste in e-commerce.",
                "https://images.unsplash.com/photo-1542601906990-b4d3fb778b09?w=400",
                new BigDecimal("25000"),
                LocalDate.now().plusDays(45),
                admin
            );

            Project project3 = new Project(
                "Community Garden App",
                "Mobile app connecting urban gardeners to share resources and knowledge.",
                "https://images.unsplash.com/photo-1416879595882-3373a0480b5b?w=400",
                new BigDecimal("15000"),
                LocalDate.now().plusDays(60),
                admin
            );

            project1.setCollectedAmount(new BigDecimal("12500"));
            project2.setCollectedAmount(new BigDecimal("8000"));
            project3.setCollectedAmount(new BigDecimal("3500"));

            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);

            Project p4 = new Project(
                "Solar-Powered Rural Lighting",
                "Deploy solar lanterns in off-grid Indian villages to replace kerosene and improve safety for children studying at night.",
                "https://images.unsplash.com/photo-1509395062183-67c5ad6faff9?auto=format&fit=crop&w=800&q=60",
                new BigDecimal("150000"),
                LocalDate.now().plusMonths(3),
                null
            );

            Project p5 = new Project(
                "Community Rainwater Harvesting Tank",
                "Build a 50,000-litre rainwater harvesting system so the village of Mahabalipuram has clean water year-round.",
                "https://images.unsplash.com/photo-1521540216272-a50305cd4421?auto=format&fit=crop&w=800&q=60",
                new BigDecimal("200000"),
                LocalDate.now().plusMonths(2),
                null
            );

            Project p6 = new Project(
                "Recycled-Plastic 3D-Printed Prosthetics",
                "Turn plastic waste into low-cost 3D-printed prosthetic limbs for underserved amputees.",
                "https://images.unsplash.com/photo-1581091870622-6c79b28d61b6?auto=format&fit=crop&w=800&q=60",
                new BigDecimal("500000"),
                LocalDate.now().plusMonths(4),
                null
            );

            Project p7 = new Project(
                "Organic Urban Rooftop Farming",
                "Convert unused Chennai rooftops into organic vegetable gardens, providing fresh produce and local jobs.",
                "https://images.unsplash.com/photo-1460518451285-97b6aa326961?auto=format&fit=crop&w=800&q=60",
                new BigDecimal("120000"),
                LocalDate.now().plusMonths(3),
                null
            );

            Project p8 = new Project(
                "Open-Source Braille eBook Reader",
                "Develop an affordable, open-source refreshable braille reader so visually-impaired students can access digital books.",
                "https://images.unsplash.com/photo-1564866657311-e9cc905d29d2?auto=format&fit=crop&w=800&q=60",
                new BigDecimal("350000"),
                LocalDate.now().plusMonths(5),
                null
            );

            Project p9 = new Project(
                "AI-Powered Crop Disease Detection",
                "Build a smartphone app that uses AI to detect crop diseases early, reducing farmer losses.",
                "https://images.unsplash.com/photo-1584447093335-da7cec3079e2?auto=format&fit=crop&w=800&q=60",
                new BigDecimal("250000"),
                LocalDate.now().plusMonths(4),
                null
            );

            Project p10 = new Project(
                "Medical Aid for Stray Dogs",
                "Raising funds to treat, vaccinate, and feed injured stray dogs in the city.",
                "https://images.unsplash.com/photo-1601758123927-1965c7c7d7b6?auto=format&fit=crop&w=800&q=60",
                new BigDecimal("30000"),
                LocalDate.now().plusMonths(1),
                null
            );

            projectRepository.saveAll(java.util.List.of(p4, p5, p6, p7, p8, p9, p10));

            System.out.println("Sample data loaded successfully!");
        }
    }
}
