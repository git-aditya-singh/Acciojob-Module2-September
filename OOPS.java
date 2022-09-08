public class OOPS {
    public static void main(String[] args){
       //object=============
        //Tano car=new Tano(2,"Blue");

        System.out.println(Tano.engine);

//        car.no_of_seats=2;
//        car.colour="Blue";
//        car.test();




    }
    //class==================
    public static class Tano{
        int no_of_seats;
        String colour;

        static int engine=650;

        Tano(int no_of_seats,String colour){
           no_of_seats=no_of_seats;
           colour=colour;
        }
        Tano(){
           System.out.println("default constructor");
        }
        void test(){
            System.out.println("testing");
        }


    }
}
