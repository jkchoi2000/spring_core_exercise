package mine.jkchoi.springcoreexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreExerciseApplication {

    public static void main(String[] args) {
        //WebServer를 실행 시키지 않고, 동작 후 종료
        SpringApplication app = new SpringApplication(SpringCoreExerciseApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);

        //WebServer 실행
        //SpringApplication.run(SpringCoreExerciseApplication.class, args);
    }

}
