package com.app.osca.service.cafeAd;

import com.app.osca.dao.CafeAdDAO;
import com.app.osca.dao.CeoDAO;
import com.app.osca.dao.TicketPurchaseDAO;
import com.app.osca.domain.StateEnum;
import com.app.osca.domain.dto.cafeAd.CafeAdDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdImagesDTO;
import com.app.osca.domain.dto.ticket.TicketDTO;
import com.app.osca.domain.paging.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CafeAdServiceImpl implements CafeAdService {

    final private CafeAdDAO cafeAdDAO;
    final private TicketPurchaseDAO ticketPurchaseDAO;
    final private CeoDAO ceoDAO;

    @Override
    public Optional<CafeAdDetailDTO> getOneCafeAd(Long id) {
        final Optional<CafeAdDetailDTO> foundCafeAd = cafeAdDAO.findCafeAndCafeAdById(id);
        foundCafeAd.ifPresent(cafeAdDetailDTO -> cafeAdDetailDTO.setCafeImages(null));
        return foundCafeAd;
    }

    @Override
    public List<CafeAdImagesDTO> getCafeAdList(Criteria criteria) {
        return null;
    }

    @Override
    public List<CafeAdDTO> getMyCafeAdList(Long memberId, Integer blocked) {
        return cafeAdDAO.findAllByMemberIdAndBlockedIsOrderByCafeAdDeadlineDateOrderById(memberId, blocked);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public StateEnum updateDeadLineDate(TicketDTO ticketDTO) {
        boolean adUpdateState = cafeAdDAO.modify(ticketDTO.toCafeAdUpdateDTO()) == StateEnum.SUCCESS;
        boolean ticketPurchaseState = ticketPurchaseDAO.save(ticketDTO.toTicketPurchaseDTO()) == StateEnum.SUCCESS;
        boolean ceoPointUpdateState = ceoDAO.modify(ticketDTO.toCeoDTO()) == StateEnum.SUCCESS;
        return (adUpdateState && ticketPurchaseState && ceoPointUpdateState) ? StateEnum.SUCCESS : StateEnum.FAIL;
    }
}
