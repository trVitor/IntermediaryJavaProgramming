public class Organizacao {

public void bubbleSort(char[] letras){
    int n = letras.length;
    for(int i = 0; i < n - 1; i++){
        for(int j = 0; j < n -1; j++){
            if(Character.toLowerCase(letras[j]) > Character.toLowerCase(letras[j + 1])){
                char temp = letras[j];
                letras[j] = letras[j + 1];
                letras[j + 1] = temp;
            }
        }
    } 
}

}
