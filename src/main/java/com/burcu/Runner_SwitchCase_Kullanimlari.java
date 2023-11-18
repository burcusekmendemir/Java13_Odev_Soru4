package com.burcu;

import java.util.Scanner;

public class Runner_SwitchCase_Kullanimlari {
    public static void main(String[] args) {


        /**
         * Java’da switch case yapısı if-else yapısına alternatif olarak oluşturulmuştur.
         * Bir programda çok sayıda koşul kontrolü ve bunların sonucuna göre gerçekleştirilmesi gereken işlemler varsa,
         * if-else yapıları ile akışın izlenmesi zorlaşabilir.
         * Böyle durumlar genellikle switch deyiminin kullanılmasının gerekli olacağı durumlardır.
         * Ama bir aralık olan koşullarda switch case yapısını kullanamayız, switch case doğrudan değer kontrolü yapar.
         *
         * Bir programda çok sayıda koşul kontrolü ve bunların sonucuna göre gerçekleştirilmesi gereken işlemler varsa,
         * switch case kullanımı tercih edilir.
         */

        /**
         * 1- Java 7’ye kadar switch-case tanımlamalarında sadece integer değerde bir değişkenin koşulları kullanılabiliyorken,
         * Java 8 ile String ve Enum type’lar için de kullanılabilir hale geldi.
         */

        Scanner scanner=new Scanner(System.in);
        System.out.println("Lütfen seçim yapınız:");
        int secim= scanner.nextInt();
        switch (secim) {
            case 1:
                System.out.println("Ocak");
                break;
            case 2:
                System.out.println("Şubat");
                break;
            case 3:
                System.out.println("Mart");
                break;
            case 4:
                System.out.println("ŞNisan");
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }

        /**
         * 2- Java 8 ile birlikte String ve Enum type'lar tanımlamalarda kullanılmaya başlandı.
         */

        //String Kullanımı:
        System.out.println("Lütfen ay seçimi yapınız:");
        String ay=new Scanner(System.in).nextLine();
        switch (ay) {
            case "Ocak":
                System.out.println("Kış");
                break;
            case "Şubat":
                System.out.println("Kış");
                break;
            case "Mart":
                System.out.println("İlkbahar");
                break;
            case "Nisan":
                System.out.println("İlkbahar");
                break;
            case "Mayıs":
                System.out.println("İlkbahar");
                break;
            case "Haziran":
                System.out.println("Yaz");
                break;
            case "Temmuz":
                System.out.println("Yaz");
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }

        // Enum Kullanımı:


        AylarEnum aylar=AylarEnum.HAZIRAN;
        switch (aylar) {
            case OCAK:
                System.out.println("Kış");
                break;
            case SUBAT:
                System.out.println("Kış");
                break;
            case MART:
                System.out.println("İlkbahar");
                break;
            case NISAN:
                System.out.println("İlkbahar");
                break;
            case MAYIS:
                System.out.println("İlkbahar");
                break;
            case HAZIRAN:
                System.out.println("Yaz");
                break;
            case TEMMUZ:
                System.out.println("Yaz");
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }

        /**
         * 3-  Java 12 ile Switch statemen’ı bir switch expression’a dönüştü.
         * Yani atanabilir (assing), geri döndürülebilir(return) bir yapıya kavuştu.
         * Fakat return edilecek ifadeden önce yield kullanılması gerekmektedir.
         */

        System.out.println("Lütfen ay seçimi yapınız:");
        String ay2=new Scanner(System.in).nextLine();

        String sonuc=
                switch (ay2) {
            case "Ocak":
                yield "Kış";

            case "Şubat":
                yield "Kış";

            case "Mart":
                yield "İlkbahar";

            case "Nisan":
                yield "İlkbahar";

            case "Mayıs":
                yield "İlkbahar";

            case "Haziran":
                yield "Yaz";

            case "Temmuz":
                yield "Yaz";

            default:
                yield "Geçersiz seçim!";
        };


        /**
         * 4- case statement’ı arrow operator olarak tanımlanabilir hale geldi.
         * Yield yerine bu kullanım daha okunur olduğu için bu ifadenin tercih edilmesi daha faydalı oldu;
         */

        System.out.println("Lütfen ay seçimi yapınız:");
        String ay3=new Scanner(System.in).nextLine();

        String sonuc2= switch (ay2) {
                    case "Ocak" -> "Kış";
                    case "Şubat" -> "Kış";
                    case "Mart" -> "İlkbahar";
                    case "Nisan" -> "İlkbahar";
                    case "Mayıs" -> "İlkbahar";
                    case "Haziran" -> "Yaz";
                    case "Temmuz" ->"Yaz";
                    default -> "Geçersiz seçim!";
        };

        /**
         * 5- Switch içinde yer alan değerin farklı case’leri için aynı işlem yapılabilmesini sağlamak için
         * tek bir case ifadesine farklı labellar yazılabilir hale geldi.
         */

        System.out.println("Lütfen ay seçimi yapınız:");
        String ay4=new Scanner(System.in).nextLine();

        String sonuc3 = switch (ay4) {
            case "Ocak","Şubat" -> "Kış";
            case "Mart", "Nisan", "Mayıs" -> "İlkbahar";
            case "Haziran", "Temmuz" -> "Yaz";
            default->"Geçersiz seçim";
        };


        /**
         * 6- Java 17 ile aşağıdaki özellikler eklendi;
         *  -Pattern matching
         *  -Gaurded pattern
         *  -Null cases
         */

        /**
         * 6.1- Pattern Matching:
         * Bir değerin tipine göre casting işlemi yaparak dönüştürülen tipin içerdiği metotlar kullanılarak
         * belli işlemler yapılması gerekir. Bunun için Java’nın pattern matching özelliği kullanılabilir.
         *
         * Java 17 ile birlikte case switch-case labellarına daha farklı tipte objeler ekleyebilmeye
         * ve yine label expressionında cast edebilmeye başlandı.
         * Bu sayede pattern matching özelliğinin okunurluğu daha yüksek ve daha kolay bir şekilde implement edebilmeye başlandı.
         */

        Object ifade = 10;
        double result;
        if (ifade instanceof Integer) {
            result = ((Integer) ifade).doubleValue();
        } else if (ifade instanceof Float) {
            result = ((Float) ifade).doubleValue();
        } else if (ifade instanceof String) {
            result = Double.parseDouble(((String) ifade));
        } else {
            result = 0d;
        }
        System.out.println(result);

        //Yukarıdaki kod göz önüne alındığında kodun okunurluğunu arttırmak ve hataya sebebiyet vermemek için pattern matching özelliği kullanılmaktadır.

        Object ifade1 = 10;
        Object result1 = switch (ifade) {
            case Integer i -> i.doubleValue();
            case Float f -> f.toString();
            case String s -> Double.parseDouble(s);
            default -> 0d;
        };
        System.out.println(result1);

        /**
         * 6.2 - Guarded Pattern: Pattern matching işlemini uygularken ek olarak farklı koşullar eklenmesi gereken
         * durumlarda case ifadesinin altına if-else'ler eklenir.
         */

        Object ifade2 = "10";

        Object result2 = switch (ifade2) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case String s -> {
                if (s.length() > 0) {
                    yield Double.parseDouble(s);
                } else {
                    yield 0d;
                }
            }
            default -> 0d;
        };
        System.out.println(result2); //10.0

        /**
         * 6.3 - Null Cases: Java 17 öncesinde, switch-case’e girilen bir değerin asla null olmaması gerekiyordu.
         * Java 17 ile birlikte  null olması durumu case labelları ile kullanılabilir hale geldi.
         */

        Object ifade3 = null;

        Object result3 = switch (ifade3) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case null -> 0d;
            default -> 0d;
        };
        
    }
}
