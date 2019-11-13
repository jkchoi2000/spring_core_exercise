package mine.jkchoi.springcoreexercise;

import java.beans.PropertyEditorSupport;

// PropertyEditor : Spring 3.0 이전까지 DataBinder가 변환 작업에 사용하던 인터페이스
// Thread Safe 하지 않기 때문에 Singleton Bean으로 등록해서 사용하면 안됨.
// Object 와 String 간의 변환만 지원
public class EventEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Event event = (Event)getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
