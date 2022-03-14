package com.codeup.kidsrewardscapstone;

import com.codeup.kidsrewardscapstone.controllers.IndexController;
import com.codeup.kidsrewardscapstone.models.Status;
import com.codeup.kidsrewardscapstone.repositories.StatusRepository;
import com.codeup.kidsrewardscapstone.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
//@ComponentScan(basePackageClasses= IndexController.class)

public class KidsRewardsCapstoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(KidsRewardsCapstoneApplication.class, args);

}
        }



