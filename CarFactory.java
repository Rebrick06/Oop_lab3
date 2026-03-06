public class CarFactory {
     public static Vehicle createCar(String type) {

         switch (type) {
             case "Volvo": return new Volvo240();
             case "Saab": return new Saab95();
             case "Scania": return new Scania();
         }
         return null;
     }

}

