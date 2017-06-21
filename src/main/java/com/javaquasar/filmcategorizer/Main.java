package com.javaquasar.filmcategorizer;

import com.javaquasar.filmcategorizer.dao.hiber.HibernateUtil;

/**
 *
 * @author Java Quasar
 */
public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}
