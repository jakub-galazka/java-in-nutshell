package com.github.jakub_galazka.java_in_nutshell._4java_collections;

public final class _11HashcodeAndEquals {

    private final String string;

    public _11HashcodeAndEquals(String string) {
            this.string = string;
        }

    /*
        Java documentation warn:
        ~ If you are using own objects as a key in a Map or as an element in a Set that you should override:
          equals() and hashcode() methods.
        ~ If 2 object compare equal,
          then their hash codes must be the same which is why you must override the hashcode() method.
        ~ How you generate hash codes is pretty much up to you,
          as long as the same object will always generate the same hashcode.

        The essence of storing object in a hashed Collection such as HashSet or HashMap:
        Think of the Collection as having a number of buckets to store the object in.
        The hashcode determines which bucket an object is going to go into.
        Now there is a requirement that any objects that are equal should always have the same hash code,
        so that they will then end up in the same bucket.
        When we add an object, its hash code tells the Collection which bucket it should go into.
        Now there may already be objects in that bucket so each is compared to the new object
        to make sure that it is not already in there.
        Now because the comparison is performed using the equals() method,
        the Collection will only know if it is already there if it is looking into the right bucket.
        So the hash codes must be the same and equals return true.
    */

    @Override
    public int hashCode() {
        return string.hashCode() + 1;
        /*
            BAD PRACTISE: [only] string.hashCode()
                -> object should generate different hash code then corresponding string of the name field
         */
    }

    // Rules for equals method: https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-
    @Override
    public boolean equals(Object obj) {
        /*
            return super.equals(obj);
                -> DEFAULT: referential equality, if both references point to the same object then they are equal,
                            otherwise they are not
         */

        // First check if instance is being compared to itself
        if (this == obj) {
            return true;
        }

        /*
            Make sure that subclasses do not compare equal
            by checking the actual class of the object being compared against the class of the object the method is in
         */
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        // Criteria for an equals match
        String objString = ((_11HashcodeAndEquals) obj).getString();
        return string.equals(objString);
    }

    public String getString() {
            return string;
        }
}
