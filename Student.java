package studentmanagment;

public class Student {
    private String name;
    private String USN;
    private int[] marks;

    public Student(String name,String USN,int[] marks){
        this.name=name;
        this.USN=USN;
        this.marks=marks;
    }
    public double average(){
        int total=0;
        for(int mark:marks){
            total+=mark;
        }
        return marks.length>0 ?(double)total/marks.length:0;
    }
    public String grade(){
        double avg=average();
        if(avg>=90)
            return "A";
        else if(avg>=80)
            return "B";
        else if(avg>=70)
            return "C";
        else if(avg>=60)
            return "D";
        else
            return "F";
    }
    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("USN: "+USN);
        System.out.println("Marks: ");
        for(int mark:marks){
            System.out.print(mark+" ");
        }
        System.out.println();
        System.out.println("Average: "+average());
        System.out.println("Grade: "+grade());
        System.out.println("---------------------");
    }
    public String getUSN(){
        return USN;
    }

}
