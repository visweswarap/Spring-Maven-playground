package com.vish.springmaven.utils;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalUtils {

    private OptionalUtils() {	}

    /**
     * This method will help us to deal with nulls.  Particularly when we require to check nested nulls.<br>
     *
     * <pre>
     *     Object obj = new Object();
     *     resolveNestedNulls(() -> obj.getLevelOneChild().getLevelTwoChild().getName());
     *         .ifPresent(System.out::println);
     *
     * is equal to:
     *
     *     if(obj.getLevelOneChild() != null && obj.getLevelOneChild().getLevelTwoChild() != null && obj.getLevelOneChild().getLevelTwoChild().getName()){
     *         System.out.println(obj.getLevelOneChild().getLevelTwoChild().getName());
     *     }
     * </pre>
     *
     * @param resolver
     * @return {@link Optional}
     */
    public static <T> Optional<T> resolveNestedNulls(Supplier<T> resolver) {

        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }
}