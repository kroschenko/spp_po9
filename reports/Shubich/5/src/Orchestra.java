package org.example;

public class Orchestra {
    private MusicalInstrument[] instruments;


    public Orchestra() {
        instruments = new MusicalInstrument[0];
    }

    public void addInstrument(MusicalInstrument instrument) {
        MusicalInstrument[] newArray = new MusicalInstrument[instruments.length + 1];

        for (int i = 0; i < instruments.length; i++) {
            newArray[i] = instruments[i];
        }

        newArray[newArray.length - 1] = instrument;
        instruments = newArray;
    }

    public void printOrchestra(){
        for (MusicalInstrument instrument : instruments) {
            System.out.println(instrument.getName());
        }
    }
}
