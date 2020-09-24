package com.jiten.sprint_demp_anno;

public class ProductService implements IProductService {

	@Override
	public void createProduct(String name, double price) {
		// TODO Auto-generated method stub
		System.out.println(name + "-" + price);
	}

}