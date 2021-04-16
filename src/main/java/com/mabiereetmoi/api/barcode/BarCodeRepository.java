package com.mabiereetmoi.api.barcode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BarCodeRepository extends CrudRepository<BarCode,String> {
}
