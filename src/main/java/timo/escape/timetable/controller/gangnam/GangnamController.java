package timo.escape.timetable.controller.gangnam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import timo.escape.timetable.model.BranchInfo;
import timo.escape.timetable.model.ShopInfo;
import timo.escape.timetable.model.domain.Shop;
import timo.escape.timetable.service.GangnamService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/gangnam")
@Controller
public class GangnamController {

    private final GangnamService service;

    /**
     * 강남에 위치한 방탈출 매장 목록 조회
     *
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("shops", service.getShopListInGangnam());

        return "/gangnam/index";
    }

    /**
     * 넥스트 에디션의 강남내 지점 목록 조회
     *
     * @param model
     * @return
     */
    @GetMapping("/{shopUrl}")
    public String nextEdition(@PathVariable String shopUrl, Model model) {

        Shop shop = null;
        for (Shop temp : Shop.values()) {
            if (shopUrl.equals(temp.getUrl())) {
                shop = temp;
            }
        }

        List<BranchInfo> branchInfoList = service.getBranchListInGangnam(shop);
        model.addAttribute("shopName", shop.getName());
        model.addAttribute("branches", branchInfoList);

        return "/gangnam/branches";
    }

    @GetMapping("/secret-garden")
    public String secretGarden() {
        return "/gangnam/secret-garden";
    }
}
