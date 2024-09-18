package ru.job4j.dip.violation;

/*
Нарушение: прямая зависимость от р-ции БД , если нужно будет изменить источник данных
придется изменять код.
 */
public class ProductRepository {
    public void save(String product) {
        Database db = new Database();
        db.saveProduct(product);
    }

    private static class Database {
        public String saveProduct(String product) {
            return product;
        }
        /*
        Логика класса
         */
    }
}
