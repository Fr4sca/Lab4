public class Main {
    public static void main(String[] args) {
        OfficeSupply pen = new OfficeSupply("Ручка");
        OfficeSupply.SupplyManual.printManual(pen.getName());
        
        Employee anna = new Employee("Анна");
        anna.useSupply(pen);
        
        System.out.println("\n---\n");
        
        Office mainOffice = new Office("Головний офіс");
        mainOffice.addSupply("Олівець");
        mainOffice.addSupply("Степлер");
        mainOffice.addSupply("Скріпки");
        mainOffice.workDay();
    }
}