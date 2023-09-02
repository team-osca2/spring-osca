package com.app.osca.service.ceo;

import com.app.osca.domain.StateEnum;
import com.app.osca.domain.dto.ceo.CeoDTO;

import java.util.Optional;

public interface CeoService {

   public void joinPoint(Long memberId, boolean isFirstAccount);

   public StateEnum usePoint(CeoDTO ceoDTO);

   public Optional<Integer> getPoint(Long memberId);

}
