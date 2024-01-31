/**
 * The store class saves all the entered products into a primitive array.
 *
 * @author Siobhan Drohan, Mairead Meagher
 * @version 2.2
 */

import java.util.ArrayList;

public class Store {

    private ArrayList<Product> products;

    public Store()
    {
        products = new ArrayList<Product>();
    }

    /**
     * If there is space available, add the product object, passed as a parameter, to the array.
     *
     * @param product Product object to be added to the array.
     * @return Status of the add; true for success, false for fail.
     */
    public boolean add(Product product)
    {
       return products.add (product);
    }

    /**
     * This method builds and returns a String containing all the products in the array.
     * For each product in the array, the associated index number is included.
     * If no products are stored in the array, the String "No products in the store" is returned.
     *
     * @return A String containing all the products in the array, or "No products in the store",
     * if empty.
     */
    public String listProducts()
    {
        if (products.isEmpty())
        {
            return "No products in the store";
        }
        else
        {
            String listOfProducts = "";
            for (int i = 0; i < products.size(); i++)
            {
                listOfProducts += i + ": " + products.get(i) + "\n";
            }
            return listOfProducts;
        }
    }

    /**
     * This method returns the cheapest product in the array.
     * If no products are stored in the array, null is returned.
     *
     * @return The cheapest Product in the array or null, if no products are added yet.
     */
    public Product cheapestProduct()
    {
        if (!products.isEmpty())
        {
            Product cheapestProduct = products.get(0);
            for (int i = 1; i < products.size(); i++)
            {
                if (products.get(i).getUnitCost() < cheapestProduct.getUnitCost())
                    cheapestProduct = products.get(i);
            }
            return cheapestProduct;
        }
        else
        {
            return null;
        }
    }

    /**
     * This method builds and returns a String containing all the products in the array
     * that are in the current product line.
     * <p>
     * For each product added to the String, the associated index number is included.
     *
     * @return A String containing all the products in the array, or "No products are in our current
     * product line", if none in the current line.  If no products are stored in the array, the
     * returned String indicates this.
     */
    public String listCurrentProducts()
    {
        if (products.isEmpty())
        {
            return "No Products in the store";
        }
        else
        {
            String listOfProducts = "";
            for (int i = 0; i < products.size(); i++)
            {
                if (products.get(i).isInCurrentProductLine())
                    listOfProducts += i + ": " + products.get(i) + "\n";
            }
            if (listOfProducts.equals(""))
            {
                return "No Products are in our current product line";
            }
            else
            {
                return listOfProducts;
            }
        }
    }

    /**
     * This method returns the average product price of all the products in the array.
     * If no products are stored in the array, the value returned is -1.
     *
     * @return The average product price, or -1 if no products exist.
     */
    public double averageProductPrice() {
        if (!products.isEmpty()) {
            double totalPrice = 0;
            for (Product product : products)
            {
                totalPrice += product.getUnitCost();
            }
            return totalPrice / products.size();
        }
        else
        {
            return -1;
        }

    }

    /**
     * This method builds and returns a String containing all the products in the array
     * that are more expensive that a specific amount (passed as a parameter).
     * <p>
     * For each product added to the String, the associated index number is included.
     * If no products are stored in the array, the returned String indicates this.
     *
     * @param price The value used to filter for products costing more than it.
     * @return A String containing all the products in the array more expensive than the parameter value
     * or "No Products are more expensive than: ", if none are more expensive.  If no products are
     * in the array, the returned String contains "No products in store".
     */
    public String listProductsAboveAPrice(double price)
    {
        if (products.isEmpty())
        {
            return "No Products in the store";
        }
        else
        {
            String str = "";
            for (int i = 0; i < products.size(); i++)
            {
                if (products.get(i).getUnitCost() > price)
                    str += i + ": " + products.get(i) + "\n";
            }
            if (str.equals(""))
            {
                return "No products are more expensive than: " + price;
            }
            else
            {
                return str;
            }
        }
    }

}
