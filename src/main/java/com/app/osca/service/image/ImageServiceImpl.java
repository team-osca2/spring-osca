package com.app.osca.service.image;

import com.app.osca.dao.ImageDAO;
import com.app.osca.domain.ImageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    final private ImageDAO imageDAO;

    @Override
    public void join(ImageVO imageVO) {
        imageDAO.save(imageVO);
    }
}
