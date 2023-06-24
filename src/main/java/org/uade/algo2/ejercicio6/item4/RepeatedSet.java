package org.uade.algo2.ejercicio6.item4;

import java.util.Objects;
import java.util.Random;

public class RepeatedSet implements ISet{

    private NodeRepeatedSet first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new NodeRepeatedSet(new Pair(a, 1), null);
            this.count++;
            return;
        }

        if (this.first.getValue().getValue() == a) {
            this.first.getValue().setCant(this.first.getValue().getCant()+1);
            return;
        }

        NodeRepeatedSet candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue().getValue() == a) {
                candidate.getValue().setCant(candidate.getValue().getCant()+1);
                return;
            }
        }
        candidate.setNext(new NodeRepeatedSet(new Pair(a,1), null));
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue().getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue().getValue() == a) {
                if(this.first.getValue().getCant() > 1){
                    this.first.getValue().setCant(this.first.getValue().getCant()-1);
                }else{
                    this.first = null;
                    this.count--;
                }
            }
            return;
        }

        if (this.first.getValue().getValue() == a) {
            if(this.first.getValue().getCant() > 1){
                this.first.getValue().setCant(this.first.getValue().getCant()-1);
            }else{
                this.first = null;
                this.count--;
            }
            return;
        }

        NodeRepeatedSet backup = this.first;
        NodeRepeatedSet candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue().getValue() == a) {
                if(candidate.getValue().getCant() > 1){
                    candidate.getValue().setCant(candidate.getValue().getCant()-1);
                }else{
                    backup.setNext(candidate.getNext());
                    this.count--;
                    return;
                }

            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        NodeRepeatedSet candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue().getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepeatedSet set = (RepeatedSet) o;
        return count == set.count && Objects.equals(first, set.first);
    }
}
