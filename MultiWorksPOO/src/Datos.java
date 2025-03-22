import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.lang.System.out;

public class Datos {
    static Scanner sc = new Scanner(System.in);

    public String validarVacio (String str) {
        while (str.isEmpty()) {
            out.print("Error, este campo no puede estar vacío\nIngrese un valor: ");
            str = sc.nextLine();
        }
        return str;
    }

    public int validarNum (int num) {
        do {
            try {
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                out.print("Error, el valor ingresado no es numérico\nIntente de nuevo: ");
                num = -1;
                continue;
            }
            if (num < 0) {
                out.print("Error, el valor ingresado no puede ser negativo\nIngrese un valor positivo: ");
                num = -1;
            }
        } while (num < 0);
        return num;
    }

    public double validarNum (double num) {
        do {
            try {
                num = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                out.print("Error, el valor ingresado no es numérico\nIntente de nuevo: ");
                num = -1;
                continue;
            }
            if (num < 0) {
                out.print("Error, el valor ingresado no puede ser negativo\nIngrese un valor positivo: ");
                num = -1;
            }
        } while (num < 0);
        return num;
    }

    public LocalDate validarFecha (String fecha) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lDate = null;
        String result = "";

        do {
            try {
                lDate = LocalDate.parse(fecha, formato);
                result = lDate.format(formato);
            } catch (Exception e) {
                result = "";
            }
            if (!result.equals(fecha)) {
                result = "";
                out.print("Error, debe ingresar la fecha en el formato dd/MM/yyyy.\nIntente de nuevo: ");
                fecha = sc.nextLine();
            }
        } while (!result.equals(fecha));

        return lDate;
    }
}
