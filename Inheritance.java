public class Inheritance {

    public static void main(String []args){
//        Tano t1=new Tano(2);
////        t1.no_of_seats=2;
////        t1.colour="Red";
//        //method overloading or compile time polymorphism
//        t1.driving();
//        t1.driving("Naveen");
        childA CHILDA=new childA();
        CHILDA.capital();
    }

    static class car{
        int no_of_seats;
        String colour;
        car(){
            System.out.println("constructor of car");
        }
//        car(int no_of_seats){
//            System.out.println("No of seats"+no_of_seats);
//        }
    }
    static class Tano extends car{

        Tano(){
            System.out.println("constructor of Tano");
        }
        Tano(int no_of_seats){
            this();
            System.out.println("No of seats "+no_of_seats);
        }
        void driving(){
            System.out.println("Tano is driving");
        }
        void driving(String drivername){
            System.out.println(drivername+ " is driving nano");
        }


    }

    static class King{
        void capital(){
            System.out.println("King's capital");
        }
    }
    static class childA extends King{
        void capital(){
            System.out.println("Child's Capital");
        }

    }
}
//abstract class
abstract class car{
    abstract void runcar(String drivername);
    void stopcar(){
        System.out.println("car is stopped");
    }

}
class Bano extends car{
    void runcar(String drivername){
        System.out.println(drivername+" is driving car");
    }

}
//interface
interface yudi{
    void runcar();
}
class b implements yudi{
    public void runcar(){
        System.out.println("yudi is running");
    }
}