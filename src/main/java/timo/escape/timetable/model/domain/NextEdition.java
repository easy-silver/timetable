package timo.escape.timetable.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NextEdition {

    GN1("넥스트에디션", "GN","강남점", "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam"),
    GN2("넥스트에디션", "GN","강남2호점", "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam2"),
    GN3("넥스트에디션", "GN","강남3호점", "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam3"),
    GN4("넥스트에디션", "GN","강남신논현점", "https://www.nextedition.co.kr/shops/Nextedition%20gangnamsinnonhyun"),
    GN5("넥스트에디션", "GN","강남5호점", "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam5");

    private String shopName;
    private String area;
    private String branchName;
    private String link;
}
