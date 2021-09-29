package com.example.tinwhistle;

public class Notes {

    private int note;
    public Boolean[] Fill = new Boolean[6];
    public Notes(int note) {
        this.note = note;
        buildNote();
    }
    private void buildNote(){
        switch(note){
            case 1 :
                for(int i = 5; i >=0; i--){
                    Fill[i] = false;
                }
                break;
            case 2:
                Fill[5] = true;
                for(int i = 4; i >=0; i--){
                    Fill[i] = false;
                }
                break;
            case 3:
                for(int i = 5; i >=4; i--){
                    Fill[i] = true;
                }
                for(int i = 3; i >=0; i--){
                    Fill[i] = false;
                }
                break;
            case 4:
                for(int i = 5; i >=3; i--){
                    Fill[i] = true;
                }
                for(int i = 2; i >=0; i--){
                    Fill[i] = false;
                }
                break;
            case 5:
                for(int i = 5; i >=2; i--){
                    Fill[i] = true;
                }
                for(int i = 1; i >=0; i--){
                    Fill[i] = false;
                }
                break;
            case 6:
                for(int i = 5; i >=1; i--){
                    Fill[i] = true;
                }
                for(int i = 0; i >=0; i--){
                    Fill[i] = false;
                }
                break;
            case 7:
                for(int i = 5; i >=0; i--){
                    Fill[i] = true;
                }
                break;
            case 8:
                for(int i = 5; i >=0; i--){
                    Fill[i] = false;
                }
                Fill[4] = true;
                Fill[3] = false;
                break;
            default:
                for(int i = 5; i >=0; i--){
                    Fill[i] = false;
                }
                break;
        }
    }
}
