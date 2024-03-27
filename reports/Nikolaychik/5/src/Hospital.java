import java.util.ArrayList;

public class Hospital {
    public ArrayList<Doctor> stored_doctors = null;
    public ArrayList<Patient> stored_patients = null;
    Hospital(){
        this.stored_doctors.add(new Doctor("Koba",this));
        this.stored_doctors.add(new Doctor("Zloba",this));
        this.stored_doctors.add(new Doctor("Moba",this));
        this.stored_doctors.add(new Doctor("Zaznoba",this));
        this.stored_patients.add(new Patient("Pufik",this,
                stored_doctors.get(0)));
        this.stored_patients.add(new Patient("Aufik",this,
                stored_doctors.get(1)));
        this.stored_patients.add(new Patient("Gulfik",this,
                stored_doctors.get(2)));
        this.stored_patients.add(new Patient("Rufik",this,
                stored_doctors.get(3)));
    }
    public void out_doc(){
        for (int i = 0; i < this.stored_doctors.size(); i++) {
            this.stored_doctors.get(i).out();
        }
    }
    public void out_pat(){
        for (int i = 0; i < this.stored_patients.size(); i++) {
            this.stored_patients.get(i).out();
        }
    }
}
