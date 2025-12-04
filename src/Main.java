import java.util.*;

public class Main {
    public static void main(String[] args) {

        ProductManagement pm = new ProductManagement();

        List<Product> products = new ArrayList<>();
        products.add(new Product(2, "Laptop", 2500));
        products.add(new Product(1, "Phone", 1200));
        products.add(new Product(3, "Tablet", 900));

        System.out.println(" Tous les produits : ");
        pm.displayProducts(products, p -> System.out.println(p));

        System.out.println(" Produits avec prix > 1000 : ");
        pm.displayProductsByFilter(
                products,
                p -> p.getPrix() > 1000,     // Predicate
                p -> System.out.println(p)   // Consumer
        );

        String names = pm.returnProductsNames(products, prod -> prod.getNom());
        System.out.println(" Noms des produits : " + names);

        Product nouveau = pm.createProduct(() -> new Product(4, "Watch", 300));
        products.add(nouveau);

        System.out.println(" Après ajout d'un nouveau produit : ");
        for (Product p : products) {
            System.out.println(p);
        }

        pm.sortProductsById(products, (a, b) -> a.getId() - b.getId());

        System.out.println(" Produits triés par id : ");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println(" Affichage via Stream : ");
        pm.convertToStream(products)
                .forEach(p -> System.out.println(p));

    }
}
