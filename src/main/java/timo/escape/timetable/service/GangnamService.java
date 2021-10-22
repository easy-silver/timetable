package timo.escape.timetable.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timo.escape.timetable.controller.repository.NextEditionRepository;
import timo.escape.timetable.model.ShopInfo;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GangnamService {

    private final NextEditionRepository nextEditionRepository;

    public List<ShopInfo> getTimetableOfNextEdition() {

        return nextEditionRepository.getShopInfoList();
    }
}
