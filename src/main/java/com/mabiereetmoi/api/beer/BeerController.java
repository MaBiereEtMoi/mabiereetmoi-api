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
    private final BeerConverter beerConverter;

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
    public ResponseEntity<BeerDto> getBeerByid(@PathVariable Long id) throws BeerNotFoundException {
        return ResponseEntity.ok(beerConverter.entityToDto(beerService.findById(id)));
    }

    @GetMapping
    @CrossOrigin
    public List<BeerDto> getAllBeers(){
        return beerConverter.listEntityToDto(beerService.findAll());
    }
}
