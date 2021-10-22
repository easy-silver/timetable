package timo.escape.timetable.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopInfo {

    private String name;
    private String branchName;
    private List<ThemeInfo> themeInfos = new ArrayList<>();
}
