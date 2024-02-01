public class Date {
    private int day, month, year;
    private String monthName;
    private int format;

    //Fecha predeterminada:
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

    //Setters
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
        this.format = format;
    }

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

    private void updateMonthName() {
        String monthNames[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviebmre", "Diciembre"};
        this.monthName = monthNames[this.month -1];
    }

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

    public boolean equals(Object o) {
        if (!(o instanceof Date))
            return false;
        Date comp = (Date)o;
        if (this.day == comp.day && this.month == comp.month && this.year == comp.year) {
            return true;
        }
        else return false;
    }

    public Date clone() {
        return new Date(this.day, this.month, this.year, this.format);
    }
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
