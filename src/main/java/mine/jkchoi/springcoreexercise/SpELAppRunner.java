package mine.jkchoi.springcoreexercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

/**
 * SpEL
 * - #{"표현식"} : 표현식을 실행을 하고 결과 값을 속성에 대입
 * - ${"프로퍼티"} :
 * - 표현식은 프로퍼티를 가질 수 있지만, 반대는 불가
 *    - #{${my.data} + 1}
 *
 * SpEL 구성
 * ExpressionParser parser = new SpelExpressionParser()
 * StandardEvaluationContext context = new StandardEvaluationContext(bean)
 * Expression expression = parser.parseExpression("SpEL 표현식")
 * String value = expression.getValue(context, String.class)
 */
@Component
public class SpELAppRunner implements ApplicationRunner {

    @Value("#{1+1}")
    int plusVal;

    @Value("#{'hello' + 'world'}")
    String greeting;

    @Value("hello")
    String hello;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("${my.value}")
    int myValue;

    @Value("#{${my.value} eq 100}")
    boolean isMyValue100;

    @Value("#{'spring'}")
    String spring;

    //Bean의 속성 값
    @Value("#{sample.data}")
    int sampleData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=====================") ;
        System.out.println(plusVal);
        System.out.println(greeting);
        System.out.println(hello);
        System.out.println(trueOrFalse);
        System.out.println(myValue);
        System.out.println(isMyValue100);
        System.out.println(spring);
        System.out.println(sampleData);

        //코드로 SpEL 사용 방법
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2 + 100");
        Integer value = expression.getValue(Integer.class);
        System.out.println(value);

    }
}
