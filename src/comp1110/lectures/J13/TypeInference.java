package comp1110.lectures.J13;

import java.util.LinkedList;
import java.util.function.IntFunction;

public class TypeInference {

    static class ThingHolder<T> {
        private T value;

        public ThingHolder(T value) {
            this.value = value;
        }

        public static <U> ThingHolder<U> makeHolder(U value) {
            return new ThingHolder(value);
        }
    }

    public static void main(String[] args) {
        var theAnswer = 42; // theAnswer is an int
        System.out.println(theAnswer);

        //var s = new LinkedList<String>();
        LinkedList<String> s = new LinkedList<>();
        s.add("Hello");

        ThingHolder<String> holder = new ThingHolder<>("Hello");
        var anotherHolder = new ThingHolder<>("Hi again");
        System.out.println(anotherHolder);
        var yetAnotherHolder = ThingHolder.makeHolder(Integer.valueOf(42));

        IntFunction increment = x -> x + 1;
        // var increment2 = x -> x + 1; // invalid - can't infer the type of x
        // var increment3 = (int x) -> x + 1; // invalid - can't infer functional interface of lambda expression

        //var nothing = null; // invalid - null has no type;
        //var mystery; // invalid - can't infer type without initializer
    }
}
