package timo.escape.timetable.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timo.escape.timetable.controller.repository.NextEditionRepository;
import timo.escape.timetable.model.BranchInfo;
import timo.escape.timetable.model.ShopInfo;
import timo.escape.timetable.model.domain.NextEdition;
import timo.escape.timetable.model.domain.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GangnamService {

    private final NextEditionRepository nextEditionRepository;

    public List<Shop> getShopListInGangnam() {
        return Arrays.stream(Shop.values()).filter(s -> s.isExistInGangnam()).collect(Collectors.toList());
    }

    /**
     * 해당 매장의 지점 조회
     *
     * @param shop
     * @return
     */
    public List<BranchInfo> getBranchListInGangnam(Shop shop) {
        List<BranchInfo> branchInfos = new ArrayList<>();

        switch (shop) {
            case NEXTEDITION:
                for (NextEdition branch : NextEdition.values()) {
                    if (branch.getArea().equals("GN")) {
                        branchInfos.add(new BranchInfo(branch.getBranchName(), branch.getLink()));
                    }
                }
                break;
            default:
                break;
        }

        return branchInfos;
    }

    public List<ShopInfo> getTimetableOfNextEdition() {

        return nextEditionRepository.getShopInfoList();
    }

}
