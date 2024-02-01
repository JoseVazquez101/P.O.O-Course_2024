public class TestDate {
    public static void main(String[] args) {
        // a) Crear d1 como la fecha predeterminada
        Date d1 = new Date();

        // b) Crear d2 como la fecha 31 de diciembre de 2023
        Date d2 = new Date(31, 12, 2023);

        // c) Crear d3 como el clon de d1
        Date d3 = d1.clone();

        // d) Crear d4: con el día de d1, el mes de d2, el año de d3 y el formato 1
        Date d4 = new Date(d1.getDay(), d2.getMonth(), d3.getYear(), 1);

        // e) Crear d5 y asignar la fecha correspondiente al siguiente día de d2
        Date d5 = new Date();
        d5.setDay(d2.getDay());
        d5.setMonth(d2.getMonth());
        d5.setYear(d2.getYear());
        d5.next();

        // f) Cambiar el mes de d3 a Abril
        d3.setMonth(4);

        // g) Imprimir en consola el resultado de comparar d1 y d3
        System.out.println("\nd1 es igual a d3: " + d1.equals(d3));

        // h) Imprimir en consola el resultado de comparar d1 y d5
        System.out.println("d1 es igual a d5: " + d1.equals(d5));

        System.out.println("\n========== TEST ==========\n");

        // i) Imprimir en consola las cinco fechas anteriores en los tres formatos
        Date[] dates = {d1, d2, d3, d4, d5};
        for (Date date : dates) {
            for (int format = 0; format <= 2; format++) {
                date.setFormat(format);
                System.out.println(date);
            }
            System.out.println();
        }
    }
}
