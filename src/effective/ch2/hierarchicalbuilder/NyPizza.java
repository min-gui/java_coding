package effective.ch2.hierarchicalbuilder;


import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;


    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override protected Builder self() { return this; }
    }

    @Override public String toString() {
        return toppings + "로 토핑한 뉴욕 피자";
    }

}
