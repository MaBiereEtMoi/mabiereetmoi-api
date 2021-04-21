package com.mabiereetmoi.api.barcode;

import com.mabiereetmoi.api.beer.Beer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BarCodeService {

    private final BarCodeRepository barCodeRepository;

    public Beer getBeerByBarCode(String barCode){
        return barCodeRepository.findById(barCode).get().getBeer();
    }

    public BarCode saveBarcode(BarCode barCode) {
        return barCodeRepository.save(barCode);
    }
}
