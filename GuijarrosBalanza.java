import java.util.*;

public class GuijarrosBalanza {

    /*funcion 
     * si al aucumular todos los pesos da un numero impar directamente devuelve false pq no es posible balanzar
     * si no ,buscamos los elementos de la lista de pesos que sea igual al acumulador/2  
     * si la encontramos devolvemos true
     * si no la encontramos devolvemos false
     */
    public static boolean esPosibleBalanzar(List<Integer> pesos){
        int acumulador = 0;
        for (int peso : pesos) {
            acumulador+=peso;
        }

        if(acumulador%2 != 0)
            return false;
        else
            return encontrarTarget(pesos, acumulador/2);
        
    }

    public static boolean encontrarTarget(List<Integer> numeros, int target) {
        // Llama al método recursivo que evalúa todas las combinaciones posibles
        return backtrack(numeros, target, 0);
    }

    private static boolean backtrack(List<Integer> numeros, int target, int indice) {
        // Caso base: si el target es exactamente 0, se encontró una solución
        if (target == 0) {
            return true;
        }

        // Si pasamos del final de la lista o el target es negativo, no es posible encontrar la suma
        if (indice >= numeros.size() || target < 0) {
            return false;
        }

        // Decisión: arbol
        // 1. Incluir el número actual en la suma
        // 2. Excluir el número actual y buscar el target sin él
        return backtrack(numeros, target - numeros.get(indice), indice + 1) || // Incluir
               backtrack(numeros, target, indice + 1);                        // Excluir
    }

public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int casosPrueba=0;
    int numGuijarros ;
    List<Integer> pesos = new ArrayList<>();

    while (casosPrueba < 10000) { 
        casosPrueba++;
        numGuijarros=sc.nextInt();
        
        if(numGuijarros == 0) 
        break;

        while(2>numGuijarros || numGuijarros>12){
            System.out.println("Entrada inválida");
            numGuijarros = sc.nextInt();
        }

        for (int i = 0; i < numGuijarros; i++) {
            int peso = sc.nextInt();
            pesos.add(peso);
        }

        if (esPosibleBalanzar(pesos)) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
        
    }

}
}