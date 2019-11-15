package mine.jkchoi.springcoreexercise;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * Spring 5에 추가된 null 관련 Annotation
 * @NonNull, @Nullable, @NonNullApi (패키지 레벨 설정), @NonNullFields (패키지 레벨 설정)
 *
 * 목적
 * - (툴의 지원을 받아) 컴파일 시점에 최대한 NullPointException 을 방지
 * - Reactor or Spring Data에서 사
 */
@Service
public class EventService {

    @NonNull
    public String createEvent(@NonNull String name) {
        return "hello " + name;
    }
}
