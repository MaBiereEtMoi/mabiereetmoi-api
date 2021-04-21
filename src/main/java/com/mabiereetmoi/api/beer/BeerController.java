package com.mabiereetmoi.api.beer;

import com.mabiereetmoi.api.barcode.BarCode;
import com.mabiereetmoi.api.barcode.BarCodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;
    private final BarCodeService barCodeService;

    @PostMapping
    public Beer saveBeer(@RequestBody Beer beer){
        return beerService.save(beer);
    }

    @PostMapping("/{barcode}")
    public ResponseEntity<Beer> saveBeerWithBarcode(@PathVariable("barcode") String barcode, @RequestBody Beer beer) {
        Beer beerSave = beerService.save(beer);
        if (barcode != null) {
            BarCode barCode = new BarCode(barcode, beerSave);
            barCodeService.saveBarcode(barCode);
        }
        return ResponseEntity.ok(beerSave);
    }

    @GetMapping("/{id}")
    public Beer getBeerByid(@PathVariable Long id){
        return beerService.findById(id);
    }

    @GetMapping
    @CrossOrigin
    public List<Beer> getAllBeers(){
        return beerService.findAll();
    }
}
