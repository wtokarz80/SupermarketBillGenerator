package services;

import tools.ListComparator;

import java.util.*;

public class BillGenerator {

    private Map<String, Integer> amountOfProduct = new HashMap<>();

    public double calculatePrice(List<List<String>> productPrices, List<String> products) {

        double totalPrice = 0;

        Set<String> keys = new HashSet<>(products);
        for (String key : keys) {
            amountOfProduct.put(key, Collections.frequency(products, key));
        }

        Set<Map.Entry<String, Integer>> entries = amountOfProduct.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            List<List<String>> temp = new ArrayList<>();
            int amount = entry.getValue();
            for (List<String> productPrice : productPrices){
                if (productPrice.contains(entry.getKey())){
                    temp.add(productPrice);
                }
            }
            temp.sort(new ListComparator<>());
            int i = 1;
            while (amount > 0){
                if(amount >= Integer.parseInt(temp.get(temp.size()-i).get(2))){
                    amount -= Integer.parseInt(temp.get(temp.size()-i).get(2));
                    totalPrice += Double.parseDouble(temp.get(temp.size()-i).get(3));
                }
                else {
                    i++;
                }
            }
        }

        return Math.round(totalPrice * 100.0) / 100.0;
    }
}
