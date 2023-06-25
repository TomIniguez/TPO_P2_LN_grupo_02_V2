import java.util.Arrays;
import java.util.Random;

public class Set implements ISet {

    private final int[] array;
    private int count;

    private Set(Builder builder) {
        this.array = builder.array;
        this.count = builder.count;
    }

    @Override
    public void add(int a) {
        if (contains(a)) {
            return;
        }

        int[] newArray = Arrays.copyOf(array, count + 1);
        newArray[count] = a;

        Set.Builder builder = new Set.Builder();
        builder.array(newArray);
        builder.count(count + 1);

        Set newSet = builder.build();
        array = newSet.array;
        count = newSet.count;
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                if (i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array[i] = this.array[this.count - 1];
                this.count--;
            }
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
        return this.array[randomIndex];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        if (count != set.count) return false;

        int[] array1Copy = Arrays.copyOf(array, array.length);
        int[] array2Copy = Arrays.copyOf(set.array, set.array.length);
        Arrays.sort(array1Copy);
        Arrays.sort(array2Copy);

        for (int i = 0; i < count; i++) {
            if (array1Copy[i] != array2Copy[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean contains(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                return true;
            }
        }
        return false;
    }

    public static class Builder {
        private int[] array;
        private int count;

        public Builder() {
            this.array = new int[10000];
            this.count = 0;
        }

        public Builder array(int[] array) {
            this.array = array;
            return this;
        }

        public Builder count(int count) {
            this.count = count;
            return this;
        }

        public Builder addAll(Set set) {
            int newCount = this.count;
            int[] newArray = Arrays.copyOf(this.array, this.count + set.getCount());

            for (int i = 0; i < set.getCount(); i++) {
                int element = set.getArray()[i];
                boolean exists = false;

                for (int j = 0; j < newCount; j++) {
                    if (newArray[j] == element) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    newArray[newCount] = element;
                    newCount++;
                }
            }

            this.array = newArray;
            this.count = newCount;
            return this;
        }

        public Set build() {
            return new Set(this);
        }
    }
}

