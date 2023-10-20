import java.util.Scanner;

public class CGPA_Calculator{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int totalSubjects = input.nextInt();

        int[] creditHours = new int[totalSubjects];
        for(int i=0; i<creditHours.length; i++){
            System.out.println("Enter the credit hours(between 1 to 5) of subject " + (i+1) + " : ");
            creditHours[i] = input.nextInt();
        }
        
        int[] marks = new int[totalSubjects];
        for(int i=0; i<creditHours.length; i++){
            System.out.println("Enter the marks you scored in subject " + (i+1) + " of credit hour " + creditHours[i] + " : ");
            marks[i] = input.nextInt();
        }
        input.close();

        double[] qp = new double[totalSubjects];

        for(int i=0; i<totalSubjects; i++){
            int Marks = marks[i];

            switch(creditHours[i]){
                case 1:
                    if(Marks < 8){
                        qp[i] = 0;
                    }else if(Marks == 8){
                        qp[i] = 1;
                    }else if(Marks == 9){
                        qp[i] = 1.5;
                    }else if(Marks == 10){
                        qp[i] = 2;
                    }else if(Marks == 11){
                        qp[i] = 2.33;
                    }else if(Marks == 12){
                        qp[i] = 2.67;
                    }else if(Marks == 13){
                        qp[i] = 3;
                    }else if(Marks == 14){
                        qp[i] = 3.33;
                    }else if(Marks == 15){
                        qp[i] = 3.67;
                    }else if(Marks >=16 && Marks <=20){
                        qp[i] = 4;
                    }
                    break;
                case 2:
                    if(Marks < 16){
                        qp[i] = 0;
                    }else if(Marks == 16){
                        qp[i] = 2;
                    }else if(Marks == 17){
                        qp[i] = 2.5;
                    }else if(Marks == 18){
                        qp[i] = 3;
                    }else if(Marks == 19){
                        qp[i] = 3.5;
                    }else if(Marks == 20){
                        qp[i] = 4;
                    }else if(Marks == 21){
                        qp[i] = 4.33;
                    }else if(Marks == 22){
                        qp[i] = 4.67;
                    }else if(Marks == 23){
                        qp[i] = 5;
                    }else if(Marks == 24){
                        qp[i] = 5.33;
                    }else if(Marks == 25){
                        qp[i] = 5.67;
                    }else if(Marks == 26){
                        qp[i] = 6;
                    }else if(Marks == 27){
                        qp[i] = 6.33;
                    }else if(Marks == 28){
                        qp[i] = 6.67;
                    }else if(Marks == 29){
                        qp[i] = 7;
                    }else if(Marks == 30){
                        qp[i] = 7.33;
                    }else if(Marks == 31){
                        qp[i] = 7.67;
                    }else if(Marks >= 32 && Marks <= 40){
                        qp[i] = 8;
                    }
                    break;
                case 3:
                    if(Marks < 24){
                        qp[i] = 0;
                    }else if(Marks == 24){
                        qp[i] = 3;
                    }else if(Marks == 25){
                        qp[i] = 3.5;
                    }else if(Marks == 26){
                        qp[i] = 4;
                    }else if(Marks == 27){
                        qp[i] = 4.5;
                    }else if(Marks == 28){
                        qp[i] = 5;
                    }else if(Marks == 29){
                        qp[i] = 5.5;
                    }else if(Marks == 30){
                        qp[i] = 6;
                    }else if(Marks == 31){
                        qp[i] = 6.33;
                    }else if(Marks == 32){
                        qp[i] = 6.67;
                    }else if(Marks == 33){
                        qp[i] = 7;
                    }else if(Marks == 34){
                        qp[i] = 7.33;
                    }else if(Marks == 35){
                        qp[i] = 7.67;
                    }else if(Marks == 36){
                        qp[i] = 8;
                    }else if(Marks == 37){
                        qp[i] = 8.33;
                    }else if(Marks == 38){
                        qp[i] = 8.67;
                    }else if(Marks == 39){
                        qp[i] = 9;
                    }else if(Marks == 40){
                        qp[i] = 9.33;
                    }else if(Marks == 41){
                        qp[i] = 9.67;
                    }else if(Marks == 42){
                        qp[i] = 10;
                    }else if(Marks == 43){
                        qp[i] = 10.33;
                    }else if(Marks == 44){
                        qp[i] = 10.67;
                    }else if(Marks == 45){
                        qp[i] = 11;
                    }else if(Marks == 46){
                        qp[i] = 11.33;
                    }else if(Marks == 47){
                        qp[i] = 11.67;
                    }else if(Marks >= 48 && Marks <= 60){
                        qp[i] = 12;
                    }
                    break;
                case 4:
                    if(Marks < 32){
                        qp[i] = 0;
                    }else if(Marks == 32){
                        qp[i] = 4;
                    }else if(Marks == 33){
                        qp[i] = 4.5;
                    }else if(Marks == 34){
                        qp[i] = 5;
                    }else if(Marks == 35){
                        qp[i] = 5.5;
                    }else if(Marks == 36){
                        qp[i] = 6;
                    }else if(Marks == 37){
                        qp[i] = 6.6;
                    }else if(Marks == 38){
                        qp[i] = 7;
                    }else if(Marks == 39){
                        qp[i] = 7.5;
                    }else if(Marks == 40){
                        qp[i] = 8;
                    }else if(Marks == 41){
                        qp[i] = 8.33;
                    }else if(Marks == 42){
                        qp[i] = 8.67;
                    }else if(Marks == 43){
                        qp[i] = 9;
                    }else if(Marks == 44){
                        qp[i] = 9.33;
                    }else if(Marks == 45){
                        qp[i] = 9.67;
                    }else if(Marks == 46){
                        qp[i] = 10;
                    }else if(Marks == 47){
                        qp[i] = 10.33;
                    }else if(Marks == 48){
                        qp[i] = 10.67;
                    }else if(Marks == 49){
                        qp[i] = 11;
                    }else if(Marks == 50){
                        qp[i] = 11.33;
                    }else if(Marks == 51){
                        qp[i] = 11.67;
                    }else if(Marks == 52){
                        qp[i] = 12;
                    }else if(Marks == 53){
                        qp[i] = 12.33;
                    }else if(Marks == 54){
                        qp[i] = 12.67;
                    }else if(Marks == 55){
                        qp[i] = 13;
                    }else if(Marks == 56){
                        qp[i] = 13.33;
                    }else if(Marks == 57){
                        qp[i] = 13.67;
                    }else if(Marks == 58){
                        qp[i] = 14;
                    }else if(Marks == 59){
                        qp[i] = 14.33;
                    }else if(Marks == 60){
                        qp[i] = 14.67;
                    }else if(Marks == 61){
                        qp[i] = 15;
                    }else if(Marks == 62){
                        qp[i] = 15.33;
                    }else if(Marks == 63){
                        qp[i] = 15.67;
                    }else if(Marks >= 64 && Marks <= 80){
                        qp[i] = 16;
                    }
                    break;
                case 5:
                    if(Marks < 40){
                        qp[i] = 0;
                    }else if(Marks == 40){
                        qp[i] = 5;
                    }else if(Marks == 41){
                        qp[i] = 5.5;
                    }else if(Marks == 42){
                        qp[i] = 6;
                    }else if(Marks == 43){
                        qp[i] = 6.5;
                    }else if(Marks == 44){
                        qp[i] = 7;
                    }else if(Marks == 45){
                        qp[i] = 7.5;
                    }else if(Marks == 46){
                        qp[i] = 8;
                    }else if(Marks == 47){
                        qp[i] = 8.5;
                    }else if(Marks == 48){
                        qp[i] = 9;
                    }else if(Marks == 49){
                        qp[i] = 9.5;
                    }else if(Marks == 50){
                        qp[i] = 10;
                    }else if(Marks == 51){
                        qp[i] = 10.33;
                    }else if(Marks == 52){
                        qp[i] = 10.67;
                    }else if(Marks == 53){
                        qp[i] = 11;
                    }else if(Marks == 54){
                        qp[i] = 11.33;
                    }else if(Marks == 55){
                        qp[i] = 11.67;
                    }else if(Marks == 56){
                        qp[i] = 12;
                    }else if(Marks == 57){
                        qp[i] = 12.33;
                    }else if(Marks == 58){
                        qp[i] = 12.67;
                    }else if(Marks == 59){
                        qp[i] = 13;
                    }else if(Marks == 60){
                        qp[i] = 13.33;
                    }else if(Marks == 61){
                        qp[i] = 13.67;
                    }else if(Marks == 62){
                        qp[i] = 14;
                    }else if(Marks == 63){
                        qp[i] = 14.33;
                    }else if(Marks == 64){
                        qp[i] = 14.67;
                    }else if(Marks == 65){
                        qp[i] = 15;
                    }else if(Marks == 66){
                        qp[i] = 15.33;
                    }else if(Marks == 67){
                        qp[i] = 15.67;
                    }else if(Marks == 68){
                        qp[i] = 16;
                    }else if(Marks == 69){
                        qp[i] = 16.33;
                    }else if(Marks == 70){
                        qp[i] = 16.67;
                    }else if(Marks == 71){
                        qp[i] = 17;
                    }else if(Marks == 72){
                        qp[i] = 17.33;
                    }else if(Marks == 73){
                        qp[i] = 17.67;
                    }else if(Marks == 74){
                        qp[i] = 18;
                    }else if(Marks == 75){
                        qp[i] = 18.33;
                    }else if(Marks == 76){
                        qp[i] = 18.67;
                    }else if(Marks == 77){
                        qp[i] = 19;
                    }else if(Marks == 78){
                        qp[i] = 19.33;
                    }else if(Marks == 79){
                        qp[i] = 19.67;
                    }else if(Marks >= 80 && Marks <=100){
                        qp[i] = 20;
                    }
                    break;
                default: 
                    System.out.println("Credit Hours must be in the range from 1 to 5");
            }

        }
        
        double totalQP = 0;
        for(int i=0; i<qp.length; i++){
            totalQP += qp[i];
        }
        int totalCreditHours = 0;
        for(int i=0; i<creditHours.length; i++){
            totalCreditHours += creditHours[i];
        }
        double gpa = totalQP / totalCreditHours;

        System.out.println("Your GPA is: " + gpa);
        
    }
}