package Algo5.data;

public class Student {

        private String surname;
        private String prename;
        private int immatNumber;
        private int course;
    
        public Student(String surname, String prename, int immatNumber, int course) {
            this.surname = surname;
            this.prename = prename;
            this.immatNumber = immatNumber;
            this.course = course;
        }
    
        public String getSurname() {
            return this.surname;
        }
    
        public void setSurname(String surname) {
            this.surname = surname;
        }
    
        public String getPrename() {
            return this.prename;
        }
    
        public void setPrename(String prename) {
            this.prename = prename;
        }
    
        public int getImmatNumber() {
            return this.immatNumber;
        }
    
        public void setImmatNumber(int immatNumber) {
            this.immatNumber = immatNumber;
        }
    
        public int getCourse() {
            return this.course;
        }
    
        public void setCourse(int course) {
            this.course = course;
        }
    
    
        @Override
        public String toString() {
            return "{" +
                " surname='" + getSurname() + "'" +
                ", prename='" + getPrename() + "'" +
                ", immatNumber='" + getImmatNumber() + "'" +
                ", course='" + getCourse() + "'" +
                "}";
        }
}