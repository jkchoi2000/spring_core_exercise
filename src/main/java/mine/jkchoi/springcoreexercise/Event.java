package mine.jkchoi.springcoreexercise;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//SpringBoot 2.0.5 이상에서 빈으로 등록하는 LocalValidatorFactoryBean 을 사용하는 경우 Annotation으로 설정
public class Event {
    int id;

    @NotEmpty
    String title;

    //@Size(min = 0) //Collection의 Size 검사
    @Min(0)
    Integer limit;

    @Email
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
