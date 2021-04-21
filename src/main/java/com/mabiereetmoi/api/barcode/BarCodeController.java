package com.mabiereetmoi.api.barcode;

import com.mabiereetmoi.api.beer.Beer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/barcode")
public class BarCodeController {

    private final BarCodeService barCodeService;

    @PostMapping
    public ResponseEntity<BarCode> saveBarcode(@RequestBody BarCode barCode) {
        return ResponseEntity.ok(barCodeService.saveBarcode(barCode));
    }

    @GetMapping("/{barCode}")
    @CrossOrigin
    public Beer getBeerByBarcode(@PathVariable String barCode){
        return barCodeService.getBeerByBarCode(barCode);
    }
}
