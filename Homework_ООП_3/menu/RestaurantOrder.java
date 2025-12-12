/*
● orderId (String) - номер заказа
● tableNumber (int) - номер стола
● orderItems - список блюд в заказе
● orderStatus (String) - статус заказа
● totalOrders - счетчик заказов (static)
● MAX_TABLE_NUMBER - final константа = 50 (static)

● addItem(MenuItem item) - добавить блюдо в заказ
● removeItem(String itemId) - удалить блюдо из заказа
● calculateTotal() - посчитать общую сумму заказа
● getOrderDetails() - получить детали заказа
● updateStatus(String newStatus) - обновить статус заказа
● getItemsByType(String type) - получить блюда по типу
● estimatePreparationTime() - оценить общее время приготовления
*/
public class RestaurantOrder {

	private static int totalOrders = 0;
	private static final MAX_TABLE_NUMBER = 50;
	
	private String orderId;
	private int tableNumber;
	private MenuItem[] orderItems;
	private String orderStatus; 
	private int itemsCount;

	public RestaurantOrder(String orderId) {
		this.orderId = orderId;
		this.tableNumber = tableNumber;
		this.orderItems = new MenuItem[0];
		this.orderStatus = "Создан";
		this.itemsCount = 0;
		totalOrders++;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public void setTableNumber(int tableNumber) {
		if (tableNumber <= MAX_TABLE_NUMBER) {
			this.tableNumber = tableNumber;
		} else {
			System.out.println("Максимальное кол-во столиков - 50!");
		}
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;

	public String getOrderId() {
		return this.orderId;
	}
	public int getTableNumber() {
		return this.tableNumber;
	}
	public String getOrderStatus() {
		return this.orderStatus;
	}
	public int getItemsCount() {
		return itemsCount; 
	}

	public void addItem(MenuItem item) {
		if (itemsCount >= orderItems.length) {
            MenuItem[] newItems = new MenuItem[orderItems.length * 2];
            for (int i = 0; i < orderItems.length; i++) {
                newItems[i] = orderItems[i];
            }
            orderItems = newItems;
        }
        orderItems[itemsCount] = item;
        itemsCount++;
        System.out.println("Блюдо '" + item.getName() + "' добавлено в заказ"); 
	}

	public void removeItem(String itemId) {
		for (int i = 0; i < itemsCount; i++) {
            if (orderItems[i].getItemId().equals(itemId)) {
                String itemName = orderItems[i].getName();
                for (int j = i; j < itemsCount - 1; j++) {
                    orderItems[j] = orderItems[j + 1];
                }
                orderItems[itemsCount - 1] = null;
                itemsCount--;
                System.out.println("Блюдо '" + itemName + "' удалено из заказа");
                return;
            }
        }
        System.out.println("Блюдо с ID '" + itemId + "' не найдено в заказе");
	}

	public void calculateTotal() {
		double total = 0;
        for (int i = 0; i < itemsCount; i++) {
            total += orderItems[i].getPrice();
        }
        System.out.println("Общая сумма заказа: " + total + " руб.");
	}

	public void getOrderDetails() {
		System.out.println("=== Детали заказа ===");
        System.out.println("Номер заказа: " + orderId);
        System.out.println("Стол: " + tableNumber);
        System.out.println("Статус: " + orderStatus);
        System.out.println("Количество блюд: " + itemsCount);
        for (int i = 0; i < itemsCount; i++) {
            System.out.println((i + 1) + ". " + orderItems[i].getName() + " - " + orderItems[i].getPrice() + " руб.");
        }
        calculateTotal();
	}

	public void updateStatus(String newStatus) {
		setOrderStatus(newStatus);
        System.out.println("Статус заказа обновлен: " + newStatus);
	}

	public void getItemsByType(String type) {
		System.out.println("=== Блюда типа '" + type + "' в заказе ===");
        int count = 0;
        for (int i = 0; i < itemsCount; i++) {
            if (orderItems[i].getItemType().equals(type)) {
                count++;
                System.out.println(count + ". " + orderItems[i].getName());
            }
        }
        if (count == 0) {
            System.out.println("Блюд типа '" + type + "' не найдено");
        }
	}

	public void estimatePreparationTime() {
		int totalTime = 0;
        for (int i = 0; i < itemsCount; i++) {
            totalTime += orderItems[i].getCookingTime();
        }
        System.out.println("Общее время приготовления: " + totalTime + " минут");
	}
}