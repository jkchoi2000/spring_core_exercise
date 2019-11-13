package mine.jkchoi.springcoreexercise;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//복잡한 검증이 필요한 경우에 Validator 인터페이스를 구현하에 검증
//간단한 경우에는 SpringBoot 에서 제공하는 LocalValidatorFactoryBean을 사용하기 위해서 Annotation으로 검증 가능
public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // 방법 1
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "Empty title is not allow");

        // 방법 2
        Event event = (Event)o;
        if(event.getTitle() == null) {
            errors.reject("TEST");
        }
    }

}
