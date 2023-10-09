public class TestEmployee {
    public static void main(String[] args) {
        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setId(1);
        contractEmployee.setName("Tian");
        contractEmployee.setPayPerHour(100000);
        contractEmployee.setContactPeriod("2 bulan");
        System.out.println(contractEmployee.getName());
        System.out.println(contractEmployee);
        contractEmployee.work();

    }
}
