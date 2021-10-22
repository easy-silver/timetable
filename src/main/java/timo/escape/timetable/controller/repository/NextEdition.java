package timo.escape.timetable.controller.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NextEdition {

    NEGN1("넥스트에디션", "강남점", "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam"),
    NEGN2("넥스트에디션", "강남2호점", "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam2"),
    NEGN3("넥스트에디션", "강남3호점", "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam3"),
    NEGN4("넥스트에디션", "강남신논현점", "https://www.nextedition.co.kr/shops/Nextedition%20gangnamsinnonhyun"),
    NEGN5("넥스트에디션", "강남5호점", "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam5");

    private String shopName;
    private String branchName;
    private String link;
}
