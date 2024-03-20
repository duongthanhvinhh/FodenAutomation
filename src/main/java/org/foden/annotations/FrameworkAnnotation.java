package org.foden.annotations;

import org.foden.enums.CategoryType;

import java.lang.annotation.*;

/**
 * The interface Framework annotation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
//@Target(ElementType.METHOD)
@Documented //To have FrameworkAnnotation appear in the java document
public @interface FrameworkAnnotation {

    /**
     * Author string [ ].
     *
     * @return the string [ ]
     */
    public String[] author();

    /**
     * Category category type [ ].
     *
     * @return the category type [ ]
     */
    public CategoryType[] category();

}
