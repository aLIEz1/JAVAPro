package StaffMember;

public abstract class StaffMember {
    private int no;
    private String name;
    private String address;
    private String phone;
    private String title;
    private String socialSN;
    private double payRate;

    public StaffMember(int no, String name, String address,
                       String phone, String title, String socialSN, double payRate) {
        this.no = no;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.title = title;
        this.socialSN = socialSN;
        this.payRate = payRate;

    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getTitle() {
        return title;
    }

    public String getSocialSN() {
        return socialSN;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSocialSN(String socialSN) {
        this.socialSN = socialSN;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }


    abstract double Pay();

    public String ToString() {
        return this.no + " " + this.name + " " + this.address
                + " " + this.phone + " " + this.title + " " + this.socialSN + " " + "$" + this.Pay();
    }

    public static void main(String[] args) {
        Staff s = new Staff();
        s.showPay();
    }

}

class Manager extends StaffMember {
    private double bonus;

    public Manager(int no, String name, String address,
                   String phone, String title, String socialSN, double payRate, double bonus) {
        super(no, name, address, phone, title, socialSN, payRate);
        this.bonus = bonus;
    }

    public void awardBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double Pay() {
        return this.getPayRate() + this.bonus;
    }
}

class Employee extends StaffMember {
    public Employee(int no, String name, String address,
                    String phone, String title, String socialSN, double payRate) {
        super(no, name, address, phone, title, socialSN, payRate);
    }

    @Override
    double Pay() {
        return this.getPayRate();
    }
}

class Hourly extends StaffMember {
    private int hourWorked;

    public Hourly(int no, String name, String address,
                  String phone, String title, String socialSN, double payRate, int hourWorked) {
        super(no, name, address, phone, title, socialSN, payRate);
        this.hourWorked = hourWorked;
    }

    public int getHourWorked() {
        return hourWorked;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }

    public void addHours(int hours) {
        setHourWorked(hours + this.getHourWorked());
    }

    @Override
    public String ToString() {
        return super.ToString() + "工作时长:" + this.hourWorked;
    }

    @Override
    double Pay() {
        return this.getPayRate() * this.hourWorked;
    }

}

class Volunteer extends StaffMember {

    public Volunteer(int no, String name, String address,
                     String phone, String title, String socialSN, double payRate) {
        super(no, name, address, phone, title, socialSN, payRate);
    }

    @Override
    public String ToString() {
        return super.ToString();
    }

    @Override
    double Pay() {
        return 0.00;
    }
}

class Staff {
    private StaffMember[] members = new StaffMember[6];

    public Staff() {
        StaffMember manager = new Manager(1, "姓名：Sam", "地址：123 Main Line",
                "电话：555-0469", "职位：manager", "社会安全号：123-45-6789", 2943.07, 500.00);
        StaffMember employee1 = new Employee(2, "姓名：peter", "地址：456 Off Line",
                "电话：555-0101", "职位：employee", "社会安全号：987-65-4321", 1246.15);
        StaffMember employee2 = new Employee(3, "姓名：Mary", "地址：789 Off Rocker",
                "电话：555-0690", "职位：employee", "社会安全号010-20-3040", 1169.23);
        StaffMember hourly = new Hourly(4, "姓名：Cliff", "地址：678 Fifth Ave",
                "电话：555-0000", "职位：hourly", "社会安全号：958-47-3625", 10.55, 120);
        StaffMember volunteer1 = new Volunteer(5, "姓名：AI", "地址：987 Suds Ave",
                "电话：555-8374", "职位：volunteer", "", 0);
        StaffMember volunteer2 = new Volunteer(6, "姓名：Gus", "地址：321 Off Line",
                "电话：555-7282", "职位：volunteer", "", 0);
        members[0] = manager;
        members[1] = employee1;
        members[2] = employee2;
        members[3] = hourly;
        members[4] = volunteer1;
        members[5] = volunteer2;
    }

    public void showPay() {
        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i].ToString());
            System.out.println("#################################");
        }
    }
}