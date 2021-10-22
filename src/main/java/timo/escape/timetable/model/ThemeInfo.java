package timo.escape.timetable.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ThemeInfo {

    private String title;

    private List<String> times = new ArrayList<>();

    private List<String> availableTimes = new ArrayList<>();

    public void addTime(String time) {
        if (StringUtils.hasText(time)) {
            this.times.add(time);
        }
    }

    public void addAvailableTime(String time) {
        if (StringUtils.hasText(time)) {
            this.availableTimes.add(time);
        }
    }
}
