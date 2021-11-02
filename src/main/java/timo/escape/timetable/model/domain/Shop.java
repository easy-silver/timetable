package timo.escape.timetable.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Shop {

    NEXTEDITION("넥스트에디션", "next-edition", true),
    SECRETGARDEN("비밀의화원", "secret-garden", true),
    KEYESCAPE("키이스케이프", "key-escape", true),
    ZEROWORLD("제로월드", "zero-world",true),
    QUESTIONMARK("퀘스천마크", "question-mark", false);

    private String name;
    private String url;
    private boolean existInGangnam;

}
