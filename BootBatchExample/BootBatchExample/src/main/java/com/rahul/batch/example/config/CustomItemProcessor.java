package com.rahul.batch.example.config;

import com.rahul.batch.example.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        // transform ka logic yaha likha jayega
        //calculate karenge discounted price
        //price
        //discount
        try{
            int discountPer = Integer.parseInt(item.getDiscount().trim());
            double originalPrice = Double.parseDouble(item.getPrice().trim());
            double discount = originalPrice * ((double) discountPer /100);
            double finalPrice = originalPrice - discount;
            item.setDiscountedPrice(String.valueOf(finalPrice));
        }catch (
                NumberFormatException ex
        ){
            ex.printStackTrace();
        }
        return item;
    }
}
