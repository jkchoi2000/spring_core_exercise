package mine.jkchoi.springcoreexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NullSafetyAppRunner implements ApplicationRunner {
    @Autowired
    EventService eventService;

    /*
     * 경고 표시를 해주기 위해서는 intelliJ의 설정이 필요하다.
     * Preference > Build, Excution, Deployment > Compiler > Add runtime assertion ... 에 추가 후 재시작 필요
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent(null);
    }
}
