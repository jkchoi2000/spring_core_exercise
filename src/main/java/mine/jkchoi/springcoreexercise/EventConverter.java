package mine.jkchoi.springcoreexercise;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Converter<S, T>
 * - S 타입을 T 타입으로 변환할 수 있는 매우 일반적인 변환기
 * - 상태 정보 없음(Stateless) 쓰레드 세이프
 * - ConverterRegistry에 등록해서 사용
 */
public class EventConverter {

    //Bean으로 등록하여 사용 가능 (DefaultFormmattingConversionService 가 자동 등록)
    //@Component
    public static class StringToEventConverter implements Converter<String, Event> {
        @Override
        public Event convert(String s) {
            return new Event(Integer.parseInt(s));
        }
    }

    //Bean으로 등록하여 사용 가능 (DefaultFormmattingConversionService 가 자동 등록)
    //@Component
    public static class EventToStringConverter implements Converter<Event, String> {
        @Override
        public String convert(Event event) {
            return event.getId().toString();
        }
    }
}
