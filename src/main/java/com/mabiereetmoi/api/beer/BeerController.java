package com.mabiereetmoi.api.beer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;

    @PostMapping
    public Beer saveBeer(@RequestBody Beer beer){
        return beerService.save(beer);
    }

    @GetMapping("/{id}")
    public Beer getBeerByid(@PathVariable Long id){
        return beerService.findById(id);
    }
}
