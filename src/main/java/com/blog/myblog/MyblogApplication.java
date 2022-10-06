package com.blog.myblog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MyblogApplication {

//    @Bean
//    public PasswordEncorder passwordEncorder(){
//        return new BCryptPasswordEncorder;
//    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }



//    @GetMapping
//    Customer getCustomer(){
//        return new Customer(23L, "Dennis");
//    }
//
//    class Customer{
//
//        private final Long id;
//        private final String name;
//
//        Customer(Long id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//    }


}



