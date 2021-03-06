package com.codepoetics.octarine.functional.tuples;

import com.codepoetics.octarine.functional.functions.F5;

import java.util.Objects;
import java.util.function.Function;

public final class T5<A, B, C, D, E> {
    private final A a;
    private final B b;
    private final C c;
    private final D d;
    private final E e;

    private T5(A a, B b, C c, D d, E e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }


    public static <S, A, B, C, D, E> Function<S, T5<A, B, C, D, E>> unpacker(Function<? super S, ? extends A> first,
                                                                             Function<? super S, ? extends B> second,
                                                                             Function<? super S, ? extends C> third,
                                                                             Function<? super S, ? extends D> fourth,
                                                                             Function<? super S, ? extends E> fifth) {
        return s -> T5.of(first.apply(s), second.apply(s), third.apply(s), fourth.apply(s), fifth.apply(s));
    }

    public static <A, B, C, D, E> TupleLens<T5<A, B, C, D, E>, A> first() {
        return TupleLens.of(
                0,
                T5::getFirst,
                T5::withFirst
        );
    }

    public static <A, B, C, D, E> TupleLens<T5<A, B, C, D, E>, B> second() {
        return TupleLens.of(
                1,
                T5::getSecond,
                T5::withSecond
        );
    }

    public static <A, B, C, D, E> TupleLens<T5<A, B, C, D, E>, C> third() {
        return TupleLens.of(
                2,
                T5::getThird,
                T5::withThird
        );
    }

    public static <A, B, C, D, E> TupleLens<T5<A, B, C, D, E>, D> fourth() {
        return TupleLens.of(
                3,
                T5::getFourth,
                T5::withFourth
        );
    }

    public static <A, B, C, D, E> TupleLens<T5<A, B, C, D, E>, E> fifth() {
        return TupleLens.of(
                4,
                T5::getFifth,
                T5::withFifth
        );
    }

    public static <A, B, C, D, E> T5<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
        return new T5<>(a, b, c, d, e);
    }

    public A getFirst() {
        return a;
    }

    public <A2> T5<A2, B, C, D, E> withFirst(A2 a2) {
        return T5.of(a2, b, c, d, e);
    }

    public B getSecond() {
        return b;
    }

    public <B2> T5<A, B2, C, D, E> withSecond(B2 b2) {
        return T5.of(a, b2, c, d, e);
    }

    public C getThird() {
        return c;
    }

    public <C2> T5<A, B, C2, D, E> withThird(C2 c2) {
        return T5.of(a, b, c2, d, e);
    }

    public D getFourth() {
        return d;
    }

    public <D2> T5<A, B, C, D2, E> withFourth(D2 d2) {
        return T5.of(a, b, c, d2, e);
    }

    public E getFifth() {
        return e;
    }

    public <E2> T5<A, B, C, D, E2> withFifth(E2 e2) {
        return T5.of(a, b, c, d, e2);
    }

    public <R> R pack(F5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends R> f) {
        return f.apply(a, b, c, d, e);
    }

    public T2<E, T4<A, B, C, D>> pop() {
        return Tuple.of(e, Tuple.of(a, b, c, d));
    }

    public T2<A, T4<B, C, D, E>> shift() {
        return Tuple.of(a, Tuple.of(b, c, d, e));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof T5)) {
            return false;
        }
        T5 other = (T5) o;
        return Objects.equals(a, other.a) &&
                Objects.equals(b, other.b) &&
                Objects.equals(c, other.c) &&
                Objects.equals(d, other.d) &&
                Objects.equals(e, other.e);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s, %s, %s)", a, b, c, d, e);
    }
}
