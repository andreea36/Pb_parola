import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        // PassWord Complex
        boolean pctunu = false;
        boolean pctdoi = false;
        boolean pcttrei = false;

        System.out.println("Bine ai venit la Verificatorul de Parole!");
        System.out.println("Te rog scrie o parola care sa aiba urmatoarele caracteristici:");
        System.out.println("1. Sa fie intre 6 si 20 de caractere");
        System.out.println("2. Trebuie sa contina cel putin o litera mica, o litera mare si un numar");
        System.out.println("3. NU se accepta caractere repetate de mai mult de 3 ori.");
        Scanner wordScaner = new Scanner(System.in);

        String pass = wordScaner.nextLine();
        //Aici testam marimea parolei
        if (pass.length() < 6) {
            System.out.println("Prea Mica");
        } else if (pass.length() > 20) {
            System.out.println("Prea Mare");
        } else {
            System.out.println("Punct 1 OK");
            pctunu = true;
        }
        //Aici testam daca are toate tipurile de caractere
        //String normalChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
        boolean litereMici = false;
        boolean litereMari = false;
        boolean numere = false;
        if (pass.matches("(?=.*[a-z]).*")) {
            litereMici = true;
        } else {
            System.out.println("Lipsesc literele mici");
        }
        if (pass.matches("(?=.*[A-Z]).*")) {
            litereMari = true;
        } else {
            System.out.println("Lipsesc literele mari");
        }
        if (pass.matches("(?=.*[0-9]).*")) {
            numere = true;
        } else {
            System.out.println("Lipsesc Numere");
        }

        if (litereMari == true && litereMici == true && numere == true) {
            System.out.println("Punct 2 OK");
            pctdoi = true;
        }
        //Aici comparam caracterele


        for (int i = 2; i < pass.length(); i++) {
            //System.out.println(pass.charAt(i));
            if (pass.charAt(i - 1) == pass.charAt(i)) {
                if (pass.charAt(i - 2) == pass.charAt(i - 1))
                    System.out.println("Avem o repetitie de 3 caractere consecutive: " + pass.charAt(i - 2) + "(" + (i - 2) + ") - " + pass.charAt(i - 1) + "(" + (i - 1) + ") - " + pass.charAt(i) + "(" + (i) + ")");
                pcttrei = false;

            } else {
                pcttrei = true;
            }
        }

        if (pcttrei == true) {
            System.out.println("Punct 3 OK");
        } else {
            System.out.println("Explicatie: X=caracterul (pozitia caracterului in parola)");
        }

        if (pctunu == true && pctdoi == true && pcttrei == true) {
            System.out.println("Parola indeplineste toate cele 3 conditii !");
        }

    }
}
