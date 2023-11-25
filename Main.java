 class Product {

    public String productname;

    public int UnitPrice;

    public int gst;

    public int Quantity;

    public Product(String productname, int UnitPrice, int gst, int Quantity) {
        this.productname = productname;
        this.UnitPrice = UnitPrice;
        this.gst = gst;
        this.Quantity = Quantity;
    }

}

    public class Main{
    public static void main(String[] args){
        Product leatherwallet = new Product("Leather wallet", 1100, 18, 1);
        Product Umbrella = new Product("Umbrella", 900, 12, 4);
        Product Cigratte = new Product("Cigratte", 200, 28, 3);
        Product Honey = new Product("Honey", 100, 0, 2);

        Product maxGstProduct = findMaxGstProduct(leatherwallet, Umbrella, Cigratte, Honey);
        System.out.println("The product withmax Gst amount is " +maxGstProduct.productname);

        int totalAmount = calculateTotalAmount(leatherwallet, Umbrella, Cigratte, Honey);
        System.out.println("The total amount to be paid is " +totalAmount);
    }

    private static Product findMaxGstProduct(Product... products){
        Product maxGstProduct = null;
        double maxGstAmount = 0;

        for (Product product : products){
            double gstAmount = (product.UnitPrice * product.gst) / 100.0;
                if (gstAmount > maxGstAmount){
                    maxGstAmount = gstAmount;
                    maxGstProduct = product;
                }
        }
        return  maxGstProduct;
    }

        private static  int calculateTotalAmount(Product... products){
           int totalAmount = 0;

           for (Product product : products){
               double gstAmount = (product.UnitPrice * product.gst) / 100.0;
                double discountedPrice = product.UnitPrice - (product.UnitPrice >= 500 ? 0.05 * product.UnitPrice : 0);
                 totalAmount += (discountedPrice + gstAmount) * product.Quantity;
        }

        return  totalAmount;
    }
}
