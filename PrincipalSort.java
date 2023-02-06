import java.util.Scanner;

public class PrincipalSort<T> {

    public static void main(String[] args) {
        boolean funcionar = true;
        String enter;

        while (funcionar) {
            System.out.println("¿Cuántos valores desea generar?");
            Scanner teclado = new Scanner(System.in);
            int qty = Integer.parseInt( teclado.nextLine());
    
            int valores[] = new int[qty];
            int datos[] = new int[qty];
            Sorts<Integer> lista = new Sorts<Integer>();
    
            for (int i = 0; i < qty; i++){
                valores[i] = (int) (Math.floor(Math.random()*(1000)));
                datos[i] = valores[i];
            }
    
            for (int i = 0; i < datos.length; i++){
                System.out.println(datos[i]);
            }
    
            System.out.println("\nElija el sort que desea utilizar:\n\n1: Gnome Sort\n2: Merge Sort\n3: Quick Sort\n4: Radix Sort\n5: Selection Sort\n6: Salir del programa");
            int eleccion = teclado.nextInt();
            teclado.nextLine();

            switch (eleccion) {
                case 1:
                    //Gnome Sort
                    System.out.println("\nOrdenado los datos del arreglo con GnomeSort...");
                    lista.gnomeSort(datos);
                    System.out.println("Los datos han sido arreglados");
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }
                    
                    System.out.println("Presionar enter para volver a ordenar los datos");
                    enter = teclado.nextLine();
                    lista.gnomeSort(datos);
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }
                        
                    break;
                case 2:
                    //Merge Sort
                    System.out.println("\nOrdenado los datos del arreglo con MergeSort...");
                    Sorts.mergeSort(datos, datos.length);
                    System.out.println("Los datos han sido arreglados");
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }

                    System.out.println("Presionar enter para volver a ordenar los datos");
                    enter = teclado.nextLine();
                    Sorts.mergeSort(datos, datos.length);
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }

                    break;
                case 3:
                        //Quick Sort
                        System.out.println("\nOrdenado los datos del arreglo con QuickSort...");
                        lista.quickSort(datos, 0, datos.length-1);
                        System.out.println("Los datos han sido arreglados");
                        for (int i = 0; i < datos.length; i++){
                            System.out.println(datos[i]);
                        }

                        System.out.println("Presionar enter para volver a ordenar los datos");
                        enter = teclado.nextLine();
                        lista.quickSort(datos, 0, datos.length-1);
                        for (int i = 0; i < datos.length; i++){
                            System.out.println(datos[i]);
                        }
                    break;
                case 4:
                    //Radix Sort
                    System.out.println("\nOrdenado los datos del arreglo con RadixSort...");
                    Sorts.radixSort(datos);
                    System.out.println("Los datos han sido arreglados");
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }

                    System.out.println("Presionar enter para volver a ordenar los datos");
                    enter = teclado.nextLine();
                    Sorts.radixSort(datos);
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }
                    break;
                    case 5:
                        //Selection Sort
                        System.out.println("\nOrdenado los datos del arreglo con SelectionSort...");
                        Sorts.selectionSort(datos);
                        System.out.println("Los datos han sido arreglados");
                        for (int i = 0; i < datos.length; i++){
                            System.out.println(datos[i]);
                        }

                        System.out.println("Presionar enter para volver a ordenar los datos");
                        enter = teclado.nextLine();
                        Sorts.selectionSort(datos);
                        for (int i = 0; i < datos.length; i++){
                            System.out.println(datos[i]);
                        }
                    break;
                case 6:
                    funcionar = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    break;
            }
        }
    }   
}
