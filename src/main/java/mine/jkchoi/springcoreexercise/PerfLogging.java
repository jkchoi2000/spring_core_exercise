package mine.jkchoi.springcoreexercise;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS) //Default : Class 파일까지 Annotation 정보 유지
//@Retention(RetentionPolicy.SOURCE) //Source 파일까지 Annotation 정보 유지
//@Retention(RetentionPolicy.RUNTIME) //실행 시간까지 Annotation 정보 유지
@Target(ElementType.METHOD)
@Documented //Javadoc 생성 시, 문서화 되도
public @interface PerfLogging {
}
