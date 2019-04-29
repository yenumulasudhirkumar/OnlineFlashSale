package com.pramati.flashsale.service;

import com.pramati.flashsale.beans.Sale;

/**
 * @author sudhirk
 *
 * Interface for Sale Service
 */
public interface SaleService {

	
	public Sale createSale(Sale s);
	
	public Sale getSaleById(Integer saleId);
	
	
	
}
