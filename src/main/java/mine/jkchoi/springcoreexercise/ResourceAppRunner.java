package mine.jkchoi.springcoreexercise;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class ResourceAppRunner implements ApplicationRunner {

    @Autowired
    //ResourceLoader resourceLoader;
    ApplicationContext resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //과거에 ApplicationContext를 생성 시에 사용한 방법 (리소스를 사용하였다.)
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("aaaa.xml");
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("aaa.xml");

        //Resource 의 종류
        //1. ApplicationContext의 종류에 따라서 리소스의 종류도 결정
        //  ClassPathResource <= ClassPathXmlApplicationContext
        //  FileSystemResource <= FileSystemXmlApplicationContext
        //  ServletContextResource <= WebApplicationContext (interface) : GenericWebApplicationContext 많이 사용
        //    - 웹 애플리케이션 루트에서 상대 경로로 리소스를 찾는다.
        //2. [추천] ApplicationContext의 타입에 상관없이 리소스 타입을 강제하려면 java.net.URL 접두어(http, https, ftp, file, jar) + clsspath 중 하나를 사용
        //  ClassPathResource <= classpath:mine/jkchoi/config.xml
        //  FileSystemResource <= file:///some/resource/path/config.xml (root path에서 읽으려면 /// 3개로 시작)

        System.out.println(resourceLoader.getClass()); //o.s.b.w.s.c.AnnotationConfigServletWebServerApplicationContext

        //Resource resource = resourceLoader.getResource("classpath:text.txt");  //org.springframework.core.io.ClassPathResource
        Resource resource = resourceLoader.getResource("text.txt"); //org.springframework.web.context.support.ServletContextResource
        System.out.println(resource.getClass());
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());
    }
}
