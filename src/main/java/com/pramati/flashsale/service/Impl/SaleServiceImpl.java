package com.pramati.flashsale.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.flashsale.beans.Sale;
import com.pramati.flashsale.model.SaleDO;
import com.pramati.flashsale.repository.SaleRepository;
import com.pramati.flashsale.service.SaleService;
import com.pramati.flashsale.util.ApplicationException;

/**
 * @author sudhirk
 *
 * Service implementation class for the entity Sale
 */
@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public Sale createSale(Sale sale) {
		
		
		Optional<SaleDO> optional = saleRepository.findById(sale.getSaleId());
		if(optional.isPresent())
			throw new ApplicationException("Sale is aleady created");
		return DtoMapper.fromSaleDO(saleRepository.save(DtoMapper.fromSaleDto(sale)));

	}

	@Override
	public Sale getSaleById(Integer saleId) {
		
			return DtoMapper.fromSaleDO(saleRepository.findById(saleId).orElse(null));
		
	}

	
	
}

