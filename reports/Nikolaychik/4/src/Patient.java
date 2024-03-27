import java.util.ArrayList;

public class Patient {
    short in_type=0,out_type=1,wait_type=2;
    Hospital hospital;
    public String name;
    int id;
    int type;
    public Doctor doctor;
    String note=null;
    Patient(String name, Hospital hospital, Doctor doctor){
        this.name=name;
        this.hospital=hospital;
        this.doctor=doctor;
        this.id=0;
        hospital.stored_patients.add(this);
        if(hospital.stored_patients==null){
            hospital.stored_patients= new ArrayList<Patient>();
        }
        boolean flag=true;
        for (int i=1;this.id==0;i++){
            flag=true;
            for(int j=0;j<hospital.stored_patients.size();j++){
                if(hospital.stored_patients.get(j).id == i)
                {
                    flag=false;
                }
            }
            if(flag) {
                this.id = i;
            }
        }
        this.type=in_type;

    }
    void out(){
        System.out.println("PATIENT");
        System.out.println("id: "+this.id);
        System.out.println("name: "+this.name);
        System.out.println();
        System.out.println("AND HIS DOCTOR");
        this.doctor.out();
    }
}
