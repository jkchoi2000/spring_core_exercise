package mine.jkchoi.springcoreexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class ConversionAppRunner implements ApplicationRunner {

    /**
     * WebConversionService
     * - ConversionService, ConvertRegistry, FormatterRegistry를 상속받은 DefaultFormmattingConversionService를 상속
     * - Formatter와 Converter 빈을 찾아 자동으로 등록해 준다.
     * - 실재로 아래처럼 직접 사용할 일은 거의의 없
     */
    @Autowired
    ConversionService conversionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //등록되어있는 Converter를 모두 확인이 가능하다.
        System.out.println(conversionService);

        //org.springframework.boot.autoconfigure.web.format.WebConversionService
        System.out.println(conversionService.getClass().toString());

    }
}
