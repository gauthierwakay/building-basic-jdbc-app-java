package io.nspai;

import io.nspai.dao.DAO;
import io.nspai.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BuildingJdbcSpringbootApplication {

    private static DAO<Course> dao;

    public BuildingJdbcSpringbootApplication(DAO<Course> dao) {
        this.dao =dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(BuildingJdbcSpringbootApplication.class, args);

        System.out.println("\n Create Courses -------------------------------- \n");
        Course springVue = new Course("Spring Boot + vue", "New Course", "https://www.testcourse.dev");
        dao.create(springVue);

        System.out.println("\n One Course -------------------------------- \n");
        Optional<Course> firstOne = dao.get(1);
        System.out.println(firstOne.get());

        System.out.println("\n Update Course-------------------------------- \n");
        springVue.setDescription("Learn to Build Vue apps that talk to Spring Boot ");
        dao.update(springVue, 6);

        dao.delete(4);

        System.out.println("\n All Courses -------------------------------- \n");
        List<Course> courses = dao.list();
        courses.forEach(System.out::println);
    }

}
