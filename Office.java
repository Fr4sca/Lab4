import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    // Асоціація: працівник використовує канцелярське приладдя
    public void useSupply(OfficeSupply supply) {
        System.out.println(name + " використовує: " + supply.getName());
        supply.use();
    }
}

class Office {
    private String name;
    // Композиція: офіс володіє канцелярським приладдям
    private List<OfficeSupply> supplies = new ArrayList<>();
    
    public Office(String name) {
        this.name = name;
    }
    
    public void addSupply(String supplyName) {
        supplies.add(new OfficeSupply(supplyName));
    }
    
    // Агрегація: офіс містить приладдя, але може існувати без нього
    public List<OfficeSupply> getSupplies() {
        return supplies;
    }
    
    public void workDay() {
        System.out.println("Робочий день в офісі \"" + name + "\":");
        for (OfficeSupply supply : supplies) {
            supply.use();
        }
    }
}

class OfficeSupply {
    private String name;
    
    public OfficeSupply(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // Внутрішній клас (inner class)
    class Maintenance {
        public void maintain() {
            System.out.println("Обслуговуємо канцелярське приладдя: " + name);
        }
    }
    
    // Статичний вкладений клас (static nested class)
    static class SupplyManual {
        public static void printManual(String supplyName) {
            System.out.println("Інструкція до \"" + supplyName + "\": зберігайте в сухому місці!");
        }
    }
    
    public void use() {
        // Локальний клас (local class)
        class UsageAction {
            void perform() {
                System.out.println("Використовуємо \"" + name + "\" для роботи");
            }
        }
        
        Maintenance maintenance = new Maintenance();
        maintenance.maintain();
        
        UsageAction action = new UsageAction();
        action.perform();
    }
}