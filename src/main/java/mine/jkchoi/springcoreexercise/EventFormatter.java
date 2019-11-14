package mine.jkchoi.springcoreexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Formatter
 * - PropertyEditor 대체제
 * - Object 와 String 간의 변형을 담당
 * - 문자열의 Locale에 따라서 다국화하는 기능도 제공한다. (Optional)
 * - FormatterRegistry에 등록해서 사용
 */
//Bean으로 등록하여 사용 가능 (DefaultFormmattingConversionService 가 자동 등록)
@Component
public class EventFormatter implements Formatter<Event> {

//    @Autowired
//    MessageSource messageSource; //ApplicationContext

    @Override
    public Event parse(String s, Locale locale) throws ParseException {
        return new Event(Integer.parseInt(s));
    }

    @Override
    public String print(Event event, Locale locale) {
        //아래와 같이 Locale에 따른 Message를 가져와서 사용할 수 있다.
        //String localeString = messageSource.getMessage("title", locale);

        return event.getId().toString();
    }
}
