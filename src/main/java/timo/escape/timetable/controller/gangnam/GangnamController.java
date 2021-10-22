package timo.escape.timetable.controller.gangnam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import timo.escape.timetable.model.ShopInfo;
import timo.escape.timetable.service.GangnamService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/gangnam")
@Controller
public class GangnamController {

    private final GangnamService service;

    @GetMapping("")
    public String index() {
        return "/gangnam/index";
    }

    @GetMapping("/next-edition")
    public String nextEdition(Model model) {

        List<ShopInfo> shopInfoList = service.getTimetableOfNextEdition();
        model.addAttribute("shops", shopInfoList);

        return "/gangnam/next-edition";
    }

    @GetMapping("/secret-garden")
    public String secretGarden() {
        return "/gangnam/secret-garden";
    }
}
