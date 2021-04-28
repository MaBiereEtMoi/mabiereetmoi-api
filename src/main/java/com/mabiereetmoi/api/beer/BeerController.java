package com.mabiereetmoi.api.beer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;
    private final BeerConverter beerConverter;

    @PostMapping
    public Beer saveBeer(@RequestBody Beer beer){
        return beerService.save(beer);
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
