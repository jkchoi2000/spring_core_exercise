package mine.jkchoi.springcoreexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreExerciseApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringCoreExerciseApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);

        app.run(args);

        //SpringApplication.run(SpringCoreExerciseApplication.class, args);
    }

}
