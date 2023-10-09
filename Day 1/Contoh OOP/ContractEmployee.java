public class ContractEmployee extends Employee implements Employable{
    private float payPerHour;
    private String contactPeriod;

    public ContractEmployee() {
    }

    public ContractEmployee(int id,String name,float payPerHour, String contactPeriod) {
        super(id, name);
        this.payPerHour = payPerHour;
        this.contactPeriod = contactPeriod;
    }
    public float getPatPerHour() {
        return payPerHour;
    }
    public String getContactPeriod() {
        return contactPeriod;
    }
    public void setPayPerHour(float patPerHour) {
        this.payPerHour = patPerHour;
    }
    public void setContactPeriod(String contactPeriod) {
        this.contactPeriod = contactPeriod;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +  "id=" + getId() + ", name ='" + getName() +'\''+
                ", payPerHour=" + payPerHour +
                ", contactPeriod='" + contactPeriod + '\'' +
                '}';
    }
    @Override
    public void work() {
        System.out.println("Tugas kontrak Employee");
    }
}
