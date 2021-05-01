package com.mabiereetmoi.api.barcode;

import com.mabiereetmoi.api.beer.Beer;
import com.mabiereetmoi.api.beer.BeerConverter;
import com.mabiereetmoi.api.beer.BeerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/barcode")
public class BarCodeController {

    private final BarCodeService barCodeService;
    private final BeerConverter beerConverter;

    @PostMapping
    public ResponseEntity<BarCode> saveBarcode(@RequestBody BarCode barCode) {
        return ResponseEntity.ok(barCodeService.saveBarcode(barCode));
    }

    @GetMapping("/{barCode}")
    @CrossOrigin
    public BeerDto getBeerByBarcode(@PathVariable String barCode){
        return beerConverter.entityToDto(barCodeService.getBeerByBarCode(barCode));
    }
}
