package com.mabiereetmoi.api.barcode;

import com.mabiereetmoi.api.beer.Beer;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bar_code")
public class BarCode {
    @Id
    private String barCode;


    @ManyToOne(cascade = CascadeType.ALL)
    private Beer beer;
}
