package zekaoyunu;

import java.util.Scanner;

public class ZekaOyunu {

    public static void yazdir(String[][] tahta){
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                System.out.print(tahta[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static String[][] goster(String[][] bosTahta, String[][] orginalTahta, int a, int b){
        String[][] temp = new String[5][5];
        
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                temp[i][j] = bosTahta[i][j];
            }
        }
        
        temp[a][b] = orginalTahta[a][b];
        return temp;
    }
    
    
   /* public static String[][] goster2(String[][] yeniTahta, String[][] orginalTahta, int a, int b, int c, int d){
        // yeniTahta = temp , orginalTahta = tahta
        String[][] temp = new String[5][5];
        // maindeki tempi başka(temp) değişkenine kopyalıyoruz. maindeki temp dizisi değişmesin diye..
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                temp[i][j] = yeniTahta[i][j];
            }
        }
        temp[c][d] = orginalTahta[c][d];
        
        return yeniTahta;
    }*/
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String[][] tahta = {{"","","","",""},
                            {"","a","2","b","a"},
                            {"","b","x","2","x"},
                            {"","t","z","<","y"},
                            {"","z","y","<","t"}};
        
        String[][] empty = {{"","","","",""},
                            {"","_","_","_","_"},
                            {"","_","_","_","_"},
                            {"","_","_","_","_"},
                            {"","_","_","_","_"}};
        yazdir(empty);
        int count = 0, denemeSayisi=0;
        int visibleElement = 0;
        String[][] temp,temp2;
        
        while(true){
            //1. tahmin bilgisi kullanıcıdan alınıyor.
            System.out.println("1. Tahmin için Satır ve Sütun değerini giriniz...");
            System.out.print("Satır: ");
            int x1 = in.nextInt();
            System.out.print("Sütun: ");
            int y1 = in.nextInt();
            temp = goster(empty, tahta, x1, y1); // temp dizisi 1 tahminin gösterildiği dizidir.
            yazdir(temp);
            
            //2. tahmin bilgisi kullanıcıdan alınıyor.
            System.out.println("2. Tahmin için Satır ve Sütun değerini giriniz...");
            System.out.print("Satır: ");
            int x2 = in.nextInt();
            System.out.print("Sütun: ");
            int y2 = in.nextInt();
            temp2 = goster(temp, tahta, x2, y2); // temp2 dizisi 2 tahmininde tahta üzerinde gösterildiği dizidir.
            
            
            if(tahta[x1][y1].equals(tahta[x2][y2])){
                empty[x1][y1] = tahta[x1][y1];
                empty[x2][y2] = tahta[x2][y2];
                visibleElement += 2;
                yazdir(temp2);
                System.out.println("*********************");
                System.out.println("Eşleşme Durumu: DOĞRU");
                System.out.println("*********************");
            }else{
                yazdir(temp2);
                System.out.println("**********************");
                System.out.println("Eşleşme Durumu: YANLIŞ");
                System.out.println("**********************");
                System.out.println("\nSON GÖRÜNÜM::.");
                yazdir(empty);
            }
            
            denemeSayisi++;
            if(visibleElement == 16){
                break;
            }
        }
        
        System.out.println("Tebrikler! " + denemeSayisi + " deneme ile tamamlandınız.");
        
    }
    
}