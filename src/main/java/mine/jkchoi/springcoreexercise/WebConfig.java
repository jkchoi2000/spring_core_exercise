package mine.jkchoi.springcoreexercise;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //Converter 등록
        //registry.addConverter(new EventConverter.StringToEventConverter());

        //Formatter 등록
        //registry.addFormatter(new EventFormatter());
    }
}
