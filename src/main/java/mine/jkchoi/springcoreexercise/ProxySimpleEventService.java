package mine.jkchoi.springcoreexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 아래와 같이 Proxy Class를 직접 구현하는 경우 발생하는 문제를 막기위해 AOP(Aspect Oriented Programming) 등장
 * - Spring IoC 컨테이너가 제공하는 기반 시설과 Dynamic 프록시를 사용하여 여러 복잡한 문제 해결
 * - 동적 프록시 : 동적으로 프록시 객체 생성하는 방법
 *   - 자바가 제공하는 방법은 인터페이스 기반 프록시 생성
 *   - CGlib은 클래스 기반 프록시 지원
 * - 스프링 IoC : 기존 빈을 대체하는 동적 프록시 빈을 만들어 등록 시켜준다.
 *   - 클라이언트 코드 변경 없음
 *   - AbstractAutoProxyCreator implements BeanPostProcessor
 */
//@Service //Spring AOP 확인을 위해 주석 처리
//@Primary //Spring AOP 확인을 위해 주석 처리
public class ProxySimpleEventService implements EventService {

    @Autowired
    SimpleEventService simpleEventService;

    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis();

        simpleEventService.createEvent();

        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void publishEvent() {
        long begin = System.currentTimeMillis();

        simpleEventService.publishEvent();

        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();
    }
}
