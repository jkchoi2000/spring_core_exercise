package mine.jkchoi.springcoreexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class ValidationAppRunner implements ApplicationRunner {

    //SpringBoot 2.0.5 이상에서는 LocalValidatorFactoryBean 빈으로 자동 등록
    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(validator.getClass()); // org.springframework.validation.beanvalidation.LocalValidatorFactoryBean


        Event event = new Event();
        event.setLimit(-1);
        event.setEmail("jkchoi");
        Errors errors = new BeanPropertyBindingResult(event, "event");

        //과거 직접 구현한 Validator 호출
        EventValidator evnetValidator = new EventValidator();
        //evnetValidator.validate(event, errors);

        //Spring 지원 LocalValidatorFactoryBean
        validator.validate(event, errors);

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("======== Error Code ========");

            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });



    }
}
