import java.util.ArrayList;

public class Doctor extends Mensch{
    Hospital hospital;
    int id;
    Doctor(String name, Hospital hospital){
        super(name,50);
        this.name=name;
        this.hospital=hospital;
        this.id=0;
        hospital.stored_doctors.add(this);
        if(hospital.stored_doctors==null){
            hospital.stored_doctors= new ArrayList<Doctor>();
        }
        boolean flag=true;
        for (int i=1;this.id==0;i++){
            flag=true;
            for(int j=0;j<hospital.stored_doctors.size();j++){
                if(hospital.stored_doctors.get(j).id == i)
                {
                    flag=false;
                }
            }
            if(flag) {
                this.id = i;
            }
        }
    }

    void Set_note(String note, Patient patient){
        if(this.id== patient.doctor.id) {
            patient.note = note;
            patient.type = patient.wait_type;
            System.out.println("Назначено");
        }
        else System.out.println("Невозможно назначить");
    }
    void Cure(Patient patient){
        for(int j=0;j<patient.hospital.stored_patients.size();j++){
            if(patient.hospital.stored_patients.get(j).id == patient.id)
            {
                patient.hospital.stored_patients.remove(j);
            }
        }

    }
    void out(){
        System.out.println("DOCTOR");
        System.out.println("id: "+this.id);
        System.out.println("name: "+this.name);
        System.out.println();
    }
}
