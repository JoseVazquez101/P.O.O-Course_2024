
<h1>Clase Date. Tarea 1</h1>






![[Pasted image 20240131173440.png]]




- **Nombre:** José Manuel Rodriguez Vázquez
- **Materia**: Programación Orientada a Objetos
- **Carrerea**: Ingeniería en Ciberseguridad





***

- En esta tarea, se creará una clase `Date` a partir de un objeto con:
	- Métodos constructores
	- Getters
	- Setters
	- Métodos especiales

- Esto a través de una `UML` específica con esta forma:

  ![[Pasted image 20240131173104.png]]

***
<h3>Clase Date:</h3>

- **Atributos**:

~~~java
package Tarea_Date;  
  
public class Date {  
    private int day, month, year;  
    private String monthName;  
    private int format;  
~~~

- **Constructores**:

~~~java
    //Constructor predeterminado:  
    public Date() {  
        this(1, 1, 2024, 0);  
    }  
  
    //Constructor 1:  
    public Date(int dd, int mm, int yy) {  
        this(dd, mm, yy, 0);  
    }  
  
    //Constructor 2:  
    public Date(int dd, int mm, int yy, int format) {  
        setDay(dd);  
        setMonth(mm); //También va a actualizar el nombre del mes  
        setYear(yy);  
        setFormat(format);  
    }  
~~~

-  **Setters:**

~~~java
    public void setDay(int day) {  
        if (this.month == 2 && day >=1 && day <=28) {  
            this.day = day;  
        } else if ((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) && day >=1 && day <=30) {  
            this.day = day;  
        } else if (day >=1 && day <=31) {  
            this.day = day;  
        }  
    }
  
    public void setMonth(int month) {  
        if (month >= 1 && month <= 12) {  
            this.month = month;  
            updateMonthName();  
        }  
    }  
  
    public void setYear(int year) {  
        if (year >=1900 && year <=3000) {  
            this.year = year;  
        }  
    }  
  
    public void setFormat(int format) {  
	    if (format >=0 && <= 2) {
        this.format = format;  
        }
    }  
~~~

- **Getters:**

~~~java
    public int getDay() {  
            return day;  
    }  
  
    public int getMonth() {  
        return month;  
    }  
  
    public int getYear() {  
        return year;  
    }  
  
    public int getFormat() {  
        return format;  
    }  
  
    public String getMonthName() {  
        return monthName;  
    }  
~~~

- Método para cambiar nombre; funciona sacando del arreglo la `posición +1` dependiendo del número del mes a través de `this.month`.

~~~java
    private void updateMonthName() {  
        String monthNames[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",  
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviebmre", "Diciembre"};  
        this.monthName = monthNames[this.month -1];  
    }
~~~

- Método para imprimir dependiendo del número de clase elegida. Empleé un `switch-case` para elegir dependiendo del valor de `this.format`. 

~~~java  
    public String toString() {  
        switch (this.format) {  
            case 0:  
                return String.format("[+] Formato 1: %02d/%02d/%02d",  
                        this.day, this.month, this.year % 100);  
            case 1:  
                return String.format("[+] Formato 2: %d-%s-%d",  
                        this.day, this.monthName.substring(0, 3), this.year);  
            case 2:  
                return String.format("[+] Formato 3: %d de %s de %d",  
                        this.day, this.monthName, this.year);  
            default:  
                return "";  
        }  
    }
~~~

- Método booleano que compara valores del objeto original a uno que introduzcamos como argumento.

~~~java
    public boolean equals(Object o) {  
        if (!(o instanceof Date))  
            return false;  
        Date comp = (Date)o;  
        if (this.day == comp.day && this.month == comp.month && this.year == comp.year) {  
            return true;  
        }  
        else return false;  
    }  
~~~

- Método encargado de clonar un objeto tomando como referencia valores de otro, asignados en un espacio de memoria distinto:

~~~java  
    public Date clone() {  
        return new Date(this.day, this.month, this.year, this.format);  
    }  
~~~

- Método encargado de buscar los días siguientes del que se le indique. Valoro casos donde el aumento del día puedan causar conflicto, como podría ser el último día de un mes.

~~~java
    public void next() {  
        if ((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) && this.day == 30) {  
            this.day = 1;  
            this.month++;  
        } else if (this.month == 2 && this.day == 28) {  
            this.day = 1;  
            this.month++;  
        } else if ((this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10) && this.day == 31) {  
            this.day = 1;  
            this.month++;  
        } else if (this.month == 12 && this.day == 31) {  
            this.day = 1;  
            this.month = 1;  
            this.year++;  
        } else {  
            this.day++;  
        }  
    }  
}
~~~

***

<h3>Casos de prueba:</h3>

- Se nos solicita realizar lo siguiete:

~~~java
package Tarea_Date;  
  
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
~~~

***
<h3>Output:</h3>
- Comparar ``d1 <---> d3`` // ``d1 <---> d5``:

~~~java
        // g) Imprimir en consola el resultado de comparar d1 y d3  
        System.out.println("\nd1 es igual a d3: " + d1.equals(d3));  

        // h) Imprimir en consola el resultado de comparar d1 y d5  
        System.out.println("d1 es igual a d5: " + d1.equals(d5));  
~~~

![[Pasted image 20240131173226.png]]

- Imprimir valores de `d1, d2, d3, d4, d5`:

~~~java
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
~~~

- Capturas `d1-d5`:
![[Pasted image 20240131173253.png]]