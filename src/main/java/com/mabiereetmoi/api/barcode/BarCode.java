package com.mabiereetmoi.api.barcode;

import com.mabiereetmoi.api.beer.Beer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bar_code")
public class BarCode {

    @Id
    private String barCode;


    @ManyToOne(cascade = CascadeType.ALL)
    private Beer beer;
}
