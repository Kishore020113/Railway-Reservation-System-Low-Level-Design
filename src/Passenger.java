public class Passenger {
    private static int id = 1;
    private String name;
    private String emailId;
    private int age;
    private String  source;
    private String destination;
    private int passengerId;

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public int getAge() {
        return age;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }

    public int getPassengerId() {
        return passengerId;
    }
    public String getPassengerName(){
        return name;
    }

    public Passenger(String name,String emailId,int age,String source,String destination){
        this.passengerId = id;
        this.name = name;
        this.emailId = emailId;
        this.age = age;
        this.source = source;
        this.destination = destination;
        id++;
    }

}
