package timo.escape.timetable.controller.repository;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;
import timo.escape.timetable.model.ShopInfo;
import timo.escape.timetable.model.ThemeInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NextEditionRepository {

    public List<ShopInfo> getShopInfoList() {
        List<ShopInfo> availableShops = new ArrayList<>();

        //넥스트에디션 모든 강남 매장
        for (NextEdition shop : NextEdition.values()){
            ShopInfo shopInfo = new ShopInfo();
            shopInfo.setName(shop.getShopName());
            shopInfo.setBranchName(shop.getBranchName());

            final String url = shop.getLink();
            Connection connection = Jsoup.connect(url);
            List<ThemeInfo> themes = new ArrayList<>();
            try {
                Document document = connection.get();
                Elements themeElements = document.getElementsByClass("white-page-content");
                for (Element theme : themeElements) {
                    ThemeInfo themeInfo = new ThemeInfo();

                    //제목
                    Elements title = theme.getElementsByTag("h2");
                    themeInfo.setTitle(title.size() > 0 ? title.get(0).text() : "");

                    //시간
                    Elements timeElements = theme.getElementsByClass("res-true");
                    List<String> availableTimes = timeElements
                            .stream()
                            //.filter(e -> e.getElementsByTag("span").get(1).text().equals("예약가능"))
                            .map(e -> e.getElementsByTag("span").get(0).text())
                            .collect(Collectors.toList());

                    themeInfo.setAvailableTimes(availableTimes);
                    if(availableTimes.size() > 0) themes.add(themeInfo);
                }

                if (themes.size() > 0) {
                    shopInfo.setThemeInfos(themes);
                    availableShops.add(shopInfo);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return availableShops;
    }
}
