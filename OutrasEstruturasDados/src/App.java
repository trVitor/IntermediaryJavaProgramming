import java.util.HashSet;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap01();
    }
        public static void exemplo01(){
            HashSet<String> cars = new HashSet<String>();
            System.out.println(cars.add("Volvo"));
            System.out.println(cars.add("BMW"));
            System.out.println(cars.add("Ford"));
            System.out.println(cars.add("BMW"));
            System.out.println(cars.add("Mazda"));
            System.out.println(cars);
        }   

        public static void exemplo02(){
            HashSet<Produto> catalogo = new HashSet<Produto>();
            
            Produto Nintendo = new Produto("Nintendo", "Switch", 2000);
            System.out.println(catalogo.add(Nintendo));
        
            Produto MasterSystem = new Produto("TECTOY", "MasterSystem", 350);
            System.out.println(catalogo.add(MasterSystem));

            System.out.println(catalogo.add(Nintendo));

            System.out.println("Número de Produtos na coleção: " + catalogo.size());
            
            Nintendo.setPreco(1899);
            System.out.println(catalogo.add(Nintendo));

            System.out.println("Número de Produtos na coleção: " + catalogo.size());

            try{
                Produto NintendoClone = (Produto) Nintendo.clone(); 
                Nintendo.setPreco(1899);
                System.out.println(catalogo.add(NintendoClone));
                System.out.println("Número de Produtos na coleção: " + catalogo.size());
            }catch(Exception e){
                // TODO
            }
        }
        
        public static void HashMap01(){

            Produto Xbox = new Produto("Microsoft","SERIE S", 5000);
            HashMap <String, Produto> catalogoComChave =  new HashMap<String, Produto>();
            System.out.println(catalogoComChave.put("xboxChurrasqueira", Xbox));

            System.out.println("Produto na coleção: " + catalogoComChave.size());
            System.out.println(catalogoComChave.get("xboxChurrasqueira"));
        }

    }

