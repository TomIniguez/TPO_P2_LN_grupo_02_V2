package coreVer2.adt.implementation.TPO;

public class MonteCarloTDA {

    public void esMonteCarlo(){
        int countB = 0;
        int i = 0;
        for(i = 0; i < 10000; i++){
            TDACoordenadas coord = new TDACoordenadas(Math.random(), Math.random());
            if(Math.pow(coord.getX(),2) <= 1 && Math.pow(coord.getY(),2) <= 1){
                countB++;
            }
        }
        System.out.println("( " + countB + " / " + i + ") * 4 es aproximadamente PI");
    }

}
