public class MainRestaurantOrder {
    public static void main(String[] args) {
       
        Appetizer salad = new Appetizer("app1", "Греческий салат", 350.0);
        salad.setVegetarian(true);
        salad.setSpiceLevel(2);
        salad.setCookingTime(10);
        
        MainCourse steak = new MainCourse("main1", "Стейк Рибай", 1200.0);
        steak.setMainIngredient("Говядина");
        steak.setSideDish("Овощи гриль");
        steak.setCalories(650);
        steak.setCookingTime(25);
        
        Dessert cake = new Dessert("dess1", "Тирамису", 280.0);
        cake.setSweetnessLevel(7);
        cake.setGlutenFree(false);
        cake.setCookingTime(15);
        System.out.println();
        
        RestaurantOrder order1 = new RestaurantOrder("ORD001", 5);
        
        order1.addItem(salad);
        order1.addItem(steak);
        order1.addItem(cake);
        
        System.out.println();
        
        order1.getOrderDetails();
        System.out.println();
        
        order1.calculateTotal();
        System.out.println();
        
        order1.getItemsByType("Закуска");
        System.out.println();
        
        order1.estimatePreparationTime();
        System.out.println();
        
        salad.displayInfo(true);
        salad.prepare();
        salad.getNutritionInfo();
        
        steak.displayInfo();
        steak.prepare();
        steak.getCookingInstructions();
        
        cake.displayInfo();
        cake.prepare(true);
        cake.checkAllergies();
        
        System.out.println();
        
        steak.updatePrice(1300.0, "Подорожание мяса");
        System.out.println();
        
        order1.removeItem("app1");
        System.out.println();
        
        order1.updateStatus("Готовится");
        System.out.println();

        order1.getOrderDetails();
        System.out.println();
        
        System.out.println("Всего блюд в меню: " + MenuItem.getTotalMenuItems());
        System.out.println("Всего заказов: " + RestaurantOrder.getTotalOrders());
        System.out.println("Блюд в текущем заказе: " + order1.getItemsCount());
    }
}